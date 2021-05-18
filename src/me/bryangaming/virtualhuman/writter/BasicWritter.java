package me.bryangaming.virtualhuman.writter;

import me.bryangaming.virtualhuman.manager.ActionManager;
import me.bryangaming.virtualhuman.api.Database;
import me.bryangaming.virtualhuman.api.Writter;
import me.bryangaming.virtualhuman.utils.TextType;
import me.bryangaming.virtualhuman.utils.TextUtils;

import java.io.InputStream;
import java.util.Scanner;

public class BasicWritter implements Writter {


    private boolean isEnabled = true;
    private Scanner scanner;

    private final InputStream inputStream;
    private final ActionManager actionManager;

    public BasicWritter(InputStream inputStream, ActionManager actionManager){
        this.inputStream = inputStream;
        this.actionManager = actionManager;
    }


    @Override
    public void load() {
        scanner = new Scanner(inputStream);
        TextUtils.log(TextType.SYSTEM, "Writter loaded!");
        sendWelcomeMessage();
        write();
    }

    @Override
    public void write(){
        while (isEnabled) {
           actionManager.execute(scanner.nextLine());
        }
    }

    @Override
    public void unload(){
        isEnabled = false;
    }

    public void sendWelcomeMessage(){
        TextUtils.log(TextType.EMPTY,
                " ",
                "VirtualHuman - 17/05/21",
                "Version - 1.0",
                "- Good luck!",
                " ");
    }
}
