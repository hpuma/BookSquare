package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class listingViewController {

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

    @FXML
    private Label postDate;

    @FXML
    private Label sellerDate;

    @FXML
    private Label sellerListingsNum;


    public void setSellerLabels(String title, String author, String ISBN, String userFullName, String userID, String email, String phone, String postdate, String selldate, String lists){
        bookTitle.setText(title);
        bookAuthor.setText(author);
        bookISBN.setText(ISBN);
        sellerName.setText(userFullName);
        sellerID.setText(userID);
        sellerEmail.setText(email);
        sellerPhone.setText(phone);
        postDate.setText(postdate);
        sellerDate.setText(selldate);
        sellerListingsNum.setText(lists);
    }
}
