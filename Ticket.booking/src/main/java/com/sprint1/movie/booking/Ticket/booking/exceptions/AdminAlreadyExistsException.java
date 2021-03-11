package com.sprint1.movie.booking.Ticket.booking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class AdminAlreadyExistsException extends RuntimeException {

public AdminAlreadyExistsException() {
		
	}
	
	public AdminAlreadyExistsException(String message) {
		super(message);
	}

}