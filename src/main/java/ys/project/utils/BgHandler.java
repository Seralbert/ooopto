package ys.project.utils;

/**
 * Created by User on 01.12.2019.
 * генератор фона
 */
public abstract class BgHandler {
    public static String getBG(){
        String[] source = {"bg1.jpg","bg2.jpg","bg3.jpg","bg4.jpg","bg25.jpg"};
        int index = (int)(Math.random()*source.length);

        return source[index];
    }
}
