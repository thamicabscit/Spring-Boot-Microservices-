package com.example.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.exception.EmailAlreadyExistException;
import com.example.exception.ResourceNotFoundException;
import com.example.mapper.MapperClass;
import com.example.mapper.MapperStruct;
import com.example.repo.Repo;
import com.example.service.UserService;

@Service
public class UserImpl implements UserService {

	@Autowired
	private Repo repo;
	@Autowired
	private ModelMapper modelmapper;

	@Override
	public UserDto create(UserDto userdto)
	{
 
		Optional<User> opt=repo.findByemail(userdto.getEmail());
		if(opt.isPresent())
		{
			throw new EmailAlreadyExistException("Email already exist");
		}
		
		//converting to jpa entity
//		User  user = MapperClass.mapTouser(userdto);
		User user =modelmapper.map(userdto,User.class);
		//storing 
		User saveduser= repo.save(user);
		//again converting from jpa to dto
//		UserDto dto=MapperClass.mapToDto(saveduser);
		UserDto dto=modelmapper.map(saveduser,UserDto.class);
//		UserDto dto=MapperStruct.MAPPER.mapToUserDto(saveduser);
		return dto;
		
		
		
	}

	@Override
	public UserDto getbyid(int id) {

		// optional = if a value is present it will return or shows nosuchelement
		// exceptions
		User opt = repo.findById(id).orElseThrow(
				()->new ResourceNotFoundException("User","id" , id) //resourcename,fieldname,fieldvalue
				);
		

//		return MapperClass.mapToDto(opt);
       	return modelmapper.map(opt, UserDto.class);
//		return MapperStruct.MAPPER.mapToUserDto(opt);
	}

	@Override
	public List<UserDto> get() {

		
		//get all users by findall and storing it to variable 
		List<User> savedusers=repo.findAll();
		//returning jpa entity into dto 
//		return savedusers.stream().map(MapperClass::mapToDto).collect(Collectors.toList());
		return savedusers.stream().map((user)->modelmapper.map(user, UserDto.class)).collect(Collectors.toList());
//		return savedusers.stream().map((user)->MapperStruct.MAPPER.mapToUserDto(user)).collect(Collectors.toList());
	}

	@Override
	public UserDto update(UserDto userdto) {
		//finding by id
		User exist = repo.findById(userdto.getId()).orElseThrow(
				()-> new ResourceNotFoundException("User","id" , userdto.getId()));
				
			
		//set data 
		exist.setId(userdto.getId());
		exist.setName(userdto.getName());
		exist.setEmail(userdto.getEmail());
		//save those changes
		User saveduser=repo.save(exist);
//		return MapperClass.mapToDto(saveduser);
		return modelmapper.map(saveduser, UserDto.class);
//		return MapperStruct.MAPPER.mapToUserDto(saveduser);
	}

	@Override
	public void delete(int id) {
		User exist = repo.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("User","id" , id));
		repo.deleteById(id);
		
	}

	

}
