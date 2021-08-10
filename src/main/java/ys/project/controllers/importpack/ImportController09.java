package ys.project.controllers.importpack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ys.project.model.etalon.BookRecord;
import ys.project.services.BookRecordServiceImpl;
import ys.project.utils.BgHandler;
import ys.project.utils.DataHandler;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 11.12.2019.
 * реализция иморта книг инвентаризации
 */

public class ImportController09 {
    @Autowired
    private BookRecordServiceImpl recordService;
    @GetMapping("/import")
    public String getImportPage(Model model){
        return "import";
    }

    @GetMapping("/import091o")
    public String inputMarevoO1(Model model){
        model.addAttribute("bgImg", BgHandler.getBG());

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("C://1-О09utf.txt"), StandardCharsets.UTF_8))){
            String line;
            while ((line = reader.readLine()) != null) {
                String[] s = line.split("\t");
                String orgInfo =  "Маревский отдел";
                String docType = s[6];
                String docInvNumber = "1-О/" + s[0];
                String docKadastrNumber = getKadastrNumber(s[1]);
                int docCreate = getDocCreate(s[2]);
                String docTransfer = getDocTransfer(s[3]);
                String docAccessType = "Открытые";
                int pageCount = 0;
                String sysCoord = "МСК-53";
                String scale = "";
                Double objArea = 0d;
                String docName = modifyString(s[1]);
                String objName = "";
                String docAuthor = "";
                String objPrice = "";
                String addOn;
                if(s.length==8) addOn = modifyString(s[7]); else addOn = "";
                String docComment = s[4] + addOn;
                recordService.save(DataHandler.inputer(orgInfo, docType, docInvNumber,
                        docKadastrNumber, docCreate, docTransfer,
                        docAccessType, pageCount, sysCoord,
                        scale, objArea, docName, objName,
                        docAuthor, objPrice, docComment, "", ""));

            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла");
        }


        return "redirect:/";
    }
//
    @GetMapping("/import092o")
    public String inputMarevoO2(Model model){
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("C://2-О09utf.txt"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] s = line.split("\t");
                if(s.length!=0){
                    String orgInfo =  "Маревский отдел";
                    String docType = s[6].split(" ")[0];
                    String docInvNumber = "2-О/" + s[0];
                    String docKadastrNumber = "";
                    int docCreate = getDocCreate(s[2]);
                    String docTransfer = getDocTransfer(s[3]);
                    String docAccessType = "Открытые";
                    int pageCount = 0;
                    String sysCoord = "МСК-53";
                    String scale = "";
                    Double objArea = 0d;
                    String docName = modifyString(s[1]);
                    String objName = "";
                    String docAuthor = "";
                    String objPrice = "";
                    String docComment =s[4] + " " + s[3].substring(s[3].indexOf(" ")) + " " +s[6].substring(s[6].indexOf(" "));
                    //System.out.println(s[3].substring(s[3].indexOf(" ")));
                    //System.out.println(s[6].substring(s[6].indexOf(" ")));
                    recordService.save(DataHandler.inputer(orgInfo, docType, docInvNumber,
                            docKadastrNumber, docCreate, docTransfer,
                            docAccessType, pageCount, sysCoord,
                            scale, objArea, docName, objName,
                            docAuthor, objPrice, docComment, "", ""));
                    //System.out.println(docName);
                }

            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла");
        }
        return "redirect:/";
    }
    @GetMapping("/import091d")
    public String inputMarevoO3(Model model) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("C://1-ДСП09utf.txt"), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] s = line.split("\t");
                if (s.length != 0) {
                    String orgInfo = "Маревский отдел";
                    String docType = "";
                    String docInvNumber = "1-ДСП/" + s[0];
                    String docKadastrNumber = "";
                    int docCreate = getDocCreate(s[2]);
                    String docTransfer = getDocTransfer(s[3]);
                    String docAccessType = "ДСП";
                    int pageCount = 0;
                    String sysCoord = "МСК-53";
                    String scale = "";
                    Double objArea = 0d;
                    String docName = modifyString(s[1]);
                    String objName = "";
                    String docAuthor = "";
                    String objPrice = "";
                    String docComment;// =s[6] + " " + s[4].substring(s[4].indexOf(" ")) + " " +s[5] + " " + s[7];
                    //System.out.println(s[3].substring(s[3].indexOf(" ")));
                    //System.out.println(s[6].substring(s[6].indexOf(" ")));
                    if (s.length < 7) {
                        docComment = s[3].substring(s[3].indexOf(" "));
                    } else {
                        docComment = s[4] + " " + s[3].substring(s[3].indexOf(" ")) + " " + s[6];
                    }
                    recordService.save(DataHandler.inputer(orgInfo, docType, docInvNumber,
                            docKadastrNumber, docCreate, docTransfer,
                            docAccessType, pageCount, sysCoord,
                            scale, objArea, docName, objName,
                            docAuthor, objPrice, docComment, "", ""));
                    //System.out.println(s[0] + " " + s.length);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
        private String getKadastrNumber(String s){
        //if(s.contains(""))
        return "";
    }

    private String modifyString(String s){
        String res = DataHandler.makeSingleSpace(s);
        if(s.startsWith("\"")){
            res = s.substring(1,s.length()-1);
            //res = res.replaceAll("\"","\'");
            res = res.replaceAll("\"\"", "&quot;");
        }
        return res;
    }
    private int getDocCreate(String s){
        if(!s.isEmpty()){
            return Integer.parseInt(s);
        }
        return 0;
    }
    private String getDocTransfer(String s){
        if(!s.isEmpty() && s.contains(" ")){
            String res = s.split("\\s")[0];
            return res;
        }
        return "";
    }
    //
    /*private void inputer(String orgInfo, String docType, String docInvNumber,
                         String docKadastrNumber, int docCreate, String docTransfer,
                         String docAccessType, int pageCount, String sysCoord,
                         String scale, Double objArea, String docName, String objName,
                         String docAuthor, String objPrice, String docComment){
        BookRecord record = new BookRecord();

        record.setOrgInfo(orgInfo);
        record.setDocType(docType);
        record.setDocInvNumber(docInvNumber);
        record.setDocKadastrNumber(docKadastrNumber);
        record.setDocCreate(docCreate);
        if(!docTransfer.isEmpty())
            record.setDocTransfer(DataHandler.stringToDate(DataHandler.reverseDate(docTransfer)));
        record.setDocAccessType(docAccessType);
        record.setPageCount(pageCount);
        record.setSysCoord(sysCoord);
        record.setScale(scale);
        if(objArea!=null)
            record.setObjArea(objArea);
        record.setDocName(docName);
        record.setObjName(objName);
        record.setDocAuthor(docAuthor);
        if(objPrice!=null)
            record.setObjPrice(objPrice);
        record.setDocComment(DataHandler.makeSingleSpace(docComment));

        recordService.save(record);
        //if(docInvNumber.contains("76"))
        //System.err.println(record.getDocName());
    }*/
}
