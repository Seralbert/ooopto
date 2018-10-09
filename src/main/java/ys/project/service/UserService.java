package ys.project.service;

import com.google.common.collect.ImmutableList;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ys.project.model.Role;
import ys.project.model.User;
import ys.project.repos.UserRepository;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by zorrax on 26.09.2018.
 * Важно! постоянно происхолдит сброс пароля админа на deafult
 */
@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepo;
    @Autowired
    public void setUserRepo(UserRepository userRepo){this.userRepo = userRepo;}
    @Override
    public UserDetails loadUserByUsername(@NonNull String s) throws UsernameNotFoundException {

        return userRepo.findByUsername(s).orElseThrow( () -> new UsernameNotFoundException("user " + s + "was not found"));
    }



    @PostConstruct
    public void init(){
    /*    userRepo.findByUsername("admin").ifPresent(user -> {
            user.setPassword(new BCryptPasswordEncoder().encode("admin"));
            userRepo.save(user);
        });*/
        /*if(!userRepo.findByUsername("admin").isPresent()) {
            User admin = userRepo.findByUsername("admin").orElse(new User());
            admin.setUsername("admin");
            admin.setPassword("admin");
            admin.setAuthorities(ImmutableList.of(Role.USER));
            admin.setAccountNonExpired(true);
            admin.setAccountNonLocked(true);
            admin.setCredentialsNonExpired(true);
            admin.setEnabled(true);
            userRepo.save(admin);
        }*/
    }

    public boolean addUser(@NonNull String username, @NonNull String password) {
                if (!userRepo.findByUsername(username).isPresent()) {
            userRepo.save(User.builder()
                    .username(username)
                    .password(new BCryptPasswordEncoder().encode(password))
                    .authorities(ImmutableList.of(Role.USER))
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .enabled(true)
                    .build());
            return true;
        }
        return false;
    }
    public List<User> getUserList(){
        return userRepo.findAll();
    }



    public void save(User user) {
        userRepo.save(user);
    }
}
