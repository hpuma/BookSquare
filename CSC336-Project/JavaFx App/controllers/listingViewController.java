package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class listingViewController {
    @FXML
    private Label postDate;

    @FXML
    private Label bookTitle;

    @FXML
    private Label bookAuthor;

    @FXML
    private Label bookISBN;

    @FXML
    private Label sellerName;

    @FXML
    private Label sellerID;

    @FXML
    private Label sellerEmail;

    @FXML
    private Label sellerPhone;


    public void setSellerLabels(int ListingID, String title, String isbn, String timePosted){
        bookTitle.setText(title);
        bookISBN.setText(isbn);
        postDate.setText(timePosted);
    }
}
