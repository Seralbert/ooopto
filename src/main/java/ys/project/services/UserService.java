package ys.project.services;

import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ys.project.model.Role;
import ys.project.model.User;
import ys.project.repository.UserRepo;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

/**
 * Created by Yuriy Smirnov on 13.03.2020.
 *
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init(){

        if(userRepo.findByUsername("admin") == null) {
            User admin = new User();
            admin.setUsername("admin");
            admin.setFio("Администратор системы");
            admin.setPassword(new BCryptPasswordEncoder().encode("admin"));
            admin.setAuthorities(ImmutableList.of(Role.ADMIN));
            admin.setAccountNonExpired(true);
            admin.setAccountNonLocked(true);
            admin.setCredentialsNonExpired(true);
            admin.setEnabled(true);
            userRepo.save(admin);
        }
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    public boolean addUser(User user) {
        User userFromDb = userRepo.findByUsername(user.getUsername());
        if (userFromDb != null) {
            return false;
        }
        user.setEnabled(true);
        user.setAuthorities(ImmutableList.of(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepo.save(user);
        return true;
    }
    public void delUser(Long id){
        userRepo.delete(userRepo.getOne(id));
    }
    public List<User> findAll(){
        return userRepo.findAll();
    }
    public void save(User u){
        userRepo.save(u);
    }

    public boolean userExist(String username){
        if (userRepo.findByUsername(username)!=null)return true;
        return false;
    }
    public User getUserById(Long id){
        return userRepo.getOne(id);
    }
}
