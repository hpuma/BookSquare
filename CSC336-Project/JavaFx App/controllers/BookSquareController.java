package controllers;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import DatabaseFiles.dbConnection;
import org.apache.ibatis.javassist.Loader;
import org.w3c.dom.Text;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BookSquareController implements Initializable {
    @FXML
    public static UserAccount currAccount = new UserAccount();
    public String currUserEmail;
    public String currUserPassword;

    @FXML
    private TextField searchText;

    @FXML
    private Button storeLogo;
    @FXML
    private Button searchButton;

    @FXML
    private Button myDashboardButton;

    @FXML
    private ToggleGroup priceGroup;

    @FXML
    private ToggleGroup conditionGroup;

    @FXML
    private ToggleGroup timeGroup;

    @FXML
    private RadioButton low_p;

    @FXML
    private RadioButton high_p;

    @FXML
    private RadioButton new_con;

    @FXML
    private RadioButton good_con;

    @FXML
    private RadioButton accept_con;

    @FXML
    private RadioButton old_time;

    @FXML
    private RadioButton new_time;

    @FXML
    private RadioButton clearPrice;

    @FXML
    private RadioButton clearCondition;

    @FXML
    private RadioButton clearTime;


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

    public void getLoginInfo(String email, String password) throws Exception {
        currUserEmail = email;
        currUserPassword = password;
        currAccount.updateAccount(email, password);
        System.out.println(currAccount.getEmail());
        System.out.println(currAccount.getPass());
    }

    @FXML
//    We need to discuss how we will display the books that match the user's search.
    void searchButtonClicked(ActionEvent e) throws IOException, SQLException {
        System.out.println("Books have been searched in the home page.");
        String input = searchText.getText().toLowerCase();
        System.out.println(input);
        loadProductListing(e, input);

    }

    @FXML
//    Opens up a new, smaller window showcasing more information about the book.
    void moreBookInfo(ActionEvent e) throws IOException {
        System.out.println("");
    }

    @FXML
//    Logs the user out, directing them back to the log in page.
    void logOut(ActionEvent e) throws IOException {
        AnchorPane p = FXMLLoader.load(getClass().getResource("/pages/LogIn.fxml"));

        homeWindow.getChildren().setAll(p);
    }

    @FXML
    void getDashboard(ActionEvent e) throws IOException {

        String fullName = currAccount.getFirstName() + " " + currAccount.getLastName();//Info to show
        String userId = String.valueOf(currAccount.getUserID());
        //System.out.println(fullName);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/pages/myDashboard.fxml"));//load next controller
        Parent root = (Parent) loader.load();

        myDashboardController myDashboardController = loader.getController();
        myDashboardController.setUserLabels(fullName, userId, currAccount.getEmail(), currAccount.getPhone());//change labels in dashboard fxml

        Stage stage = new Stage();//change to new scene
        stage.setScene(new Scene(root));
        stage.show();

        Stage stageToClose = (Stage) myDashboardButton.getScene().getWindow();//close old window
        stageToClose.close();

        //AnchorPane p = FXMLLoader.load(getClass().getResource("/pages/myDashboard.fxml"));
        //homeWindow.getChildren().setAll(p);

//            CALLING GETTER METHOD IN loginController class to retrieve user's email from ANYWHERE.
//            IT IS CALLED IN THE FOLLOWING PRINT STATEMENT:
        System.out.println("This is the user's email: " + loginController.getUserEmail());

    }


    private SortToggle tog = new SortToggle(0, 0, 0);

    @FXML
    public void change_price() {
        if (this.priceGroup.getSelectedToggle().equals(this.low_p)) {
            this.tog.setPrice(1);
        }
        if (this.priceGroup.getSelectedToggle().equals(this.high_p)) {
            this.tog.setPrice(2);
        }
        if (this.priceGroup.getSelectedToggle().equals(this.clearPrice)){
            this.tog.setPrice(0);
        }
    }

    @FXML
    public void change_con() {
        if (this.conditionGroup.getSelectedToggle().equals(this.good_con)) {
            this.tog.setCondition(2);
        }
        if (this.conditionGroup.getSelectedToggle().equals(this.new_con)) {
            this.tog.setCondition(3);
        }
        if (this.conditionGroup.getSelectedToggle().equals(this.accept_con)) {
            this.tog.setCondition(1);
        }
        if (this.conditionGroup.getSelectedToggle().equals(this.clearCondition)) {
            this.tog.setCondition(0);
        }
    }

    @FXML
    public void change_time() {
        if (this.timeGroup.getSelectedToggle().equals(this.old_time)) {
            this.tog.setTime(1);
        }
        if (this.timeGroup.getSelectedToggle().equals(this.new_time)) {
            this.tog.setTime(2);
        }

        if (this.timeGroup.getSelectedToggle().equals(this.clearTime)) {
            this.tog.setTime(0);
        }
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
    private TableColumn<ProductListing, Integer> listid_col;

    @FXML
    private TableColumn<ProductListing, String> imgid_col;

    @FXML
    private TableColumn<ProductListing, Float> price_col;

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

    private String toggle_query(SortToggle togg, Connection c) {
        String sql = "SELECT ListingID, ListingID AS ImageID, Price, ISBN, Title, Cond, TimePosted, Status FROM Temptableview ";
        switch (togg.getPrice()) {
            case 0:
                switch (togg.getCondition()) {
                    case 0:
                        switch (togg.getTime()) {
                            case 0:
                                sql = sql.concat(";");
                                break;
                            case 1:
                                sql = sql.concat(" ORDER BY TimePosted ASC;");
                                break;
                            case 2:
                                sql = sql.concat(" ORDER BY TimePosted DESC;");
                                break;
                        }
                    case 1:
                        switch (togg.getTime()) {
                            case 0:
                                sql = sql.concat(" WHERE Cond = 0;");
                                break;
                            case 1:
                                sql = sql.concat((" WHERE Cond = 0 ORDER BY TimePosted ASC;"));
                                break;
                            case 2:
                                sql = sql.concat((" WHERE Cond = 0 ORDER BY TimePosted DESC;"));
                                break;
                        }
                    case 2:
                        switch (togg.getTime()) {
                            case 0:
                                sql = sql.concat(" WHERE Cond = 1;");
                                break;
                            case 1:
                                sql = sql.concat((" WHERE Cond = 1 ORDER BY TimePosted ASC;"));
                                break;
                            case 2:
                                sql = sql.concat((" WHERE Cond = 1 ORDER BY TimePosted DESC;"));
                                break;
                        }
                    case 3:
                        switch (togg.getTime()) {
                            case 0:
                                sql = sql.concat(" WHERE Cond = 2;");
                                break;
                            case 1:
                                sql = sql.concat((" WHERE Cond = 2 ORDER BY TimePosted ASC;"));
                                break;
                            case 2:
                                sql = sql.concat((" WHERE Cond = 2 ORDER BY TimePosted DESC;"));
                                break;
                        }
                }
            case 1:
                switch (togg.getCondition()) {
                    case 0:
                        switch (togg.getTime()) {
                            case 0:
                                sql = sql.concat(" ORDER BY Price ASC;");
                                break;
                            case 1:
                                sql = sql.concat(" ORDER BY Price ASC, TimePosted ASC;");
                                break;
                            case 2:
                                sql = sql.concat(" ORDER BY Price ASC, TimePosted DESC;");
                                break;
                        }
                    case 1:
                        switch (togg.getTime()) {
                            case 0:
                                sql = sql.concat(" WHERE Cond = 0 ORDER BY Price ASC;");
                                break;

                            case 1:
                                sql = sql.concat((" WHERE Cond = 0 ORDER BY Price ASC, TimePosted ASC;"));
                                break;
                            case 2:
                                sql = sql.concat((" WHERE Cond = 0 ORDER BY Price ASC, TimePosted DESC;"));
                                break;
                        }
                    case 2:
                        switch (togg.getTime()) {
                            case 0:
                                sql = sql.concat(" WHERE Cond = 1 ORDER BY Price ASC;");
                                break;

                            case 1:
                                sql = sql.concat((" WHERE Cond = 1 ORDER BY Price ASC, TimePosted ASC;"));
                                break;
                            case 2:
                                sql = sql.concat((" WHERE Cond = 1 ORDER BY Price ASC, TimePosted DESC;"));
                                break;
                        }
                    case 3:
                        switch (togg.getTime()) {
                            case 0:
                                sql = sql.concat(" WHERE Cond = 2 ORDER BY Price ASC;");
                                break;
                            case 1:
                                sql = sql.concat((" WHERE Cond = 2 ORDER BY Price ASC, TimePosted ASC;"));
                                break;
                            case 2:
                                sql = sql.concat((" WHERE Cond = 2 ORDER BY Price ASC, TimePosted DESC;"));
                                break;
                        }
                }
            case 2:
                switch (togg.getCondition()) {
                    case 0:
                        switch (togg.getTime()) {
                            case 0:
                                sql = sql.concat(" ORDER BY Price DESC;");
                                break;
                            case 1:
                                sql = sql.concat(" ORDER BY Price DESC, TimePosted ASC;");
                                break;
                            case 2:
                                sql = sql.concat(" ORDER BY Price DESC, TimePosted DESC;");
                                break;
                        }
                    case 1:
                        switch (togg.getTime()) {
                            case 0:
                                sql = sql.concat(" WHERE Cond = 0 ORDER BY Price DESC;");
                                break;
                            case 1:
                                sql = sql.concat((" WHERE Cond = 0 ORDER BY Price DESC, TimePosted ASC;"));
                                break;
                            case 2:
                                sql = sql.concat((" WHERE Cond = 0 ORDER BY Price DESC, TimePosted DESC;"));
                                break;
                        }
                    case 2:
                        switch (togg.getTime()) {
                            case 0:
                                sql = sql.concat(" WHERE Cond = 1 ORDER BY Price DESC;");
                                break;
                            case 1:
                                sql = sql.concat((" WHERE Cond = 1 ORDER BY Price DESC, TimePosted ASC;"));
                                break;
                            case 2:
                                sql = sql.concat((" WHERE Cond = 1 ORDER BY Price DESC, TimePosted DESC;"));
                                break;
                        }
                    case 3:
                        switch (togg.getTime()) {
                            case 0:
                                sql = sql.concat(" WHERE Cond = 2 ORDER BY Price DESC;");
                                break;
                            case 1:
                                sql = sql.concat((" WHERE Cond = 2 ORDER BY Price DESC, TimePosted ASC;"));
                                break;
                            case 2:
                                sql = sql.concat((" WHERE Cond = 2 ORDER BY Price DESC, TimePosted DESC;"));
                                break;
                        }
                }
        }
        return sql + ";";
    }

    public void initialize(URL url, ResourceBundle rb) {
        this.dbc = new dbConnection();

    }


    public Connection con = dbConnection.connect();

    @FXML
    private void loadProductListing(ActionEvent ev, String s) throws SQLException {
        try {

            PreparedStatement ps = con.prepareStatement("DROP TABLE IF EXISTS Temptableview;");
            ps.execute();
            PreparedStatement ps2 = con.prepareStatement("CREATE TEMPORARY TABLE Temptableview AS SELECT * FROM Listings, Product, ListingImage, Books, Users, Profiles WHERE Listings.ListingID = Product.ListingID AND Listings.ListingID = ListingImage.ListingID AND Books.ISBN = Product.ISBN AND Listings.UserID = Users.UserID AND Users.UserID = Profiles.UserID AND (LOWER(Books.ISBN) LIKE ? OR LOWER(Books.Title) LIKE ? OR LOWER(Books.Author) LIKE ?);");
            ps2.setString(1, "%"+s+"%");
            ps2.setString(2, "%"+s+"%");
            ps2.setString(3, "%"+s+"%");
            ps2.execute();

            this.data = FXCollections.observableArrayList();
            System.out.println(this.tog.getPrice() + this.tog.getCondition() + this.tog.getTime());
            ResultSet rs = con.createStatement().executeQuery(toggle_query(this.tog, con));
            while (rs.next()) {
                this.data.add(new ProductListing(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getBoolean(8)));
                System.out.println(rs.getString(1) +
                        rs.getString(2) +
                        rs.getString(3) +
                        rs.getString(4) +
                        rs.getString(5) +
                        rs.getString(6) +
                        rs.getString(7) +
                        rs.getString(8));
            }
            rs.close();
            ps.close();
            ps2.close();

        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        this.listid_col.setCellValueFactory(new PropertyValueFactory<ProductListing, Integer>("ListingID"));
        this.imgid_col.setCellValueFactory(new PropertyValueFactory<ProductListing, String>("ImageID"));
        this.price_col.setCellValueFactory(new PropertyValueFactory<ProductListing, Float>("Price"));
        this.isbn_col.setCellValueFactory(new PropertyValueFactory<ProductListing, String>("ISBN"));
        this.title_col.setCellValueFactory(new PropertyValueFactory<ProductListing, String>("Title"));
        this.cond_col.setCellValueFactory(new PropertyValueFactory<ProductListing, String>("Condition"));
        this.time_col.setCellValueFactory(new PropertyValueFactory<ProductListing, String>("TimePosted"));
        this.status_col.setCellValueFactory(new PropertyValueFactory<ProductListing, String>("Status"));

        this.Listings_Table.setItems(null);
        this.Listings_Table.setItems(this.data);

        this.Listings_Table.setOnMousePressed(new EventHandler<MouseEvent>() {


            @Override
            public void handle (MouseEvent event){
                FXMLLoader Loader = new FXMLLoader();
                Loader.setLocation(getClass().getResource("/pages/listingView.fxml"));

                try {
                    Loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("TEST:: Getting a closer look at the book listing...");
                listingViewController listingViewController = Loader.getController();
                int lid_temp = Listings_Table.getSelectionModel().getSelectedItem().getListingID();
                try {
                    PreparedStatement pre = con.prepareStatement("SELECT Title, Author, ISBN, FirstName ||' '|| LastName AS Name, UserID, Email, Phone, TimePosted, RegDate FROM Temptableview WHERE ListingID = ?;");
                    pre.setInt(1, lid_temp);
                    ResultSet p = pre.executeQuery();
                    PreparedStatement pre2 = con.prepareStatement("SELECT UserID FROM Listings WHERE ListingID = ?;");
                    pre2.setInt(1, lid_temp);
                    ResultSet counter = pre2.executeQuery();
                    PreparedStatement pre3 = con.prepareStatement("SELECT count(UserID) AS ListingCount FROM Listings WHERE UserID = ?;");
                    pre3.setInt(1, counter.getInt(1));
                    ResultSet counter2 = pre3.executeQuery();

//                Sets the information for the pop up after clicking on a listing.
                    listingViewController.setSellerLabels("Title: " + p.getString(1), "Author: " + p.getString(2), "ISBN: "+p.getString(3), "Name: " + p.getString(4), "userId: " + p.getString(5), "email: " + p.getString(6), "phone: "+p.getString(7), "Posted At "+p.getString(8), "Selling Since: "+p.getString(9), counter2.getString(1)+" Listings" );
                    p.close();
                    counter.close();
                    counter2.close();
                    pre.close();
                    pre2.close();
                    pre3.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                Parent p = Loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(p));
                stage.show();
            }
        });
    }

}
