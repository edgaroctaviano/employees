package com.raven.employees.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raven.employees.models.Employee;
import com.raven.employees.models.GenericResponse;
import com.raven.employees.service.IEmployeesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/raven/rh")
@CrossOrigin(origins = "*")
public class EmployeesController {

	@Autowired
	private IEmployeesService service;

	public EmployeesController(IEmployeesService service) {
		this.service = service;
	}

	@PostMapping("/employees")
	public ResponseEntity<GenericResponse> postEmployees(@Valid @RequestBody Employee body) {

		return ResponseEntity.status(201).body(new GenericResponse(service.setEmployee(body)));
	}

	@GetMapping("/employees")
	public GenericResponse getEmployees() {

		return new GenericResponse(service.getEmployees());
	}

	@GetMapping("/employees/{id}")
	public GenericResponse getEmployee(@Valid @PathVariable String id) {

		return new GenericResponse(service.getEmployee(id));
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<GenericResponse> putEmployees(@PathVariable String id, @Valid @RequestBody Employee body) {

		return ResponseEntity.status(200).body(new GenericResponse(service.updateEmployee(id, body)));
	}

	@DeleteMapping("/employees/{id}")
	public GenericResponse deleteEmployees(@PathVariable String id) {
		service.deleteEmployee(id);
		ResponseEntity.status(200);
		return new GenericResponse();
	}

}
