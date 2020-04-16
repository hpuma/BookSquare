package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    public static Connection connect(){
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:BookSquare.db");
            System.out.println("Connection established");
        } catch (ClassNotFoundException | SQLException e){
            // TODO Auto-generated catch block
            System.out.println(e+"");
        }
        return con;
    }

}
