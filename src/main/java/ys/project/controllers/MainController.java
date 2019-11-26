package ys.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zorrax on 06.09.2018.
 * Основной контроллер проекта, проводит работу с доступом
 */
@Controller
public class MainController {
@RequestMapping("/")
    public String index(Model model){
    return "main";
}

//TEST MAPING
@GetMapping("/append")
    public String appendNew(Model model){
        return "append";
}
@PostMapping("/append")
    public String appendNewW(Model model){
        return "append";
    }
}
