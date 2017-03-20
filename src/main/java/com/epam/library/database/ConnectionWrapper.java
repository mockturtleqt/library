package com.epam.library.database;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionWrapper {
    private static final Logger logger = LogManager.getLogger();

    private static final ConnectionWrapper INSTANCE = new ConnectionWrapper();
    private Connection connection;

    private static final String DATABASE = "db";
    private static final String DB_URL = "db.url";
    private static final String DB_USER = "db.user";
    private static final String DB_PASSWORD = "db.password";

    private ConnectionWrapper() {
        connection = getDatabaseConnection();
    }

    public static ConnectionWrapper getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.ERROR, e);
        }
    }

    private Connection getDatabaseConnection() {
        try {
            ResourceBundle resource = ResourceBundle.getBundle(DATABASE);
            return DriverManager.getConnection(resource.getString(DB_URL),
                    resource.getString(DB_USER), resource.getString(DB_PASSWORD));
        } catch (SQLException e) {
            logger.log(Level.FATAL, e, e);
            throw new RuntimeException("Cannot connect to database.", e);
        }
    }
}
