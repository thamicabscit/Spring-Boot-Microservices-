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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.repo.Repo;
import com.example.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<UserDto> get(@PathVariable int id)
	
	{
		UserDto saveduser=service.getbyid(id);
		return new ResponseEntity<>(saveduser,HttpStatus.OK);
		
	}

	@PostMapping("/create")
	public ResponseEntity<UserDto> add(@Valid @RequestBody UserDto userdto)
	{
		UserDto saveduser=service.create(userdto);
		return new ResponseEntity<>(saveduser,HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<UserDto>> getAll()
	{
		List<UserDto> saveduser=service.get();
		return new ResponseEntity<>(saveduser,HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<UserDto> update( @PathVariable int id, @Valid @RequestBody UserDto userdto)
	{
		userdto.setId(id);
		UserDto saveduser=service.update(userdto);
		return  new ResponseEntity<>(saveduser,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable int id)
	{
		service.delete(id);
		return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
		
	}
	
	
	
	}
	
	
	
	
	
	

