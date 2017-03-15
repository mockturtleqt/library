package com.epam.library.controller;

import com.epam.library.command.Command;
import com.epam.library.command.ExitCommand;
import com.epam.library.database.ConnectionWrapper;
import com.epam.library.factory.ActionFactory;

import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {
        System.out.println("Welcome to our library!");
        printMenu();
        Scanner scanner = new Scanner(System.in);

        try {
            while (scanner.hasNext()) {
                String userCommand = scanner.next();
                Command command = new ActionFactory().defineCommand(userCommand);

                System.out.println(command.execute());

                if (command instanceof ExitCommand) {
                    break;
                }
                System.out.println("Would you like to continue? (yes/no)");
                if (!"yes".equalsIgnoreCase(scanner.next())) {
                    break;
                } else {
                    printMenu();
                }
            }
        } finally {
            ConnectionWrapper.getInstance().closeConnection();
        }
    }

    private static void printMenu() {
        System.out.println("Type `REPORT_1` to view report on employees who've read 1+ books.");
        System.out.println("Type `REPORT_2` to view report on employees who've read 2+ books.");
        System.out.println("Type `CHANGE_BOOK_TITLE` to rename a book.");
        System.out.println("Type `EXIT` to exit");
    }
}
