package com.nashtech.rookies.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nashtech.rookies.model.Author;
import com.nashtech.rookies.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

	
	List<Book> findByName(String name);
	List<Book> findAllByNameAndAuthor(String name, Author author);
	List<Book> findByNameStartingWith(String a);
	
	
//	List<Book> findByNameIgoreCase(String name);
	
//	 List<Book> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);
//
//	  // Enables the distinct flag for the query
	
//	  List<Book> findDistinctPeopleByLastnameOrFirstname(String lastname, String firstname);
//	  List<Book> findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);
//
//	  // Enabling ignoring case for an individual property
	
//	  List<Book> findByLastnameIgnoreCase(String lastname);
//	  // Enabling ignoring case for all suitable properties
//	  List<Book> findByLastnameAndFirstnameAllIgnoreCase(String lastname, String firstname);
//
//	  // Enabling static ORDER BY for a query
	
	  List<Book> findByNameOrderByIdAsc(String lastname);
//	  List<Book> findByLastnameOrderByFirstnameDesc(String lastname);
	
	 // Create query jp
	
	 @Query("select u from Book u where u.name = ?1")
	 Optional<Book> findByNameQuery(String name);
	
	// NamedQuery JPA
	
	 List<Book> findByNameA(String name);
//	 List<Book> findAllQ();
}
