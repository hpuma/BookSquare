package controllers;
import DatabaseFiles.executeScript;

import java.sql.ResultSet;


public class UserAccount {
    private int UserID;
    private String firstName;
    private String lastName;
    private String Phone;
    private String Email;
    private String Pass;

    // Constructor that queries an account based on important credentials.
    public UserAccount(){

    }
    public UserAccount(String UserEmail, String UserPassword){
      try{
          if(this.updateAccount(UserEmail, UserPassword)){
              System.out.println("ACCOUNT FOUND!");
          }
          else{
              System.out.println("ACCOUNT NOT FOUND!");
          }
      }catch (Exception e){
          e.printStackTrace();
      }
    }

    // Update the User details based on the Users login info.
    public boolean updateAccount(String UserEmail, String UserPassword) throws Exception {
        String LoginDetails = String.format("SELECT * FROM Users WHERE Email=\'%s\'"+" AND Pass=\'%s\';",UserEmail, UserPassword);
        executeScript runQuery = new executeScript();
        try (ResultSet AccountInfo = runQuery.executeStatement("users",LoginDetails)){
            if (AccountInfo.next()){
               this.UserID =  AccountInfo.getInt("UserID");
               this.firstName = AccountInfo.getString("FirstName");
               this.lastName = AccountInfo.getString("LastName");
               this.Phone = AccountInfo.getString("Phone");
               this.Email = AccountInfo.getString("Email");
               this.Pass = AccountInfo.getString("Pass");
               return true;
            }
        }
        catch (NullPointerException n){
            n.printStackTrace();
        }
        return false;
    }

    public int getUserID() {
        return this.UserID;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getPhone() {
        return this.Phone;
    }
    public String getEmail() {
        return this.Email;
    }
    public String getPass() {
        return this.Pass;
    }

}
