package com.example.service;

import com.example.dto.EmployeeDto;
import com.example.impl.ApiResponseDto;

public interface EmployeeService {
	
	EmployeeDto create(EmployeeDto empdto);
	
	ApiResponseDto getbyid(Long id);
	
	

}
