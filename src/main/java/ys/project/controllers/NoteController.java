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
import ys.project.model.Note;
import ys.project.service.NoteService;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by zorrax on 03.10.2018.
 * Коньроллер новостных записей
 */
@Controller
public class NoteController {
    @Value("${upload.path}")
    private String uploadPath;
    @Value("${var.server.addr}")
    private String serverAddr;

    private NoteService serviceNote;
    @Autowired
    public void setNoteServce(NoteService service){
        this.serviceNote = service;
    }

    @RequestMapping("/")
    public String main(Model model){
        /*Можно получить информацию о аутентифиакации
        */
        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User user = (User) authentication.getPrincipal();
        model.addAttribute("username", user.getUsername());
        model.addAttribute("roles", user.getAuthorities().stream().map(Role::getAuthority).collect(joining(",")));
*/

        model.addAttribute("notes", serviceNote.findAll());
        model.addAttribute("serverAddr",serverAddr);
        return "main";
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

    @RequestMapping("/delete/{id}")
    public String deleteById(@PathVariable String id, Model model){
        serviceNote.deleteNote(serviceNote.findNoteById(id));
        model.addAttribute("serverAddr",serverAddr);
        return "redirect:/";
    }

    @RequestMapping("/{id}")
    public String notePage(@PathVariable String id, Model model){
        model.addAttribute("note", serviceNote.findNoteById(id));
        model.addAttribute("serverAddr",serverAddr);
        return "notePage";
    }
}
