package controllers;

import javafx.beans.property.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProductListing {

    private final IntegerProperty ListingID;
    private final StringProperty ImageID;
    private final FloatProperty Price;
    private final StringProperty ISBN;
    private final StringProperty Title;
    private final StringProperty Condition;
    private final StringProperty TimePosted;
    private final StringProperty Status;

    public ProductListing(int LID, String ImgID, float P, String isbn, String title, int condition, String t_posted, Boolean status){

        this.ImageID = new SimpleStringProperty(ImgID);
        this.ListingID = new SimpleIntegerProperty(LID);
        this.Price = new SimpleFloatProperty(P);
        this.ISBN = new SimpleStringProperty(isbn);
        this.Title = new SimpleStringProperty(title);
        this.Condition = new SimpleStringProperty(check_cond(condition));
        this.TimePosted = new SimpleStringProperty(t_posted);
        this.Status = new SimpleStringProperty(check_availability(status));
    }

    //Check
    public String check_availability(Boolean stat){
        if(stat == Boolean.TRUE){
            return "OPEN";
        }
        else if(stat == Boolean.FALSE){
            return "CLOSED";
        }
        return stat.toString();
    }

    public String check_cond(int con){
        if(con == 0){
            return "Acceptable";
        }
        else if(con == 1){
            return "Good";
        }
        else if(con == 2){
            return "Like New";
        }
        return "NULL";
    }

    //Getters
    public String getImageID() {
        return ImageID.get();
    }

    public StringProperty imageIDProperty() {
        return ImageID;
    }

    public int getListingID() {
        return ListingID.get();
    }

    public IntegerProperty listingIDProperty() {
        return ListingID;
    }

    public float getPrice() {
        return Price.get();
    }

    public FloatProperty priceProperty() {
        return Price;
    }

    public String getISBN() {
        return ISBN.get();
    }

    public StringProperty ISBNProperty() {
        return ISBN;
    }

    public String getTitle() {
        return Title.get();
    }

    public StringProperty titleProperty() {
        return Title;
    }

    public String getCondition() {
        return Condition.get();
    }

    public StringProperty conditionProperty() {
        return Condition;
    }

    public String getTimePosted() {
        return TimePosted.get();
    }

    public StringProperty timePostedProperty() {
        return TimePosted;
    }

    public String getStatus() {
        return Status.get();
    }

    public StringProperty statusProperty() {
        return Status;
    }

    //Setters


    public void setImageID(String imageID) {
        this.ImageID.set(imageID);
    }

    public void setListingID(int listingID) {
        this.ListingID.set(listingID);
    }

    public void setPrice(float price) {
        this.Price.set(price);
    }

    public void setISBN(String ISBN) {
        this.ISBN.set(ISBN);
    }

    public void setTitle(String title) {
        this.Title.set(title);
    }

    public void setCondition(String condition) {
        this.Condition.set(condition);
    }

    public void setTimePosted(String timePosted) {
        this.TimePosted.set(timePosted);
    }

    public void setStatus(String status) {
        this.Status.set(status);
    }


}
