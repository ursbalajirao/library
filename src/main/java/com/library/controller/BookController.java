package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.Book;
import com.library.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService applicationService;

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public Book getBookDetails(@PathVariable Integer id){
        return  applicationService.findById(id).get();
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public Book addBook(@RequestBody Book book){
        Book response = applicationService.save(book);
        return response;
    }

    @RequestMapping(value = "/book", method = RequestMethod.PUT)
    Book updateBook(@RequestBody Book book){
        Book response = applicationService.save(book);
        return response;
    }

	@RequestMapping(value = "/book", method = RequestMethod.DELETE)
	public String deleteBook(@RequestParam Integer id) {
		String response=applicationService.deleteBook(id);
		return response;
	}

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public List<Book> addAllBooks(){
        return applicationService.getAllBooks();
    }
    
    @RequestMapping(value = "/book-by-author/{author}", method = RequestMethod.GET)
    public Book getBookDetailsByAuthor(@PathVariable String author){
        return  applicationService.getBookDetailsByAuthor(author);
    }
    
    @RequestMapping(value = "/books-by-library/{library}", method = RequestMethod.GET)
    public List<Book> getBooksByLibrary(@PathVariable String library){
        return  applicationService.getBooksByLibrary(library);
    }
}
