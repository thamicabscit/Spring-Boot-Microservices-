package com.example.impl;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.dto.DepartmentDto;

@FeignClient(url="http://localhost:8081",value="Department-service")
public interface OpenFeignClient {
	
	//open feign library will implement dynamically for this interface 
	
	@GetMapping("/api/dept/getbycode/{code}")
	DepartmentDto getbycode(@PathVariable String code);
	
	
	

}
