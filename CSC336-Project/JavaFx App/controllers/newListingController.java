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
import java.lang.reflect.InvocationTargetException;

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
    private RadioButton acceptableButton;

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
// Checks to see if there is a single radio button selected then returns the condition value
// If somehow, none or all are selected then we return an empty string.
    private String getSingleButton(RadioButton[] buttonList){
        int buttonActive = 0;
        String message = "";
        for (RadioButton currButton: buttonList){
            if(currButton.isSelected()){
                buttonActive +=1;
                if (buttonActive == 1){
                    message = currButton.getText();
                }
            }
        }
        return buttonActive == 1?message:"" ;
    }

    // Updating the radio buttons when pressed.
    @FXML
    void setNewButton(ActionEvent e){
        acceptableButton.setSelected(false);
        goodButton.setSelected(false);
        newButton.setSelected(true);
    }
    @FXML
    void setGoodButton(ActionEvent e){
        newButton.setSelected(false);
        acceptableButton.setSelected(false);
        goodButton.setSelected(true);
    }
    @FXML
    void setAcceptableButton(ActionEvent e){
        newButton.setSelected(false);
        goodButton.setSelected(false);
        acceptableButton.setSelected(true);
    }
    // Handle when create listing is pressed, I have not queried the database yet or added a list.
    @FXML
    void setCreateListingButton(ActionEvent e)throws IOException{
        try{
            String title = titleTextField.getText();
            String author = authorTextField.getText();
            String ISBN = ISBNTextField.getText();
            String Condition = getSingleButton(new RadioButton[]{goodButton, newButton, acceptableButton});
            Double Price = Double.valueOf(priceTextField.getText()); //Will give you a nasty error if not handled!

            // When all the data is VALID, Condition is valid and text is not empty!
            if (title.isEmpty() ^ author.isEmpty() ^ ISBN.isEmpty() ^ Price.isNaN() ^ !Condition.isEmpty()){
                System.out.println(title+"\n"+author+"\n"+ISBN+"\n"+Condition);
                System.out.println(Price);
            }else{
                System.out.println("INVALID DATA ");
            }
        }
        catch (NullPointerException ex){
            System.out.println("UNACCEPTABLE PRICE");
            ex.printStackTrace();
        }
        catch (NumberFormatException ex){
            System.out.println("PRICE IS NOT VALID");
        }
    }
    @FXML
    void uploadListingImage(ActionEvent event) {
    	System.out.println("boo");
    	FileChooser fileChooser = new FileChooser();
    	File selectedFile = fileChooser.showOpenDialog(newListing.getScene().getWindow());

    }
}