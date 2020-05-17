package com.library.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.library.model.Book;
import com.library.model.Library;
import com.library.repo.BookRepository;
import com.library.service.BookService;
import com.library.service.LibraryService;

@ExtendWith(MockitoExtension.class)
public class BookTestService {

	@InjectMocks
	BookService applicationService;

	@Mock
	BookRepository bookRepository;
	
	@InjectMocks
	LibraryService libraryService;
	
	@Test
	public void findByIdTest() {
		Optional<Book> response = null;
		when(bookRepository.findById(1)).thenReturn(response);
		assertEquals(response, applicationService.findById(1));
	}

	@Test
	public void saveBookTest() {
		Book bookObj = new Book();
		bookObj.setId(1);
		bookObj.setLibrary_name("HYD-BOOK-HUB");
		when(bookRepository.save(bookObj)).thenReturn(bookObj);
		assertEquals(bookObj, applicationService.save(bookObj,"CREATE"));

	}

	@Test
	public void SaveLibraryTest() {
		Book bookObj=new Book();
		bookObj.setLibrary_name("HYD-BOOK-HUB");
		Library libObj=new Library();
		libObj.setId(1);
		libObj.setLibrary_name("HYD-BOOK-HUB");
		libObj.setNo_of_books(1);
		when(libraryService.getLibrary(bookObj.getLibrary_name())).thenReturn(libObj);
		libObj.setNo_of_books(libObj.getNo_of_books()+1);
	}
	@Test
	public void deleteBookTestOne() {
		String response = "Book deleted successfully";
		Optional<Book> record=Optional.ofNullable(new Book());
		when(bookRepository.findById(1)).thenReturn(record);
		assertEquals(response,applicationService.deleteBook(1));
	}
	
	@Test
	public void deleteBookTestTwo() {
		String response = "Book not found";
		
		Optional<Book> record=Optional.ofNullable(null);
		when(bookRepository.findById(1)).thenReturn(record);
		assertEquals(response,applicationService.deleteBook(1));
	}
	
	@Test
	public void getAllBooksTest() {
		List<Book> response=new ArrayList<>();
		when(bookRepository.findAll()).thenReturn(response);
		assertEquals(response,applicationService.getAllBooks());
	}
	
	@Test
	public void getBookDetailsByAuthorTest() {
		Book response=new Book();
		when(bookRepository.myQuery("balajirao")).thenReturn(response);
	    assertEquals(response, applicationService.getBookDetailsByAuthor("balajirao"));
	}
	
	@Test
	public void getBooksByLibraryTest() {
		List<Book> response=new ArrayList<>();
		when(bookRepository.findBooksByLibrary("balajirao")).thenReturn(response);
	    assertEquals(response, applicationService.getBooksByLibrary("balajirao"));
	}
}
