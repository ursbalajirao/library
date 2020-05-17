package com.library.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Book;
import com.library.model.Library;
import com.library.repo.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private LibraryService libraryService;

	public List<Book> getBooksByLibrary(String libraryName) {
		return bookRepository.findBooksByLibrary(libraryName);
	}

	public Optional<Book> findById(Integer id) {
		return bookRepository.findById(id);
	}

	public Book save(Book book,String actionType) {
		book.setCreated_date(LocalDate.now());
		Book response=bookRepository.save(book);
		if (actionType.equalsIgnoreCase("CREATE")) {
			saveLibrary(book);
		}
		return response ;
	}

	public void saveLibrary(Book book) {
		Library libraryObj=libraryService.getLibrary(book.getLibrary_name());
		libraryObj.setNo_of_books(libraryObj.getNo_of_books()+1);
		libraryService.saveLibrary(libraryObj);
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
