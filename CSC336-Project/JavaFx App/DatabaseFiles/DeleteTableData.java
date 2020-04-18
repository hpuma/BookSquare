package DatabaseFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTableData {

    public void delProductsBooks(String table, String ISBN) throws SQLException {
//        deletes by ISBN
        Connection c = dbConnection.connect();
        Statement s = c.createStatement();
        s.execute("DELETE FROM " + table + " WHERE ISBN = " + ISBN);
    }

    public void delData(String table, String primaryKey, int value) throws SQLException {
//        deletes by primary key
        Connection c = dbConnection.connect();
        Statement s = c.createStatement();
        s.execute("DELETE FROM " + table + " WHERE " + primaryKey + " = " + value);
    }


}
