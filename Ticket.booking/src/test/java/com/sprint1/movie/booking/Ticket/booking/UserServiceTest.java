package com.sprint1.movie.booking.Ticket.booking;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint1.movie.booking.Ticket.booking.entities.User;
import com.sprint1.movie.booking.Ticket.booking.service.UserService;



@Configurable
@SpringBootTest
public class UserServiceTest {
	@Autowired
	UserService userService;
	
//	@Test
	void testaddUser() {
		
		try {
			User us = new User("root","admin");
			userService.addUser(us);

		}
		catch(NoResultException e) {
			e.printStackTrace();
		}
	}
	
}



