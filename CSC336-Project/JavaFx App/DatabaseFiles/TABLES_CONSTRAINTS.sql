CREATE TABLE Listings (
	ListingID INT UNSIGNED,
	ImageID INT UNSIGNED NOT NULL UNIQUE,
	UserID INT UNSIGNED,
	TimePosted TIMESTAMP,
	Status BIT(1),
	PRIMARY KEY(ListingID)
);

-- ImageID, Size, Type
CREATE TABLE ListingImage (
   ImageID INT UNSIGNED PRIMARY KEY,
   ImageSrc VARCHAR(255) NOT NULL,
   FOREIGN KEY(ImageID) REFERENCES Listings(ImageID)
   ON DELETE CASCADE
);

-- ListingID, ISBN, Condition, Price .................................
CREATE TABLE Product (
	ISBN VARCHAR(255),
	ListingID INT UNSIGNED NOT NULL,
	Cond INT UNSIGNED NOT NULL, -- Use number codes for its condition
	Price DECIMAL UNSIGNED NOT NULL,
	PRIMARY KEY(ISBN),
	FOREIGN KEY(ListingID) REFERENCES Listings(ListingID)
);

-- TransactionID, BuyerID, SellerID, ListingID, TimeCompleted
CREATE TABLE AuditLog (
   TransID INT UNSIGNED AUTO_INCREMENT,
   ListingID INT UNSIGNED,
   SellerID INT UNSIGNED NOT NULL,
   BuyerID INT UNSIGNED NOT NULL,
   TimeComplete TIMESTAMP NOT NULL,
   PRIMARY KEY(TransID, ListingID),
   FOREIGN KEY(ListingID) REFERENCES Listings(ListingID)
);

CREATE TABLE Books (
   ISBN VARCHAR(255),
   Title VARCHAR(255) NOT NULL,
   Author VARCHAR(255),
   PRIMARY KEY(ISBN),
   FOREIGN KEY(ISBN) REFERENCES Product(ISBN)
);

-- UserID, FirstName, LastName, Phone, Email, Password
CREATE TABLE Users (
   UserID INT UNSIGNED AUTO_INCREMENT,
   FirstName VARCHAR(255) NOT NULL,
   LastName VARCHAR(255) NOT NULL,
   Phone VARCHAR(255),
   Email VARCHAR(255),
   Pass VARCHAR(255) NOT NULL,
   PRIMARY KEY(UserID, Phone, Email)
);

-- UserID, Avatar, RegDate
CREATE TABLE Profiles (
   UserID INT UNSIGNED,
   Avatar VARCHAR(255), -- ... Path to an image
   RegDate DATE,
   PRIMARY KEY(UserID),
   FOREIGN KEY(UserID) REFERENCES Users(UserID)
);