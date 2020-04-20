package DatabaseFiles;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Declare this object when checking for valid users.
//How to declare this object: Login_Obj login = new Login_Obj();
public class Login_Obj {
    Connection c;
    // Revised the verify login, it connects to the database and queries the user table.
    public boolean valid_login(String email, String password) {
        // Safe way of formatting the SQL query
        if (email.isEmpty() || password.isEmpty()) {
            return false;
        }
        try {
            c = dbConnection.connect();
            PreparedStatement ps = c.prepareStatement("SELECT * FROM Users WHERE Email=? AND Pass=?;");
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet r = ps.executeQuery();
            if (r != null) { // The current input has been successfully queried in the database.
                String emailFound = r.getString("Email");
                String passFound = r.getString("Pass");
                r.close();
                ps.close();
                return email.equals(emailFound) && password.equals(passFound);
            } else {
                return false; // The Current User does not exist.
            }
        } catch (NullPointerException | SQLException n) {
            return false;
        }
    }
}
