package com.example.demo.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class BookUpdateDto {
	@NotBlank(message = "Book name is required")
	private String name;
	private String author;
	@Min(value = 1, message = "Price should be a positive number")
	private Double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
