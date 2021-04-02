package com.sprint1.movie.booking.Ticket.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.persistence.NoResultException;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sprint1.movie.booking.Ticket.booking.entities.Admin;
import com.sprint1.movie.booking.Ticket.booking.service.AdminService;


@SpringBootTest
public class AdminServiceTest {

	Logger log = org.slf4j.LoggerFactory.getLogger(AdminServiceTest.class);

	@Autowired
	AdminService adminService;

	//	@Test
	void testaddAdmin() {

		try {
			Admin admin = new Admin(1,"Chand","9899998805");
			adminService.addAdmin(admin);

		}
		catch(NoResultException e) {
			log.info(e.getMessage());
		}
	}

	//	@Test
	void testViewAdmin() {
		try {
			int id=2;
			log.info(adminService.viewAdminById(id)+"");
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}
	}	


	//	@Test
	void testViewAllAdmins() {
		List<Admin> admins = adminService.viewAllAdmin();
		System.out.println(admins);
		assertEquals(1, admins.size());	
	}

	//	@Test
	void testRemoveAdmin() {
		try{
			int id=5;
			adminService.deleteAdmin(id);
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}
	}

	//	@Test
	void testUpdateAdmin() {
		try {
			int id=1;
			Admin admin = new Admin(id,"Cass",null);
			adminService.updateAdmin(admin);	
		}
		catch(Exception e) {
			log.info(e.getMessage());
		}
	}
}