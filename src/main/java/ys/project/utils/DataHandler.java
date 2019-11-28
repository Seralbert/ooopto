package ys.project.utils;

import com.sun.javafx.binding.StringFormatter;

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

               // System.out.println("Объект: " + sdf.parse(date));
                return    sdf.parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Date dateToDate(Date date) {

        return
            null
            ;}
    public static String stringToString(String string){
        String[] parts = string.split("-");
        return parts[2]+parts[1]+parts[0];
    }
    public static String dateToString(Date date){
        String patternSmall = "yyyy-MM-dd";
        String patternLong = "E MMM dd HH:mm:ss z yyyy";
        DateFormat df = new SimpleDateFormat(patternSmall);
        return df.format(date);
    }
}
