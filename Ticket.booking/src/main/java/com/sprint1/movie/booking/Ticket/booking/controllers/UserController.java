package com.sprint1.movie.booking.Ticket.booking.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sprint1.movie.booking.Ticket.booking.entities.User;
import com.sprint1.movie.booking.Ticket.booking.exceptions.UserNotExistsException;
import com.sprint1.movie.booking.Ticket.booking.repository.UserRepository;
import com.sprint1.movie.booking.Ticket.booking.service.UserService;


@RestController
@RequestMapping("/user")

public class UserController {
		
		@Autowired
		UserService us;
		
		//adding a new user
		@PostMapping("/adduser")
		@ResponseStatus(code = HttpStatus.CREATED)
		public ResponseEntity<User> addUser(@RequestBody User u) {
			ResponseEntity<User>re;

				us.addUser(u);
				re=new ResponseEntity<>(u, HttpStatus.CREATED);
		 return re;
			
		}
		
		//Deleting a User by id
		@DeleteMapping("/deleteuser/{id}")
		public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
			ResponseEntity<Void>re;
			Optional<User> user= us.findById(id);
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
