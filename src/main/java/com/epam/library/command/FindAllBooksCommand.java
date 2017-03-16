package com.epam.library.command;

import com.epam.library.domain.Book;
import com.epam.library.exception.ServiceException;
import com.epam.library.service.BookService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindAllBooksCommand implements Command {
    private static final Logger logger = LogManager.getLogger();

    public String execute() {
        List<Book> books = new ArrayList<>();
        try {
            books = new BookService().findAll();
        } catch (ServiceException e) {
            logger.error(e);
        }
        return books.stream()
                .map(Book::toString)
                .collect(Collectors.joining("\n"));
    }
}
