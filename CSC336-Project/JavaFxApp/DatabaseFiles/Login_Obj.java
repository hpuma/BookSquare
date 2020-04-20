package DatabaseFiles;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Declare this object when checking for valid users.
//How to declare this object: Login_Obj login = new Login_Obj();
public class Login_Obj {
    // Revised the verify login, it connects to the database and queries the user table.
    public boolean valid_login(String email, String password) throws Exception{
        // Safe way of formatting the SQL query
        if(email.isEmpty() || password.isEmpty()){
            return false;
        }

        String check = String.format("SELECT * FROM Users WHERE Email=\'%s\'"+" AND Pass=\'%s\';",email,password);
        executeScript runQuery = new executeScript();
        try(ResultSet r = runQuery.executeStatement("users",check)){
            return r != null;
        }
        catch (NullPointerException n){
            n.printStackTrace();
        }
        return false;
    }
}
