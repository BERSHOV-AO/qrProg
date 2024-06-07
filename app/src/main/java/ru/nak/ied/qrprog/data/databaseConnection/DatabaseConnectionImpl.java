package ru.nak.ied.qrprog.data.databaseConnection;

import android.util.Log;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionImpl implements IDatabaseConnection{
    private static Connection connection;

    private DatabaseConnectionImpl() {
    }

    public static Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/mysql";
        String username = "root";
        String password = "mysql";

        if (connection == null) {
            try {
//            Properties properties = new Properties();
//            try (FileInputStream fis = new FileInputStream(
//                    "database/resources/db.properties")) {
//                properties.load(fis);
//                String url = properties.getProperty("url");
//                String username = properties.getProperty("username");
//                String password = properties.getProperty("password");


                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "mysql");
                Log.d("MyLog", "DB OK connect");
            } catch (SQLException e) {
                Log.d("MyLog", "DB NOT connect");

                e.printStackTrace();
            }
        }
        return connection;
    }

}
