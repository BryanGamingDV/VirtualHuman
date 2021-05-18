package me.bryangaming.virtualhuman.app;

import me.bryangaming.virtualhuman.api.app.App;
import me.bryangaming.virtualhuman.utils.TextType;
import me.bryangaming.virtualhuman.utils.TextUtils;

import java.lang.invoke.StringConcatFactory;

public class MathApp implements App {


    @Override
    public void execute(String text) {
        String[] path = text.split(" ");

        int firstNumber;
        try {
            firstNumber = Integer.parseInt(path[0]);
        }catch (NumberFormatException numberFormatException) {
            TextUtils.log(TextType.BOT, "Unknown number: " + path[0]);
            return;

        }

        String operator;
        try {
            operator = path[1];
        }catch( ArrayIndexOutOfBoundsException | IllegalArgumentException exception){
            TextUtils.log(TextType.BOT, "Unknown args: [firstNumber] [operator] [secondNumber]");
            return;
        }

        if (!TextUtils.contains(operator, "+", "-", "*", "/")){
            TextUtils.log(TextType.BOT, "Unknown operator: [+, -, *, /]");
            return;
        }

        String secondText;
        try {
            secondText = path[2];
        }catch(ArrayIndexOutOfBoundsException | IllegalArgumentException excepction){
            TextUtils.log(TextType.BOT, "Unknown args: [firstNumber] [operator] [secondNumber]");
            return;
        }

        int secondNumber;
        try {
            secondNumber = Integer.parseInt(secondText);
        }catch (NumberFormatException exception){
            TextUtils.log(TextType.BOT, "Unknown number: " + secondText);
            return;
        }

        calculateNumber(firstNumber, operator, secondNumber);

    }

    private void calculateNumber(int firstNumber, String operator, int secondNumber){
        int number;
        switch (operator){
            case "+" -> number = firstNumber + secondNumber;
            case "-" -> number = firstNumber - secondNumber;
            case "*" -> number = firstNumber * secondNumber;
            case "/" -> number = firstNumber / secondNumber;
            default -> number = 0;
        }

        TextUtils.log(TextType.BOT, "The result is: " + number);
    }

}
