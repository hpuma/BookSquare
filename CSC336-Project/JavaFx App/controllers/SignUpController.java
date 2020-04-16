package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SignUpController {

    @FXML
    private AnchorPane signUpWindow;

    @FXML
//    Once the user signs up for an account, they will be taken to the home page.
    private void signUp(ActionEvent e) throws IOException {
        AnchorPane p = FXMLLoader.load(getClass().getResource("/pages/BookSquare.fxml"));
        signUpWindow.getChildren().setAll(p);
    }
}

