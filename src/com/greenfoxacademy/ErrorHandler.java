package com.greenfoxacademy;

public class ErrorHandler {

    public static boolean hasSecondArg(String[] args) {
        return args.length > 1;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }

        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }

        return true;
    }

    public static String indexChecking(String[] args, int numOfLines) {
        if ( !ErrorHandler.hasSecondArg(args) ) {
            return "Nem lehetséges az eltávolítás: nem adott meg indexet!";
        }

        String index = args[1];

        if ( !ErrorHandler.isNumeric(index) ) {
            return "Nem lehetséges az eltávolítás: a megadott index nem szám!";
        }

        int numIndex = Integer.parseInt(index);
        if (numOfLines < numIndex) {
            return "Nem lehetséges az eltávolítás: túlindexelési probléma adódott!";
        }

        return "";
    }
}
