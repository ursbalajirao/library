package com.library.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.library.model.Library;
import com.library.repo.LibraryRepository;
import com.library.service.LibraryService;

@ExtendWith(MockitoExtension.class)
public class LibraryTestService {

	@InjectMocks
	LibraryService libraryService;

	@Mock
	LibraryRepository libraryRepository;
	
	@Test
	public void getAllLibraries() {
		List<Library> response=new ArrayList<Library>();
		when(libraryRepository.findAll()).thenReturn(response);
		assertEquals(response, libraryService.getAllLibraries());
	}
	
	@Test
	public void saveLibraryTest() {
		Library obj=new Library();
		when(libraryRepository.save(obj)).thenReturn(obj);
		libraryService.saveLibrary(obj);
	}
	
	@Test
	public void getLibraryTest() {
		Library obj=new Library();
		when(libraryRepository.findBylibrary_name("test")).thenReturn(obj);
		assertEquals(obj, libraryService.getLibrary("test"));
	}

}
