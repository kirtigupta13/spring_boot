package io.egens.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)// because we have to provide code to print it on frontend
public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
String message;

public NotFoundException(String messag) {
	
	this.message = messag;
};

}
