package ys.project.controllers.importpack;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ys.project.model.AppendDoc;
import ys.project.model.etalon.BookRecord;
import ys.project.services.AppendDocServiceImpl;
import ys.project.services.BookRecordServiceImpl;
import ys.project.utils.DataHandler;

import javax.validation.constraints.NotNull;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Smirnov Yuriy on 24.04.2020.
 *
 */
@Controller
public class ImportController {

    @Value("${upload.path}")
    private String upLoadPath;

    @Autowired
    private BookRecordServiceImpl recordService;

    @Autowired
    private AppendDocServiceImpl appendDocService;

    @GetMapping("/import")
    public String getImportPage(Model model){
        return "import";
    }

    @PostMapping("/importo")
    public  String input00(Model model,
                              @RequestParam String orgInfo,
                              @RequestParam String fileName,
                              @RequestParam String bookName
                              ){
        int cc=0;
        try {
            String docAccessType = "ДСП";
            int pageCount = 0;
            String sysCoord = "МСК-53";
            String scale = "";
            Double objArea = 0d;
            String objName = "";
            String docAuthor = "";
            String objPrice = "";
            String docKadastrNumber = "";
            String docPlace = "";
            String fondEmpl ="";


            Workbook wb = WorkbookFactory.create(new FileInputStream(fileName));
            Sheet sheet = wb.getSheetAt(0);
            Iterator<Row> iterator = sheet.iterator();
            //String oInfo = orgInfo;
            if(bookName.toLowerCase().contains("о"))docAccessType = "Открытые";
            while (iterator.hasNext()) {
                Row row = iterator.next();

                Cell c = row.getCell(0);
                //System.out.println(c.getCellType());
                if (c.getCellType().equals(CellType.BLANK))break;
                //System.out.println(c.getCellType() + " " + c.getCellStyle().getAlignment());
                if (row.getCell(1).getCellType().equals(CellType.STRING) && c.getCellType().equals(CellType.NUMERIC) && (c.getCellStyle().getAlignment()).equals(HorizontalAlignment.CENTER) ) {
                    ++cc;
                    int docInvNumber = (int) row.getCell(0).getNumericCellValue();
                    String docName = "";
                    if(row.getCell(1).getCellType().equals(CellType.STRING))
                    docName = row.getCell(1).getStringCellValue();
                    int docCreate = (int) row.getCell(2).getNumericCellValue();
                    String docTransfer = "";
                    String addon = "";
                    String docComment = "";
                    //System.out.println(row.getCell(3).getCellType());
                    if(row.getCell(3).getCellType().equals(CellType.STRING)) {
                        String base = row.getCell(3).getStringCellValue();
                        docTransfer = base.split("\\s")[0];

                        //addon = base.substring(docTransfer.length(),base.length()); // Сотрудник фонда
                        fondEmpl = base.substring(docTransfer.length(),base.length()); // Сотрудник фонда

                    } else
                    if (!row.getCell(3).getCellType().equals(CellType.BLANK))
                        if (row.getCell(3).getCellType().equals(CellType.NUMERIC) && DateUtil.isCellDateFormatted(row.getCell(3)))
                        docTransfer = dateToString(row.getCell(3).getDateCellValue());
                    if(row.getCell(4).getCellType().equals(CellType.STRING))

                    //    addon += "|" + row.getCell(4).getStringCellValue(); // место хранения
                    docPlace = row.getCell(4).getStringCellValue(); // место хранения
                    boolean hasCopy = false;
                    if(row.getCell(5).getCellType().equals(CellType.STRING))
                        if (row.getCell(5).getStringCellValue().contains("имеется электронный вид"))hasCopy = true;
                    if(row.getCell(6).getCellType().equals(CellType.STRING))
                    //    addon += "|" + row.getCell(6).getStringCellValue(); // Предыдущий номер
                    docComment =  row.getCell(6).getStringCellValue(); // Предыдущий номер
                    String docType = "";
                    if(row.getCell(7).getCellType().equals(CellType.STRING))
                        docType = row.getCell(7).getStringCellValue();

                    if(row.getCell(8).getCellType().equals(CellType.STRING))
                        docAuthor = row.getCell(8).getStringCellValue();

                    if(row.getCell(9).getCellType().equals(CellType.STRING))
                        docKadastrNumber = row.getCell(9).getStringCellValue();

                    //docComment = addon;

                    recordService.save(
                            DataHandler.inputer(orgInfo, docType, bookName + "/" + docInvNumber,
                            docKadastrNumber, docCreate, docTransfer,
                            docAccessType, pageCount, sysCoord,
                            scale, objArea, docName, objName,
                            docAuthor, objPrice, docComment, docPlace, fondEmpl));

                    System.out.println("SAVE RECORD " + bookName + "/" + docInvNumber + "|" + cc);
                    if(docInvNumber != cc)System.err.println("" + docInvNumber + " " + cc + " " );

                }
                //System.out.println(c.getAddress());

            }
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(orgInfo + "|" + fileName + "|" + bookName);
        return "redirect:/import";
    }
    @PostMapping("/importimg")
    public  String input01(Model model,
                           @RequestParam String orgInfo,
                           @RequestParam String fileName
    ) {
        //System.out.println(orgInfo + " " + fileName);
        try(
        FileInputStream fis = new FileInputStream(fileName);
        InputStreamReader isr = new InputStreamReader(fis, "cp866");
        ){
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine())!=null)
        {
            String path = line.replaceAll("\\\\", "//");
            File chk = new File(path);
            if(!chk.isDirectory() && !line.contains(fileName)){
            //if(!chk.isDirectory())
            //    System.out.println(chk.getName());
            String[] parts = line.split("\\\\");
            String invNumber = parts[parts.length - 2].split(" ")[0];
            String[] in = invNumber.split("О");
            String iNumber = in[0]+ "-О/" + in[1];
            //System.out.println("Отдел: " + orgInfo + " Итоговый номер: " + iNumber);
            BookRecord record = recordService.getOneByOrgInfoAndInvNumber(orgInfo,iNumber);


            //----------------------------------------------------------

                AppendDoc o = new AppendDoc();
                o.setUuidFile(UUID.randomUUID().toString());

                o.setDescription("");
                o.setParentId(record.getId());
                o.setCurrent_record(record);
                System.out.println("Begin Upload");
                String uploadPathNEW = upLoadPath + "/" + record.getOrgInfo() + "/" + record.getDocInvNumber().split("/")[0] + "/" + record.getDocInvNumber().split("/")[1];
                //System.err.println(record.getDocInvNumber().split("/")[1]);
                File uploadDir = new File(uploadPathNEW);

                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                String resultFileName = uploadPathNEW + "/" + chk.getName();
                System.out.println(resultFileName);
                File out = new File(resultFileName);
                FileUtils.copyFile(chk,out);

                o.setFilePath(out.getName());
                o.setOrgName(record.getOrgInfo());
                appendDocService.addAppendDoc(o);

                record.getListDoc().add(o);
                //----------------------------------------------------------



            System.out.println(record.getDocName());
            }
        }
        }catch (IOException e){
            e.printStackTrace();
        }
        return "redirect:/import";
    }


    @GetMapping ("/reimport")
    public String getReimport(Model model){

        File dir = new File(upLoadPath); //path указывает на корневую директорию
        List<File> lst = new ArrayList<>();

        File[] org_in_root = dir.listFiles();
        File[] book_in_org = null;
        File[] rec_in_book = null;
        File[] img_in_rec = null;

        String orgName, bookName, recNum, imgName;

        if (org_in_root!=null){
            for ( File file :  org_in_root){
                if ( file.isDirectory() )
                    // Список книг
                    book_in_org = file.listFiles();
                    if (book_in_org != null)
                    for (File b : book_in_org) {
                        if (b.isDirectory()) {
                            rec_in_book = b.listFiles();
                            if (rec_in_book != null)
                            for (File r : rec_in_book) {
                                if (r.isDirectory()){
                                    img_in_rec = r.listFiles();
                                    if (img_in_rec != null)
                                    for (File i : img_in_rec){
                                        if (i.isFile()){
                                            orgName = file.getName();
                                            bookName = b.getName();
                                            recNum = r.getName();
                                            imgName = i.getName();

                                           /* System.out.println(orgName +"|" +
                                                    bookName + "/" +
                                                    recNum + "|" +
                                                    imgName);
                                                    */
BookRecord record = recordService.getOneByOrgInfoAndInvNumber(orgName,bookName + "/" + recNum);
if (record != null){
//System.out.println(record.getDocName());

    AppendDoc o = new AppendDoc();
    o.setUuidFile(UUID.randomUUID().toString());

    o.setDescription("");
    o.setParentId(record.getId());
    o.setCurrent_record(record);

    o.setFilePath(imgName);
    o.setOrgName(record.getOrgInfo());
    List<AppendDoc> recAppList = record.getListDoc();
    boolean needSkip = false;
    for (AppendDoc ad : recAppList){
        if (ad.getFilePath().equals(imgName)){
            needSkip = true;
        }
    }
    if (!needSkip){
    appendDocService.addAppendDoc(o);
    recAppList.add(o);

    System.out.println("Связан: "+ orgName +"|" +
            bookName + "/" +
            recNum + "|" +
            imgName);
    } else {
        System.out.println("Уже есть: "+ orgName +"|" +
                bookName + "/" +
                recNum + "|" +
                imgName);
    }
}
                                        }
                                    }
                                }

                            }
                        }
                    }
            }

        }
        return "redirect:/import";
    }
    @GetMapping("/recreate")
    public String getRecreate(Model model){
/*создаем пустой каталог для образов*/
        List<BookRecord> list = recordService.getAll();
        if (list!= null && !list.isEmpty())
        for (BookRecord r : list) {
            String recPathNEW = upLoadPath + "/" + r.getOrgInfo() + "/" + r.getDocInvNumber();
            File recDir = new File(recPathNEW);
            if (!recDir.exists()) {
                System.out.println("Создаем каталог: " + recPathNEW);
                recDir.mkdirs();
            }
        }
        return "redirect:/import";
    }

    private String dateToString(Date date) {
        String patternSmall = "yyyy-MM-dd";
        String patternSmall1 = "dd.MM.yyyy";
        String patternLong = "E MMM dd HH:mm:ss z yyyy";
        DateFormat df = new SimpleDateFormat(patternSmall1);
        return df.format(date);
    }
}
