CREATE TABLE BOOKS
        (
        id NUMBER(10) NOT NULL primary key AUTO_INCREMENT,
        title VARCHAR2(50) NOT NULL,
        author VARCHAR2(50) NOT NULL,
        book_description VARCHAR2(500),
        book_type VARCHAR2(50),
        language VARCHAR2(50),
		library_name VARCHAR2(50),
		created_date DATE,
        PRIMARY KEY(id)
        );
        
CREATE TABLE LIBRARY
        (
        id NUMBER(10) NOT NULL primary key AUTO_INCREMENT,
        library_name VARCHAR2(50) NOT NULL,
        location VARCHAR2(50) NOT NULL,
        no_of_books NUMBER(10),
		created_date DATE,
        PRIMARY KEY(id)
      );        