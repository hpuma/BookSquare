package DatabaseFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewListing_Obj {
    Connection c;
    public NewListing_Obj(){
        this.c = dbConnection.connect();
    }

    public boolean valid_listing(String email, String password) throws Exception{
        ResultSet r = null;
        String check = "SELECT * FROM Users WHERE Email =" + email+" AND Pass = ?;" +password;
        executeScript runQuery = new executeScript();
        try {
            r = runQuery.executeStatement("users",check);
            if(r != null){
                return r.getString("Email") == email && r.getString("Pass") == password;
            }
            return false;
        }
        finally {
            r.close();
        }

    }
}
