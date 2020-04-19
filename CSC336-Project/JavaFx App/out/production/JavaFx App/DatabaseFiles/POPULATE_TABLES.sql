INSERT INTO 
    Users(UserID, FirstName, LastName, Phone, Email, Pass)
VALUES
    (1, 'Name1', 'LName1', 'Phone1', 'Email1', 'Pass1'),
    (2, 'Name2', 'LName2', 'Phone2', 'Email2', 'Pass2'),
    (3, 'Name3', 'LName3', 'Phone3', 'Email3', 'Pass3'),
    (4, 'Name4', 'LName4', 'Phone4', 'Email4', 'Pass4'),
    (5, 'Name5', 'LName5', 'Phone5', 'Email5', 'Pass5'),
    (10, 'Name10', 'LName10', 'Phone10', 'Email10', 'Pass10'),
    (21, 'Name21', 'LName21', 'Phone21', 'Email21', 'Pass21'),
    (32, 'Name32', 'LName32', 'Phone32', 'Email32', 'Pass32'),
    (43, 'Name43', 'LName43', 'Phone43', 'Email43', 'Pass43'),
    (54, 'Name54', 'LName54', 'Phone54', 'Email54', 'Pass54');



INSERT INTO
    Profiles(UserID, Avatar, RegDate)
VALUES
    (1, 'Avatar1', '2020-04-20'),
    (2, 'Avatar2', '2019-04-21'),
    (3, 'Avatar3', '2012-04-22'),
    (4, 'Avatar4', '2000-04-23'),
    (5, 'Avatar5', '2001-04-24'),
    (10, 'Avatar10', '2015-04-25'),
    (21, 'Avatar21', '2017-04-26'),
    (32, 'Avatar32', '2016-04-27'),
    (43, 'Avatar43', '2016-04-28'),
    (54, 'Avatar54', '2011-04-29');



INSERT INTO 
    Listings(ListingID, ImageID, UserID, TimePosted, Status)
VALUES
    (1, 11, 10, '2010-05-28T15:36:56.200', 1),
	(2, 22, 21, '2011-08-28T13:24:45.200', 1),
	(3, 33, 32, '2012-08-28T17:52:48.200', 1),
	(4, 44, 43, '2013-08-28T12:26:55.200', 1),
	(5, 55, 54, '2014-08-28T11:63:31.200', 1);



INSERT INTO 
    ListingImage(ImageID, ImageSrc)
VALUES
    (11, 'PathtoImage11'),
    (22, 'PathtoImage22'),
    (33, 'PathtoImage33'),
    (44, 'PathtoImage1'),
    (55, 'PathtoImage1');




INSERT INTO 
    Books(ISBN, Title, Author)
VALUES 
    ('ISBN1', 'Title1', 'Author1'),
    ('ISBN2', 'Title2', 'Author2'),
    ('ISBN3', 'Title3', 'Author3'),
    ('ISBN4', 'Title4', 'Author4'),
    ('ISBN5', 'Title5', 'Author5');




INSERT INTO 
    Product(ISBN, ListingID, Cond, Price)
VALUES
    ('ISBN1', 1, 'VeryGood', 21.99),
    ('ISBN2', 2, 'Good', 22.99),
    ('ISBN3', 3, 'Fair', 23.99),
    ('ISBN4', 4, 'Fine', 24.99),
    ('ISBN5', 5, 'Acceptable', 25.99);



INSERT INTO 
    AuditLog(TransID,ListingID,SellerID,BuyerID,TimeComplete)
VALUES
    (532, 1, 10, 1, '2015-08-03T15:36:56.200'),
	(252, 2, 21, 2, '2012-02-14T15:36:56.200'),
	(373, 3, 32, 3, '2014-03-26T15:36:56.200'),
	(425, 4, 43, 4, '2012-02-01T15:36:56.200'),
	(733, 5, 54, 5, '2020-01-24T15:36:56.200');