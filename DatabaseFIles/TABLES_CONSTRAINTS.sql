USE csc336;

-- ListingID, ImageID, UserID, TimePosted, Status
CREATE TABLE IF NOT EXISTS Listings (
    ListingID INT,
    ImageID INT,
    UserID INT UNSIGNED,
    TimePosted TIMESTAMP,
    Status BIT(1),
	PRIMARY KEY (ListingID, UserID, ImageID)
    );

-- ListingID, ISBN, Condition, Price .................................
CREATE TABLE IF NOT EXISTS Product (
    ListingID INT,
    ISBN VARCHAR(255),
    Cond INT UNSIGNED NOT NULL, -- Use number codes for its condition
    Price DECIMAL,
    PRIMARY KEY(ListingID,ISBN),
	FOREIGN KEY(ListingID) REFERENCES Listings (ListingID)
);

-- ImageID, Size, Type
CREATE TABLE IF NOT EXISTS ListingImage (
    ImageID INT,
    ImgSrc VARCHAR(255),
    PRIMARY KEY(ImageID),
	FOREIGN KEY(ImageID) REFERENCES Listings(ImageID)
);

-- TransactionID, BuyerID, SellerID, ListingID, TimeCompleted
CREATE TABLE IF NOT EXISTS AuditLog (
    TransID INT UNSIGNED AUTO_INCREMENT,
    BuyerID INT UNSIGNED NOT NULL,
    SellerID INT UNSIGNED NOT NULL,
    ListingID INT UNSIGNED NOT NULL,
    TimeComplete TIMESTAMP,
	PRIMARY KEY (TransID, ListingID),
	FOREIGN KEY (ListingID) REFERENCES Listings(ListingID)
    );


-- ISBN, Title, Author
CREATE TABLE IF NOT EXISTS Books (
    ISBN VARCHAR(255),
    PRIMARY KEY (ISBN),
    Title VARCHAR(255) NOT NULL,
    Author VARCHAR(255),
	FOREIGN KEY (ISBN) REFERENCES Products(ISBN) -- ... EHH
);


-- UserID, FirstName, LastName, Phone, Email, Password
CREATE TABLE IF NOT EXISTS Users (
    UserID INT UNSIGNED AUTO_INCREMENT,
    FirstName VARCHAR(255),
    LastName VARCHAR(255),
    Phone VARCHAR(255),
    Email VARCHAR(255),
    Pass VARCHAR(255),
	PRIMARY KEY (UserID, Phone, Email)
    );


-- UserID, Avatar, RegDate
CREATE TABLE IF NOT EXISTS Profiles (
    UserID INT UNSIGNED,
    Avatar VARCHAR(255), -- ... Path to an image
    RegDate DATE,
	PRIMARY KEY (UserID),
    FOREIGN KEY (UserID) REFERENCES Users(UserID)
    );