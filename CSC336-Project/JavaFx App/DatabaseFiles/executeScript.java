package DatabaseFiles;

import org.apache.ibatis.jdbc.ScriptRunner;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class executeScript {

    public void createTablesConstraints() throws IOException, SQLException {

        FileInputStream f = new FileInputStream(System.getProperty("user.dir") + "\\DatabaseFiles\\TABLES_CONSTRAINTS.sql");

        Scanner s = new Scanner(f);
        s.useDelimiter("/\\*[\\s\\S]*?\\*/|--[^\\r\\n]*|;");

        Connection c = dbConnection.connect();
//        ScriptRunner sr = new ScriptRunner(c);
//        sr.setEscapeProcessing(false);
//        BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "\\DatabaseFiles\\TABLES_CONSTRAINTS.sql"));
//        StringBuffer sb = new StringBuffer();
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
        }
        finally{
            if (st != null){
                st.close();
            }
        }
//        String s;
//        while ((s = reader.readLine()) != null){
//            st.execute(s);
//        }
//
//
//        sr.runScript(reader);

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
