package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dto.DepartmentDto;


public interface DepartmentService {
	
	DepartmentDto create(DepartmentDto departmentdto);
	DepartmentDto getBycode(String code);
	DepartmentDto update(DepartmentDto deptdto);
	void delete(Long id);
	

}
