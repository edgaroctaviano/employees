package com.raven.employees.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.raven.employees.enums.EnumHttpMessages;
import com.raven.employees.exception.GenericException;
import com.raven.employees.models.Employee;
import com.raven.employees.repository.IEmployeeRepository1;
import com.raven.employees.repository.IEmployeesRepository;
import com.raven.employees.service.impl.EmployeesServiceImpl;
import com.raven.employees.util.Validations;

@ExtendWith(MockitoExtension.class)
public class EmployeesServiceImplTest {

	@InjectMocks
	EmployeesServiceImpl service;

	@Mock
	public IEmployeesRepository repository;
	@Mock
	public IEmployeeRepository1 repo;
	@Mock
	public Validations vali;

	@Test
	void getEmployeesTest() {

		Employee body = new Employee(1L, "Edgar", null, "Octaviano", "Gonzalez", "27", "M", "26-03-1999", "Tech Lead",
				"20-05-2026", "activo");
		List<Employee> list = new ArrayList<>();
		list.add(body);
		when(repository.findAll()).thenReturn(list);
		service.getEmployees();
	}
	
	@Test
	void getEmployeesTestExc() {
		List<Employee> list = new ArrayList<>();
		when(repository.findAll()).thenReturn(list);
		assertThrows(GenericException.class, () ->  service.getEmployees());
	}

	@Test
	void getEmployeeTest() {
		when(vali.searchType("1")).thenReturn(true);
		Employee body = new Employee(1L, "Edgar", null, "Octaviano", "Gonzalez", "27", "M", "26-03-1999", "Tech Lead",
				"20-05-2026", "activo");
		when(repository.findById(1L)).thenReturn(Optional.of(body));
		service.getEmployee("1");
	}
	
	@Test
	void getEmployeeTestExc() {
		when(vali.searchType("1")).thenReturn(true);
		Employee body = new Employee();
		when(repository.findById(1L)).thenReturn(Optional.of(body).empty());
		assertThrows(GenericException.class, () ->  service.getEmployee("1"));
	}

	@Test
	void getEmployeeTestName() {
		when(vali.searchType("Edgar")).thenReturn(false);
		Employee body = new Employee(1L, "Edgar", null, "Octaviano", "Gonzalez", "27", "M", "26-03-1999", "Tech Lead",
				"20-05-2026", "activo");
		when(repo.findBySegundoApellido("Edgar")).thenReturn(Optional.of(body));
		service.getEmployee("Edgar");
	}
	
	@Test
	void setEmployeeTest() {
		Employee body = new Employee(1L, "Edgar", null, "Octaviano", "Gonzalez", "27", "M", "26-03-1999", "Tech Lead",
				"20-05-2026", "activo");
		Employee body1 = new Employee();
		when(repository.findById(1L)).thenReturn(Optional.of(body1).empty());
		when(repository.save(body)).thenReturn(body);
		service.setEmployee(body);
	}
	
	@Test
	void setEmployeeTestExc() {
		Employee body = new Employee(1L, "Edgar", null, "Octaviano", "Gonzalez", "27", "M", "26-03-1999", "Tech Lead",
				"20-05-2026", "activo");
		Employee body1 = new Employee();
		when(repository.findById(1L)).thenReturn(Optional.of(body1));
		assertThrows(GenericException.class, () ->  service.setEmployee(body));
	}
	
	@Test
	void updateEmployeeTest() {
		Employee body = new Employee(1L, "Edgar", null, "Octaviano", "Gonzalez", "27", "M", "26-03-1999", "Tech Lead",
				"20-05-2026", "activo");
		Employee body1 = new Employee();
		when(repository.save(body)).thenReturn(body);
		service.updateEmployee("1",body);
	}
	
	@Test
	void deleteEmployeeTest() {
		Employee body = new Employee(1L, "Edgar", null, "Octaviano", "Gonzalez", "27", "M", "26-03-1999", "Tech Lead",
				"20-05-2026", "activo");
		service.deleteEmployee("1");
	}

}
