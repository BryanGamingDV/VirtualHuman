package me.bryangaming.virtualhuman.manager;

import me.bryangaming.virtualhuman.api.Database;
import me.bryangaming.virtualhuman.api.app.App;
import me.bryangaming.virtualhuman.api.manager.Manager;
import me.bryangaming.virtualhuman.builder.BuilderType;
import me.bryangaming.virtualhuman.app.AppType;
import me.bryangaming.virtualhuman.utils.TextType;
import me.bryangaming.virtualhuman.utils.TextUtils;
import me.bryangaming.virtualhuman.writter.WritterLoader;

import javax.lang.model.type.NoType;
import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.Map;

public class ActionManager implements Manager {

    private final Database dataManager;
    private AppManager appManager;

    private AppType appType;

    public ActionManager(Database dataManager){
        this.dataManager = dataManager;
        this.appType = AppType.NOTHING;
        load();
    }

    @Override
    public void load() {
        appManager = new AppManager();
        TextUtils.log(TextType.SYSTEM,"Actions loaded!");
    }

    public void execute(String text) {
        if (appType != AppType.NOTHING){
            appManager.getApp(appType).execute(text);
            return;
        }

        if (text.startsWith("-")) {
            executeFlags(text);
            return;
        }

        for (String word : text.split(" ")){
            if (dataManager.containsWord(word)) {
                continue;
            }

            if (word.trim().isEmpty()){
                continue;
            }

            dataManager.addWord(word);
        }

        executeText();



    }

    public void executeText(){
        int dataSize = dataManager.getSize();

        for (BuilderType builderType : BuilderType.values()){
            if (dataSize < builderType.getNumberRequeriment()){
                executeStringBuilder(builderType.getBuilderTimes());
                break;
            }
        }
    }

    public void executeStringBuilder(int times){
        StringBuilder stringBuilder = new StringBuilder();

        int id = 0;
        while (id != times){
            stringBuilder.append(dataManager.getRandomWord()).append(" ");
            id++;
        }

        TextUtils.log(TextType.BOT, stringBuilder.toString());
    }


    public void executeFlags(String flag){
        String flagName = flag.split(" ")[0];

        switch (flagName) {
            case "-stop" -> stopWriter(0);
            case "-size" -> TextUtils.log(TextType.BOT, "The data size is: " + dataManager.getSize() + " words.");
            case "-app" -> {

                String app;
                try {
                    app = flag.split(" ")[1];
                }catch(ArrayIndexOutOfBoundsException  arrayIndexOutOfBoundsException){
                    TextUtils.log(TextType.BOT, "Unknown args: -app [type]");
                    return;
                }
                AppType appType;
                try{
                    appType = AppType.valueOf(app.toUpperCase());
                }catch (IllegalArgumentException illegalArgumentException){
                    TextUtils.log(TextType.BOT, "Unknown app.");
                    return;
                }
                executeApp(appType);
                TextUtils.log(TextType.BOT, "App executed! " + flag.split(" ")[1]);
            }
            case "-resetwords" -> {
                dataManager.getData().clear();
                TextUtils.log(TextType.BOT, "Bot reseted!");
            }
            default -> TextUtils.log(TextType.BOT, "Unknown flag!");
        }
    }


    public void executeApp(AppType appType){
        this.appType = appType;
    }
    public void stopWriter(int id){
        WritterLoader.get(id).unload();
    }
}
