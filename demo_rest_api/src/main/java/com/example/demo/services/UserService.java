package com.example.demo.services;

import com.example.demo.data.entities.UserEntity;

public interface UserService {
	public UserEntity changeUserName(Long id, String firstName, String lastName);
}
