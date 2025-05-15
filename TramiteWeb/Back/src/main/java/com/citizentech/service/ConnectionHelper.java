package com.citizentech.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;
import org.apache.log4j.Logger;

public class ConnectionHelper {
    
    final static Logger logger = Logger.getLogger(ConnectionHelper.class);
    
    public static Connection getConnection() throws Exception {
         try (InputStream input = new FileInputStream("configcitizentech.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(prop.getProperty("db.url"),
                                               prop.getProperty("db.user"), 
                                               prop.getProperty("db.password"));
        } catch (Exception e) {
            logger.error("Error", e);
            throw e;
        }
    }

    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            logger.error("Error", e);
        }
    }
}
