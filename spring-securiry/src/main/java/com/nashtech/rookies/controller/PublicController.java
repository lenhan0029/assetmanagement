package com.nashtech.rookies.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/public")
public class PublicController {

	@GetMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}

}