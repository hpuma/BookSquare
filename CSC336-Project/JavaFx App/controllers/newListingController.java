package controllers;

import DatabaseFiles.InsertTableData;
import DatabaseFiles.dbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.*;
import java.util.Date;

public class newListingController {
    // Path to the current image to upload to the database.
    public static String imageName = "file:" + System.getProperty("user.dir") + "\\images\\gettyimages-766410071-612x612.jpg";
    public void resetEntries(){
        imageName = "file:" + System.getProperty("user.dir") + "\\images\\gettyimages-766410071-612x612.jpg";
        TextField textfieldList[] = {titleTextField, authorTextField, ISBNTextField, priceTextField};
        RadioButton buttonList[] = {acceptableButton,goodButton,newButton};
        for (TextField currentTextfield: textfieldList){
            if (!currentTextfield.getText().isEmpty()){
                currentTextfield.clear();
                System.out.println("TEXTFIELD CLEARED:\t"+currentTextfield.getId());
            }
        }
        for (RadioButton currentButton: buttonList){
            if (currentButton.isSelected()){
                currentButton.setSelected(false);
                System.out.println("BUTTON CLEARED:\t"+currentButton.getId());
            }
        }
    }
    @FXML
    private ImageView storeLogo;
    @FXML
    private AnchorPane newListing;
    @FXML
    private TextField searchTextField;
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
    // Radio Buttons
    @FXML
    private RadioButton acceptableButton;
    @FXML
    private RadioButton goodButton;
    @FXML
    private RadioButton newButton;
    @FXML
    private TextField priceTextField;
    @FXML
    private Button createListingButton;
    @FXML
    private ImageView uploadImage;
    @FXML
    private Button uploadButton;
    @FXML
    public Text confirmText;
    public void changeConfirm(String message,boolean error){
        confirmText.setText(message);
        if (error){
            confirmText.setFill(Paint.valueOf("#FF0000"));
        }else{
            confirmText.setFill(Paint.valueOf("#008000"));
        }
        confirmText.setVisible(true);
    }
    public void clearConfirm(){
        if(confirmText.isVisible()){
            confirmText.setText("NULL");
            confirmText.setFill(Paint.valueOf("#FFFFFF"));
            confirmText.setVisible(false);
        }
    }
    @FXML
    public void logoClicked(MouseEvent mouseEvent) throws IOException {
        AnchorPane p = FXMLLoader.load(getClass().getResource("/pages/BookSquare.fxml"));
        newListing.getChildren().setAll(p);
        System.out.println("LOGOCLICKED");
    }
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
    private int getSingleButton(RadioButton[] buttonList) {
        int buttonActive = 0;
        String message = "";
        for (RadioButton currButton : buttonList) {
            if (currButton.isSelected()) {
                return buttonActive;
            }
            buttonActive += 1;
        }
        return -1; // Rare case where none of them are active
    }
    // Updating the radio buttons when pressed so only one button is selected at a time.
    @FXML
    void setNewButton(ActionEvent e) {
        acceptableButton.setSelected(false);
        goodButton.setSelected(false);
        newButton.setSelected(true);
    }
    @FXML
    void setGoodButton(ActionEvent e) {
        newButton.setSelected(false);
        acceptableButton.setSelected(false);
        goodButton.setSelected(true);
    }
    @FXML
    void setAcceptableButton(ActionEvent e) {
        newButton.setSelected(false);
        goodButton.setSelected(false);
        acceptableButton.setSelected(true);
    }
    // Handle when create listing is pressed, I have not queried the database yet or added a list.
    @FXML
    void setCreateListingButton(ActionEvent e) {
        try {
            // Retrieving all the input data.
            String title = titleTextField.getText();
            String author = authorTextField.getText();
            String isbn = ISBNTextField.getText();
            int condition = getSingleButton(new RadioButton[]{acceptableButton, goodButton, newButton});
            double price = Double.parseDouble(priceTextField.getText()); //Will give you a nasty error if not handled!
            clearConfirm();
            // When all the data is VALID, Condition is valid and text is not empty! We can do better.
            if (title.isEmpty() ^ author.isEmpty() ^ isbn.isEmpty() ^ Double.isNaN(price) ^ (condition >= 0)) {

                // Getting UserID.
                int currentUserID = loginController.currAccount.getUserID();

                // Create the TimeStamp Column.
                Date now = new Date();
                Timestamp currentTime = new Timestamp(now.getTime());

                System.out.println(currentTime);
                System.out.println(currentUserID);

                Connection c = dbConnection.connect();
                PreparedStatement ps = c.prepareStatement("SELECT * FROM (Listings JOIN Product ON Listings.ListingID = Product.ListingID) " +
                                                            "WHERE Listings.UserID=? AND Product.ISBN=? AND Product.Cond=? AND Product.Price =? AND Listings.Status=1;");
                ps.setInt(1,currentUserID);
                ps.setString(2,isbn);
                ps.setInt(3,condition);
                ps.setDouble(4,price);

                // Executing the query to find a duplicate.
                ResultSet listingSearch = ps.executeQuery();
                    if (listingSearch.next()) {
                        System.out.println("FOUND BOOK");
                        System.out.println(listingSearch.getString("ListingID") + "\t" +
                                listingSearch.getInt("UserID") + "\t" +
                                listingSearch.getString("ISBN") + "\t" +
                                listingSearch.getBigDecimal("Price"));
                        changeConfirm("LISTING ALREADY EXISTS",true);
                    }else{
                        // ADD THE ITEM HERE, SET ADD QUERIES HERE.
                        System.out.println("THIS BOOK IS UNIQUE");

                        // Creating the ListingID. Hashcode creates a large number for listingID :/
                        String hashMaker = isbn + currentUserID + price;
                        int newListingID = Math.abs(hashMaker.hashCode());
                        System.out.println("NEW LISTING CREATED:"+newListingID);

                        // Inserting to all the tables.
                        InsertTableData.insertListings(newListingID, currentUserID, currentTime, true);
                        changeConfirm("PREVIOUS LISTING CREATED:\n"+"ListingID:\t"+newListingID,false);
                        resetEntries();

                        InsertTableData.insertImage(newListingID, imageName);
                        InsertTableData.insertBooks(isbn, title, author);
                        InsertTableData.insertProduct(isbn, newListingID, condition, price);
                    }
            } else {
                System.out.println("INVALID DATA 2: INVALID DATA SOMEWHERE ");
                changeConfirm("ERROR CREATING THE LISTING",true);
            }
        } catch (NullPointerException ex) {
            changeConfirm("ERROR CREATING THE LISTING",true);
        } catch (NumberFormatException ex) {
            System.out.println("PRICE IS NOT A VALID ENTRY");
            changeConfirm("PRICE IS NOT A VALID ENTRY",true);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
            changeConfirm("ERROR IN CREATING THE LISTING",true);
        }
    }
    @FXML
    void uploadListingImage(ActionEvent event) throws MalformedURLException {
        //System.out.println("boo");
        FileChooser fileChooser = new FileChooser();//opens file explorer
        File selectedFile = fileChooser.showOpenDialog(newListing.getScene().getWindow());
        String imagePath = selectedFile.getAbsolutePath();//get file path
        System.out.println(imagePath);
        imageName = selectedFile.toURI().toString();
        Image image = new Image(imageName);//change image to selected image
        uploadImage.setImage(image);
    }
}