package DatabaseFiles;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;

public class executeScript {

    public void createTables() throws FileNotFoundException, SQLException {
        Connection c = dbConnection.connect();
        ScriptRunner sr = new ScriptRunner(c);
        sr.setEscapeProcessing(false);
        BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\DatabaseFiles\\CREATE_TABLES.sql"));
        sr.runScript(reader);

//        c.close();
    }

    public void createTablesConstraints() throws FileNotFoundException, SQLException {
        Connection c = dbConnection.connect();
        ScriptRunner sr = new ScriptRunner(c);
        sr.setEscapeProcessing(false);
        BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\DatabaseFiles\\TABLES_CONSTRAINTS.sql"));
        sr.runScript(reader);

//        c.close();
    }



    public void deleteTables() throws FileNotFoundException, SQLException {
        Connection c = dbConnection.connect();
        ScriptRunner sr = new ScriptRunner(c);
        sr.setEscapeProcessing(false);
        BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\DatabaseFiles\\DELETE_TABLES.sql"));
        sr.runScript(reader);

        c.close();
    }


}
