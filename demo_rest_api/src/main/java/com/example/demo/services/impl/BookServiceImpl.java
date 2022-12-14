package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.entities.Book;
import com.example.demo.data.repositories.BookRepository;
import com.example.demo.dto.request.BookUpdateDto;
import com.example.demo.dto.response.BookResponseDto;
import com.example.demo.exceptions.BookNotFoundException;
import com.example.demo.exceptions.ResourceFoundException;
import com.example.demo.services.BookService;

@Service
public class BookServiceImpl implements BookService {

	private BookRepository bookRepository;
	private ModelMapper modelMapper;

	@Autowired
	public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper) {
		this.bookRepository = bookRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public BookResponseDto getBookByIdDto(Long id) {
		Optional<Book> bookOptional = this.bookRepository.findById(id);

		if (bookOptional.isPresent()) {
		    Book book =  bookOptional.get();
		    BookResponseDto dto = new BookResponseDto();
			return modelMapper.map(bookOptional.get(), BookResponseDto.class);
		}

		throw new BookNotFoundException();
	}

	@Override
	public List<Book> getAllBooks() {
		return this.bookRepository.findAll();
	}

	@Override
	public Book getBookById(Long id) {
		Optional<Book> bookOptional = this.bookRepository.findById(id);

		if (bookOptional.isPresent()) {
			Book book =  bookOptional.get();
			return book;
		}

		throw new BookNotFoundException();
//		throw new ResourceFoundException("Book Not Found with Controller Advice");
	}

	@Override
	public BookResponseDto createBook(BookUpdateDto dto) {
		Book book = modelMapper.map(dto, Book.class);
		Book savedBook = bookRepository.save(book);
		return modelMapper.map(savedBook, BookResponseDto.class);
	}

	@Override
	public BookResponseDto updateBook(Long id, BookUpdateDto dto) {
		Optional<Book> bookOptional = bookRepository.findById(id);
		if (bookOptional.isEmpty()) {
			throw new BookNotFoundException();
		}
		Book book = bookOptional.get();
		modelMapper.map(dto, book);
		book = bookRepository.save(book);
		return modelMapper.map(book, BookResponseDto.class);
	}
}
