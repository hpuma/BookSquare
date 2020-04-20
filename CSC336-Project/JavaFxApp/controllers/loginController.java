package controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Optional;

import DatabaseFiles.Login_Obj;
import javafx.stage.Stage;

public class loginController {
    @FXML
    public static UserAccount currAccount = new UserAccount();

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


    //    ************** Variables and small getter method for retireving the user's email from ANYWHERE, including ANY CONTROLLER.
//    Check BookSquareController!!!!!  - Julia
    @FXML
    private static String email;
    private String password;
    //    GETTER METHOD, GET THE EMAIL from anywhere.
    @FXML
    public static String getUserEmail(){
        return email;
    }

    @FXML
    private void logIn(ActionEvent e) throws Exception {
        Login_Obj loginChecker = new Login_Obj();//create Login_Obj to use function valid_login

        Alert alert = new Alert(AlertType.ERROR);//create alert dialog if invalid login
        alert.setTitle("Invalid Login");

        email = emailTextfield.getText();
        password = passwordTextfield.getText();

//		Test
//        System.out.println(email + "    " + password);

        if(!loginChecker.valid_login(email, password)) {//if invalid login, display error dialog
            alert.setHeaderText("Invalid email/password combination, please check and try again.");

            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK)//pressing ok in error dialog closes it
                alert.close();
        }
        else {// if valid, take to next page, Julias way commented just in case we need to revert back
//            AnchorPane p = FXMLLoader.load(getClass().getResource("/pages/BookSquare.fxml"));
//            logInWindow.getChildren().setAll(p);
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/pages/BookSquare.fxml"));//load to next page
                Parent root = (Parent) loader.load();

                BookSquareController BookSquareController = loader.getController();//obtain login info to bring to next controller
                BookSquareController.getLoginInfo(email, password);
                currAccount.updateAccount(email, password);
                System.out.println(currAccount.getUserID());

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

                Stage stageToClose = (Stage) loginButton.getScene().getWindow();
                stageToClose.close();
            } catch (IOException io){
                io.printStackTrace();
            }
        }
    }

    @FXML
//    If the user does not have an account, they will be directed to the sign up page.
    private void signUp(ActionEvent e) throws IOException {
        AnchorPane p = FXMLLoader.load(getClass().getResource("/pages/SignUp.fxml"));
        logInWindow.getChildren().setAll(p);
    }


}