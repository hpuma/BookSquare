USE csc366;

-- ListingID, ImageID, UserID, TimePosted, Status
CREATE TABLE IF NOT EXISTS Listings (
    ListingID INT UNSIGNED,
    PRIMARY KEY (ListingID),
    ImageID INT UNSIGNED NOT NULL,
    UserID INT UNSIGNED NOT NULL,
    TimePosted TIMESTAMP,
    Status BIT(1)
    );

-- ListingID, ISBN, Condition, Price
CREATE TABLE IF NOT EXISTS Product(
    ListingID INT UNSIGNED,
    PRIMARY KEY (ListingID),
    ISBN VARCHAR(255),
    Cond INT UNSIGNED NOT NULL, -- Use number codes for its condition
    Price DECIMAL
);

-- ImageID, Size, Type
CREATE TABLE IF NOT EXISTS ListingImage (
    ImageID INT UNSIGNED,
    PRIMARY KEY (ImageID),
    imgsize INT UNSIGNED NOT NULL,
    imgtype INT UNSIGNED NOT NULL,
    Stat BIT(1)
);

-- ISBN, Title, Author
CREATE TABLE IF NOT EXISTS Books(
    ISBN VARCHAR(255),
    PRIMARY KEY (ISBN),
    Title VARCHAR(255) NOT NULL,
    Author VARCHAR(255)
);

-- UserID, FirstName, LastName, Phone, Email, Password
CREATE TABLE IF NOT EXISTS Users(
    UserID INT UNSIGNED AUTO_INCREMENT,
    PRIMARY KEY (UserID),
    FirstName VARCHAR(255),
    LastName VARCHAR(255),
    Phone VARCHAR(255),
    Email VARCHAR(255),
    Pass VARCHAR(255)
    );

-- TransactionID, BuyerID, SellerID, ListingID, TimeCompleted
CREATE TABLE IF NOT EXISTS AuditLog (
    TransID INT UNSIGNED AUTO_INCREMENT,
    PRIMARY KEY (TransID),
    BuyerID INT UNSIGNED NOT NULL,
    SellerID INT UNSIGNED NOT NULL,
    ListingID INT UNSIGNED NOT NULL,
    TimeComplete TIMESTAMP
    );

-- UserID, Avatar, RegDate
CREATE TABLE IF NOT EXISTS Profiles (
    UserID INT UNSIGNED,
    PRIMARY KEY (UserID),
    Avatar VARCHAR(255),
    RegDate DATE
    );