package com.greenfoxacademy;

import java.util.List;

public class TodoApp {

    public static void main(String[] args) {

        csvHandler csvHandler = new csvHandler("todos.csv");

        String[] test1  = new String[]{};
        String[] test21  = new String[]{"-a", "Kutyát sétáltatni"};
        String[] test22 = new String[]{"-a", "Tejet venni"};
        String[] test23  = new String[]{"-a", "Megcsinálni a leckét"};
        String[] test24  = new String[]{"-l"};
        String[] test3  = new String[]{"-l"};
        String[] test4  = new String[]{"-a", "Megetetni a papagájt"};
        String[] test5  = new String[]{"-a"};
        String[] test6  = new String[]{"-r", "2"};

        args = test6;

        String operation = args.length > 0
                ? args[0]
                : "";

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
                    System.out.println("Nem lehetséges új feladat hozzáadása: nincs megadva a feladat!");
                }
                break;
            case "-l":
            case "-list":
                if (csvHandler.notEmpty()) {
                    csvHandler.printWithRowNumber();
                } else {
                    System.out.println("Nincs mára tennivalód! :)");
                }
                break;
            case "-r":
            case "-remove":
                //System.out.println("remove a todo logic");
                // be kell olvasni a fajlbol

            default:
                //System.out.println("not supported operation");

        }

        /*
        // read todos from file
                    FileHandler file = new FileHandler("todo.csv");
                    List<String> lines = file.readAllLines();

                    // build todolist from file
                    TodoList todos = new TodoList();
                    for (String line : lines) {
                        String[] parsedData = line.split(",");
                        String description = parsedData[0];
                        boolean isDone = parsedData[1] == "1";
                        todos.add(new Todo(description, isDone));
                    }

                    // add new todo to the list:
                    todos.add(todo);

                    // create striglist from todolist:

                    // save updated todolist to the file:
         */
    }
}
