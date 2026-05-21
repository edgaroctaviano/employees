package com.raven.employees.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.raven.employees.models.Employee;
import com.raven.employees.service.IEmployeesService;

@ExtendWith(MockitoExtension.class)
public class EmployeesControllerTest {

	@InjectMocks
	private EmployeesController controller;
	@Mock
	private IEmployeesService service;

	@Test
	void postEmployeesTest() {

		Employee body = new Employee(1L, "Edgar", null, "Octaviano", "Gonzalez", "27", "M", "26-03-1999", "Tech Lead",
				"20-05-2026", "activo");
		when(service.setEmployee(body)).thenReturn(body);
		controller.postEmployees(body);
	}

	@Test
	void getEmployeesTest() {

		Employee body = new Employee(1L, "Edgar", null, "Octaviano", "Gonzalez", "27", "M", "26-03-1999", "Tech Lead",
				"20-05-2026", "activo");
		List<Employee> list = new ArrayList<>();
		list.add(body);
		when(service.getEmployees()).thenReturn(list);
		controller.getEmployees();
	}

	@Test
	void getEmployeeTest() {

		Employee body = new Employee(1L, "Edgar", null, "Octaviano", "Gonzalez", "27", "M", "26-03-1999", "Tech Lead",
				"20-05-2026", "activo");
		when(service.getEmployee("1")).thenReturn(Optional.of(body));
		controller.getEmployee("1");
	}
	
	@Test
	void putEmployeeTest() {

		Employee body = new Employee(1L, "Edgar", null, "Octaviano", "Gonzalez", "27", "M", "26-03-1999", "Tech Lead",
				"20-05-2026", "activo");
		when(service.updateEmployee("1", body)).thenReturn(body);
		controller.putEmployees("1", body);
	}

	@Test
	void putEmployeesTest() {

		controller.deleteEmployees("1");
	}

}
