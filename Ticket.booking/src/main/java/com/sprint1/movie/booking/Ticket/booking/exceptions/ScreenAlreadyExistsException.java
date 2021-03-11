package com.sprint1.movie.booking.Ticket.booking.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class ScreenAlreadyExistsException extends RuntimeException{

	public ScreenAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScreenAlreadyExistsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
}
