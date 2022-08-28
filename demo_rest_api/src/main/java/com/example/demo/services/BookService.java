package com.example.demo.services;

import java.util.List;

import com.example.demo.data.entities.Book;
import com.example.demo.dto.request.BookUpdateDto;
import com.example.demo.dto.response.BookResponseDto;

public interface BookService {

	public List<Book> getAllBooks();

	public Book getBookById(Long id);

	public BookResponseDto getBookByIdDto(Long id);

	public BookResponseDto createBook(BookUpdateDto dto);

	public BookResponseDto updateBook(Long id, BookUpdateDto dto);
}
