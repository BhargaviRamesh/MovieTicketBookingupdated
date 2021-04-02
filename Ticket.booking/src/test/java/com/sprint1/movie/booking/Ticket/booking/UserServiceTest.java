package com.sprint1.movie.booking.Ticket.booking;


import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint1.movie.booking.Ticket.booking.entities.User;
import com.sprint1.movie.booking.Ticket.booking.service.UserService;



@Configurable
@SpringBootTest
public class UserServiceTest {
	Logger log = org.slf4j.LoggerFactory.getLogger(UserServiceTest.class);
	@Autowired
	UserService userService;

		@Test
	void testaddUser() {

		try {
			User us = new User("a@mail.com","root","admin");
			userService.addUser(us);

		}
		catch(Exception e) {
			log.info(e.getMessage());
		}
	}
	//	@Test
	void testRemoveUser() {
		try{
			int id=5;
			userService.deleteUser(id);
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}
	}

}



