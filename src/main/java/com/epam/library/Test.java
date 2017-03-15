//package com.epam.library;
//
//import org.apache.logging.log4j.Level;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.sql.*;
//
//public class Test {
//    private static final Logger logger = LogManager.getLogger();
//    public static void main(String[] args) {
//        try {
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?autoReconnect=true&useSSL=false", "root", "mockturtle");
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM `book`");
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString(4));
//            }
//        } catch (SQLException e) {
//            logger.log(Level.ERROR, e);
//        }
//    }
//}
