package com.epam.library.command;

import com.epam.library.domain.Book;
import com.epam.library.exception.ServiceException;
import com.epam.library.service.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class FindBookByIdCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    public String execute() {
        Book book = new Book();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Book ID:");
            String id = scanner.nextLine();
            if (id.matches("\\d+")) {
                book = new BookService().findById(Integer.parseInt(id));
            } else {
                logger.error("Wrong ID.");
            }
        } catch (ServiceException e) {
            logger.error(e);
        }

        if (book != null) {
            return book.toString();
        } else {
            return "Sorry, we don't have books with this id.";
        }
    }
}
