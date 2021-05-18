package me.bryangaming.virtualhuman.utils;

public class TextUtils {


    public static void log(TextType textType, String text){
        System.out.println(textType.getText() + text);
    }

    public static void log(TextType textType, String... texts){
        for (String text : texts){
            System.out.println(textType.getText() + text);
        }
    }

    public static boolean contains(String text, String... textMatchers ){
        for (String textMatcher : textMatchers){
            if (text.contains(textMatcher)){
                return true;
            }
        }
        return false;
    }

}
