package com.jpa.test.services;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.City;
import com.jpa.test.entities.User;

@Service
public class UserService {
	

	
	@Autowired
	UserRepository userRepository;
		
	
	public ArrayList<User> getAllUsers()
	{
		Iterable<User> it =userRepository.findAll();
		
		
		ArrayList<User> res = new ArrayList<User>();
		it.forEach(i->res.add(i));
		
		return res;
		
	}
	
	public User getUserById(int id)
	{
		User res = userRepository.findById(id).get();
		
		return res;
	}
	
	public User getUserByCityId(int cityId)
	{
		User res = userRepository.findByCity_cityId(cityId);
		
		return res;
	}
	
	public User getUserByCityName(String cityName)
	{
		User res = userRepository.findByCity_cityName(cityName);
		
		return res;
	}
	
	public User addUser(User user)
	{
		User res = userRepository.save(user);
		
		return res;
	}
	
	public ArrayList<User> deleteUserById(int userId)
	{
			userRepository.deleteById(userId);
			
			return this.getAllUsers();
	}
	
	
	public User updateUser(User user)
	{
		return userRepository.save(user);
	}
	
	public User patchUserName(int userId, String name)
	{	User user = userRepository.findById(userId).get();
		user.setName(name);
		
		return userRepository.save(user);
	}
	
	public User patchUserCity(int userId, City city)
	{	User user = userRepository.findById(userId).get();
		user.setCity(city);
		
		return userRepository.save(user);
	}
	
	public User patchUserStatus(int userId, String status)
	{	User user = userRepository.findById(userId).get();
		user.setStatus(status);
		
		return userRepository.save(user);
	}

}
