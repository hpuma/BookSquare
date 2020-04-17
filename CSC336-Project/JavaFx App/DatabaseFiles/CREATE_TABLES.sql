CREATE TABLE IF NOT EXISTS Listings (
    ListingID INT UNSIGNED,
    UserID INT UNSIGNED,
    ImageID INT UNSIGNED,
    TimePosted TIMESTAMP,
    Status BIT(1), -- Switch for availible or not availible
	PRIMARY KEY (ListingID,UserID,ImageID)
);

-- ListingID, ISBN, Condition, Price
CREATE TABLE IF NOT EXISTS Product (
    ListingID INT UNSIGNED,
    ISBN VARCHAR(255),
    Cond INT UNSIGNED NOT NULL, -- Use number codes for its condition, 1 worst .. 4 best
    Price DECIMAL,
    PRIMARY KEY (ListingID,ISBN)
);

-- ImageID, Size, Type
CREATE TABLE IF NOT EXISTS ListingImage (
    ImageID INT,
    ImgSrc VARCHAR(255), -- Path to the image in our C: drive
    PRIMARY KEY (ImageID)
);

-- TransactionID, BuyerID, SellerID, ListingID, TimeCompleted
CREATE TABLE IF NOT EXISTS AuditLog (
    TransID INT UNSIGNED AUTO_INCREMENT,
    ListingID INT UNSIGNED,
    BuyerID INT UNSIGNED NOT NULL,
    SellerID INT UNSIGNED NOT NULL,
    TimeComplete TIMESTAMP, -- Time of the transaction
    PRIMARY KEY (TransID, ListingID)
);

-- ISBN, Title, Author
CREATE TABLE IF NOT EXISTS Books (
    ISBN VARCHAR(255),
    Title VARCHAR(255) NOT NULL,
    Author VARCHAR(255),
    PRIMARY KEY (ISBN)
);

-- UserID, FirstName, LastName, Phone, Email, Password
CREATE TABLE IF NOT EXISTS Users (
    UserID INT UNSIGNED AUTO_INCREMENT,
    FirstName VARCHAR(255),
    LastName VARCHAR(255),
    Phone VARCHAR(255),
    Email VARCHAR(255),
    Pass VARCHAR(255),
    PRIMARY KEY (UserID,Phone,Email)
);

-- UserID, Avatar, RegDate
CREATE TABLE IF NOT EXISTS Profiles (
    UserID INT UNSIGNED,
    Avatar VARCHAR(255), -- ... Path to an image of the avatar C: drive to folder of avatar images
    RegDate DATE,
    PRIMARY KEY (UserID)
);
