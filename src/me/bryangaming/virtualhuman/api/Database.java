package me.bryangaming.virtualhuman.api;

import java.util.List;

public interface Database {


    void addWord(String text);

    void removeWord(String text);

    String getRandomWord();

    boolean containsWord(String word);

    int getSize();

    List<String> getData();

}
