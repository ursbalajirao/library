package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.model.Library;
import com.library.repo.LibraryRepository;

@Service
public class LibraryService {

	@Autowired
	private LibraryRepository libraryRepository;

	public List<Library> getAllLibraries() {
		return libraryRepository.findAll();
	}

	public Library getLibrary(String library_name) {
		return libraryRepository.findBylibrary_name(library_name);
	}

	public void saveLibrary(Library libraryObj) {
		libraryRepository.save(libraryObj);
	}
}
