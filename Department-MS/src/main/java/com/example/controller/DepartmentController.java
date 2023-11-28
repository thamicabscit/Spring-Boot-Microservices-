package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.DepartmentDto;

import com.example.entity.Department;
import com.example.repo.DepartmentRepo;
import com.example.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/dept")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepo repo;
	
	@Autowired
	private DepartmentService service;
	
	@PostMapping("/add")
	public ResponseEntity<DepartmentDto> create(@RequestBody DepartmentDto deptdto)
	{
		DepartmentDto saved=service.create(deptdto);
		return new ResponseEntity<>(saved,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getbycode/{code}")
	public ResponseEntity<DepartmentDto> getbycode(@PathVariable String code)
	{
		DepartmentDto saved=service.getBycode(code);
		return new ResponseEntity<>(saved,HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public List<Department> get()
	{
		return this.repo.findAll();
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<DepartmentDto> update( @PathVariable Long id, @Valid @RequestBody DepartmentDto deptdto)
	{
		deptdto.setId(id);
		DepartmentDto saveduser=service.update(deptdto);
		return  new ResponseEntity<>(saveduser,HttpStatus.OK);
	}

	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id)
	{
		service.delete(id);
		return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
		
	}
	

}
