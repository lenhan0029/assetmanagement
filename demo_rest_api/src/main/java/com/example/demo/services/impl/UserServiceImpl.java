package com.example.demo.services.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.entities.UserEntity;
import com.example.demo.data.repositories.UserRepository;
import com.example.demo.dto.AuditLogDto;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.exceptions.ValidationException;
import com.example.demo.services.AuditService;
import com.example.demo.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private AuditService auditService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AuditService auditService) {
        super();
        this.userRepository = userRepository;
        this.auditService = auditService;
    }

    @Override
    public UserEntity changeUserName(Long id, String firstName, String lastName) {
        if (null == firstName || "".equals(firstName) || null == lastName || "".equals(lastName)) {
            throw new ValidationException("Name is required");
        }

        Optional<UserEntity> userOptional = userRepository.findById(id);
        if (userOptional.isEmpty()) {
            throw new UserNotFoundException("User Not Found");
        }

        UserEntity user = userOptional.get();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setFullName(String.join(" ", firstName, lastName));
        try {
            user = userRepository.save(user);
        } catch (RuntimeException ex) {
            AuditLogDto dto = AuditLogDto.builder().message(ex.getMessage()).datetime(LocalDateTime.now()).build();
            auditService.writeAuditLog(dto);
        }
        return user;
    }

}
