package io.egens.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestException  extends RuntimeException{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
String message;

public BadRequestException(String messag) {
	
	this.message = messag;
}; }


