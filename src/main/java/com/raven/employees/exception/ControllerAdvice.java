package com.raven.employees.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.raven.employees.enums.EnumHttpMessages;
import com.raven.employees.models.GenericResponse;

@RestControllerAdvice
public class ControllerAdvice {
	
	GenericException genericExc;
	
	@ExceptionHandler(value = GenericException.class)
	public ResponseEntity<GenericResponse> exceptHandler (GenericException ex ){
		
		GenericResponse genericResponse = new GenericResponse(List.of(ex.getMessage()), ex.getEnumHttpMensajes());
		
		return new ResponseEntity<>(genericResponse, ex.getEnumHttpMensajes().getHttpStatus());
	}
	
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<GenericResponse> handleRequestRejectedException(MethodArgumentNotValidException ex) {
		
		GenericResponse genericResponse = new GenericResponse(List.of(ex.getBindingResult().getFieldError().getField() + " " + ex.getBindingResult().getFieldError().getDefaultMessage()), EnumHttpMessages.E400);
		
		return new ResponseEntity<>(genericResponse, HttpStatus.BAD_REQUEST);
	}

}
