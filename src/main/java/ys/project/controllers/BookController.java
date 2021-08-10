package ys.project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ys.project.model.Fond;
import ys.project.model.User;
import ys.project.model.etalon.Action;
import ys.project.model.etalon.BookRecord;
import ys.project.services.ActionServiceImpl;
import ys.project.services.BookRecordServiceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Smirnov Yury on 09.09.2020.
 *
 */
@Controller
public class BookController {
    @Autowired
    private BookRecordServiceImpl bookRecordService;
    @Autowired
    private ActionServiceImpl actionService;
    private String[] r_otdel = {
            "Батецкий район",
            "Великий Новгород",
            "Новгородский район",
            "Боровический район",
            "Валдайский район",
            "Волотовский район",
            "Демянский район",
            "Крестецкий район",
            "Любытинский район",
            "Маловишерский район",
            "Маревский район",
            "Мошенской район",
            "Окуловский район",
            "Парфинский район",
            "Пестовский район",
            "Поддорский район",
            "Солецкий район",
            "Старорусский район",
            "Хвойнинский район",
            "Холмский район",
            "Чудовской район"
    };

    @RequestMapping("/bookList")
    public String st2(Model model) {
        List<Fond> gfd = new ArrayList<>();
        List<BookRecord> allRecord;
        for (String orgName : r_otdel
                ) {
            allRecord = bookRecordService.getList(orgName);
            Set<String> bookNameSet = new HashSet<>();
            for (BookRecord br : allRecord
                    ) {
                String bookName = br.getDocInvNumber().split("/")[0];
                bookNameSet.add(bookName);
            }

            for (String bn : bookNameSet
                    ) {
                Fond o = new Fond();
                //System.out.println("Новый фонд");
                o.setOrgName(orgName);
                //System.out.println("Отдел " + orgName);
                o.setBookName(bn);
                //System.out.println("Книга " + bn);
                List<BookRecord> tmp = bookRecordService.getByOrgInfoAndInvNumber(orgName, bn);
                //System.out.println("Размер книги" + tmp.size());
                o.setAllEntry(tmp);
                gfd.add(o);
            }

        }
        model.addAttribute("list", gfd);

        return "booklist";
    }
   // @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/delBook/{orgName}/{bookName}")
    public String delBook(
            @PathVariable("orgName") String orgName,
            @PathVariable("bookName") String bookName,
            @AuthenticationPrincipal User user
            ) {
        List<BookRecord> list = bookRecordService.getByOrgInfoAndInvNumber(orgName, bookName);
        for (BookRecord br : list
                ) {
            bookRecordService.delete(br.getId());
        }
        Action a = new Action();
        a.setNameAction("Удаление книги " + orgName + " " + bookName);
        a.setUserName(user.getFio());
        actionService.save(a);
        return "redirect:/bookList";
    }
}
