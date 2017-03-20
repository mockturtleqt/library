package com.epam.library.controller;

import com.epam.library.command.Command;
import com.epam.library.command.CommandEnum;
import com.epam.library.command.factory.ActionFactory;
import com.epam.library.command.impl.ExitCommand;
import com.epam.library.util.database.ConnectionWrapper;

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

        for (CommandEnum commandEnum : CommandEnum.values()) {
            System.out.println(commandEnum.getDescription());
        }
    }
}
