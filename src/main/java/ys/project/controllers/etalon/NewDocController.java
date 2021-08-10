package ys.project.controllers.etalon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ys.project.model.User;
import ys.project.model.etalon.Action;
import ys.project.model.etalon.BookRecord;
import ys.project.services.ActionServiceImpl;
import ys.project.services.BookRecordServiceImpl;
import ys.project.services.GFDVocServiceImpl;
import ys.project.utils.BgHandler;
import ys.project.utils.DataHandler;

/**
 * Created by Smirnov Yuriy on 25.12.2019.
 *
 */
@Controller
public class NewDocController {
    //но gfd_root создать надо
    @Value("${upload.path}")
    private String upLoadPath;

    @Autowired
    private BookRecordServiceImpl recordService;

    @Autowired
    private GFDVocServiceImpl service;

    @Autowired
    private ActionServiceImpl actionService;

    @RequestMapping("/new")
    public String newDoc(Model model){
        model.addAttribute("bgImg", BgHandler.getBG());
        model.addAttribute("voc", service.getAllCode());
        return "newentry";
    }

    @PostMapping("/addNewRecord")
    public String addNewRecord(Model model,
                               @AuthenticationPrincipal User user,
                               @RequestParam(required = false) String orgInfo ,
                               @RequestParam(required = false) String docType ,
                              @RequestParam(required = false) String docInvNumber ,
                              @RequestParam(required = false) String docKadastrNumber ,
                              @RequestParam(required = false) int docCreate ,
                              @RequestParam(required = false) String docTransfer ,
                              @RequestParam(required = false) String docAccessType ,
                              @RequestParam(required = false) int pageCount ,
                              @RequestParam(required = false) String sysCoord ,
                              @RequestParam(required = false) String scale ,
                              @RequestParam(required = false) Double objArea ,
                              @RequestParam(required = false) String docName ,
                              @RequestParam(required = false) String objName ,
                              @RequestParam(required = false) String docAuthor ,
                              @RequestParam(required = false) String objPrice ,
                              @RequestParam(required = false) String docComment

    ){
        if(!docTransfer.isEmpty()) {
            BookRecord record = new BookRecord();

            record.setOrgInfo(orgInfo);
            record.setDocType(docType);
            record.setDocInvNumber(docInvNumber);
            record.setDocKadastrNumber(docKadastrNumber);
            //if(!docCreate.isEmpty())
            record.setDocCreate(docCreate);

            record.setDocTransfer(DataHandler.stringToDate(docTransfer));

            record.setDocAccessType(docAccessType);
            //String nPageCount = pageCount.replaceAll("\\s+","");
            record.setPageCount(pageCount);
            record.setSysCoord(sysCoord);
            record.setScale(scale);
            if (objArea != null)
                record.setObjArea(objArea);
            record.setDocName(docName);
            record.setObjName(objName);
            record.setDocAuthor(docAuthor);
            if (objPrice != null)
                record.setObjPrice(objPrice);
            record.setDocComment(docComment);

            recordService.save(record);
            // Создание записи журнала

            Action a = new Action();
            a.setNameRecord(docInvNumber);
            a.setNameAppendDoc("");
            a.setNameAction("Add new Record");
            a.setUserName(user.getFio());
            actionService.save(a);

        //System.out.println(record.getId() + " ID new Entry");
        return "redirect:/edit/"+ record.getId();}
        else  return "redirect:/";
    }
}