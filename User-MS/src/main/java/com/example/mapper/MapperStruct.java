package com.example.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.dto.UserDto;
import com.example.entity.User;

@Mapper     //The @Mapper annotation marks the interface as a mapping interface and lets the MapStruct processor kick in during compilation.
public interface MapperStruct {
	
	//convert jpa entity into dto
	UserDto  mapToUserDto(User user);
	
	//convert dto into jpa entity
	User mapToUser(UserDto userDto);
	
	
	
	//this mapstruct library will automatically implement this interface methods during compilation	time 
	//in order to use the instance for this interface , create mapper it is default , it is used to implement automatically

	MapperStruct MAPPER = Mappers.getMapper(MapperStruct.class);
}
