package me.bryangaming.virtualhuman.writter;

import me.bryangaming.virtualhuman.api.Writter;

import java.util.ArrayList;
import java.util.List;

public class WritterLoader {

    private static final List<Writter> writterList = new ArrayList<>();

    public static void load(Writter writter){
        writterList.add(writter);
        writter.load();

    }

    public static Writter get(int id){
        return writterList.get(id);
    }

    public static void removeWritter(int id){
        writterList.remove(id);
    }
}
