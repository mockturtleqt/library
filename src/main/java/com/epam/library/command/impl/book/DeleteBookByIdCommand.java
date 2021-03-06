package com.epam.library.command.impl.book;

import com.epam.library.command.Command;
import com.epam.library.service.exception.ServiceException;
import com.epam.library.service.factory.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class DeleteBookByIdCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    public String execute() {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Book ID:");
            String id = scanner.nextLine();

            if (id.matches("\\d+")) {
                ServiceFactory.getInstance().getBookService().deleteById(Integer.parseInt(id));
            } else {
                logger.error("Wrong ID.");
            }

        } catch (ServiceException e) {
            logger.error(e);
        }
        return "Book was successfully deleted.";
    }
}
