package com.example.demo.controllers.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.entities.Book;
import com.example.demo.dto.request.BookUpdateDto;
import com.example.demo.dto.response.BookResponseDto;
import com.example.demo.dto.response.ErrorResponse;
import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.services.BookService;

@RestController
@RequestMapping("/books")
public class BooksController {
	private BookService bookService;

	@GetMapping
	List<Book> getBooks() {
		return this.bookService.getAllBooks();
	}

	@GetMapping("/{id}")
	Book getBookById(@PathVariable("id") Long id) {
		return this.bookService.getBookById(id);
	}

	@GetMapping("/with-dto/{id}")
	BookResponseDto getBookByIdDtoDemo(@PathVariable("id") Long id) {
		return this.bookService.getBookByIdDto(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	BookResponseDto createBook(@Valid @RequestBody BookUpdateDto dto) {
		return this.bookService.createBook(dto);
	}

	@PutMapping("/{id}")
	BookResponseDto updateBook(@PathVariable("id") Long id,@RequestBody BookUpdateDto dto) {
		return this.bookService.updateBook(id, dto);
	}

	@ExceptionHandler({ BookNotFoundException.class })
	protected ResponseEntity<ErrorResponse> handleBookNotFoundException() {
		ErrorResponse error = new ErrorResponse("404", "Book Not Found");
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.NOT_FOUND);
	}

	@Autowired
	public BooksController(BookService bookService) {
		this.bookService = bookService;
	}
}
