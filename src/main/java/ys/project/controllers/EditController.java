package ys.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Создание и редактирование объектов 06.11.2019.
 */
@Controller
public class EditController {
    @RequestMapping("/new")
    public String newDoc(Model model){
        return "new";
    }
}
