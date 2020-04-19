package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Optional;

import DatabaseFiles.Login_Obj;

public class loginController {

    @FXML
    private AnchorPane logInWindow;
    
    @FXML
    private TextField emailTextfield;

    @FXML
    private TextField passwordTextfield;
    
    @FXML
    private Button loginButton;

    @FXML
    private Button signupButton;
    
    @FXML
//    After pressing the button to log in, the user will be take to the home page.
    private void logIn(ActionEvent e) throws Exception {
		Login_Obj loginChecker = new Login_Obj();//create Login_Obj to use function valid_login
		
    	Alert alert = new Alert(AlertType.ERROR);//create alert dialog if invalid login
		alert.setTitle("Invalid Login");
		
		String email = emailTextfield.getText();
		String password = passwordTextfield.getText();
		
    	if(!loginChecker.valid_login(email, password)) {//if invalid login, display error dialog
    		alert.setHeaderText("Invalid email/password combination, please check and try again.");
    		
    		Optional<ButtonType> result = alert.showAndWait();
    		if(result.get() == ButtonType.OK)//pressing ok in error dialog closes it
        		alert.close();
        }
    	else {// if valid, take to next page
            AnchorPane p = FXMLLoader.load(getClass().getResource("/pages/BookSquare.fxml"));
            logInWindow.getChildren().setAll(p);
    	}
    }

    @FXML
//    If the user does not have an account, they will be directed to the sign up page.
    private void signUp(ActionEvent e) throws IOException {
        AnchorPane p = FXMLLoader.load(getClass().getResource("/pages/SignUp.fxml"));
        logInWindow.getChildren().setAll(p);
    }


}