package com.example.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.DepartmentDto;
import com.example.dto.EmployeeDto;
import com.example.entity.Employee;
import com.example.repo.EmployeeRepo;
import com.example.service.EmployeeService;

@Service
public class EmployeeImpl implements EmployeeService{

	@Autowired
	private ModelMapper modelmapper;
	
	@Autowired
	private EmployeeRepo repo;
	
	@Autowired
	private OpenFeignClient feign;
	
	
	@Override
	public EmployeeDto create(EmployeeDto empdto) {
		//converting  jpa entity into dto
		Employee emp=modelmapper.map(empdto,Employee.class);
		//storing
		Employee saved=repo.save(emp);
		//converting
		EmployeeDto result=modelmapper.map(saved,EmployeeDto.class);
		return result;
	}


	@Override
	public ApiResponseDto getbyid(Long id) {
		
		
		
		
		
		//saving results
		Employee saved=repo.findById(id).get();
		
		//getting from department service using feign client
		DepartmentDto dept=feign.getbycode(saved.getCode());
		
		//converting
		EmployeeDto result =modelmapper.map(saved, EmployeeDto.class);
		
		//api response after feign communication
		ApiResponseDto apiresdto=new ApiResponseDto();
	
		apiresdto.setEmp(result);
		apiresdto.setDept(dept);
		
		return apiresdto;
	}




}
