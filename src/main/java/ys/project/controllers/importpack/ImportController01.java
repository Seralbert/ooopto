package ys.project.controllers.importpack;

import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ys.project.model.etalon.BookRecord;
import ys.project.services.BookRecordServiceImpl;
import ys.project.utils.DataHandler;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * Created by User on 16.02.2020.
 *
 */

public class ImportController01 {
    @Autowired
    private BookRecordServiceImpl recordService;
    @GetMapping("/import013o")
    public  String inputBat03(Model model){
        List<String> list = new ArrayList<>();
        int cc=0;
        try {
            //Workbook wb = WorkbookFactory.create(new File("C://1-О01.xls"));
            Workbook wb = WorkbookFactory.create(new FileInputStream("C://3-О01.xls"));
            Sheet sheet = wb.getSheetAt(2);
            Iterator<Row> iterator = sheet.iterator();
            String orgInfo = "Батецкий отдел";
            String docAccessType = "Открытые";
            int pageCount = 0;
            String sysCoord = "МСК-53";
            String scale = "";
            Double objArea = 0d;
            String objName = "";
            String docAuthor = "";
            String objPrice = "";
            String docKadastrNumber = "";
            while (iterator.hasNext()) {
                Row row = iterator.next();

                Cell c = row.getCell(0);
                //System.out.println(c.getAddress()); //Адрес ячейки
                if (c.getCellType().equals(CellType.NUMERIC) && (c.getCellStyle().getAlignment()).equals(HorizontalAlignment.GENERAL)) {
                    ++cc;
                    int docInvNumber = (int) row.getCell(0).getNumericCellValue(); //
                    if(cc!=docInvNumber) System.out.println("BUG");
                    String docName = ""; //
                    int docCreate = (int) row.getCell(5).getNumericCellValue(); //
                    String docTransfer = ""; // NUMERIC
                    String docComment = ""; // NUMERIC
                    String addOn = "";
                    String docType = "";
                    String copyInfo = row.getCell(11).getStringCellValue();
                    for (int i = 0; i < 6; i++) {
                        if (!row.getCell(1).getCellType().equals(CellType.BLANK))
                            docName += " " + row.getCell(1).getStringCellValue();

                        if (!row.getCell(7).getCellType().equals(CellType.BLANK))
                            if (row.getCell(7).getCellType().equals(CellType.NUMERIC) && DateUtil.isCellDateFormatted(row.getCell(7))) {
                                docTransfer = dateToString(row.getCell(7).getDateCellValue());
                            } else {
                                //if (i == 4) System.err.println(row.getCell(7).getStringCellValue());
                                docComment += " " + row.getCell(7).getStringCellValue();
                            }
                        if (!row.getCell(9).getCellType().equals(CellType.BLANK))
                            addOn += " " + row.getCell(9).getStringCellValue();

                        if (!row.getCell(13).getCellType().equals(CellType.BLANK))
                            docType += " " + row.getCell(13).getStringCellValue();
                        row = iterator.next();
                    }

                   // System.out.println(cc +"|"+ docInvNumber + docName + docCreate + docTransfer + addOn + docType + docComment);

                    recordService.save(DataHandler.inputer(orgInfo, docType, "3-О/" + docInvNumber,
                            docKadastrNumber, docCreate, docTransfer,
                            docAccessType, pageCount, sysCoord,
                            scale, objArea, docName, objName,
                            docAuthor, objPrice, docComment, "" , ""));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/import";
    }


    @GetMapping("/import011o")
    public String inputBat01(Model model){

        List<String> list = new ArrayList<>();
        List<BookRecord> tempy = new ArrayList<>();
        int cc=0;
        try {
            //Workbook wb = WorkbookFactory.create(new File("C://1-О01.xls"));
            Workbook wb = WorkbookFactory.create(new FileInputStream("C://1-О01.xls"));
            Sheet sheet = wb.getSheetAt(2);
            Iterator<Row> iterator = sheet.iterator();
            String orgInfo = "Батецкий отдел";
            String docAccessType = "Открытые";
            int pageCount = 0;
            String sysCoord = "МСК-53";
            String scale = "";
            Double objArea = 0d;
            String objName = "";
            String docAuthor = "";
            String objPrice = "";
            String docKadastrNumber = "";

            while (iterator.hasNext()) {
                Row row = iterator.next();

                Cell c = row.getCell(0);
                //System.out.println(c.getAddress()); //Адрес ячейки
                if (c.getCellType().equals(CellType.NUMERIC) && (c.getCellStyle().getAlignment()).equals(HorizontalAlignment.GENERAL)) {
                    ++cc;
                    int docInvNumber = (int) row.getCell(0).getNumericCellValue(); //
                    if(cc!=docInvNumber) System.out.println("BUG");
                    String docName = ""; //
                    int docCreate = (int) row.getCell(5).getNumericCellValue(); //
                    String docTransfer = ""; // NUMERIC
                    String docComment = ""; // NUMERIC
                    String addOn = "";
                    String docType = "";
                    String copyInfo = row.getCell(11).getStringCellValue();
                    for (int i = 0; i < 6; i++) {
                        if (!row.getCell(1).getCellType().equals(CellType.BLANK))
                            docName += " " + row.getCell(1).getStringCellValue();

                        if (!row.getCell(7).getCellType().equals(CellType.BLANK))
                            if (row.getCell(7).getCellType().equals(CellType.NUMERIC) && DateUtil.isCellDateFormatted(row.getCell(7))) {
                                docTransfer = dateToString(row.getCell(7).getDateCellValue());
                            } else {
                                //if (i == 4) System.err.println(row.getCell(7).getStringCellValue());
                                docComment += " " + row.getCell(7).getStringCellValue();
                            }
                        if (!row.getCell(9).getCellType().equals(CellType.BLANK))
                            addOn += " " + row.getCell(9).getStringCellValue();

                        if (!row.getCell(13).getCellType().equals(CellType.BLANK))
                            docType += " " + row.getCell(13).getStringCellValue();
                        row = iterator.next();
                    }

                   // System.out.println(docInvNumber + docName + docCreate + docTransfer + addOn + docType + docComment);
                   /*

                    list.add(docInvNumber +"\t"
                            + docName +"\t"
                            + docCreate +"\t"
                            + docTransfer +" " +  addOn +"\t"
                            + docComment +"\t"
                            + "отсутствует" +"\t"
                            + docType +"\t"
                            + "-" +"\t"
                            + "-"
                            );
                            */
                    recordService.save(DataHandler.inputer(orgInfo, docType, "1-О/" + docInvNumber,
                            docKadastrNumber, docCreate, docTransfer,
                            docAccessType, pageCount, sysCoord,
                            scale, objArea, docName, objName,
                            docAuthor, objPrice, docComment, "", ""));

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // ЗАПИСЬ ФАЙЛА!
        /*try {
            Files.write(Paths.get("batetsk.csv"),list, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        return "redirect:/";
    }
    private String dateToString(Date date) {
        String patternSmall = "yyyy-MM-dd";
        String patternSmall1 = "dd.MM.yyyy";
        String patternLong = "E MMM dd HH:mm:ss z yyyy";
        DateFormat df = new SimpleDateFormat(patternSmall1);
        return df.format(date);
    }
}
