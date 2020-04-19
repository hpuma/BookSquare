package controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProductListing {

    private final StringProperty ListingID;
    private final StringProperty ImageID;
    private final StringProperty Price;
    private final StringProperty ISBN;
    private final StringProperty Title;
    private final StringProperty Condition;
    private final StringProperty TimePosted;
    private final StringProperty Status;

    public ProductListing(String LID, String ImgID, String P, String isbn, String title, String condition, String t_posted, String status){

        this.ImageID = new SimpleStringProperty(ImgID);
        this.ListingID = new SimpleStringProperty(LID);
        this.Price = new SimpleStringProperty(P);
        this.ISBN = new SimpleStringProperty(isbn);
        this.Title = new SimpleStringProperty(title);
        this.Condition = new SimpleStringProperty(condition);
        this.TimePosted = new SimpleStringProperty(t_posted);
        this.Status = new SimpleStringProperty(status);
    }

    //Getters
    public String getImageID() {
        return ImageID.get();
    }

    public StringProperty imageIDProperty() {
        return ImageID;
    }

    public String getListingID() {
        return ListingID.get();
    }

    public StringProperty listingIDProperty() {
        return ListingID;
    }

    public String getPrice() {
        return Price.get();
    }

    public StringProperty priceProperty() {
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

    public void setListingID(String listingID) {
        this.ListingID.set(listingID);
    }

    public void setPrice(String price) {
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
