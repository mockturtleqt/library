package com.epam.library.util.database.query;

public class SQLEmployeeQuery {
    public static final String SQL_SELECT_EMPLOYEE_BY_ID = "SELECT \n" +
            "    `id`, `name`, `date_of_birth`, `email`\n" +
            "FROM\n" +
            "    employee\n" +
            "WHERE\n" +
            "    `id` = ?";

    public static final String SQL_SELECT_EMPLOYEE_BOOK_STATISTICS = "SELECT \n" +
            "    employee.name,\n" +
            "    employee.date_of_birth,\n" +
            "    COUNT(employee_book.book_id) AS number_of_books\n" +
            "FROM\n" +
            "    employee\n" +
            "        LEFT JOIN\n" +
            "    employee_book ON employee.id = employee_book.employee_id\n" +
            "GROUP BY employee.name\n" +
            "HAVING number_of_books > 0\n" +
            "ORDER BY number_of_books";

    public static final String SQL_SELECT_EMPLOYEE_BIRTHDAY_BOOK_STATISTICS = "SELECT \n" +
            "    employee.name,\n" +
            "    employee.date_of_birth,\n" +
            "    COUNT(employee_book.book_id) AS number_of_books\n" +
            "FROM\n" +
            "    employee\n" +
            "        LEFT JOIN\n" +
            "    employee_book ON employee.id = employee_book.employee_id\n" +
            "GROUP BY employee.name\n" +
            "HAVING number_of_books > 1\n" +
            "ORDER BY employee.date_of_birth , number_of_books DESC";

}
