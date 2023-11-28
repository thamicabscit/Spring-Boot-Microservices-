package com.example.service;

import java.util.List;

import com.example.dto.UserDto;
import com.example.entity.User;


public interface UserService {

	
	UserDto create(UserDto userdto);
	UserDto getbyid(int id);
	//list is the return type 
	List<UserDto> get();
	UserDto update(UserDto userdto);
	void delete(int id);
}
