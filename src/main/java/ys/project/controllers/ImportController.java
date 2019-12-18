package ys.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ys.project.utils.BgHandler;

/**
 * Created by User on 11.12.2019.
 * реализция иморта книг инвентаризации
 */

@Controller
public class ImportController {
    @GetMapping("/import")
    public String inputPage(Model model){
        model.addAttribute("bgImg", BgHandler.getBG());
        return "main";
    }
}
