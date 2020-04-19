package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class newListingController {

    @FXML
    private AnchorPane newListing;

    @FXML
    private TextField searchTextField;

    @FXML
    private Button searchButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Button dashboardButton;

    @FXML
    private TextField titleTextField;

    @FXML
    private TextField authorTextField;

    @FXML
    private TextField ISBNTextField;

    @FXML
    private RadioButton newButton;

    @FXML
    private RadioButton goodButton;

    @FXML
    private RadioButton AcceptableButton;

    @FXML
    private TextField priceTextField;

    @FXML
    private Button createListingButton;

    @FXML
    private ImageView uploadImage;

    @FXML
    private Button uploadButton;

    @FXML
    void searchButtonClicked(ActionEvent e) throws IOException {
        System.out.println("Books have been searched in the new listings page.");
    }

    @FXML
    void logOut(ActionEvent e) throws IOException {
        AnchorPane p = FXMLLoader.load(getClass().getResource("/pages/LogIn.fxml"));
        newListing.getChildren().setAll(p);
    }

    @FXML
    void getDashboard(ActionEvent e) throws IOException {
        AnchorPane p = FXMLLoader.load(getClass().getResource("/pages/myDashboard.fxml"));
        newListing.getChildren().setAll(p);
    }
    @FXML
    void setCreateListingButtonClicked(ActionEvent e)throws IOException{
        String title = titleTextField.getText();
        String author = authorTextField.getText();
        String ISBN = ISBNTextField.getText();
    }
    
    @FXML
    void uploadListingImage(ActionEvent event) {
    	System.out.println("boo");
    	FileChooser fileChooser = new FileChooser();
    	File selectedFile = fileChooser.showOpenDialog(newListing.getScene().getWindow());

    }
}