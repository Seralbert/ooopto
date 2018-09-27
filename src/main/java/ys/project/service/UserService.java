package ys.project.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ys.project.model.Role;
import ys.project.model.User;
import ys.project.repos.UserRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zorrax on 26.09.2018.
 */
@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(@NonNull String s) throws UsernameNotFoundException {

        return userRepo.findByUsername(s).orElseThrow( () -> new UsernameNotFoundException("user " + s + "was not found"));
    }

    @PostConstruct
    public void init(){
    if(!userRepo.findByUsername("admin").isPresent()){
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
            List<Role> roles = new ArrayList<>();
            roles.add(Role.USER);
        admin.setAuthorities(roles);
        admin.setAccountNonExpired(true);
        admin.setAccountNonLocked(true);
        admin.setEnabled(true);

        userRepo.save(admin);
    }
    }
}
