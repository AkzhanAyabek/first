package kz.aitu.oop.practice.assignment5.data;

import kz.aitu.oop.practice.assignment5.data.interfaces.IDBManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager implements IDBManager {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/assignment5";
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "aitkazin");
            return con;
        }
        catch (Exception e) {
            System.out.println(e);
            throw e;
        }
    }
}
