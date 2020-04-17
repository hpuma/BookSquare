package DatabaseFiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {

    private static Connection con = null;


    public static Connection connect() {
        if (con == null) {
            try {
                Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir") + "\\DatabaseFiles\\BookSquare.db");
                System.out.println("Connection established");
            } catch (ClassNotFoundException | SQLException e) {
                // TODO Auto-generated catch block
                System.out.println(e + "");
            }
        }
        return con;
    }
}
