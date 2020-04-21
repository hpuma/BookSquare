INSERT INTO 
    Users(UserID, FirstName, LastName, Phone, Email, Pass)
VALUES
    (1, 'John', 'Doe', '212-254-6849', 'jdoe@gmail.com', 'pass'),
    (2, 'Harry', 'Potter','917-234-3412' , 'hpotter@gmail.com', 'pass'),
    (3, 'Ben', 'Wyatt','646-234-2114' , 'bwyatt@gmail.com', 'pass'),
    (4, 'George', 'Wash','718-194-1219' , 'gwashington@gmail.com', 'pass'),
    (5, 'Bryan', 'James', '347-224-2459', 'bjames@gmail.com', 'pass'),
    (6, 'Adrian', 'Pimento', '382-234-8449', 'apimento@gmail.com', 'pass'),
    (7, 'Jake', 'Peralta', '929-734-6289', 'jperalta@gmail.com', 'pass'),
    (8, 'Terry', 'Crews', '347-284-2739', 'tcrews@gmail.com', 'pass'),
    (9, 'Alice', 'Cook', '646-933-5679', 'acook@gmail.com', 'pass'),
    (10, 'Bob', 'Davis', '718-234-5719', 'bdavis@gmail.com', 'pass'),
    (11, 'Mickey', 'Mouse', '718-234-4719', 'mmouse@gmail.com', 'pass'),
    (12, 'Dan', 'stan', '718-254-3715', 'email1', 'pass');



INSERT INTO
    Profiles(UserID, Avatar, RegDate)
VALUES
    (1, 'Avatar1', '2020-04-20'),
    (2, 'Avatar2', '2019-04-21'),
    (3, 'Avatar3', '2012-04-22'),
    (4, 'Avatar4', '2000-04-23'),
    (5, 'Avatar5', '2001-04-24'),
    (6, 'Avatar10', '2015-04-25'),
    (7, 'Avatar21', '2017-04-26'),
    (8, 'Avatar32', '2016-04-27'),
    (9, 'Avatar43', '2016-04-28'),
    (10, 'Avatar54', '2011-04-29');



INSERT INTO 
    Listings(ListingID, UserID, TimePosted, Status)
VALUES
    (1, 1, '2010-05-28T15:36:56.200', 1),
	(2, 2, '2011-08-28T13:24:45.200', 1),
	(3, 2, '2012-08-28T17:52:48.200', 1),
	(4, 3, '2013-08-28T12:26:55.200', 1),
	(5, 3, '2014-08-28T11:63:31.200', 1);



INSERT INTO 
    ListingImage(ListingID, ImageSrc)
VALUES
    (1, 'PathtoImage11'),
    (2, 'PathtoImage22'),
    (3, 'PathtoImage33'),
    (4, 'PathtoImage1'),
    (5, 'PathtoImage1');




INSERT INTO 
    Books(ISBN, Title, Author)
VALUES 
    ('9780201853926', 'The Art of Computer Programming', 'Donald Knuth'),
    ('9781259588082', 'Modern Cryptography: Applied Mathematics for Encryption and Information Security', 'Chuck Easttom'),
    ('9780262533058', 'Introduction to Algorithms', 'Ronald Rivest'),
    ('0201633612', 'The "Gang of Four":', 'Erich Gamma'),
    ('9780131101630', 'The C Programming Language. 2nd Edition', 'Dennis Ritchie');




INSERT INTO 
    Product(ISBN, ListingID, Cond, Price)
VALUES
    ('9780201853926', 1, 2, 21.99),
    ('9781259588082', 2, 1, 22.99),
    ('9780262533058', 3, 1, 23.99),
    ('0201633612', 4, 0, 24.99),
    ('9780131101630', 5, 2, 25.99);



INSERT INTO 
    AuditLog(TransID,ListingID,SellerID,BuyerID,TimeComplete)
VALUES
    (532, 1, 1, 6, '2015-08-03T15:36:56.200'),
	(252, 2, 2, 7, '2012-02-14T15:36:56.200'),
	(373, 3, 3, 8, '2014-03-26T15:36:56.200'),
	(425, 4, 4, 9, '2012-02-01T15:36:56.200'),
	(733, 5, 5, 10, '2020-01-24T15:36:56.200');
