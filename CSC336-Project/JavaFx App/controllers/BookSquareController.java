package controllers;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import DatabaseFiles.dbConnection;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BookSquareController implements Initializable{

    @FXML
    private Button searchButton;

    @FXML
    private ToggleGroup priceGroup;

    @FXML
    private ToggleGroup conditionGroup;

    @FXML
    private ToggleGroup timeGroup;

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    private VBox homeWindow;
//    private


    @FXML
//    We need to discuss how we will display the books that match the user's search.
    void searchButtonClicked(ActionEvent e) throws IOException, SQLException {
        System.out.println("Books have been searched in the home page.");
        loadProductListing(e);
    }

    @FXML
//    Opens up a new, smaller window showcasing more information about the book.
    void moreBookInfo(ActionEvent e) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/pages/listingView.fxml"));
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
//    Logs the user out, directing them back to the log in page.
    void logOut(ActionEvent e) throws IOException {
        AnchorPane p = FXMLLoader.load(getClass().getResource("/pages/LogIn.fxml"));
        homeWindow.getChildren().setAll(p);
    }

    @FXML
    void getDashboard(ActionEvent e) throws IOException {
        AnchorPane p = FXMLLoader.load(getClass().getResource("/pages/myDashboard.fxml"));
        homeWindow.getChildren().setAll(p);
    }

    @FXML
    private TextField ImageID;
    @FXML
    private TextField ListingID;
    @FXML
    private TextField Price;
    @FXML
    private TextField ISBN;
    @FXML
    private TextField Title;
    @FXML
    private TextField Condition;
    @FXML
    private TextField TimePosted;
    @FXML
    private TextField Status;

    @FXML
    private TableView<ProductListing> Listings_Table;

    @FXML
    private TableColumn<ProductListing, String> listid_col;

    @FXML
    private TableColumn<ProductListing, String> imgid_col;

    @FXML
    private TableColumn<ProductListing, String> price_col;

    @FXML
    private TableColumn<ProductListing, String> isbn_col;

    @FXML
    private TableColumn<ProductListing, String> title_col;

    @FXML
    private TableColumn<ProductListing, String> cond_col;

    @FXML
    private TableColumn<ProductListing, String> time_col;

    @FXML
    private TableColumn<ProductListing, String> status_col;

    private dbConnection dbc;

    private ObservableList<ProductListing> data;

    private String sql = "SELECT Listings.ListingID, ListingImage.ImageID, Product.Price, Books.ISBN, Books.Title, Product.Cond, Listings.TimePosted, Listings.Status FROM Listings, Product, ListingImage, Books, Users WHERE Listings.ListingID = Product.ListingID AND Listings.ImageID = ListingImage.ImageID AND Product.ISBN = Books.ISBN AND Listings.UserID = Users.UserID;";

    public void initialize(URL url, ResourceBundle rb){
        this.dbc = new dbConnection();

    }

    @FXML
    private void loadProductListing(ActionEvent ev)throws SQLException{
        try{
            Connection con = dbConnection.connect();
            this.data = FXCollections.observableArrayList();
            ResultSet rs = con.createStatement().executeQuery(sql);
            while(rs.next()){
                this.data.add(new ProductListing(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8)));
                System.out.println(rs.getString(1)+
                        rs.getString(2)+
                        rs.getString(3)+
                        rs.getString(4)+
                        rs.getString(5)+
                        rs.getString(6)+
                        rs.getString(7)+
                        rs.getString(8));
            }
        }catch (SQLException e){
            System.err.println("Error" + e);
        }
        this.listid_col.setCellValueFactory(new PropertyValueFactory<ProductListing, String>("ListingID"));
        this.imgid_col.setCellValueFactory(new PropertyValueFactory<ProductListing, String>("ImageID"));
        this.price_col.setCellValueFactory(new PropertyValueFactory<ProductListing, String>("Price"));
        this.isbn_col.setCellValueFactory(new PropertyValueFactory<ProductListing, String>("ISBN"));
        this.title_col.setCellValueFactory(new PropertyValueFactory<ProductListing, String>("Title"));
        this.cond_col.setCellValueFactory(new PropertyValueFactory<ProductListing, String>("Condition"));
        this.time_col.setCellValueFactory(new PropertyValueFactory<ProductListing, String>("TimePosted"));
        this.status_col.setCellValueFactory(new PropertyValueFactory<ProductListing, String>("Status"));

        this.Listings_Table.setItems(null);
        this.Listings_Table.setItems(this.data);

    }
}
