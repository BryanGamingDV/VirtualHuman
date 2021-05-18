package me.bryangaming.virtualhuman.database;

import me.bryangaming.virtualhuman.api.Database;
import me.bryangaming.virtualhuman.utils.TextType;
import me.bryangaming.virtualhuman.utils.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class BasicData implements Database {

    private final List<String> words = new ArrayList<>();

    public BasicData(){
        TextUtils.log(TextType.SYSTEM, "Database loaded!");
    }
    @Override
    public void addWord(String text) {
        words.add(text);
    }

    @Override
    public void removeWord(String text) {
        words.remove(text);
    }

    @Override
    public String getRandomWord() {
        int id = (int) Math.round(Math.random() * words.size());

        if (id == words.size()){
            id--;
        }

        return words.get(id);
    }

    @Override
    public boolean containsWord(String word){
        return words.contains(word);
    }

    @Override
    public int getSize(){
        return words.size();
    }

    @Override
    public List<String> getData(){
        return words;
    }
}
