package com.raven.employees.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raven.employees.models.GenericResponse;

@RestController
@RequestMapping("/raven/rh")
@CrossOrigin(origins = "*")
public class Status {
	
	@GetMapping("/status")
	public ResponseEntity<GenericResponse> status(){
		
		return ResponseEntity.status(HttpStatus.OK).body(new GenericResponse());
	}

}
