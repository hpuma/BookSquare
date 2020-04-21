-- The Users table stores all the users within the program,
-- each user is uniquely identifiable by their UserID
-- the login authentication uses the user's email and password
CREATE TABLE IF NOT EXISTS Users (
   UserID INT UNSIGNED AUTO_INCREMENT,
   FirstName VARCHAR(255) NOT NULL,
   LastName VARCHAR(255) NOT NULL,
   Phone VARCHAR(255) NOT NULL UNIQUE,
   Email VARCHAR(255) NOT NULL UNIQUE, -- User's email for logging in
   Pass VARCHAR(255) NOT NULL,      -- User's password for logging in
   PRIMARY KEY(UserID)
);

-- The Profiles table contains user data that can be viewed by other users within the program
CREATE TABLE IF NOT EXISTS Profiles (
   UserID INT UNSIGNED,
   Avatar VARCHAR(255),
   RegDate DATE,
   PRIMARY KEY(UserID),
   FOREIGN KEY(UserID) REFERENCES Users(UserID)
   ON DELETE CASCADE
);

-- The Listings Table contains the current books up for sale by a user
-- Each User can have as many listing as they want
CREATE TABLE IF NOT EXISTS Listings (
	ListingID INT UNSIGNED AUTO_INCREMENT,
	UserID INT UNSIGNED,
	TimePosted TIMESTAMP,
	Status BIT(1),
	PRIMARY KEY(ListingID)
	FOREIGN KEY(UserID) REFERENCES Users(UserID)
	ON DELETE CASCADE
);

-- The ListingImage table contains the image paths for all the images
-- That are posted to the listings table
CREATE TABLE IF NOT EXISTS ListingImage (
   ListingID INT UNSIGNED PRIMARY KEY,
   ImageSrc VARCHAR(255) NOT NULL,
   FOREIGN KEY(ListingID) REFERENCES Listings(ListingID)
   ON DELETE CASCADE
);

-- The Product table contains the distinct products
-- that have been added to the listings. The product has
-- the necessary information that is important for shoppers.
CREATE TABLE IF NOT EXISTS Product (
	ISBN VARCHAR(255),
	ListingID INT UNSIGNED NOT NULL,
	Cond INT UNSIGNED NOT NULL,
	Price DECIMAL UNSIGNED NOT NULL,
	PRIMARY KEY(ListingID),
	FOREIGN KEY(ListingID) REFERENCES Listings(ListingID),
	FOREIGN KEY(ISBN) REFERENCES Books(ISBN)
	ON DELETE CASCADE
);
-- The AuditLog table takes care of any transactions that
-- occur between users when buying and selling products.
CREATE TABLE IF NOT EXISTS AuditLog (
   TransID INT UNSIGNED AUTO_INCREMENT,
   ListingID INT UNSIGNED,
   SellerID INT UNSIGNED NOT NULL,
   BuyerID INT UNSIGNED NOT NULL,
   TimeComplete TIMESTAMP NOT NULL,
   PRIMARY KEY(TransID, ListingID)
);

-- The Books table contains all the distinct books that currently exist
-- within the Listings table.
CREATE TABLE IF NOT EXISTS Books (
   ISBN VARCHAR(255),
   Title VARCHAR(255) NOT NULL,
   Author VARCHAR(255),
   PRIMARY KEY(ISBN)
);
