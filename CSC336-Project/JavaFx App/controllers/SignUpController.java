package controllers;

import DatabaseFiles.InsertTableData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

//import java.awt.*;
import java.io.IOException;

public class SignUpController {

    @FXML
    private AnchorPane signUpWindow;

    @FXML
    private TextField userID;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField email;

    @FXML
    private TextField phone;

    @FXML
    private TextField pass;

    @FXML
//    Once the user signs up for an account, they will be taken to the home page.
    private void signUp(ActionEvent e) throws IOException {

        System.out.println("Sign up button pressed");

        InsertTableData i = new InsertTableData();

        i.insertUsers(Integer.parseInt(userID.getText()), firstName.getText(), lastName.getText(), email.getText(), phone.getText(), pass.getText());


        AnchorPane p = FXMLLoader.load(getClass().getResource("/pages/BookSquare.fxml"));
        signUpWindow.getChildren().setAll(p);
    }
}

