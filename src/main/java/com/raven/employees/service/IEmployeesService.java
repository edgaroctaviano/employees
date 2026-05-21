package com.raven.employees.service;

import java.util.List;
import java.util.Optional;

import com.raven.employees.models.Employee;

public interface IEmployeesService {

	public List<Employee> getEmployees();

	public Optional<Employee> getEmployee(String idEmployee);

	public Object setEmployee(Employee user);

	public Employee updateEmployee(String idEmployee, Employee body);

	public void deleteEmployee(String idEmployee);

}
