INSERT INTO 
    Listings(ListingID,ImageID,UserID,TimePosted,Status)
VALUES
    (1,11,10,'2010-05-28T15:36:56.200',1),
	(2,22,21,'2011-08-28T13:24:45.200',1),
	(3,33,32,'2012-08-28T17:52:48.200',1),
	(4,44,43,'2013-08-28T12:26:55.200',1),
	(5,55,54,'2014-08-28T11:63:31.200',1);

INSERT INTO 
    ListingImage(ImageID,ImageSrc)
VALUES
    (11,'PathtoImage11'),
    (22,'PathtoImage22'),
    (33,'PathtoImage33'),
    (44,'PathtoImage1'),
    (55,'PathtoImage1');


INSERT INTO 
    Product(ISBN,ListingID,Cond,Price)
VALUES
    ('ISBN1',1,'VeryGood',21.99),
    ('ISBN2',2,'Good',22.99),
    ('ISBN3',3,'Fair',23.99),
    ('ISBN4',4,'Fine',24.99),
    ('ISBN5',5,'Acceptable',25.99);

INSERT INTO 
    AuditLog(TransID,ListingID,SellerID,BuyerID,TimeComplete)
VALUES
    (532,1,10,1,'2015-08-03T15:36:56.200'),
	(252,2,21,2,'2012-02-14T15:36:56.200'),
	(373,3,32,1,'2014-03-26T15:36:56.200'),
	(425,4,43,4,'2012-02-01T15:36:56.200'),
	(733,5,54,5,'2020-01-24T15:36:56.200');


    