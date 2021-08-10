package ys.project.controllers.etalon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ys.project.model.AppendDoc;
import ys.project.model.Role;
import ys.project.model.SearchEntry;
import ys.project.model.User;
import ys.project.model.etalon.Action;
import ys.project.model.etalon.BookRecord;
import ys.project.services.*;
import ys.project.utils.DataHandler;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Smirnov Yuriy on 25.12.2019.
 *
 */
@Controller
public class EditDocController {
    //но gfd_root создать надо
    @Value("${upload.path}")
    private String upLoadPath;

    @Autowired
    private SearchServiceImpl searchService;

    @Autowired
    private ActionServiceImpl actionService;

    @Autowired
    private BookRecordServiceImpl recordService;


    @Autowired
    private GFDVocServiceImpl service;

    @Autowired
    private AppendDocService appendDocService;

    @GetMapping("/delete/{id}")
    public String deleteEntry(Model model,
                              @PathVariable Long id,
                              @AuthenticationPrincipal User user) {
        if(user.getRoles().contains(Role.USER)||user.getRoles().contains(Role.ADMIN)) {
            Action a = new Action();
            a.setNameRecord(recordService.findById(id).getDocInvNumber());
            a.setNameAppendDoc("");
            a.setNameAction("Delete Record");
            a.setUserName(user.getFio());

            recordService.delete(id);

            actionService.save(a);
        }
        model.addAttribute("voc", service.getAllCode());
        return "findentry";
    }

    @GetMapping("/edit/{id}")
    public String editEntry(Model model,
                            @PathVariable Long id, @AuthenticationPrincipal User user) {
        model.addAttribute("voc", service.getAllCode());
        BookRecord record = recordService.findById(id);
        model.addAttribute("listAppendDoc", record.getListDoc());
        model.addAttribute("id", record.getId());
        model.addAttribute("orgInfo", record.getOrgInfo());
        model.addAttribute("docType", record.getDocType());
        model.addAttribute("docInvNumber", record.getDocInvNumber());
        model.addAttribute("docKadastrNumber", record.getDocKadastrNumber());
        model.addAttribute("docCreate", record.getDocCreate());
        if (record.getDocTransfer() != null)
            model.addAttribute("docTransfer", DataHandler.dateToString(record.getDocTransfer()));
        else model.addAttribute("docTransfer", "");
        model.addAttribute("docAccessType", record.getDocAccessType().isEmpty() ? "------" : record.getDocAccessType());
        //System.out.println("------- pageCount-------- " + record.getPageCount());
        model.addAttribute("pageCount", record.getPageCount());

        model.addAttribute("sysCoord", record.getSysCoord());
        model.addAttribute("scale", record.getScale());
        model.addAttribute("objArea", record.getObjArea());
        model.addAttribute("docName", record.getDocName());
        model.addAttribute("objName", record.getObjName());
        model.addAttribute("docAuthor", record.getDocAuthor());
        model.addAttribute("objPrice", record.getObjPrice());
        model.addAttribute("docComment", record.getDocComment());
        model.addAttribute("fondEmpl", record.getFondEmpl());
        model.addAttribute("docPlace", record.getDocPlace());
        if(user.getRoles().contains(Role.GUEST)) {

            SearchEntry searchEntry = new SearchEntry();
            searchEntry.setDocNumber(record.getDocInvNumber());
            searchEntry.setUserName(user.getFio());
            searchEntry.setKadNumber(record.getDocKadastrNumber());
            searchEntry.setOrgName(record.getOrgInfo());
            searchService.save(searchEntry);
            System.out.println("Регистратор " + user.getFio() + "запросил документы ID - " + searchEntry.getId());
        }

        return "editentry";
    }

    @PostMapping("/editRecord/{id}")
    public String addNewRecord(Model model,
                               @AuthenticationPrincipal User user,
                               @PathVariable Long id,
                               @RequestParam(required = false) String orgInfo,
                               @RequestParam(required = false) String docType,
                               @RequestParam(required = false) String docInvNumber,
                               @RequestParam(required = false) String docKadastrNumber,
                               @RequestParam(required = false) String docCreate,
                               @RequestParam(required = false) String docTransfer,
                               @RequestParam(required = false) String docAccessType,
                               @RequestParam(required = false) String pageCount,
                               @RequestParam(required = false) String sysCoord,
                               @RequestParam(required = false) String scale,
                               @RequestParam(required = false) String objArea,
                               @RequestParam(required = false) String docName,
                               @RequestParam(required = false) String objName,
                               @RequestParam(required = false) String docAuthor,
                               @RequestParam(required = false) String objPrice,
                               @RequestParam(required = false) String docComment,
                               @RequestParam(required = false) String fondEmpl,
                               @RequestParam(required = false) String docPlace


    ) {
        BookRecord record = recordService.findById(id);
        if (!orgInfo.equals("------"))
            record.setOrgInfo(orgInfo);
        if (!docType.equals("------"))
            record.setDocType(docType);
        record.setDocInvNumber(docInvNumber);
        record.setDocKadastrNumber(docKadastrNumber);
        record.setDocCreate(Integer.parseInt(docCreate));
        if (!docTransfer.equals(""))
            record.setDocTransfer(DataHandler.stringToDate(docTransfer));
        if (!docAccessType.equals("------"))
            record.setDocAccessType(docAccessType);

        record.setPageCount(Integer.parseInt(pageCount));
        record.setSysCoord(sysCoord);
        record.setScale(scale);
        if (!objArea.isEmpty()) {
            record.setObjArea(DataHandler.replaceSeparator(objArea));
        }
        record.setDocName(DataHandler.replaceQuotes(docName));
        record.setObjName(objName);
        record.setDocAuthor(DataHandler.replaceQuotes(docAuthor));
        if (!objPrice.isEmpty()) {
            record.setObjPrice(objPrice);
        }
        record.setDocComment(DataHandler.replaceQuotes(docComment));
        record.setFondEmpl(DataHandler.replaceQuotes(fondEmpl));
        record.setDocPlace(DataHandler.replaceQuotes(docPlace));
        if(user.getRoles().contains(Role.USER)||user.getRoles().contains(Role.ADMIN)) {
            recordService.save(record);
        }
        Action a = new Action();
        a.setNameRecord(docInvNumber);
        a.setNameAppendDoc("");
        a.setNameAction("Edit Record");
        a.setUserName(user.getFio());
        actionService.save(a);
        //System.out.println(record.getId() + " ID updated Entry");
        return "redirect:/edit/" + record.getId();
    }


    @PostMapping("/editRecord/{id}/doAddDoc")
    public String doModal(Model model,
                          @AuthenticationPrincipal User user,
                          @PathVariable Long id,
                          @RequestParam("fileDescription") String fileDescription,
                          @RequestParam(value = "file") MultipartFile file
    ) throws IOException {
        if(user.getRoles().contains(Role.USER)||user.getRoles().contains(Role.ADMIN)) {
        BookRecord parent = recordService.findById(id);
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            String uuidFile = UUID.randomUUID().toString();

            AppendDoc o = new AppendDoc();
            o.setUuidFile(uuidFile);

            o.setDescription(fileDescription);
            o.setParentId(parent.getId());
            o.setCurrent_record(parent);
            //appendDocService.addAppendDoc(o);
            System.out.println("Begin Upload");
            //String uploadPath = upLoadPath + "/" + parent.getOrgInfo();
            String uploadPathNEW = upLoadPath + "/" + parent.getOrgInfo() + "/" + parent.getDocInvNumber().split("/")[0] + "/" + parent.getDocInvNumber().split("/")[1];
            //System.err.println(parent.getDocInvNumber().split("/")[1]);
            File uploadDir = new File(uploadPathNEW);

            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            //String resultFileName = uploadPath + "/" + uuidFile + "." + file.getOriginalFilename();
            String resultFileName = uploadPathNEW + "/" + file.getOriginalFilename();
            //          String resultFileName = test + "/" + file.getOriginalFilename();
            System.out.println(resultFileName);
            file.transferTo(new File(resultFileName));
            o.setFilePath(file.getOriginalFilename());
            o.setOrgName(parent.getOrgInfo());
            appendDocService.addAppendDoc(o);

            Action a = new Action();
            a.setNameRecord(parent.getDocInvNumber());
            a.setNameAppendDoc("");
            a.setNameAction("Add Image");
            a.setUserName(user.getFio());
            actionService.save(a);
            parent.getListDoc().add(o);
            System.out.println("Finish Upload");

            //docList.add(fileDescription);
            //System.out.println("modal");
        }}
        return "redirect:/edit/" + id;
    }

    @GetMapping("/editRecord/{id}/delAddDoc/{link}")
    public String delAppend(
            @AuthenticationPrincipal User user,
            @PathVariable Long id,
                            @PathVariable String link) {
        //String[] parts = link.split("!");
        //System.out.println("Проверка: " + id + " " + link);
        if(user.getRoles().contains(Role.USER)||user.getRoles().contains(Role.ADMIN)) {
            Action a = new Action();
            a.setNameRecord(recordService.findById(id).getDocInvNumber());
            a.setNameAppendDoc(link);
            a.setNameAction("Delete Image");
            a.setUserName(user.getFio());
            actionService.save(a);
            appendDocService.delAppendDoc(link);
        }
        return "redirect:/edit/" + id;
    }
}
