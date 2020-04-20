package controllers;

import DatabaseFiles.executeScript;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
// If somehow, none or all are selected then we return an empty string meaning that there is a non-valid condition.
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
    // Updating the radio buttons when pressed so only one button is selected at a time.
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
    void setCreateListingButton(ActionEvent e){
        try{
            // Retrieving all the input data.
            String title = titleTextField.getText();
            String author = authorTextField.getText();
            String isbn = ISBNTextField.getText();
            String condition = getSingleButton(new RadioButton[]{newButton, goodButton, acceptableButton});
            double Price = Double.parseDouble(priceTextField.getText()); //Will give you a nasty error if not handled!

            // When all the data is VALID, Condition is valid and text is not empty!
            if (title.isEmpty() ^ author.isEmpty() ^ isbn.isEmpty() ^ Double.isNaN(Price) ^ !condition.isEmpty()){
                // Generating the required query to find a duplicate listing.
                int searchUserId = 10;
                executeScript listingQuery = new executeScript();
                String findListingQuery = String.format("SELECT * FROM \n" +
                        "(Listings JOIN Product \n" +
                        "ON Listings.ListingID = Product.ListingID)\n" +
                        "WHERE Listings.UserID =%d " +
                        "AND Product.ISBN ='%s' " +
                        "AND Product.Cond='%s'" +
                        "AND Listings.Status=1;",searchUserId,isbn,condition.replaceAll("\\s",""));

                // Executing the query to find a duplicate.
                try(ResultSet listingSearch =  listingQuery.executeStatement(findListingQuery)){
                    if(listingSearch != null){
                        System.out.println("FOUND BOOK");
                        System.out.println(listingSearch.getString("ListingID") +"\t" +
                                listingSearch.getInt("UserID") +"\t"+
                                listingSearch.getString("ISBN")+"\t"+
                                listingSearch.getBigDecimal("Price"));
                    }

                } catch (SQLException ignored){
                    // ADD THE ITEM HERE



                }
            } else{ System.out.println("INVALID DATA "); }
        } catch (NullPointerException ex){
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