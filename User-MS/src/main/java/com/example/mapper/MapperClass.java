package com.example.mapper;

import com.example.dto.UserDto;
import com.example.entity.User;

public class MapperClass {

	//converting user jpa entity into dto
	public static UserDto mapToDto(User user)
	{
		UserDto dto=new UserDto(
				user.getId(),
				user.getName(),
				user.getEmail()
				);
		return dto;
	}
	
 
	//converting user dto into jpa entity
	public static User mapTouser(UserDto userdto)
	{
		User user=new User(
				userdto.getId(),
				userdto.getName(),
				userdto.getEmail()
				);
		return user;
	}
	
}
