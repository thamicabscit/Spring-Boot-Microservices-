package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.EmployeeDto;
import com.example.impl.ApiResponseDto;
import com.example.service.EmployeeService;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/add")
	public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto empdto)
	{
		EmployeeDto saved=service.create(empdto);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<ApiResponseDto> getbyid(@PathVariable Long id)
	{
		ApiResponseDto saved=service.getbyid(id);
		return  new ResponseEntity<>(saved,HttpStatus.OK);
	}
	
	
	
	
	
	

}
