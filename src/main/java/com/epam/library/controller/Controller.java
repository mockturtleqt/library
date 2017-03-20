package com.epam.library.controller;

import com.epam.library.command.Command;
import com.epam.library.command.factory.ActionFactory;
import com.epam.library.command.impl.ExitCommand;
import com.epam.library.database.ConnectionWrapper;

import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {
        System.out.println("Welcome to our library!");
        printMenu();
        Scanner scanner = new Scanner(System.in);

        try {
            while (scanner.hasNext()) {
                String userCommand = scanner.next();
                Command command = ActionFactory.getInstance().defineCommand(userCommand);

                System.out.println(command.execute());

                System.out.println("Would you like to continue? (yes/no)");
                if ("yes".equalsIgnoreCase(scanner.next())) {
                    printMenu();
                } else {
                    System.out.println(new ExitCommand().execute());
                    break;
                }
            }
        } finally {
            ConnectionWrapper.getInstance().closeConnection();
        }
    }

    private static void printMenu() {
        System.out.println("Type `REPORT_1` to view report on employees who've read 1+ books.");
        System.out.println("Type `REPORT_2` to view report on employees who've read 2+ books.");
        System.out.println("Type `RENAME_BOOK` to rename a book.");
        System.out.println("Type `CREATE_BOOK` to create a book.");
        System.out.println("Type `FIND_BOOK_BY_TITLE` to find a book by its title.");
        System.out.println("Type `FIND_BOOK_BY_ID` to find a book by its ID.");
        System.out.println("Type `FIND_ALL_BOOKS` to view all books in our library.");
        System.out.println("Type `DELETE_BOOK` to delete a book by its ID.");
    }
}
