package com.epam.library.controller;

import com.epam.library.command.Command;
import com.epam.library.command.CommandEnum;
import com.epam.library.command.EmptyCommand;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Controller {
    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        System.out.println("Welcome to our library!");
        System.out.println("Type `EMPLOYEE_REPORT_1` to view report on employees who've read 1+ books.");
        System.out.println("Type `EMPLOYEE_REPORT_2` to view report on employees who've read 2+ books.");
        System.out.println("Type `CHANGE_BOOK_TITLE` to rename a book.");
//        System.out.println("Press 4 if you want to exit");
//        TODO close connection on exit
        Scanner scanner = new Scanner(System.in);

        String userCommand = scanner.next();
        Command command = new EmptyCommand();

        if (!userCommand.isEmpty()) {
            try {
                command = CommandEnum.valueOf(userCommand.toUpperCase()).getCurrentCommand();
            } catch (IllegalArgumentException e) {
                logger.log(Level.ERROR, e);
            }

        }
        System.out.println(command.execute());
    }
}
