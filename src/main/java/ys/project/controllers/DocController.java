package ys.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ys.project.model.CustomDoc;
import ys.project.service.DocService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by zorrax on 03.10.2018.
 *  Контроллер документов
 */
@Controller
public class DocController {
    @Value("${upload.path}")
    private String uploadPath;
    @Value("${var.server.addr}")
    private String serverAddr;


    private DocService serviceDoc;
    @Autowired
    public void setDocService(DocService serviceDoc) {this.serviceDoc = serviceDoc;}

    @RequestMapping("/docs")
    public String docs(

            Model model){
        model.addAttribute("docs", serviceDoc.findAll());
        model.addAttribute("serverAddr",serverAddr);
        return "docPage";
    }

    @RequestMapping("/addDoc")
    public String addDoc(
            @RequestParam String caption,
            @RequestParam("file") MultipartFile fileDoc,
            Model model
    ) throws IOException
    {
        if (fileDoc != null && !fileDoc.getOriginalFilename().isEmpty()) {
            CustomDoc doc = new CustomDoc();
            doc.setDiscription(caption);
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultDocFilename = uuidFile + "." + fileDoc.getOriginalFilename();

            fileDoc.transferTo(new File(uploadPath + "/" + resultDocFilename));
            doc.setFileName(resultDocFilename);
            doc.setOriginalDocName(fileDoc.getOriginalFilename());
            doc.setDiscription(caption);
            serviceDoc.saveDoc(doc);
            //note.setFileDocName(resultDocFilename);
        }
        model.addAttribute("serverAddr",serverAddr);
        return "redirect:/docs";
    }



    @RequestMapping("/deleteDoc/{id}")
    public String deleteDocById(@PathVariable String id, Model model){
        serviceDoc.deleteDoc(serviceDoc.findCustomDocById(id));
        model.addAttribute("serverAddr",serverAddr);
        return "redirect:/docs";
    }

    @RequestMapping("/docEdit/{id}")
    public String editRequestDoc(@PathVariable String id, Model model){
        CustomDoc current = (CustomDoc) serviceDoc.findCustomDocById(id);
        model.addAttribute("serverAddr",serverAddr);
        model.addAttribute("id", id);
        model.addAttribute("doc", current);
        return "docPage";
    }
}
