package com.library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Book;
import com.library.repo.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> getBooksByLibrary(String libraryName) {
		return bookRepository.findBooksByLibrary(libraryName);
	}

	public Optional<Book> findById(Integer id) {
		return bookRepository.findById(id);
	}

	public Book save(Book book) {
		return bookRepository.save(book);
	}

	public String deleteBook(Integer id) {
		String response = "Book not found";

		Optional<Book> bookObj = bookRepository.findById(id);
		if (bookObj.isPresent()) {
			bookRepository.deleteById(id);
			response = "Book deleted successfully";
		}
		return response;
	}

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Book getBookDetailsByAuthor(String author) {
		return bookRepository.myQuery(author);
	}


}
