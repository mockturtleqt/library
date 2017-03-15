package com.epam.library.command;

import com.epam.library.entity.Book;
import com.epam.library.exception.ServiceException;
import com.epam.library.service.BookService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class ChangeBookTitleCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    public String execute() {
        Book book = new Book();
        try {
            BookService bookService = new BookService();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Old book title: ");
            String oldTitle = scanner.next();
            System.out.println("New book title: ");
            String newTitle = scanner.next();
            book = bookService.updateTitle(oldTitle, newTitle);
        } catch (ServiceException e) {
            logger.log(Level.ERROR, e);
        }
        return book.toString();
    }
}
