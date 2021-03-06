package com.sprint1.movie.booking.Ticket.booking.servicesImplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprint1.movie.booking.Ticket.booking.entities.Admin;
import com.sprint1.movie.booking.Ticket.booking.entities.User;
import com.sprint1.movie.booking.Ticket.booking.exceptions.AdminNotExistsException;
import com.sprint1.movie.booking.Ticket.booking.repository.AdminRepository;
import com.sprint1.movie.booking.Ticket.booking.service.AdminService;

@Service
public class AdminServiceImplementation implements AdminService {
	@Autowired
	AdminRepository iar;

	//Adding a Admin
	public void addAdmin(Admin a)   {

		User user = new User("EmailId","Password","Admin");
		a.setUser(user);
		iar.save(a);

	}
	//finding an admin
	public Optional<Admin> findByAdminId(int id) {
		Optional<Admin> admin = iar.findById(id);
		return admin;
	}


	//Viewing all admins
	public List<Admin> viewAllAdmin() {
		return iar.findAll();
	}

	//Viewing customer by id
	public Admin viewAdminById(int id) {

		Optional<Admin> admin = iar.findById(id);
		Admin a = null;
		if(admin.isPresent()) {
			a = admin.get();
		}
		else {
			throw new AdminNotExistsException("Admin not exists with id"+id);
		}

		return a;
	}

	//Deleting a customer
	public void deleteAdmin(int id){
		Optional<Admin> admin = iar.findById(id);
		Admin a = null;
		if(admin.isPresent()) {
			a = admin.get();
			iar.delete(a);
		}
		else {
			throw new AdminNotExistsException("Admin not exists with id"+id);
		}
	}

	//Update
	@Transactional
	public Admin updateAdmin(Admin admin) {
		Optional<Admin> getAdmin = iar.findById(admin.getadminId());
		Admin updateadmin = null;
		if(getAdmin.isPresent()) {
			updateadmin = getAdmin.get();
			if(admin.getadminName()!=null) {
				updateadmin.setadminName(admin.getadminName());
			  if(admin.getadminContact()!=null) {
				updateadmin.setadminContact(admin.getadminContact());
			  }
			}

		}
		else {
			throw new AdminNotExistsException("Admin not exists with id"+admin.getadminId());
		}
		return updateadmin;
	}

	public Admin ByAdminNameAndAdminContact(String adminName,String contact) {
		return iar.findByAdminNameAndAdminContact(adminName, contact);
	}


}
