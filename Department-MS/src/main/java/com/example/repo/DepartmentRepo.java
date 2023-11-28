package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dto.DepartmentDto;
import com.example.entity.Department;


public interface DepartmentRepo extends JpaRepository<Department,Long>{

	
	Department findByCode(String code);	
}
