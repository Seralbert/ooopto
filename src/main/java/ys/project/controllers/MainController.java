package ys.project.controllers;


import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ys.project.model.ImageDoc;
import ys.project.services.ImageServiceImpl;
import ys.project.services.ImgService;
import ys.project.utils.BgHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zorrax on 06.09.2018.
 * Основной контроллер проекта, проводит работу с доступом
 */
@Controller
public class MainController {
    @Autowired
    private ImageServiceImpl service;
@RequestMapping("/")
    public String index(Model model){
    model.addAttribute("bgImg", BgHandler.getBG());
    return "main";
}

//TEST MAPING
@GetMapping("/append")
    public String appendNew(Model model){
    ImageDoc i = new ImageDoc();
    try {
        InputStream is = new FileInputStream("c://1.pdf");
        if(is != null) {

            byte[] f = IOUtils.toByteArray(is);
            System.out.println(f.length);
            //i.setFile(IOUtils.toByteArray(is));
            i.setFile(f);
            service.save(i);


            ImageDoc out = new ImageDoc();
            out = service.findByID(1L);
            System.out.println("Размер в байтах" + out.getFile().length);
            try (FileOutputStream fos = new FileOutputStream("c://out.pdf")) {
                fos.write(f);

            } catch (IOException e){e.printStackTrace();}

        }else System.out.println("NO RESOURCE");


    } catch (IOException e) {
        e.printStackTrace();
    }

    return "append";
}
@PostMapping("/append")
    public String appendNewW(Model model){
        return "append";
    }

@GetMapping("/gogogog")
    public String getDoc(Model model){
    List<ImageDoc> list = new ArrayList<>();
    list.addAll(service.findAll());

    ImageDoc o = list.get(0);
    try (FileOutputStream fos = new FileOutputStream("c://out.pdf")) {
        fos.write(o.getFile());
    } catch (IOException e){e.printStackTrace();}
    return "append";}
}
