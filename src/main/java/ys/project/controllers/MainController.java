package ys.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ys.project.model.CustomDoc;
import ys.project.model.Note;
import ys.project.service.DocService;
import ys.project.service.NoteService;
import ys.project.service.UserService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by zorrax on 06.09.2018.
 * Основной контроллер проекта
 */
@Controller
public class MainController {
    private NoteService serviceNote;
    @Autowired
    public void setNoteServce(NoteService service){
        this.serviceNote = service;
    }

    private DocService serviceDoc;
    @Autowired
    public void setDocService(DocService serviceDoc) {this.serviceDoc = serviceDoc;}

    /*private UserService serviceUser;
    @Autowired
    public void setDocService(UserService serviceUser) {this.serviceUser = serviceUser;}
*/

    @Value("${upload.path}")
    private String uploadPath;
    @Value("${var.server.addr}")
    private String serverAddr;

    @RequestMapping("/")
    public String main(Model model){
        model.addAttribute("notes", serviceNote.findAll());
        //model.addAttribute("user",serviceUser.loadUserByUsername())
        model.addAttribute("serverAddr",serverAddr);
        return "main";
    }

    @RequestMapping("/docs")
    public String docs(Model model){
        model.addAttribute("docs", serviceDoc.findAll());
        model.addAttribute("serverAddr",serverAddr);
        return "docPage";
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("serverAddr",serverAddr);
    return "login";
    }

    @PostMapping("/add")
    public String addNote(@RequestParam String textCaption,
                          @RequestParam String textMain,
                          @RequestParam("file") MultipartFile file,
                          @RequestParam("fileDoc") MultipartFile fileDoc,
                          Model model) throws IOException {
        Note note = new Note(textCaption, textMain);
        // Add Image
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            note.setFileName(resultFilename);
        }
        // Add Doc
        if (fileDoc != null && !fileDoc.getOriginalFilename().isEmpty()) {

            String uuidFile = UUID.randomUUID().toString();
            String resultDocFilename = uuidFile + "." + fileDoc.getOriginalFilename();

            fileDoc.transferTo(new File(uploadPath + "/" + resultDocFilename));

            note.setFileDocName(resultDocFilename);
        }
        //
        serviceNote.saveNote(note);
        model.addAttribute("serverAddr",serverAddr);
     return "redirect:/";
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

    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable String id, Model model){
        serviceNote.deleteNote(serviceNote.findNoteById(id));
        model.addAttribute("serverAddr",serverAddr);
        return "redirect:/";
    }

    @RequestMapping("/deleteDoc/{id}")
    public String deleteDocById(@PathVariable String id, Model model){
        serviceDoc.deleteDoc(serviceDoc.findCustomDocById(id));
        model.addAttribute("serverAddr",serverAddr);
        return "redirect:/docs";
    }

    @RequestMapping("/{id}")
    //@RequestMapping("/note")
    public String notePage(@PathVariable String id, Model model){
        model.addAttribute("note", serviceNote.findNoteById(id));
        model.addAttribute("serverAddr",serverAddr);
        return "notePage";
    }
}
