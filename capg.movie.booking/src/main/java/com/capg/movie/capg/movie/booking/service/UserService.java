package com.capg.movie.capg.movie.booking.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import com.capg.movie.capg.movie.booking.entities.User;
@Component
public interface UserService {
	
	

		
		@Transactional
		public void addUser(User user);
		public void deleteUser(int id);
//		public List<User> viewAllUser();
//		public User viewUserById(int id);
//		public User updateUser(User u);
	

}
