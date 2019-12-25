package ys.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ys.project.services.GFDVocServiceImpl;

/**
 * Created by User on 24.12.2019.
 * test controller
 */
@Controller
public class TestController {
    @Autowired
    private GFDVocServiceImpl service;

    @RequestMapping("/test")
    public String getTest(Model model){
        model.addAttribute("voc", service.getAllCode());

        return "testnew";
    }
    @RequestMapping("/test2")
    public String getTest1(Model model){
        return "testfind";
    }
}
