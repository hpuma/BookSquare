
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class BookSquareController {

    @FXML
    private Button searchButton;

    @FXML
    private ToggleGroup priceGroup;

    @FXML
    private ToggleGroup conditionGroup;

    @FXML
    private ToggleGroup timeGroup;

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    private VBox homeWindow;
//    private


    @FXML
//    We need to discuss how we will display the books that match the user's search.
    void searchButtonClicked(ActionEvent e) throws IOException {
        System.out.println("Books have been searched in the home page.");
    }

    @FXML
//    Opens up a new, smaller window showcasing more information about the book.
    void moreBookInfo(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("listingView.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
//    Logs the user out, directing them back to the log in page.
    void logOut(ActionEvent e) throws IOException {
        AnchorPane p = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        homeWindow.getChildren().setAll(p);
    }

    @FXML
    void getDashboard(ActionEvent e) throws IOException {
        AnchorPane p = FXMLLoader.load(getClass().getResource("myDashboard.fxml"));
        homeWindow.getChildren().setAll(p);
    }
}