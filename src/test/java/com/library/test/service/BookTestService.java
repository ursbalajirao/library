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
import com.library.repo.BookRepository;
import com.library.service.BookService;

@ExtendWith(MockitoExtension.class)
public class BookTestService {

	@InjectMocks
	BookService applicationService;

	@Mock
	BookRepository bookRepository;
	
	
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
		bookObj.setAuthor("balajirao");
		bookObj.setBook_description("NA");
		bookObj.setLanguage("Telugu");
		bookObj.setLibrary_name("BLR-BOOK-HUB");
		bookObj.setTitle("Na chavu nenu chastha nekenduku");
		bookObj.setBook_type("LOVE");
		bookObj.setCreated_date(LocalDate.now());
		when(bookRepository.save(bookObj)).thenReturn(bookObj);
		assertEquals(bookObj, applicationService.save(bookObj));
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
