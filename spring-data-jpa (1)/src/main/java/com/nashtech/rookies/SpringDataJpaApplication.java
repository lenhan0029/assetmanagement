/**
 * https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference
 */

package com.nashtech.rookies;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nashtech.rookies.model.Author;
import com.nashtech.rookies.model.Book;
import com.nashtech.rookies.model.Song;
import com.nashtech.rookies.model.SongId;
import com.nashtech.rookies.repository.AuthorRepository;
import com.nashtech.rookies.repository.BookRepository;
import com.nashtech.rookies.repository.SongsRepository;


@SpringBootApplication
public class SpringDataJpaApplication{
	
	// Get datasource to get connection
	@Resource 
	DataSource dataSource;
	
	@Bean
	JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}
	
	
	
	private static final Logger log = LoggerFactory.getLogger(SpringDataJpaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(
			JdbcTemplate jdbcTemplate,
			AuthorRepository authorRepository, BookRepository bookRepository, 
			SongsRepository songsRepository) {
		return (args) -> {
			System.out.println(this.dataSource);
			// Create an author and add 3 books to his list of books
	        Author author = new Author("Author 1");
	        author.addBook(new Book("Book 1"));
	        author.addBook(new Book("Book 2"));
	        author.addBook(new Book("Book 3"));
	        Author savedAuthor = authorRepository.save(author);
	        System.out.println("Saved author: " + savedAuthor);

	        // Find all authors
	        List<Author> authors = authorRepository.findAll();
	        System.out.println("Authors:");
	        authors.forEach(System.out::println);

	        // Find author by name
	        List<Author> listAuthorByName = authorRepository.findByName("Author 1");
	        System.out.println("Searching for an author by name: ");
	        if(listAuthorByName.size() > 0) {
	        	listAuthorByName.forEach(System.out::println);
	        }
	        // Search for a book by ID
	        Optional<Book> foundBook = bookRepository.findById(2);
	        foundBook.ifPresent(System.out::println);

	        // Search for a book with an invalid ID
	        Optional<Book> notFoundBook = bookRepository.findById(99);
	        notFoundBook.ifPresent(System.out::println);

	        // List all books
	        List<Book> books = bookRepository.findAll();
	        System.out.println("Books in database:");
	        books.forEach(System.out::println);

	        // Find a book by name
	        List<Book> listBook1 = bookRepository.findByName("Book 2");
	        System.out.println("Query for book 2:");
	        if(listBook1.size() > 0) {
	        	listBook1.forEach(System.out::println);
	        }
	        
	        // Find a book by name using a named query
	        List<Book> listBook3 = bookRepository.findByName("Book 3");
	        System.out.println("Query for book 3:");
	        if(listBook3.size() > 0) {
	        	listBook3.forEach(System.out::println);
	        }
	        
//	        authorService.addBookToAuthor(1, new Book("Book 4"));
	        
	        Optional<Author> author1 = authorRepository.findById(1);
	        author1.ifPresent(a -> {
	            a.addBook(new Book("Book 4"));
	            System.out.println("Saved author: " + authorRepository.save(a));
	        });
			
	        
	        // Song example
	        SongId songId = new SongId("test_name", "test_album", "test_artist");
	        Song song = new Song(songId, 23, null, null, 4, "http://download.this.song");

	        songsRepository.save(song);
	        
	        Optional<Song> findById = songsRepository.findById(songId);
	        findById.ifPresent(System.out::println);
	        
	        // Test native SQl
	        String sql = "SELECT * FROM Book";
	        var rowMapper = BeanPropertyRowMapper.newInstance(Book.class);
	        books = jdbcTemplate.query(sql, rowMapper);
	        books.forEach(System.out::println);
	        
	        
		};
	}
	

}
