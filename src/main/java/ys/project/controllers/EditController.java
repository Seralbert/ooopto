package ys.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ys.project.model.AppendDoc;
import ys.project.model.GFDDoc;
import ys.project.services.AppendDocService;
import ys.project.services.DocService;
import ys.project.utils.BgHandler;
import ys.project.utils.DataHandler;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Создание и редактирование объектов 06.11.2019.
 */
@Controller
public class EditController {
    //но gfd_root создать надо
    @Value("${upload.path}")
    private String upLoadPath;

    //private List<String> docList = new ArrayList<>();
    private DocService service;
    private AppendDocService appendService;
    private GFDDoc tmp;

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
        model.addAttribute("bgImg", BgHandler.getBG());

        return "new";
    }
    /*
    * Создаем новую запись - документ для добавления в него образов
    *
    * */
    @PostMapping("/addNew")
    public String addDoc(@RequestParam(required = false) String rp ,
                         @RequestParam(required = false) String docNumber,
                         @RequestParam(required = false) String docDate,
                         @RequestParam(required = false) String numList,
                         @RequestParam(required = false) String sysCoord,
                         @RequestParam(required = false) String docName,
                         @RequestParam(required = false) String docAuthor,
                         Model model
    ){


            GFDDoc gfdObj = new GFDDoc();

            gfdObj.setNameTO(rp);
            gfdObj.setNumDoc(docNumber);
            gfdObj.setDateDoc(DataHandler.stringToDate(docDate));
            gfdObj.setNumList(Integer.parseInt(numList));
            gfdObj.setCoord(sysCoord);
            gfdObj.setNameDoc(docName);
            gfdObj.setAuthorDoc(docAuthor);
            //System.out.println(gfdObj.getId());
            service.save(gfdObj);
            //System.out.println("gfd "+gfdObj.getDateDoc());
            tmp = gfdObj;
            //System.out.println("tmp "+tmp.getDateDoc());
        //}
        return "redirect:/update";
    }
    @PostMapping("doAddDoc")
    public String doModal(Model model,
                          @RequestParam("fileDescription") String fileDescription,
                          @RequestParam(value = "file") MultipartFile file
                          ) throws IOException
    {
        //System.out.println("YYEP");
        if(file!=null && !file.getOriginalFilename().isEmpty()) {
            String uuidFile = UUID.randomUUID().toString();

            AppendDoc o = new AppendDoc();
            o.setUuidFile(uuidFile);
            o.setDescription(fileDescription);
            o.setParentId(tmp.getId());
            appendService.addAppendDoc(o);
            System.out.println("Begin Upload");
            String uploadPath = upLoadPath + "/" + tmp.getNameTO();
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {uploadDir.mkdir();}
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            file.transferTo(new File(uploadPath + "/" + resultFileName));

            System.out.println("Finish Upload");

            //docList.add(fileDescription);
            //System.out.println("modal");
        }
        return "redirect:/update";
    }
    /*
    * Обновление существуещего объекта
    * на фронте
    * */

    @GetMapping("/update")
    public String upd(Model model
        ){
        model.addAttribute("bgImg", BgHandler.getBG());
        System.err.println("ПРИШЛИ" + tmp.getId());
        model.addAttribute("listAppendDoc", appendService.findByParentId(tmp.getId()));
        //System.err.println("tmp.err! : " + tmp.getId());
        model.addAttribute("docAuthor",tmp.getAuthorDoc());
        model.addAttribute("docName",tmp.getNameDoc());
        model.addAttribute("docDate",DataHandler.dateToString(tmp.getDateDoc()));
        model.addAttribute("docID", tmp.getId());
        model.addAttribute("numList",tmp.getNumList());
        model.addAttribute("docNumber",tmp.getNumDoc());
        System.err.println("docNumber" + tmp.getNumDoc());
        return "update";
    }
    @PostMapping("/update")
    public String updateGFDDoc(
            @RequestParam(required = false) String rp ,
            @RequestParam(name = "docID", required = false) Long id ,
            @RequestParam(required = false) String docNumber,
            @RequestParam(required = false) String docDate,
            @RequestParam(required = false) String numList,
            @RequestParam(required = false) String sysCoord,
            @RequestParam(required = false) String docName,
            @RequestParam(required = false) String docAuthor,
            Model model
    )  {
        GFDDoc gfdObj = service.findById(id);

        //System.err.println("Дернули из БД: " + gfdObj.getId());
        //if(service.findByNameDoc(docName)==null)gfdObj = new GFDDoc();else gfdObj = service.findByNameDoc(docName);
       // gfdObj.setId(tmp.getId());
        gfdObj.setNameTO(rp);
        gfdObj.setNumDoc(docNumber);
        System.err.println("docNumber : " + docNumber);
        gfdObj.setDateDoc(DataHandler.stringToDate(docDate));
        gfdObj.setNumList(Integer.parseInt(numList));
        gfdObj.setCoord(sysCoord);
        gfdObj.setNameDoc(docName);
        gfdObj.setAuthorDoc(docAuthor);
        //gfdObj.setId(tmp.getId());
        service.update(gfdObj);
        tmp = gfdObj;
        return "redirect:/update";
    }

    @GetMapping("/edit/{id}")
    public String editDocument(@PathVariable Long id, Model model){
        tmp = service.findById(id);
        System.out.println(tmp.getNumDoc());
        return "redirect:/update";
    }

}
