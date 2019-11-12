package ys.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ys.project.model.GFDDoc;
import ys.project.services.DocService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    @RequestMapping("/addNew")
    public String addDoc(@RequestParam String rp,
                         @RequestParam String docNumber,
                         @RequestParam String docDate,
                         @RequestParam String numList,
                         @RequestParam String sysCoord,
                         @RequestParam String docName,
                         @RequestParam String docAuthor,
                         Model model
    ){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        GFDDoc o = new GFDDoc();
        o.setNameTO(rp);
        o.setNumDoc(docNumber);
        try {
            o.setDateDoc(sdf.parse(docDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        o.setNumList(Integer.parseInt(numList));
        o.setCoord(sysCoord);
        o.setNameDoc(docName);
        o.setAuthorDoc(docAuthor);
        service.addDoc(o);
        return "new";
    }
}
