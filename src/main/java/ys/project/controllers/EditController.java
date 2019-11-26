package ys.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ys.project.model.AppendDoc;
import ys.project.model.GFDDoc;
import ys.project.services.AppendDocService;
import ys.project.services.DocService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Создание и редактирование объектов 06.11.2019.
 */
@Controller
public class EditController {
    private List<String> docList = new ArrayList<>();
    private DocService service;
    private AppendDocService appendService;
    //private GFDDoc tmp;

    @Autowired
    public void setDocService(DocService service) {
        this.service = service;
    }
    @Autowired
    public void setAppendDocService(AppendDocService appendDocService){
        this.appendService = appendDocService;
    }


    @RequestMapping("/new")
    public String newDoc(Model model){
        model.addAttribute("listAppendDoc", docList);

        return "new";
    }
    @RequestMapping("/addNew")
    public String addDoc(@RequestParam(required = false) String rp ,
                         @RequestParam(required = false) String docNumber,
                         @RequestParam(required = false) String docDate,
                         @RequestParam(required = false) String numList,
                         @RequestParam(required = false) String sysCoord,
                         @RequestParam(required = false) String docName,
                         @RequestParam(required = false) String docAuthor,
                         Model model
    ){
        if (docDate != null && !docDate.equals("")) {
            GFDDoc gfdObj = new GFDDoc();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            gfdObj.setNameTO(rp);
            gfdObj.setNumDoc(docNumber);
            try {
                gfdObj.setDateDoc(sdf.parse(docDate));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            gfdObj.setNumList(Integer.parseInt(numList));
            gfdObj.setCoord(sysCoord);
            gfdObj.setNameDoc(docName);
            gfdObj.setAuthorDoc(docAuthor);
            service.addDoc(gfdObj);
        }
        return "redirect:/new";
    }
    @PostMapping("doAddDoc")
    public String doModal(Model model,
                          @RequestParam("fileDescription") String fileDescription,
                          @RequestParam(value = "file", required = false) MultipartFile file
                          ){
                //GFDDoc gfDdoc;
                AppendDoc o = new AppendDoc();
                o.setDescription(fileDescription);
                //o.setParent(gfdObj);
                appendService.addAppendDoc(o);
                docList.add(fileDescription);
        //System.out.println("modal");
        return "redirect:/new";
    }
}
