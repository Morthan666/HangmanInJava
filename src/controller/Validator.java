package controller;

import model.Capital;

import java.util.ArrayList;

public class Validator {

    public static Boolean validateWord(String userinput, Capital city) {
        if (userinput.toUpperCase().equals(city.getName())) {
            return true;
        } else {
            return false;
        }
    }

    public static String inputValidator(Character userinput, Capital city) {
        if (city.getDash().indexOf(userinput) >= 0) {
            return "Guessed";
        }
        if (city.getName().indexOf(userinput) == -1) {
            return "Wrong";
        }
        return "Correct";

    }


    public static String validateLetter(Character userinput, Capital city) {
        userinput = Character.toUpperCase(userinput);
        ArrayList<Integer> list = new ArrayList<Integer>();
        Integer index = city.getName().indexOf(userinput);
        while (index >= 0) {
            list.add(index);
            index = city.getName().indexOf(userinput, index + 1);
        }
        StringBuilder newDashed = new StringBuilder(city.getDash());
        for (Integer i = 0; i < list.size(); i++) {
            newDashed.setCharAt(list.get(i), userinput);

        }
        return newDashed.toString();
    }
}