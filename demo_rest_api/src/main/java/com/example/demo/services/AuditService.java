package com.example.demo.services;

import com.example.demo.dto.AuditLogDto;

public interface AuditService {
	void writeAuditLog(AuditLogDto dto);
}
