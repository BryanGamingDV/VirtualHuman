package me.bryangaming.virtualhuman.utils;

public enum TextType {
    BOT("[BOT] - "), EMPTY(""), SYSTEM("[SYSTEMe] - ");

    private final String text;

    TextType(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }
}
