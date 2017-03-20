package com.epam.library.command.impl.book;

import com.epam.library.command.Command;
import com.epam.library.domain.Book;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class RenameBookCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    public String execute() {
        Book book = new Book();
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Old book title: ");
            String oldTitle = scanner.nextLine();

            System.out.println("New book title: ");
            String newTitle = scanner.nextLine();

            book = ServiceFactory.getInstance().getBookService().updateTitle(oldTitle, newTitle);
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
