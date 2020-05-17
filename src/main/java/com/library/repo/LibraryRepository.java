package com.library.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.library.model.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer>{

	@Query("SELECT l FROM Library l WHERE l.library_name = ?1")
	Library findBylibrary_name(String library_name);

}
