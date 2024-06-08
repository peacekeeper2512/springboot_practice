package com.jpa.test.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.test.entities.City;
import com.jpa.test.entities.User;
import com.jpa.test.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/users")
	public ResponseEntity<ArrayList<User>> getUsers()
	{		
		
	
		try {
			ArrayList<User> users = userService.getAllUsers();
		return users.size()<=0?ResponseEntity.status(HttpStatus.NOT_FOUND).build():ResponseEntity.of(Optional.of(users));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int id)
	{	
			
			try {
				User user = userService.getUserById(id);
				return user==null?ResponseEntity.status(HttpStatus.NOT_FOUND).build():ResponseEntity.of(Optional.of(user));
			}
			
			catch(Exception e)
			{
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			
			
	}
	
	@GetMapping("/user/cityid/{cityId}")
	public ResponseEntity<User> getUserByCityId(@PathVariable("cityId") int cityId)
	{	
		try {
			User user = userService.getUserByCityId(cityId);
			return user==null?ResponseEntity.status(HttpStatus.NOT_FOUND).build():ResponseEntity.of(Optional.of(user));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	@GetMapping("/user/cityname/{cityName}")
	public ResponseEntity<User> getUserByCityName(@PathVariable("cityName") String cityName)
	{	
		try {
			User user = userService.getUserByCityName(cityName);
			return user==null?ResponseEntity.status(HttpStatus.NOT_FOUND).build():ResponseEntity.of(Optional.of(user));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	@PostMapping("/user")
	public ResponseEntity<User> addUser(@RequestBody User user)
	{  
		try {
			User res = userService.addUser(user);
			
			return res==null?ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build():ResponseEntity.status(201).body(res);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	
	@DeleteMapping("/user/{userId}")
	public ResponseEntity<ArrayList<User>> deleteUserById(@PathVariable("userId") int userId)
	{
		try {
			ArrayList<User> res = userService.deleteUserById(userId);
			return ResponseEntity.status(204).body(res);
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
	@PutMapping("/user")
	public ResponseEntity<User> updateUser(@RequestBody User user)
	{  
		try {
		 User res = userService.updateUser(user);
		 
		 return res!=null?ResponseEntity.status(200).body(res):ResponseEntity.status(500).build();
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(500).build();
		}
	}
	
	@PatchMapping("/user/{userId}/name")
	public ResponseEntity<User> patchUserName(@PathVariable("userId") int userId ,@RequestBody String name)
	{	
		try {
			User res = userService.patchUserName(userId, name);
			return res!=null?ResponseEntity.status(200).body(res):ResponseEntity.status(500).build();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(500).build();
		}
	}
	
	@PatchMapping("/user/{userId}/city")
	public ResponseEntity<User> patchUserCity(@PathVariable("userId") int userId ,@RequestBody City city)
	{
		try {
			User res = userService.patchUserCity(userId, city);
			return res!=null?ResponseEntity.status(200).body(res):ResponseEntity.status(500).build();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(500).build();
		}
	}
	
	@PatchMapping("/user/{userId}/status")
	public ResponseEntity<User> patchUserStatus(@PathVariable("userId") int userId ,@RequestBody String status)
	{
		try {
			User res = userService.patchUserStatus(userId, status);
			return res!=null?ResponseEntity.status(200).body(res):ResponseEntity.status(500).build();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return ResponseEntity.status(500).build();
		}
	}

}
