package org.rogenerator4j.db;

import org.rogenerator4j.util.Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by page on 2017/6/12.
 */
public class DBcon {


    public static Connection getCon(){
        Connection dbConnection = null;
        try {
            Class.forName(Config.get("db.driver"));
            dbConnection= DriverManager
                    .getConnection(Config.get("db.url"), Config.get("db.username"),Config.get("db.password"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbConnection;
    }

}
