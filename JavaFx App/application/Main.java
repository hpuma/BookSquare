package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
//            The login page will be the first that the user sees
			Parent root = FXMLLoader.load(getClass().getResource("/pages/login.fxml"));
			Scene scene = new Scene(root,1200,800);
			scene.getStylesheets().add(getClass().getClassLoader().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);


			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}