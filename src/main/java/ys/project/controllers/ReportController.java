package ys.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ys.project.services.DocService;
import ys.project.utils.BgHandler;
import ys.project.utils.CreatePDF;

import java.io.ByteArrayInputStream;

/**
 * Created by User on 07.11.2019.
 * Realise report page
 */
@Controller
public class ReportController {
    private DocService service;

    @Autowired
    public void setDocService(DocService service) {
        this.service = service;
    }


    @RequestMapping("/report")
    public String report(Model model){
        model.addAttribute("docs", service.findAll());
        model.addAttribute("bgImg", BgHandler.getBG());
        return "report";
    }


    @RequestMapping(value = "/gen", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> gen(){
        ByteArrayInputStream bis = CreatePDF.pdfReport();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

}
