package ys.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ys.project.services.DocService;

/**
 * Создание и редактирование объектов 06.11.2019.
 */
@Controller
public class EditController {
    private DocService service;

    @Autowired
    public void setDocService(DocService service) {
        this.service = service;
    }
    @RequestMapping("/new")
    public String newDoc(Model model){
        return "new";
    }
}
