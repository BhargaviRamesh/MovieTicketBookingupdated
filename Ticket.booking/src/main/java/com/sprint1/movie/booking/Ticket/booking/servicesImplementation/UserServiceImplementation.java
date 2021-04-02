package com.sprint1.movie.booking.Ticket.booking.servicesImplementation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.movie.booking.Ticket.booking.entities.User;
import com.sprint1.movie.booking.Ticket.booking.repository.UserRepository;
import com.sprint1.movie.booking.Ticket.booking.service.UserService;


@Service
public class UserServiceImplementation implements UserService {
      @Autowired
      UserRepository usr;
      
      @Autowired
      AdminServiceImplementation asi;
	
      Optional<User> users = null;

	//implementations
   public void addUser(User user) {
	   users = usr.findById(user.getUserId());
	    if(users.isEmpty()) {
		usr.save(user);
	  }
	}

	public void deleteUser(int id) {
		Optional<User> user = usr.findById(id);
		User a = null;
		if(user.isPresent()) {
			a = user.get();
			usr.delete(a);
		}
	
	}

	@Override
	public Optional<User> findById(int id) {
		return usr.findById(id);
	}
}	