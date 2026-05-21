package com.raven.employees.repository;

import org.springframework.data.repository.CrudRepository;

import com.raven.employees.models.Employee;

public interface IEmployeesRepository extends CrudRepository<Employee, Long> {

}
