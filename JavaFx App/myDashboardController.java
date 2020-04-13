import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class myDashboardController {

    @FXML
    private AnchorPane myDashboard;


    @FXML
    void logOut(ActionEvent e) throws IOException {
        AnchorPane p = FXMLLoader.load(getClass().getResource("LogIn.fxml"));
        myDashboard.getChildren().setAll(p);
    }

    @FXML
    void newListing(ActionEvent e) throws IOException {
        AnchorPane p = FXMLLoader.load(getClass().getResource("newListing.fxml"));
        myDashboard.getChildren().setAll(p);
    }

    @FXML
    void searchButtonClicked(ActionEvent e) throws IOException {
        System.out.println("Books have been searched in the dashboard.");
    }

//    Buttons not accounted for yet: upload image, create listing
}