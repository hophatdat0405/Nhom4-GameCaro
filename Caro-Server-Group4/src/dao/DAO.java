/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Admin
 */
public class DAO {
    protected Connection con;

    public DAO() {
        final String DATABASE_NAME = "caronhom4"; // TODO FILL YOUR DATABASE NAME
       final String jdbcURL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME + "?useSSL=false&allowPublicKeyRetrieval=true";

        final String JDBC_USER = "root";  // TODO FILL YOUR DATABASE USER
        final String JDBC_PASSWORD = "123456"; // TODO FILL YOUR DATABASE PASSWORD
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(jdbcURL, JDBC_USER, JDBC_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Connection to database failed");
        }
    }
}