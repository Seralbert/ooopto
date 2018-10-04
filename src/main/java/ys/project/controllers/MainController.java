package ys.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ys.project.service.UserService;

/**
 * Created by zorrax on 06.09.2018.
 * Основной контроллер проекта, проводит работу с доступом
 */
@Controller
public class MainController {
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService) {this.userService = userService;}


    @Value("${upload.path}")
    private String uploadPath;
    @Value("${var.server.addr}")
    private String serverAddr;

    @RequestMapping("/login")
    public String getLogin(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            Model model
            ){
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        model.addAttribute("serverAddr", serverAddr);
        return "login";
    }

    @RequestMapping("/reg")
    public String newUser(
            Model model
    ){
        model.addAttribute("serverAddr", serverAddr);
        return "reg";
    }

    @PostMapping("/reg")
    public String addUser(@RequestParam("username")String username,
                          @RequestParam("password")String password,
                          Model model){
        model.addAttribute("serverAddr", serverAddr);
        if (!userService.addUser(username, password)) {
            model.addAttribute("usernameError", "User exists!");
            return "reg";
        }

        return "redirect:/login";
    }

    @RequestMapping("/users")
    public String docs(Model model){
        model.addAttribute("users", userService.getUserList());
        model.addAttribute("serverAddr",serverAddr);
        return "users";
    }
}
