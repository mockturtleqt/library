package com.epam.library.command.impl.book;

import com.epam.library.command.Command;
import com.epam.library.domain.Book;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class CreateBookCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    public String execute() {
        Book book = new Book();

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Title: ");
            book.setTitle(scanner.nextLine());

            System.out.println("Publication year: ");
            String year = scanner.nextLine();
            if (year.matches("\\d+")) {
                book.setYear(Integer.parseInt(year));
            }

            System.out.println("Author: ");
            book.setAuthor(scanner.nextLine());

            ServiceFactory.getInstance().getBookService().create(book);

        } catch (ServiceException e) {
            logger.error(e);
        }

        return book.toString();
    }
}
