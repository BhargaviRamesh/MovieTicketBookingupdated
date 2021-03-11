package com.capg.movie.capg.movie.booking.servicesImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.movie.capg.movie.booking.entities.User;
import com.capg.movie.capg.movie.booking.repository.UserRepository;
import com.capg.movie.capg.movie.booking.service.UserService;

@Service
public class UserServiceImplementation implements UserService {
      @Autowired
      UserRepository usr;
      
      @Autowired
      AdminServiceImplementation asi;
	
      Optional<User> users = null;

	
   public void addUser(User user) {
	   users = usr.findById(user.getUserId());
	    if(users.isEmpty()) {
		usr.save(user);
	  }
	}
//	public List<User> viewAllUser() {
//		List<User> users = usr.findAll();
//		return users;
//	}
//
//
//	public User viewUserById(int id) {
//		Optional<User> user = usr.findById(id);
//		User a = null;
//		if(user.isPresent()) {
//			a = user.get();
//		}
//		
//		return a;
//	}
//
//	
	public void deleteUser(int id) {
		Optional<User> user = usr.findById(id);
		User a = null;
		if(user.isPresent()) {
			a = user.get();
			usr.delete(a);
		}
	
	}
//
//
//	public User updateUser(User u) {
//		Optional<User> getUser = usr.findById(u.getUserId());
//		User updateuser = null;
//		if(getUser.isPresent()) {
//			updateuser = getUser.get();
//			if(u.getPassword()!=null) {
//				updateuser.setPassword(u.getPassword());
//			}
//			
//		}
//		return updateuser;
//	}
	
}
