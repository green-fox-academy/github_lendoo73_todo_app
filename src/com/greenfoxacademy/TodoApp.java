package com.greenfoxacademy;

import java.util.List;
import java.util.function.Supplier;

public class TodoApp {

    public static void main(String[] args) {

        csvHandler csvHandler = new csvHandler("todos.csv");

        String[] test1  = new String[]{};
        String[] test21  = new String[]{"-a", "Kutyát sétáltatni"};
        String[] test22 = new String[]{"-a", "Tejet venni"};
        String[] test23  = new String[]{"-a", "Megcsinálni a leckét"};
        String[] test24  = new String[]{"-l"};
        String[] list  = new String[]{"-l"};
        String[] add  = new String[]{"-a", "Megetetni a papagájt"};
        String[] test5  = new String[]{"-a"};
        String[] test6  = new String[]{"-r", "2"};
        String[] test71  = new String[]{"-r"};
        String[] test72  = new String[]{"-r", "20"};
        String[] test73  = new String[]{"-r", "apple"};
        String[] test8  = new String[]{"get"};
        String[] test9  = new String[]{"-c", "2"};
        String[] test101  = new String[]{"-a", "Kutyát sétáltatni"};
        String[] test102  = new String[]{"-a", "Tejet venni"};
        String[] test103  = new String[]{"-a", "Megcsinálni a leckét"};
        String[] changeRow2toChecked  = new String[]{"-c", "2"};
        String[] changeRow4toChecked  = new String[]{"-c", "4"};
        String[] removeRow4  = new String[]{"-r", "4"};
        String[] listAll  = new String[]{"-la"};


        args = listAll;

        String operation = args.length > 0
                ? args[0]
                : "";

        String output = "";
        int numIndex;

        switch (operation) {
            case "":
            case "-h":
            case "-help":
                Commands.help();
                break;
            case "-a":
            case "-add":
                if (ErrorHandler.hasSecondArg(args)) {
                    csvHandler.append(args[1] + ",0");
                } else {
                    output = "Nem lehetséges új feladat hozzáadása: nincs megadva a feladat!";
                }
                break;
            case "-l":
            case "-list":
                if (csvHandler.notEmpty()) {
                    csvHandler.printWithRowNumber();
                } else {
                    output = "Nincs mára tennivalód! :)";
                }
                break;
            case "-r":
            case "-remove":
                output = ErrorHandler.indexChecking(args, csvHandler.numOfLines());
                if (output.length() > 0) break;

                numIndex = Integer.parseInt(args[1]);
                csvHandler.removeRow(numIndex);
                break;
            case "-c":
            case "-check":
                output = ErrorHandler.indexChecking(args, csvHandler.numOfLines());
                if (output.length() > 0) break;

                numIndex = Integer.parseInt(args[1]);
                csvHandler.changeCell(numIndex, 2, "1");
                break;
            case "-la":
            case "-listAll":
                csvHandler.printWithRowNumber(2, "1", " - [X] ", " - [ ] ");
                break;
            default:
                output = "Nem támogatott argumentum!";
                break;
        }

        System.out.println(output);
    }
}
