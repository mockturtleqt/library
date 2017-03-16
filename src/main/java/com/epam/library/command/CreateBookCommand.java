package com.epam.library.command;

import com.epam.library.domain.Book;
import com.epam.library.exception.ServiceException;
import com.epam.library.service.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class CreateBookCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    public String execute() {
        Book book = new Book();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Title: ");
        book.setTitle(scanner.nextLine());
        System.out.println("Publication year: ");
        String year = scanner.nextLine();
        if (year.matches("\\d+")) {
            book.setYear(Integer.parseInt(year));
        }

        System.out.println("Author: ");
        book.setAuthor(scanner.nextLine());

        try {
            new BookService().create(book);
        } catch (ServiceException e) {
            logger.error(e);
        }
        return book.toString();
    }
}
