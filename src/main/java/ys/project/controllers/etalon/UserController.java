package ys.project.controllers.etalon;

import com.google.common.collect.ImmutableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ys.project.model.Role;
import ys.project.model.User;
import ys.project.services.UserService;

/**
 * Created by Smirnov Yuriy on 13.04.2020.
 *
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("userlist", userService.findAll());
        return "users";
    }
    @GetMapping("/adduser")
    public String getNewUser(Model model){
        return "newuser";
    }
    @PostMapping("/adduser")
    public String setNewUser(
            @RequestParam String fio,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String role
                             ){
        //System.out.println(fio + "|" + username + "|" + password);
        System.out.println("Создан новый пользователь " + fio + " с логином " + username);
            User u = new User();
            u.setUsername(username);
            u.setPassword(new BCryptPasswordEncoder().encode(password));
            u.setFio(fio);
            switch (role){
                case "Просмотр": u.setAuthorities(ImmutableList.of(Role.GUEST));break;
                case "Редактор": u.setAuthorities(ImmutableList.of(Role.USER));break;
                case "Администратор": u.setAuthorities(ImmutableList.of(Role.ADMIN));break;
            }
            u.setAccountNonExpired(true);
            u.setAccountNonLocked(true);
            u.setCredentialsNonExpired(true);
            u.setEnabled(true);
            userService.save(u);
        return "redirect:/users";
    }

    @GetMapping("/edituser/{id}")
    public String userPage(Model model,
                           @PathVariable Long id){
                User u = userService.getUserById(id);
                model.addAttribute("fio", u.getFio());
                model.addAttribute("username", u.getUsername());
                String outRole = "";
                switch (u.getRoles().get(0))
                {
                    case GUEST: outRole = "Просмотр";break;
                    case USER: outRole = "Редактор"; break;
                    case ADMIN: outRole = "Администратор"; break;
                }
                model.addAttribute("role", outRole);
                return "edituser";
    }
    @PostMapping("/edituser/{id}")
    public String saveUser(Model model,
                           @PathVariable Long id,
                           @RequestParam String fio,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String role){
        User u = userService.getUserById(id);
        switch (role){
            case "Просмотр": u.getRoles().clear(); u.getRoles().add(Role.GUEST);break;
            case "Редактор": u.getRoles().clear(); u.getRoles().add(Role.USER);break;
            case "Администратор": u.getRoles().clear(); u.getRoles().add(Role.ADMIN);break;
        }
        if(!password.equals(""))
        u.setPassword(new BCryptPasswordEncoder().encode(password));
        userService.save(u);
        return "redirect:/users";
    }
    @GetMapping("deleteuser/{id}")
    public String delUser(Model model,
                          @PathVariable Long id){
        userService.delUser(id);
        return "redirect:/users";
    }
}
