package com.capg.movie.capg.movie.booking.controllers;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capg.movie.capg.movie.booking.entities.User;
import com.capg.movie.capg.movie.booking.exceptions.UserNotExistsException;
import com.capg.movie.capg.movie.booking.repository.UserRepository;
import com.capg.movie.capg.movie.booking.service.UserService;
@RestController
@RequestMapping("/user")

public class UserController {


	
		@Autowired
		UserRepository userRepository;
		
		@Autowired
		UserService us;
		
		//adding a new user
		@PostMapping("/adduser")
		@ResponseStatus(code = HttpStatus.CREATED)
		public ResponseEntity<User> addUser(@RequestBody User u) {
			ResponseEntity<User>re;
			Optional<User> user=userRepository.findById(u.getUserId());
			if(user.isEmpty()) {
				us.addUser(u);
			}	
				re=new ResponseEntity<>(u, HttpStatus.CREATED);
			
//			else {
//				throw new UserAlreadyExistsException("user with id:"+a.getUserId()+" already exists");
//			}
		 return re;
			
		}
		

    //Viewing all the users		
//		@GetMapping("/")
//		public ResponseEntity<List<User>> findAllUsers(){
//			ResponseEntity<List<User>>re;
//			List<User>users=us.viewAllUser();
//			if(users.isEmpty()) {
//				throw new UserNotExistsException("User does not exists in DB currently");
//			}
//			else {
//				re=new ResponseEntity<>(users, HttpStatus.CREATED);
//			}
//			return re;
//		}
	
//		//Update user 
//		
//		@PutMapping("/")
//		public ResponseEntity<Void> updateAdmin(@RequestBody Admin a) {
//			ResponseEntity<Void>re;
//			Optional<Admin> admin=adminRepository.findById(a.getadminId());
//			if(admin.isPresent()) {
//				ad.updateAdmin(a);
//				re=new ResponseEntity<>(HttpStatus.OK);
//			}
//			else {
//				throw new AdminNotExistsException("Admin with id:"+a.getadminId()+" not exists in DB");
//			}
//			return re;
//		}
//		
		//View user by id
//		@GetMapping("/{id}")
//		@ResponseStatus(value = HttpStatus.OK)
//		public ResponseEntity<User> viewUserById(@PathVariable("id") int id) {
//			ResponseEntity<User>re;
//			Optional<User> user= userRepository.findById(id);
//			if(user.isPresent()) {
//				User findUser=us.viewUserById(id);
//				re=new ResponseEntity<>(findUser,HttpStatus.OK);
//			}
//			else {
//				throw new UserNotExistsException("User with id:"+id+" does not exists");
//			}
//			return re;
//		}
		
		
		
		
		
		
		//Deleting a User by id
		@DeleteMapping("/deleteuser/{id}")
		public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
			ResponseEntity<Void>re;
			Optional<User> user= userRepository.findById(id);
			if(user.isPresent()) {
			 us.deleteUser(id);;
				re=new ResponseEntity<>(HttpStatus.OK);
			}
			else {
				throw new UserNotExistsException("User with id:"+id+" does not exists");
			}
			 return re;
		}



}
