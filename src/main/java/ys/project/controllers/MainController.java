package ys.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ys.project.model.Role;
import ys.project.model.User;
import ys.project.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zorrax on 06.09.2018.
 * Основной контроллер проекта, проводит работу с доступом
 */
@Controller
public class MainController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Value("${upload.path}")
    private String uploadPath;
    @Value("${var.server.addr}")
    private String serverAddr;

    @RequestMapping("/login")
    public String getLogin(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model model
    ) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        model.addAttribute("serverAddr", serverAddr);
        return "login";
    }

    @RequestMapping("/reg")
    public String newUser(
            Model model
    ) {
        model.addAttribute("serverAddr", serverAddr);
        return "reg";
    }

    @PostMapping("/reg")
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          Model model) {
        model.addAttribute("serverAddr", serverAddr);
        if (!userService.addUser(username, password)) {
            model.addAttribute("usernameError", "User exists!");
            return "reg";
        }

        return "redirect:/login";
    }

    @RequestMapping("/users")
    public String docs(Model model) {
        model.addAttribute("users", userService.getUserList());
        model.addAttribute("serverAddr", serverAddr);
        return "users";
    }

    @RequestMapping("/user/{id}")
    public String editUser(@PathVariable String id, Model model) {

        User current = (User) userService.loadUserByUsername(id);

        model.addAttribute("user", current);
        model.addAttribute("roles", Role.values());
        model.addAttribute("serverAddr", serverAddr);

        return "userForm";
    }

    @PostMapping("/updateUser")
    public String updateUser(
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user) {
        //List<Role> currentRoles = user.getAuthorities();
        List<Role> newRoles = new ArrayList<>();
        newRoles.add(Role.USER);
        if (form.containsKey(Role.ADMIN.name())) {
            //System.out.println("Admin key detected");

            newRoles.add(Role.ADMIN);

        }
        if (form.containsKey(Role.EDITOR.name())) {
            //System.out.println("Editor key detected");
            newRoles.add(Role.EDITOR);
        }

        /*for (String key : form.keySet()) {
            System.out.println("key: " + key + " value: " + form.get(key));
        }*/
        user.setAuthorities(newRoles);
        userService.save(user);
        return "redirect:/users";
    }
}
