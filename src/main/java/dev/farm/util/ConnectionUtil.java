package dev.farm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static ConnectionUtil instance;

    private ConnectionUtil() {};

    public static ConnectionUtil getInstance() {
        if(instance == null) {
           instance =  new ConnectionUtil();
        }
        return instance;
    }




    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:postgresql://project0.cmopccrkolht.us-west-1.rds.amazonaws.com:5432/postgres?currentSchema=cool_stuff",
                    "mikayla","password"
            );
        } catch (Exception throwables) {
            throwables.printStackTrace();
            return null;
        }
    }
}
