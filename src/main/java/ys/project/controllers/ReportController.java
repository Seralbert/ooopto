package ys.project.controllers;

import org.apache.el.parser.ParseException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import ys.project.model.Report1;
import ys.project.model.etalon.BookRecord;
import ys.project.services.ActionServiceImpl;
import ys.project.services.BookRecordServiceImpl;
import ys.project.utils.CreatePDF;
import ys.project.utils.DataHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.*;

/**
 * Created by Yuriy Smirnov on 07.11.2019.
 * Realise report page
 */
@Controller
public class ReportController {
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
            "Чудовский район"
    };


    @Value("${upload.path}")
    private String upLoadPath;
    @Autowired
    private BookRecordServiceImpl bookRecordService;

    @Autowired
    private ActionServiceImpl actionService;

    @RequestMapping(value = "/gen", method = RequestMethod.GET, produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> gen() {
        ByteArrayInputStream bis = CreatePDF.pdfReport();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }

    // @GetMapping("/makexls")
    @RequestMapping(value = "/genxls", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void myExcel(HttpServletResponse response)
            throws IOException, ParseException {

        Workbook template = WorkbookFactory.create(new FileInputStream(upLoadPath + "/" + "template.xlsx"));
        Sheet sheet = template.getSheetAt(0);
        Row row;
        List<BookRecord> list = bookRecordService.getByOrgInfoAndInvNumber("Маревский район", "2-О");
        int rowCounter = 2;

        Cell cell;
        CreationHelper ch = template.getCreationHelper();
        CellStyle cs = template.createCellStyle();
        cs.setDataFormat(
                ch.createDataFormat().getFormat("dd.mm.yyyy")
        );
        for (BookRecord r : list
                ) {
            //String[] comm = r.getDocComment().split("\\|");
            //System.err.println(comm[0] + comm[1] + comm[2]);
            row = sheet.createRow(rowCounter);

            row.createCell(0).setCellValue(r.getDocInvNumber().split("/")[1]);
            row.createCell(1).setCellValue(DataHandler.returnQuotes(r.getDocName()));
            row.createCell(2).setCellValue(r.getDocCreate());
            Date chkdate = r.getDocTransfer();
            //row.createCell(3).setCellValue(DateUtil.getExcelDate(chkdate));
            cell = row.createCell(3);
            cell.setCellStyle(cs);
            cell.setCellValue(chkdate);
            //System.out.println(chkdate);
            row.createCell(4).setCellValue(r.getDocPlace()); // 5 - место хранения
            if (r.getListDoc().isEmpty())
                row.createCell(5).setCellValue("");
            else
                row.createCell(5).setCellValue("в электронном виде"); // 6 - страховая копия
            row.createCell(6).setCellValue(r.getDocComment()); // 7 - примечание
            row.createCell(7).setCellValue(r.getDocType());
            row.createCell(8).setCellValue(DataHandler.returnQuotes(r.getDocAuthor()));
            row.createCell(9).setCellValue(r.getDocKadastrNumber());
            rowCounter++;
        }


        response.setHeader("Content-Disposition", "inline;filename=\"" + URLEncoder.encode("invbook.xlsx", "UTF-8") + "\"");
        response.setContentType("application/xls");

        OutputStream outputStream = response.getOutputStream();

        template.write(outputStream);

        outputStream.flush();
        outputStream.close();
    }

    @GetMapping("/getLog")
    public String getLog(Model model) {
        model.addAttribute("list", actionService.findAll());
        return "logreport";
    }

    //-------------------Отчет наполнение--------------------------
    @RequestMapping(value = "/genreport0", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void reportExcel1(HttpServletResponse response)
            throws IOException, ParseException {
        Workbook template = WorkbookFactory.create(new FileInputStream(upLoadPath + "/" + "report1.xlsx"));
        Sheet sheet = template.getSheetAt(0);
        int rowCounter = 2;
        Row row;
        Cell cell;


        System.out.println("Create report 1");
        for (String rs : r_otdel
                ) {
            Map<String, Integer> rmap = new HashMap<>();
            Map<String, Integer> rmapad = new HashMap<>();
            List<BookRecord> list = bookRecordService.getList(rs);
            //System.out.println(list.size() + " " + list.get(0).getDocInvNumber().split("/")[0]);
            for (BookRecord l : list
                    ) {
                String bookName = l.getDocInvNumber().split("/")[0];

                if (rmap.containsKey(bookName)) {
                    rmap.put(bookName, rmap.get(bookName) + 1);
                } else rmap.put(bookName, 1);
                if (!l.getListDoc().isEmpty())
                    if (rmapad.containsKey(bookName)) {
                        rmapad.put(bookName, rmapad.get(bookName) + 1);
                    } else rmapad.put(bookName, 1);

            }
            //System.out.println(rs);
            row = sheet.createRow(rowCounter);
            row.createCell(0).setCellValue(rs);
            rowCounter++;
            for (Map.Entry<String, Integer> entry : rmap.entrySet()
                    ) {
                row = sheet.createRow(rowCounter);
                row.createCell(0).setCellValue(entry.getKey());
                row.createCell(1).setCellValue(entry.getValue());
                row.createCell(2).setCellValue(0);
                rowCounter++;
                //System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
        response.setHeader("Content-Disposition", "inline;filename=\"" + URLEncoder.encode("report1.xlsx", "UTF-8") + "\"");
        response.setContentType("application/xls");

        OutputStream outputStream = response.getOutputStream();

        template.write(outputStream);

        outputStream.flush();
        outputStream.close();
    }

    @RequestMapping(value = "/genreport1", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void reportExcel2(HttpServletResponse response)
            throws IOException, ParseException {
        System.out.println("BEGIN GENERATION");
        List<Report1> report1List1 = new ArrayList<>();

        for (String rs : r_otdel
                ) {
            List<BookRecord> list = bookRecordService.getList(rs);
            Set<String> bookSet = new HashSet<>();

            for (BookRecord br : list
                    ) {
                String bookName = br.getDocInvNumber().split("/")[0];
                bookSet.add(bookName);
            }

            for (String s : bookSet
                    ) {
                Report1 report1 = new Report1(rs, s);
                report1.setRecordCount(bookRecordService.getCount(rs, s));
                report1.setAppCount(bookRecordService.getCountWAppend(rs, s));
                report1List1.add(report1);
            }

        }

        Workbook template = WorkbookFactory.create(new FileInputStream(upLoadPath + "/" + "report1.xlsx"));
        Sheet sheet = template.getSheetAt(0);
        int rowCounter = 1;
        Row row;

        for (Report1 r : report1List1
                ) {
            row = sheet.createRow(rowCounter);
            row.createCell(0).setCellValue(r.getOrgName());
            row.createCell(1).setCellValue(r.getBookName());
            row.createCell(2).setCellValue(r.getRecordCount());
            row.createCell(3).setCellValue(r.getAppCount());
            rowCounter++;

            System.out.println(r.getOrgName() + " " + r.getBookName() + " " + r.getRecordCount() + " " + r.getAppCount());
        }
        response.setHeader("Content-Disposition", "inline;filename=\"" + URLEncoder.encode("report1_" + DataHandler.dateToString(new Date()) +".xlsx", "UTF-8") + "\"");
        response.setContentType("application/xls");

        OutputStream outputStream = response.getOutputStream();

        template.write(outputStream);

        outputStream.flush();
        outputStream.close();

        System.out.println("END GENERATION");
    }

    @RequestMapping(value = "/genreport2", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public void reportExcel3(HttpServletResponse response)
            throws IOException, ParseException {
        System.out.println("BEGIN GENERATION");
        Workbook template = WorkbookFactory.create(new FileInputStream(upLoadPath + "/" + "report2.xlsx"));
        int rowCounter = 1;
        for (String rs : r_otdel
                ) {
            List<BookRecord> list = bookRecordService.getList(rs);
            Set<String> docCodeSet = new HashSet<>();
            Set<String> bookName = new HashSet<>();
            for (BookRecord br : list
                    ) {
                docCodeSet.add(br.getDocType());
                bookName.add(br.getDocInvNumber().split("/")[0]);
            }

            Sheet sheet = template.getSheetAt(0);
            Row row;
            for (String book : bookName
                    ) {
                for (String s : docCodeSet
                        ) {
                    int counter = bookRecordService.getCountByCode(rs, book, s);
                    if (counter != 0) {
                        System.out.println(rowCounter);
                        row = sheet.createRow(rowCounter);
                        row.createCell(0).setCellValue(rs);
                        row.createCell(1).setCellValue(book);

                        if (s.isEmpty()) {
                            //System.out.println("БЕЗ НОМЕРА" + row.getRowNum());
                            row.createCell(2).setCellValue("Без кода");
                            row.createCell(3).setCellValue(counter);
                            System.out.println(rs + " " + book + " без кода " + counter);
                            //rowCounter++;
                        } else {
                            //System.out.println("C НОМЕРОМ" + row.getRowNum());
                            row.createCell(2).setCellValue(s);
                            row.createCell(3).setCellValue(counter);
                            System.out.println(rs + " " + book + " " + s + " " + counter);
                            //rowCounter++;
                        }
                        rowCounter++;

                    }

                }
            }

        }
        response.setHeader("Content-Disposition", "inline;filename=\"" + URLEncoder.encode("report2_" + DataHandler.dateToString(new Date()) +".xlsx", "UTF-8") + "\"");
        response.setContentType("application/xls");
        OutputStream outputStream = response.getOutputStream();
        template.write(outputStream);
        outputStream.flush();
        outputStream.close();

        System.out.println("END GENERATION");
    }
}
