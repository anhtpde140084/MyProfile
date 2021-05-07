package com.laptrinhjava.myinfor.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDAO {

    protected Connection connection;

    public BaseDAO(){
        try {
            String user = "sa";
            String pass = "1234";
            String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=MyProfile";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
