package controllers;

import DatabaseFiles.InsertTableData;
import DatabaseFiles.SignUp_Obj;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

//import java.awt.*;
import java.io.IOException;
import java.util.Optional;

public class SignUpController {
    @FXML
    private Button goBack;
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
        SignUp_Obj signUpChecker = new SignUp_Obj();

        Alert alert = new Alert(Alert.AlertType.ERROR);//create alert dialog if invalid login
        alert.setTitle("Invalid Login");

        if(!signUpChecker.valid_SignUp(email.getText(), pass.getText())) {//if invalid SignUp, display error dialog
            alert.setHeaderText("Invalid email address, please check and try again.");

            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK)//pressing ok in error dialog closes it
                alert.close();
        }
        else {// if valid, take to next page
            AnchorPane p = FXMLLoader.load(getClass().getResource("/pages/BookSquare.fxml"));
            signUpWindow.getChildren().setAll(p);
            InsertTableData i = new InsertTableData();
            i.insertUsers(Integer.parseInt(userID.getText()), firstName.getText(), lastName.getText(), phone.getText(), email.getText(), pass.getText());
        }

    }
    public void backToLogin(ActionEvent actionEvent) throws IOException {
        AnchorPane p = FXMLLoader.load(getClass().getResource("/pages/login.fxml"));
        signUpWindow.getChildren().setAll(p);
    }
}

