# BookSquare
CSC 336 Project 1: Peter, Daniel, Julia and Henry

#### Before running, be sure to include the following external libraries to the Project Structure:
- The mavin dependency: ``` org.mybatis:mybatis:3.4.6 ```
- Any javafx-sdk library that is at least version 11. 
- Any sqlite-jdbc library. i.e. ```sqlite-jdbc-3.30.1 ```

#### Login with the following basic credentials:
- Email:   ``` email1 ```
- Password: ``` pass ```

#### If you are having issues with your modules, follow these steps:
- Go to "Run" tab.
- Click on "Edit Configurations".
- In VM Options, type in: "--module-path "C:\Users\ -your path- \javafx-sdk-14\lib" --add-modules=javafx.controls,javafx.fxml,javafx.graphics"
- Click 'Apply' and 'Ok'.

# Software Documentation

## Login page

- This is the first page your enter when opening up the program. To sign in with your account, you need to insert your email and password of your account in their respective text fields.
  - A correct email/password combination will sucessfully log the user in and bring them to the main page.
  - An incorrect email/password combination will make a pop up dialog appear, telling the user that their email/password combination is incorrect and to try again.
  - To make a new account, click the sign up button on the bottom left. This will take you to the Sign up page.
  ![Login Page](C:\Users\Daniel .H\Desktop\BookSquare_Login.png)
  
   <img src = 'https://github.com/hpuma/CSC336-Project/blob/master/login6.gif'/>

  
 ## Sign Up page
  - This page allows a user to create a new account and add the newly created user into the database.
  - The user is prompted to insert the following before signing up:
    - A unique user ID
    - A first name
    - A last name
    - An Email
    - A phone number
    - A password
  
## Main page

- This page is where a user will spend most of their time. The user can search for specific listings, sort the results of the search, access their dashboard, and log out.
- The main bar on the top allows the user to search book listings by either ISBN, Title, or Author. The options to log out or go to their dashboard are next to the search bar.
- The list of Listings is shown with a JavaFX ListView. The user can see a listings Listing ID, Image ID, Price, ISBN, Title, Condition, Time Posted, and it's Status(open or closed).
- On the right are options to sort the list of results from a users search. They can sort price by either lowest first or highest first, sort by condition with 3 levels of condition(Like New, Good, Acceptable), and sort by time the listing was posted into the database, by oldest first or by newest first.

 <img src = 'https://github.com/hpuma/CSC336-Project/blob/master/mainpage1.gif'/>
 
 ## Listing View
  - This page will pop up whenever the user clicks a listing on the Main page.
  - This page will allow the user to see the Listing's respective image.
  - This page will also show the user more details about the seller:
    - The seller's name
    - The sellers user ID
    - The seller's Email and Phone number
    - How long the seller has been a user, and the number of listings they have posted to the database.
   - This information will enable the user to contact the seller in order to complete the sale. This program does not facilitate the sale itself, but just provides the necessary information for the user to make contact with the seller. 


## My Dashboard page

- This is a users profile page, showing a user's information and gives the user an option to add a listing to the database.
- To add a listing, click the 'Add Listing' button on the right.

 <img src = 'https://github.com/hpuma/CSC336-Project/blob/master/dash.gif'/>


## New Listing page

- This page allows the user to create a new book listing and add it to the booksquare database. The user is prompted to insert the necessary information:
  - Title
  - Author
  - ISBN
  - Condition
  - Price
 - To the right, the user can click the 'Upload Image' button to upload an image of their book.
