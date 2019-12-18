package ys.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ys.project.model.GFDDoc;
import ys.project.services.DocService;
import ys.project.utils.BgHandler;
import ys.project.utils.DataHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Контроллер модуля поиска on 06.11.2019.
 */
@Controller
public class FindController {
    List<GFDDoc> resList = new ArrayList<>();
    private DocService service;

    @Autowired
    public void setDocService(DocService service) {
        this.service = service;
    }

    @RequestMapping("/find")
    public String find(Model model) {

        model.addAttribute("bgImg", BgHandler.getBG());
        return "find";
    }


    @PostMapping("/dofind")
    public String processForm(Model model,
                              @RequestParam(required = false) String rp,
                              @RequestParam(required = false) String docNumber,
                              @RequestParam(required = false) String docDateStart,
                              @RequestParam(required = false) String docDateStop,
                              @RequestParam(required = false) String sysCoord,
                              @RequestParam(required = false) String docName,
                              @RequestParam(required = false) String docAuthor

    ) {
        String exp_rp = "";
        Date exp_dstart = docDateStart.isEmpty()? DataHandler.stringToDate("1900-01-01"):DataHandler.stringToDate(docDateStart);
        Date exp_dstop = docDateStop.isEmpty()? DataHandler.stringToDate("2200-12-31"):DataHandler.stringToDate(docDateStop);

        if (!rp.contains("Выберете отдел")) exp_rp = rp; // без РП
        resList.clear();
        //resList.addAll(service.findByFild(docNumber, docName, docAuthor, exp_rp,exp_dstart,exp_dstop));
        //resList.addAll(service.findByFild(docNumber, docName, docAuthor, exp_rp));
        resList.addAll(service.findByPattern(docName,docNumber,exp_dstart,exp_dstop,docAuthor,exp_rp));
        return "redirect:/result";
    }

    @GetMapping("/result")
    public String getResult(Model model) {
        model.addAttribute("bgImg", BgHandler.getBG());
        model.addAttribute("docs", resList);
        return "result";
    }

}
