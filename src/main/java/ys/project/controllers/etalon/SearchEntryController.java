package ys.project.controllers.etalon;

import org.apache.el.parser.ParseException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ys.project.model.Role;
import ys.project.model.SearchEntry;
import ys.project.model.User;
import ys.project.services.SearchServiceImpl;
import ys.project.utils.DataHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 27.08.2020.
 *
 */
@Controller
public class SearchEntryController {
    @Value("${upload.path}")
    private String upLoadPath;

    @Autowired
    private SearchServiceImpl searchService;

    @GetMapping("/searchRequestList")
    public String getSearchEntry(Model model){
        return "searchresult";
    }

    @GetMapping("/searchRequestForm")
    public String getSearchEntryForm(Model model){
        return "searchform";
    }
    @PostMapping("/doFindSearch")
    public String getSearchEntryResult(Model model,
                                       @AuthenticationPrincipal User user,
                                       @RequestParam(required = false) String orgInfo ,
                                       @RequestParam(required = false) String docTransferB,
                                       @RequestParam(required = false) String docTransferE
                                       ){
        //String exp_orgInfo = orgInfo.contains("ВСЕ") ? "" : orgInfo;
        String exp_docTransferB = docTransferB.isEmpty() ? "1900-01-01" : docTransferB;
        // @TODO Использовать текущую дату
        String exp_docTransferE = docTransferE.isEmpty() ? "2200-12-31" : docTransferE;
        //System.out.println(exp_orgInfo);
        //System.out.println(DataHandler.stringToDate(exp_docTransferB));
        //System.out.println(DataHandler.stringToDate(exp_docTransferE));
        List<SearchEntry> list;
        if(orgInfo.contains("ВСЕ")){
            list = searchService.findList(DataHandler.stringToDate(exp_docTransferB),DataHandler.stringToDate(exp_docTransferE));
            model.addAttribute("list", list);
            model.addAttribute("size", list.size());
        }else{
            list = searchService.findList(orgInfo,DataHandler.stringToDate(exp_docTransferB),DataHandler.stringToDate(exp_docTransferE));
            model.addAttribute("list", list);
            model.addAttribute("size", list.size());
        }

     //   model.addAttribute("list", searchService.findAll());
        return "searchresult";
    }

    @GetMapping("/searchDel/{id}")
    public String delSearch(
            @AuthenticationPrincipal User user,
            @PathVariable Long id){
        if(user.getRoles().contains(Role.ADMIN))
            searchService.delById(id);

        return "redirect:/searchRequestForm";
    }

    @RequestMapping(value = "/searchGen/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void reportExcel3(HttpServletResponse response,
                             @AuthenticationPrincipal User user,
                             @PathVariable Long id
                             )
            throws IOException, ParseException {
        if(user.getRoles().contains(Role.ADMIN)|| user.getRoles().contains(Role.USER)) {
            System.out.println("BEGIN GENERATION");
            SearchEntry entry = searchService.findById(id);
            Workbook template = WorkbookFactory.create(new FileInputStream(upLoadPath + "/" + "order1.xlsx"));
            Sheet sheet = template.getSheetAt(0);
            Row row = sheet.getRow(11);
            Cell cell = row.getCell(3);
            cell.setCellValue(entry.getUserName());
            row = sheet.getRow(17);
            cell = row.getCell(0);
            cell.setCellValue(entry.getKadNumber());

            response.setHeader("Content-Disposition", "inline;filename=\"" + URLEncoder.encode("order1_" + DataHandler.dateToString(new Date()) + ".xlsx", "UTF-8") + "\"");
            response.setContentType("application/xls");
            OutputStream outputStream = response.getOutputStream();
            template.write(outputStream);
            outputStream.flush();
            outputStream.close();
            System.out.println("Сформировано заявление на запрос в ГФД");
            System.out.println("END GENERATION");
        }
    }

}
