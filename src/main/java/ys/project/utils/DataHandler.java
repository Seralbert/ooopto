package ys.project.utils;

import com.sun.javafx.binding.StringFormatter;
import ys.project.model.etalon.BookRecord;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 27.11.2019.
 *
 */
public abstract class DataHandler {
    // Thu Nov 28 00:00:00 MSK 2019
    public static Date stringToDate(String date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {

               //System.out.println("Объект: " + sdf.parse(date) + " " + date);
                return    sdf.parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Date dateToFind(String date) {
        //'2020-02-01 00:00:00'
        String patternLong = "E MMM dd HH:mm:ss z yyyy";
        String patternReverse = "yyyy-MM-dd HH:mm:ss";
        DateFormat df = new SimpleDateFormat(patternReverse);

        SimpleDateFormat sdf = new SimpleDateFormat(patternReverse);
        try {

            //System.out.println("Объект: " + sdf.parse(date));
            return    sdf.parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }
    public static String stringToString(String string){
        String[] parts = string.split("-");
        return parts[2]+parts[1]+parts[0];
    }

    public static String reverseDate(String s){
        String[] parts = s.split("\\.");
        return parts[2]+ "-" + parts[1] + "-" + parts[0];
    }
    public static String dateToString(Date date){
        String patternSmall = "yyyy-MM-dd";
        String patternLong = "E MMM dd HH:mm:ss z yyyy";
        DateFormat df = new SimpleDateFormat(patternSmall);
        return df.format(date);
    }

    public static String removeSpace(String s){
        return s.isEmpty()?"":s.replaceAll("\\s+","");
    }
    public static String makeSingleSpace(String s){
        return s.replaceAll("[\\s]{2,}", " ");
    }

    public static Double replaceSeparator(String s){
        String clean = removeSpace(s);
        String res = s.replaceAll(",", "\\.");

        return Double.parseDouble(res);
    }
    public static String replaceQuotes(String s){
        return s.replaceAll("\"","&quot;");
    }
    public static  String returnQuotes(String s) {return s.replaceAll("&quot;", "\"");}
    public static String replaceDQuotes(String s){
        return s.replaceAll("\"\"","&quot;");
    }

    /*public static  BookRecord setCommentField(BookRecord o, String docPlace, String fondEmpl){
        o.setDocPlace(docPlace);
        o.setFondEmpl(fondEmpl);
        return o;
    }
*/
    public static BookRecord inputer(String orgInfo, String docType, String docInvNumber,
                                     String docKadastrNumber, int docCreate, String docTransfer,
                                     String docAccessType, int pageCount, String sysCoord,
                                     String scale, Double objArea, String docName, String objName,
                                     String docAuthor, String objPrice, String docComment,
                                     String docPlace, String fondEmpl
    ){

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
        record.setDocName(DataHandler.replaceQuotes(DataHandler.makeSingleSpace(docName)));
        record.setObjName(objName);
        record.setDocAuthor(DataHandler.replaceQuotes(DataHandler.makeSingleSpace(docAuthor)));
        if(objPrice!=null)
            record.setObjPrice(objPrice);
        record.setDocComment(DataHandler.makeSingleSpace(docComment));
        //String[] comm = DataHandler.makeSingleSpace(docComment).split("\\|");
        /*if (comm.length == 3){
            record.setFondEmpl(comm[0]);
            record.setDocPlace(comm[1]);
            record.setDocComment(comm[2]);
        }*/
        record.setDocPlace(DataHandler.makeSingleSpace(DataHandler.replaceQuotes(docPlace)));
        record.setFondEmpl(DataHandler.makeSingleSpace(fondEmpl));
        return record;
    }


}
