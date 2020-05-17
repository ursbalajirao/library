package com.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.Library;
import com.library.service.LibraryService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api")
public class LibraryController {
	
	@Autowired
	private LibraryService libraryService;
	
    @RequestMapping(value = "/libraries", method = RequestMethod.GET)
    public List<Library> addAllLibraries(){
        return libraryService.getAllLibraries();
    }
}
