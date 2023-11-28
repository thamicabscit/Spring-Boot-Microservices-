package com.example.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

@Repository
public interface Repo extends JpaRepository<User,Integer>{

	//for email already exist exception 
	Optional<User> findByemail(String email);
}
