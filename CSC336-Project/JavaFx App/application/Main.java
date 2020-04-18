package application;
import DatabaseFiles.InsertTableData;
import DatabaseFiles.InsertTableData;
import DatabaseFiles.executeScript;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;

public class Main extends Application {


	@Override
	public void start(Stage primaryStage) throws FileNotFoundException, SQLException {


		executeScript e = new executeScript();
//       e.createTablesConstraints();
//		e.createTables();

		Timestamp time = new Timestamp(System.currentTimeMillis());
		InsertTableData i = new InsertTableData();
		java.sql.Date d = new java.sql.Date(Calendar.getInstance().getTimeInMillis());

//        i.insertBooks("1210", "Clifford", "Peter Ye");
//        i.insertListings(1231, 55, 0123, time, true );
//		  i.insertImage(1011, "myDog");
//		  i.insertUsers(50005, "j", "b", "100064", "@0115@", "pass");
//        i.insertProfiles(1200, "me", d);
//        i.insertProduct("123", 123, 1, 1.5);
		i.insertAuditLog(121310, 415106, 781109, 610918, time);




//		e.deleteTables();

		try {
//            The login page will be the first that the user sees
			Parent root = FXMLLoader.load(getClass().getResource("/pages/login.fxml"));
			Scene scene = new Scene(root,1200,800);
			scene.getStylesheets().add(getClass().getClassLoader().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);


			primaryStage.show();

		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {launch(args); }




}