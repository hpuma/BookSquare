package application;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.stream.Collectors;

public class executeScript {

    public void createTables() throws FileNotFoundException, SQLException {
        Connection c = dbConnection.connect();
        ScriptRunner sr = new ScriptRunner(c);
        sr.setEscapeProcessing(false);
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\julia\\Documents\\GitHub\\CSC336-Project\\CSC336-Project\\DatabaseFIles\\CREATE_TABLES.sql"));
        sr.runScript(reader);

//        c.close();
    }

    public void createTablesConstraints() throws FileNotFoundException, SQLException {
        Connection c = dbConnection.connect();
        ScriptRunner sr = new ScriptRunner(c);
        sr.setEscapeProcessing(false);
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\julia\\Documents\\GitHub\\CSC336-Project\\CSC336-Project\\DatabaseFIles\\TABLES_CONSTRAINTS.sql"));
        sr.runScript(reader);

//        c.close();
    }



    public void deleteTables() throws FileNotFoundException, SQLException {
        Connection c = dbConnection.connect();
        ScriptRunner sr = new ScriptRunner(c);
        sr.setEscapeProcessing(false);
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\julia\\Documents\\GitHub\\CSC336-Project\\CSC336-Project\\DatabaseFIles\\DELETE_TABLES.sql"));
        sr.runScript(reader);

        c.close();
    }


}
