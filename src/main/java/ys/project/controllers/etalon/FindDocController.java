package ys.project.controllers.etalon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ys.project.model.FillReq;
import ys.project.model.User;
import ys.project.model.UserRequest;
import ys.project.model.etalon.BookRecord;
import ys.project.services.BookRecordServiceImpl;
import ys.project.services.FillReqServiceImpl;
import ys.project.services.GFDVocServiceImpl;
import ys.project.services.UserRequestServiceImpl;
import ys.project.utils.BgHandler;
import ys.project.utils.DataHandler;

import java.util.List;

/**
 * Created by Smirnov Yuriy on 30.01.2020.
 *
 */
@Controller
public class FindDocController {

    @Autowired
    private UserRequestServiceImpl userRequestService;

    @Autowired
    private BookRecordServiceImpl bookRecordService;

    @Autowired
    private GFDVocServiceImpl service;

    @Autowired
    private FillReqServiceImpl fillReqService;

    @RequestMapping("/find")
    public String find(Model model) {
        model.addAttribute("bgImg", BgHandler.getBG());
        model.addAttribute("voc", service.getAllCode());
        return "findentry";
    }

    @PostMapping("/doFind")
    public String doFind(Model model,
                         @RequestParam(required = false) String orgInfo,
                         @RequestParam(required = false) String docInvNumber,
                         @RequestParam(required = false) String docKadastrNumber,
                         @RequestParam(required = false) String docType,
                         @RequestParam(required = false) String docAccessType,
                         @RequestParam(required = false) String docName,
                         @RequestParam(required = false) String objName,
                         @RequestParam(required = false) String docAuthor,
                         @RequestParam(required = false) String docComment,
                         @RequestParam(required = false) String docCreateB,
                         @RequestParam(required = false) String docCreateE,
                         @RequestParam(required = false) String docTransferB,
                         @RequestParam(required = false) String docTransferE,
                         @RequestParam(required = false) String scaleB,
                         @RequestParam(required = false) String scaleE,
                         @RequestParam(required = false) String objPrice,
                         @AuthenticationPrincipal User user
                         //  @PageableDefault(sort = { "id" }, direction = Sort.Direction.DESC)Pageable pageable
    ) {
        String exp_orgInfo = orgInfo.contains("ВСЕ") ? "" : orgInfo;

        String exp_docType = docType.contains("ВСЕ") ? "" : docType;

        String exp_objPrice = objPrice.contains("ВСЕ") ? "" : objPrice;

        int exp_docCreateB = docCreateB.isEmpty() ? 0 : Integer.parseInt(docCreateB);
        int exp_docCreateE = docCreateE.isEmpty() ? 1000000 : Integer.parseInt(docCreateE);

        String exp_docTransferB = docTransferB.isEmpty() ? "1900-01-01" : docTransferB;
        // @TODO Использовать текущую дату
        String exp_docTransferE = docTransferE.isEmpty() ? "2200-12-31" : docTransferE;
        //System.out.println("Багнутая запись " + bookRecordService.findById(4l).getDocTransfer() );
        //System.out.println("Приходит " + exp_docTransferE);
        String exp_scaleB = scaleB.isEmpty() ? "0" : scaleB;
        String exp_scaleE = scaleE.isEmpty() ? "200000000000000000000" : scaleE;

        UserRequest request = userRequestService.getRequestByUsername(user.getUsername());
        if (request == null) request = new UserRequest();
        request.setOrgInfo(exp_orgInfo);
        request.setDocInvNumber(docInvNumber);
        request.setDocKadastrNumber(docKadastrNumber);
        request.setDocType(exp_docType);
        request.setDocAccessType(docAccessType);
        request.setDocName(DataHandler.replaceQuotes(docName));
        request.setObjName(objName);
        request.setDocAuthor(docAuthor);
        request.setDocComment(docComment);
        request.setDocCreateB(exp_docCreateB);
        request.setDocCreateE(exp_docCreateE);
        request.setDocTransferB(exp_docTransferB);
        request.setDocTransferE(exp_docTransferE);
        request.setUser(user.getUsername());


        userRequestService.save(request);
        System.out.println("Пользователь " + user.getFio() + " выполнил поиск ID - " + request.getId());
        return "redirect:/doFind?page=0&size=100";
    }

    @GetMapping("/doFind")
    public String doGetFind(Model model,
                            @AuthenticationPrincipal User user,
                            @PageableDefault(sort = {"docInvNumber"}, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        UserRequest request = userRequestService.getRequestByUsername(user.getUsername());
        Page<BookRecord> page = bookRecordService.findByPatternPage(
                request.getOrgInfo(),
                request.getDocInvNumber(),
                request.getDocKadastrNumber(),
                request.getDocType(),
                request.getDocAccessType(),
                request.getDocName(),
                request.getObjName(),
                request.getDocAuthor(),
                request.getDocComment(),
                request.getDocCreateB(),
                request.getDocCreateE(),
                DataHandler.stringToDate(request.getDocTransferB()),
                DataHandler.stringToDate(request.getDocTransferE()),
                pageable);
        model.addAttribute("header", "Найдено по критериям: " + request.getOrgInfo() + " - " + page.getTotalElements() + " записей");
        model.addAttribute("url", "/doFind");
        model.addAttribute("page", page);
        return "result";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/findAll")
    public String findAll(Model model,
                          @PageableDefault(sort = {"docInvNumber"}, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        model.addAttribute("page", bookRecordService.findAll(pageable));
        model.addAttribute("url", "/findAll");
        model.addAttribute("header", "");
        return "result";
    }

    @GetMapping("/fillRequest")
    public String getFillRequest(Model model,
                                 @AuthenticationPrincipal User user){
        UserRequest request = userRequestService.getRequestByUsername(user.getUsername());
        FillReq o = new FillReq();
        o.setUserName(user.getFio());
        o.setKadNumber(request.getDocKadastrNumber());
        o.setDocNumber(request.getDocInvNumber());
        o.setDocName(request.getDocName());
        fillReqService.save(o);
        return "redirect:/find";
    }

    @GetMapping("/fillRequestList")
    public String getFillList(Model model){
        model.addAttribute("list", fillReqService.findAll());
        return "fillreq";
    }

    @GetMapping("/deleteReq/{id}")
    public String deleteReq(@PathVariable("id")Long id) {
                return "redirect:/fillRequestList";
    }
}
