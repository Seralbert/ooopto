package ys.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Контроллер модуля поиска on 06.11.2019.
 */
@Controller
public class FindController {
    @RequestMapping("/find")
    public String find(Model model){
        return "find";
    }


    @PostMapping("/dofind")
    public String processForm(Model model){
        return "redirect:/report";
    }
}
