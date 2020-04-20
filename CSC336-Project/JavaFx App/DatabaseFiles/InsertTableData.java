package DatabaseFiles;

import java.sql.*;

// This should be implemented with the "new listing" page
public class InsertTableData {


    public static void insertUsers(int userID, String first, String last, String phone, String email, String pass) {
        Connection c = dbConnection.connect();
        try {
            PreparedStatement ps = c.prepareStatement("INSERT INTO Users(UserID, FirstName, LastName, Phone, Email, Pass) VALUES(?,?,?, ?, ?, ?)");
            ps.setInt(1, userID);
            ps.setString(2, first);
            ps.setString(3, last);
            ps.setString(4, phone);
            ps.setString(5, email);
            ps.setString(6, pass);

            ps.execute();
            System.out.println("The Users table has been updated with the specified values");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void insertProfiles(int userID, String avatar, Date regDate) {
        Connection c = dbConnection.connect();

        try {
            PreparedStatement ps = c.prepareStatement("INSERT INTO Profiles(UserID, Avatar, RegDate) VALUES(?,?,?)");
            ps.setInt(1, userID);
            ps.setString(2, avatar);
            ps.setDate(3, regDate);
            ps.execute();
            System.out.println("The Profiles table has been updated with the specified values");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertListings(int listingID, int userID, Timestamp time, boolean b) {
        Connection c = dbConnection.connect();

        try {
            PreparedStatement ps = c.prepareStatement("INSERT INTO Listings(ListingID, UserID, TimePosted, Status) VALUES(?,?,?,?)");
            ps.setInt(1, listingID);
            ps.setInt(2, userID);
            ps.setTimestamp(3, time);
            ps.setBoolean(4, b);
            ps.execute();
            System.out.println("The Listings table has been updated with the specified values");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void insertBooks(String ISBN, String Title, String Author) {
        Connection c = dbConnection.connect();
        try {
            PreparedStatement ps = c.prepareStatement("INSERT INTO Books(ISBN, Title, Author) VALUES(?,?,?)");
            ps.setString(1, ISBN);
            ps.setString(2, Title);
            ps.setString(3, Author);
            ps.execute();
            System.out.println("The Books table has been updated with the specified values");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void insertImage(int listingID, String imageSrc) {
        Connection c = dbConnection.connect();
        try {
            PreparedStatement ps = c.prepareStatement("INSERT INTO ListingImage(ListingID, ImageSrc) VALUES(?,?)");
            ps.setInt(1, listingID);
            ps.setString(2, imageSrc);
            ps.execute();
            System.out.println("The Image table has been updated with the specified values");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void insertProduct(String ISBN, int listingID, int cond, double price) {
        Connection c = dbConnection.connect();
        try {
            PreparedStatement ps = c.prepareStatement("INSERT INTO Product(ISBN, listingID, Cond, Price) VALUES(?,?, ?, ?)");
            ps.setString(1, ISBN);
            ps.setInt(2, listingID);
            ps.setInt(3, cond);
            ps.setDouble(4, price);
            ps.execute();
            System.out.println("The Products table has been updated with the specified values");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertAuditLog(int transID, int listingId, int sellerId, int buyerId, Timestamp time) {
        Connection c = dbConnection.connect();
        try {
            PreparedStatement ps = c.prepareStatement("INSERT INTO AuditLog(TransId, ListingId, SellerId, BuyerId, TimeComplete) VALUES(?,?, ?, ?, ?)");
            ps.setInt(1, transID);
            ps.setInt(2, listingId);
            ps.setInt(3, sellerId);
            ps.setInt(4, buyerId);
            ps.setTimestamp(5, time);
            ps.execute();
            System.out.println("The AuditLog table has been updated with the specified values");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

