package me.bryangaming.virtualhuman;

import me.bryangaming.virtualhuman.api.Core;
import me.bryangaming.virtualhuman.api.Database;
import me.bryangaming.virtualhuman.api.Writter;
import me.bryangaming.virtualhuman.database.BasicData;
import me.bryangaming.virtualhuman.manager.ActionManager;
import me.bryangaming.virtualhuman.writter.BasicWritter;
import me.bryangaming.virtualhuman.writter.WritterLoader;

public class SimpleCore implements Core {


    @Override
    public void init() {

        Database basicData = new BasicData();
        ActionManager actionManager = new ActionManager(basicData);
        Writter writter = new BasicWritter(System.in, actionManager);

        WritterLoader.load(writter);
    }

}
