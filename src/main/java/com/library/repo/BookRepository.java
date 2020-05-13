package com.library.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.library.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	@Query("SELECT b FROM Book b WHERE b.author = ?1")
	public Book myQuery(String author);

	@Query("SELECT b FROM Book b WHERE b.library_name = ?1")
	public List<Book> findBooksByLibrary(String libraryName);
}
