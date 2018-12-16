create database if not exists part1;
use part1;

#Book table
DROP TABLE IF EXISTS BOOK;
CREATE TABLE BOOK (
 bookid      VARCHAR(20) NOT NULL,
 title     VARCHAR(100) NOT NULL,
 price     INT UNSIGNED NOT NULL,
 author     VARCHAR(100) NOT NULL,
 category  ENUM('Biography and Memoir','Business and Finance','Computers', 'Entertainment', 'History', 'Fiction', 'Science Fiction', 'Self-Help', 'Health', 'Science and Nature', 'Poetry') NOT NULL,
 featured	tinyint(1) NOT NULL,
 PRIMARY KEY(bookid)
) ;

INSERT INTO BOOK (bookid, title, price, author, category, featured) VALUES ('1735463700', '2 States', 18, 'Chetan Bhagat', 'Fiction', 0);
INSERT INTO BOOK (bookid, title, price, author, category, featured) VALUES ('1735463701', 'Kite Runner', 15, 'Khaled Hosseini', 'Fiction', 1);
INSERT INTO BOOK (bookid, title, price, author, category, featured) VALUES ('1735463702', 'Half Girlfriend', 11, 'Chetan Bhagat', 'Fiction', 1);
INSERT INTO BOOK (bookid, title, price, author, category, featured) VALUES ('1735463703', 'Business Concepts', 12, 'Dr Gulati', 'Business and Finance', 0);
INSERT INTO BOOK (bookid, title, price, author, category, featured) VALUES ('1735463704', 'Pre-Historic Era of Unknown Civilization', 14, 'Arthur Boyle', 'History', 1);
INSERT INTO BOOK (bookid, title, price, author, category, featured) VALUES ('1735463705', 'Soorma', 20, 'Diljit', 'Biography and Memoir', 1);
INSERT INTO BOOK (bookid, title, price, author, category, featured) VALUES ('1735463706', 'Fun with Science', 9, 'Dr Hammock', 'Science Fiction', 0);
INSERT INTO BOOK (bookid, title, price, author, category, featured) VALUES ('1735463707', 'Healthy Living', 22, 'Prem Kumar Chopra', 'Health', 0);
INSERT INTO BOOK (bookid, title, price, author, category, featured) VALUES ('1735463708', 'The Sun and her Flowers', 18, 'Rupi Kaur', 'Poetry', 1);
INSERT INTO BOOK (bookid, title, price, author, category, featured) VALUES ('1735463709', 'Honey I shrunk the kids', 13, 'Dick Simmons', 'Entertainment', 1);
INSERT INTO BOOK (bookid, title, price, author, category, featured) VALUES ('1735463710', 'Python for Dummies', 20, 'Pawan Manchanda', 'Computers', 0);


#Account info table
CREATE TABLE AccountInfo (
 username    VARCHAR(20) NOT NULL,
 password  VARCHAR(50)  NOT NULL,
 PRIMARY KEY(username)
) ;

#User info table
CREATE TABLE UserInfo (
 fname     VARCHAR(20) NOT NULL,
 lname     VARCHAR(20) NOT NULL,
 username    VARCHAR(20) NOT NULL,
 shippingaddress   VARCHAR(100) NOT NULL,
 billingaddress     VARCHAR(100) NOT NULL,
 FOREIGN KEY (username) REFERENCES accountinfo (username) 
) ;

#Purchase Order table
DROP TABLE IF EXISTS PO;
CREATE TABLE PO (
 id        INT UNSIGNED NOT NULL AUTO_INCREMENT,
 lname     VARCHAR(20) NOT NULL,
 fname     VARCHAR(20) NOT NULL,
 status    ENUM('ORDERED','PROCESSED','DENIED') NOT NULL,
 address   VARCHAR(100) ,
 PRIMARY KEY(id),
 INDEX (address)
) ;

#PO item table
DROP TABLE IF EXISTS POItem;
CREATE TABLE POItem (
 id       INT UNSIGNED NOT NULL,
 bookid     VARCHAR(20) NOT NULL,
 price    INT UNSIGNED NOT NULL,
 PRIMARY KEY(id,bookid),
 INDEX (id),
 FOREIGN KEY(id) REFERENCES PO(id) ON DELETE CASCADE,
 INDEX (bookid),
 FOREIGN KEY(bookid) REFERENCES BOOK(bookid) ON DELETE CASCADE
) ;

#Visit event table
DROP TABLE IF EXISTS VisitEvent;
CREATE TABLE VisitEvent(
day date NOT NULL, 
bookid varchar(20) not null REFERENCES BOOK.bookid, 
eventtype ENUM('VIEW','CART','PURCHASE') NOT NULL,	
FOREIGN KEY(bookid) REFERENCES BOOK(bookid) 
);