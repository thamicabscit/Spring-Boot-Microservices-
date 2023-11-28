package com.example.mapper;

import com.example.dto.DepartmentDto;
import com.example.entity.Department;


public class ModelMapperClass {
	//converting user jpa entity into dto
		public static DepartmentDto mapToDto(Department dept)
		{
			DepartmentDto dto=new DepartmentDto(
					dept.getId(),
					dept.getDepartmentName(),
					dept.getDescription(),
					dept.getCode()
					
					);
			return dto;
		}
		
	 
		//converting user dto into jpa entity
		public static Department mapTodept(DepartmentDto deptdto)
		{
			Department user=new Department(
					deptdto.getId(),
					deptdto.getDepartmentName(),
					deptdto.getDescription(),
					deptdto.getCode()
					
					);
			return user;
		}

}
