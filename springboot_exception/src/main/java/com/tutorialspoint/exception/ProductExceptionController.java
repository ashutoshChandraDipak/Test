package com.tutorialspoint.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.tutorialspoint.exception.ProductNotfoundException;

@ControllerAdvice
public class ProductExceptionController {
	
			@ExceptionHandler(value = ProductNotfoundException.class)
		    public ResponseEntity<Object> exception(ProductNotfoundException exception) 
			 {
				//HttpStatus.BAD_REQUEST,HttpStatus.NOT_FOUND;
			      return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
			 }
			
			//@ExceptionHandler(Exception.class)
			@ExceptionHandler(value = HandleAllExceptions.class)
		    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		      
		       // ErrorResponse error = new ErrorResponse("Server Error", details);
		        return new ResponseEntity("Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
		    }
}
