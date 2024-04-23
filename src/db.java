
import java.sql.Connection;
import java.sql.DriverManager;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Nimisha
 */
public class db {
    static String dbUser = "root";
    static String dbPassword = "";
    static String dbName = "cms";
    static String connectionURL = "jdbc:mysql://localhost:3306/" + dbName;
    static Connection dbConnection;
    
    public Connection checkConnection() {
        try {
            dbConnection = DriverManager.getConnection(connectionURL, dbUser, dbPassword);
        } catch (Exception exp) {
            System.out.println(exp);
        }
        return dbConnection;
    }
    
    public static void main(String[] args) {
        db startDB = new db();
        startDB.checkConnection();
    }
}
