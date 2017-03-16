package com.epam.library.database.query;

public class SQLBookQuery {
    public static final String SQL_SELECT_BOOK_BY_ID = "SELECT \n" +
            "    `id`, `title`, `publish_year`, `author`\n" +
            "FROM\n" +
            "    book\n" +
            "WHERE\n" +
            "    `id` = ?";

    public static final String SQL_SELECT_ALL_BOOKS = "SELECT \n" +
            "    `id`, `title`, `publish_year`, `author`\n" +
            "FROM\n" +
            "    book\n";

    public static final String SQL_SELECT_BOOK_BY_TITLE = "SELECT \n" +
            "    `id`, `title`, `publish_year`, `author`\n" +
            "FROM\n" +
            "    book\n" +
            "WHERE\n" +
            "    `title` = ?";

    public static final String SQL_UPDATE_BOOK = "UPDATE book \n" +
            "SET \n" +
            "    `title` = ?\n" +
            "WHERE\n" +
            "    id = ?";

    public static final String SQL_INSERT_BOOK = "INSERT INTO book(`title`, `publish_year`, `author`) VALUES (?, ?, ?)";

    public static final String SQL_DELETE_BOOK = "DELETE FROM book \n" +
            "WHERE\n" +
            "    id = ?";
}
