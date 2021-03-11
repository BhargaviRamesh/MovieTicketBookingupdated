package com.sprint1.movie.booking.Ticket.booking.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.movie.booking.Ticket.booking.entities.User;

@Component
public interface UserService {
	
	

		
		@Transactional
		public void addUser(User user);
		public void deleteUser(int id);

	

}

