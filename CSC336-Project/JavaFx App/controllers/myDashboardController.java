package controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javax.swing.*;
import java.io.IOException;

public class myDashboardController {

    @FXML
    private ImageView storeLogo;

    @FXML
    private AnchorPane myDashboard;

    @FXML
    private Label userFullName;

    @FXML
    private Label userID;

    @FXML
    private Label userEmail;

    @FXML
    private Label userPhone;

    public String fullName;
    //    public static void setUserEmail(String email){
//        userEmail.setText(email);
//    }


    
    public void setUserLabels(String fullName, String userId, String email, String phoneNumber){
        userFullName.setText(fullName);
        userID.setText(userId);
        userEmail.setText(email);
        userPhone.setText(phoneNumber);
    }

    @FXML
    void logoClicked(MouseEvent mouseEvent) throws IOException {
        AnchorPane p = FXMLLoader.load(getClass().getResource("/pages/BookSquare.fxml"));
        myDashboard.getChildren().setAll(p);
        System.out.println("LOGOCLICKED");
    }


    @FXML
    void logOut(ActionEvent e) throws IOException {
        AnchorPane p = FXMLLoader.load(getClass().getResource("/pages/LogIn.fxml"));
        myDashboard.getChildren().setAll(p);
    }

    @FXML
    void newListing(ActionEvent e) throws IOException {
        AnchorPane p = FXMLLoader.load(getClass().getResource("/pages/newListing.fxml"));
        myDashboard.getChildren().setAll(p);
    }

    @FXML
    void searchButtonClicked(ActionEvent e) throws IOException {
        System.out.println("Books have been searched in the dashboard.");
    }



//    Buttons not accounted for yet: upload image, create listing
}