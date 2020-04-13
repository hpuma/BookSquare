package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class loginController {

    @FXML
    private AnchorPane logInWindow;

    @FXML
//    After pressing the button to log in, the user will be take to the home page.
    private void logIn(ActionEvent e) throws IOException {
        AnchorPane p = FXMLLoader.load(getClass().getResource("/pages/BookSquare.fxml"));
        logInWindow.getChildren().setAll(p);
    }

    @FXML
//    If the user does not have an account, they will be directed to the sign up page.
    private void signUp(ActionEvent e) throws IOException {
        AnchorPane p = FXMLLoader.load(getClass().getResource("/pages/SignUp.fxml"));
        logInWindow.getChildren().setAll(p);
    }


}