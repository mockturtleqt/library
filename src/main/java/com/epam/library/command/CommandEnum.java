package com.epam.library.command;

import com.epam.library.command.impl.ExitCommand;
import com.epam.library.command.impl.book.*;
import com.epam.library.command.impl.employee.EmployeeBirthdayBookReportCommand;
import com.epam.library.command.impl.employee.EmployeeBookReportCommand;

public enum CommandEnum {

    REPORT_1 {
        {
            command = new EmployeeBookReportCommand();
            description = "Type `REPORT_1` to view report on employees who've read 1+ books.";
        }
    },
    REPORT_2 {
        {
            command = new EmployeeBirthdayBookReportCommand();
            description = "Type `REPORT_2` to view report on employees who've read 2+ books.";
        }
    },
    RENAME_BOOK {
        {
            command = new RenameBookCommand();
            description = "Type `RENAME_BOOK` to rename a book.";
        }
    },
    CREATE_BOOK {
        {
            command = new CreateBookCommand();
            description = "Type `CREATE_BOOK` to create a new book.";
        }
    },
    FIND_BOOK_BY_TITLE {
        {
            command = new FindBookByTitleCommand();
            description = "Type `FIND_BOOK_BY_TITLE` to find a book by its title.";
        }
    },
    FIND_BOOK_BY_ID {
        {
            command = new FindBookByIdCommand();
            description = "Type `FIND_BOOK_BY_ID` to find a book by its ID.";
        }
    },
    FIND_ALL_BOOKS {
        {
            command = new FindAllBooksCommand();
            description = "Type `FIND_ALL_BOOKS` to view all books in our library.";
        }
    },
    DELETE_BOOK {
        {
            command = new DeleteBookByIdCommand();
            description = "Type `DELETE_BOOK` to delete a book by its ID.";
        }
    },
    EXIT {
        {
            command = new ExitCommand();
            description = "Type `EXIT` to exit.";
        }
    };
    Command command;
    String description;

    public Command getCurrentCommand() {
        return command;
    }

    public String getDescription() {
        return description;
    }
}
