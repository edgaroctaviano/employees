package com.raven.employees.repository;

import java.util.Optional;

import com.raven.employees.models.Employee;

public interface IEmployeeRepository1 {
	

	Optional<Employee> findBySegundoApellido(String segundoApellido);

}
