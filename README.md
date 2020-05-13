# library
# Getting Started

### Reference Documentation
# To build application RUN 
mvn clean package
and RUN
java -jar BUILD_FILE/library.jar

API's

# To get list of libraries
Method Type : GET
https://localhost:8080/api/library

# To Books by library name 
Method Type : GET
https://localhost:8080/api/books-by-library

# To Save Book details
https://localhost:8080/api/book 
Method Type : POST
Payload: {
       "title": "PRINCE OF PERCIA2",
       "language": "ENGLISH",
       "type": "GAME",
       "author": "balajirao",
       "libraryName": "BLR",
       "createdDate": "2020-05-11",
       "bookDescription": "this is gaming book"
 } 
 
Response:
Status Code:  200
{
       "title": "PRINCE OF PERCIA2",
       "language": "ENGLISH",
       "type": "GAME",
       "author": "balajirao",
       "libraryName": "BLR",
       "createdDate": "2020-05-11",
       "bookDescription": "this is gaming book"
 }

 # To Delete Book details
 Method Type:DELETE
 https://localhost:8080/api/book?id=1
 Response: "Book deleted successfully"
 Status Code:  200
 
