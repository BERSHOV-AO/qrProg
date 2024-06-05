package ru.nak.ied.qrprog.data.databaseConnection;

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

        if (connection == null) {
            Properties properties = new Properties();
            try (FileInputStream fis = new FileInputStream(
                    "database/resources/db.properties")) {
                properties.load(fis);
                String url = properties.getProperty("url");
                String username = properties.getProperty("username");
                String password = properties.getProperty("password");

                connection = DriverManager.getConnection(url, username, password);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

}
