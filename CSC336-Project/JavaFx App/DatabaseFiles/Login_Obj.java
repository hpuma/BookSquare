package DatabaseFiles;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//Declare this object when checking for valid users.
//How to declare this object: Login_Obj login = new Login_Obj();
public class Login_Obj {
    Connection c;

    public Login_Obj(){
        this.c = dbConnection.connect();
    }

    public boolean valid_connection(){
        return  this.c !=null;
    }
    
    //Returns True if entry/user account exists in the database.
    public boolean valid_login(String email, String password)throws Exception{
        PreparedStatement p = null;
        ResultSet r = null;

        String check = "SELECT * FROM Users WHERE Email = ? AND Pass = ?;";

        try {
            p = this.c.prepareStatement(check);
            p.setString(1, email);
            p.setString(2, password);
            r = p.executeQuery();

            boolean checker;

            if(r.next()){
                return true;
            }
            return false;
        }catch (SQLException e){
            return false;
        }

        finally {
            p.close();
            r.close();
        }

    }
}
