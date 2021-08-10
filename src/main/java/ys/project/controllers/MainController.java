package ys.project.controllers;


import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ys.project.model.ImageDoc;
import ys.project.model.User;
import ys.project.repository.etalon.BookRecordRepository;
import ys.project.services.AppendDocServiceImpl;
import ys.project.services.BookRecordServiceImpl;
import ys.project.services.ImageServiceImpl;
import ys.project.services.ImgService;
import ys.project.utils.BgHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yuriy Smirnov on 06.09.2018.
 * Основной контроллер проекта, проводит работу с доступом
 */
@Controller
public class MainController {
    @Autowired
    private ImageServiceImpl service;

    @Autowired
    private BookRecordServiceImpl bookRecordService;

    @Autowired
    private AppendDocServiceImpl appendDocService;

@RequestMapping("/")
    public String index(Model model,
                        @AuthenticationPrincipal User user
                        ){

return "welcom";
}

    @RequestMapping("/stat1")
    public String st1(Model model,
                        @AuthenticationPrincipal User user
    ){
        //model.addAttribute("bgImg", BgHandler.getBG());


    model.addAttribute("r", "Великий Новгород");
    model.addAttribute("record",bookRecordService.getCount("Великий Новгород"));
    model.addAttribute("image",appendDocService.getCount("Великий Новгород"));

    model.addAttribute("r0", "Новгородский район");
    model.addAttribute("record00",bookRecordService.getCount("Новгородский район"));
    model.addAttribute("image00",appendDocService.getCount("Новгородский район"));

    model.addAttribute("r1", "Батецкий район");
    model.addAttribute("record01",bookRecordService.getCount("Батецкий район"));
    model.addAttribute("image01",appendDocService.getCount("Батецкий район"));

    model.addAttribute("r2", "Боровический район");
    model.addAttribute("record02",bookRecordService.getCount("Боровический район"));
    model.addAttribute("image02",appendDocService.getCount("Боровический район"));

    model.addAttribute("r3", "Валдайский район");
    model.addAttribute("record03",bookRecordService.getCount("Валдайский район"));
    model.addAttribute("image03",appendDocService.getCount("Валдайский район"));

    model.addAttribute("r4", "Волотовский район");
    model.addAttribute("record04",bookRecordService.getCount("Волотовский район"));
    model.addAttribute("image04",appendDocService.getCount("Волотовский район"));

    model.addAttribute("r5", "Демянский район");
    model.addAttribute("record05",bookRecordService.getCount("Демянский район"));
    model.addAttribute("image05",appendDocService.getCount("Демянский район"));

    model.addAttribute("r6", "Крестецкий район");
    model.addAttribute("record06",bookRecordService.getCount("Крестецкий район"));
    model.addAttribute("image06",appendDocService.getCount("Крестецкий район"));

    model.addAttribute("r7", "Любытинский район");
    model.addAttribute("record07",bookRecordService.getCount("Любытинский район"));
    model.addAttribute("image07",appendDocService.getCount("Любытинский район"));

    model.addAttribute("r8", "Маловишерский район");
    model.addAttribute("record08",bookRecordService.getCount("Маловишерский район"));
    model.addAttribute("image08",appendDocService.getCount("Маловишерский район"));

    model.addAttribute("r9", "Маревский район");
    model.addAttribute("record09",bookRecordService.getCount("Маревский район"));
    model.addAttribute("image09",appendDocService.getCount("Маревский район"));

    model.addAttribute("r10", "Мошенской район");
    model.addAttribute("record10",bookRecordService.getCount("Мошенской район"));
    model.addAttribute("image10",appendDocService.getCount("Мошенской район"));

    model.addAttribute("r11", "Окуловский район");
    model.addAttribute("record11",bookRecordService.getCount("Окуловский район"));
    model.addAttribute("image11",appendDocService.getCount("Окуловский район"));


    model.addAttribute("r12", "Парфинский район");
    model.addAttribute("record12",bookRecordService.getCount("Парфинский район"));
    model.addAttribute("image12",appendDocService.getCount("Парфинский район"));

    model.addAttribute("r13", "Пестовский район");
    model.addAttribute("record13",bookRecordService.getCount("Пестовский район"));
    model.addAttribute("image13",appendDocService.getCount("Пестовский район"));


    model.addAttribute("r14", "Поддорский район");
    model.addAttribute("record14",bookRecordService.getCount("Поддорский район"));
    model.addAttribute("image14",appendDocService.getCount("Поддорский район"));

    model.addAttribute("r15", "Солецкий район");
    model.addAttribute("record15",bookRecordService.getCount("Солецкий район"));
    model.addAttribute("image15",appendDocService.getCount("Солецкий район"));

    model.addAttribute("r16", "Старорусский район");
    model.addAttribute("record16",bookRecordService.getCount("Старорусский район"));
    model.addAttribute("image16",appendDocService.getCount("Старорусский район"));

    model.addAttribute("r17", "Хвойнинский район");
    model.addAttribute("record17",bookRecordService.getCount("Хвойнинский район"));
    model.addAttribute("image17",appendDocService.getCount("Хвойнинский район"));

    model.addAttribute("r18", "Холмский район");
    model.addAttribute("record18",bookRecordService.getCount("Холмский район"));
    model.addAttribute("image18",appendDocService.getCount("Холмский район"));

    model.addAttribute("r19", "Чудовский район");
    model.addAttribute("record19",bookRecordService.getCount("Чудовский район"));
    model.addAttribute("image19",appendDocService.getCount("Чудовский район"));

    return "main";
    }


/*
//TEST MAPING
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
*/
}
