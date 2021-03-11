package com.capg.movie.capg.movie.booking.entities;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="UserTable")
public class User {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	int userId;
	String password;
	String role;
	
	@OneToOne(targetEntity = Admin.class,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="adminId")
	Admin admin;
     
	@OneToOne(targetEntity = Customer.class,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="customerId")
	Customer customer;
     
	public User() {}

	public User(String password, String role) {
		super();
		this.password = password;
		this.role = role;
		
	}
	


	public User(int userId, String password, String role, Admin admin) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
        this.admin = admin;	
	}
    
	public User(int userId, String password, String role, Customer customer) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
		this.customer = customer;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", role=" + role + ", adminId=" + admin +"]";
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		//result = prime * result + ((admin == null) ? 0 : admin.hashCode());
//		result = prime * result + ((password == null) ? 0 : password.hashCode());
//		result = prime * result + ((role == null) ? 0 : role.hashCode());
//		return result;
//	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		User other = (User) obj;
//		if (admin == null) {
//			if (other.admin != null)
//				return false;
//		} else if (!admin.equals(other.admin))
//			return false;
//		if (password == null) {
//			if (other.password != null)
//				return false;
//		} else if (!password.equals(other.password))
//			return false;
//		if (role == null) {
//			if (other.role != null)
//				return false;
//		} else if (!role.equals(other.role))
//			return false;
//		return true;
//	}

	


}
