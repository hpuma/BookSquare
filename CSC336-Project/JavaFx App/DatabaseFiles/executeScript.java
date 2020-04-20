package DatabaseFiles;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class executeScript {

    // The acceptable table names that we can query from
    public static String[] tableNames = {"users", "profiles","listings","listingimage","product","auditlog","books"};

    public void createTablesConstraints() throws IOException, SQLException {

        FileInputStream f = new FileInputStream(System.getProperty("user.dir") + "\\DatabaseFiles\\TABLES_CONSTRAINTS.sql");

        Scanner s = new Scanner(f);
        s.useDelimiter("/\\*[\\s\\S]*?\\*/|--[^\\r\\n]*|;");

        Connection c = dbConnection.connect();
        Statement st = null;

        try {

            st = c.createStatement();

            while (s.hasNext()) {
                String line = s.next().trim();

                if (!line.isEmpty()) {
                    System.out.println(line);
                    st.execute(line);
                }
            }
        } finally {
            if (st != null) {
                st.close();
            }
        }

    }



    public void deleteTables() throws FileNotFoundException, SQLException {
        Connection c = dbConnection.connect();
        ScriptRunner sr = new ScriptRunner(c);
        sr.setEscapeProcessing(false);
        BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\DatabaseFiles\\DELETE_TABLES.sql"));
        sr.runScript(reader);

        c.close();
    }

    // Checks if the given table name is an acceptable table that we can query from.
    public static Boolean checkTableInput(String tableInput){
        tableInput = tableInput.toLowerCase();
        for(String table: tableNames){
            if(table.equals(tableInput)){return true;}
        }
        return false;
    }
    // This fully executes an SQL query to a specific table.
    public ResultSet executeStatement(String table, String SQLQUERY){
        Connection c = dbConnection.connect();
        PreparedStatement ps = null;
        ResultSet querySet = null;
        try{
            ps = c.prepareStatement(SQLQUERY);
            querySet = ps.executeQuery();
            return querySet;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

}
