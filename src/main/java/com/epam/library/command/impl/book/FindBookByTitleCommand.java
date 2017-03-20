package com.epam.library.command.impl.book;

import com.epam.library.command.Command;
import com.epam.library.domain.Book;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class FindBookByTitleCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    public String execute() {
        Book book = new Book();
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Book title: ");
            book = ServiceFactory.getInstance().getBookService().findByTitle(scanner.nextLine());
        } catch (ServiceException e) {
            logger.error(e);
        }

        if (book != null) {
            return book.toString();
        } else {
            return "Sorry, we don't have books with this title.";
        }
    }
}
