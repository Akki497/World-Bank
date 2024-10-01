package com.infymobile.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class InfyMeMobileGlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInformation> exceptionHandler(Exception ex){
		ErrorInformation err = new ErrorInformation();
		err.setErrorMessage(ex.getMessage());
		err.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		err.setErrorTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInformation>(err,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	public ResponseEntity<ErrorInformation> exceptionHandler(InfyMeMobileException ex){
		ErrorInformation err = new ErrorInformation();
		err.setErrorMessage(ex.getMessage());
		err.setErrorCode(HttpStatus.OK.value());
		err.setErrorTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInformation>(err,HttpStatus.OK);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInformation> methodArgumentNotValid(MethodArgumentNotValidException e){
		ErrorInformation err = new ErrorInformation();
		List<ObjectError> errors = e.getAllErrors();
		String message = "";
		for(ObjectError oe: errors) {
			message = message + oe.getDefaultMessage() + ",";
		}
		err.setErrorMessage(message);
		err.setErrorCode(HttpStatus.NOT_ACCEPTABLE.value());
		err.setErrorTimeStamp(LocalDateTime.now());
		return new ResponseEntity<ErrorInformation>(err,HttpStatus.NOT_ACCEPTABLE);
	}
}
