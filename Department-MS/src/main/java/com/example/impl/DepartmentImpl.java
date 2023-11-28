package com.example.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.DepartmentDto;
import com.example.entity.Department;
import com.example.mapper.ModelMapperClass;
import com.example.repo.DepartmentRepo;
import com.example.service.DepartmentService;

@Service
public class DepartmentImpl implements DepartmentService {

	@Autowired
	private DepartmentRepo repo;
	

	
	@Override
	public DepartmentDto create(DepartmentDto departmentdto)
	{
		Department dept=ModelMapperClass.mapTodept(departmentdto);
		Department saved = repo.save(dept);
		DepartmentDto dto=ModelMapperClass.mapToDto(saved);
		return dto;
	}

	@Override
	public DepartmentDto getBycode(String code) {
		
		
		Department saved=repo.findByCode(code);
		DepartmentDto dto=ModelMapperClass.mapToDto(saved);
		return dto;
	}

	@Override
	public DepartmentDto update( DepartmentDto deptdto) {
		Department saved=repo.findById(deptdto.getId()).get();
		saved.setId(deptdto.getId());
		saved.setDepartmentName(deptdto.getDepartmentName());
		saved.setDescription(deptdto.getDescription());
		saved.setCode(deptdto.getCode());
		//saving
		Department result=repo.save(saved);
		//converting
		return ModelMapperClass.mapToDto(result);
		
		
	}

	@Override
	public void delete(Long id) {
		Optional<Department> saved=repo.findById(id);
		repo.deleteById(id);
		
	}

	

}
