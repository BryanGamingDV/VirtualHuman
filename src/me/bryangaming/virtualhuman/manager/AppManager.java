package me.bryangaming.virtualhuman.manager;

import me.bryangaming.virtualhuman.api.app.App;
import me.bryangaming.virtualhuman.api.manager.Manager;
import me.bryangaming.virtualhuman.app.AppType;
import me.bryangaming.virtualhuman.app.MathApp;

import java.util.HashMap;
import java.util.Map;

public class AppManager implements Manager {

    private final Map<AppType, App> appMap = new HashMap<>();

    public AppManager(){
        load();
    }

    @Override
    public void load() {
        appMap.put(AppType.MATH, new MathApp());
    }

    public App getApp(AppType appType){
        return appMap.get(appType);
    }
}
