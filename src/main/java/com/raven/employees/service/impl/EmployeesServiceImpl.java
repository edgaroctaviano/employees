package com.raven.employees.service.impl;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;

import com.raven.employees.enums.EnumHttpMessages;
import com.raven.employees.exception.GenericException;
import com.raven.employees.models.Employee;
import com.raven.employees.repository.IEmployeeRepository1;
import com.raven.employees.repository.IEmployeesRepository;
import com.raven.employees.service.IEmployeesService;
import com.raven.employees.util.Validations;

@Service
public class EmployeesServiceImpl implements IEmployeesService {

	@Autowired
	public IEmployeesRepository repository;
	@Autowired
	public IEmployeeRepository1 repo;

	@Autowired
	public Validations vali;

	private static final Logger logger = LoggerFactory.getLogger(EmployeesServiceImpl.class);

	public EmployeesServiceImpl(IEmployeesRepository repository, IEmployeeRepository1 repo, Validations vali) {
		this.repository = repository;
		this.repo = repo;
		this.vali = vali;
	}

	@Override
	public List<Employee> getEmployees() {
		logger.info("Obtiene empleados");
		Iterable<Employee> res = repository.findAll();
		List<Employee> list = new ArrayList<>();
		res.forEach(list::add);
		if (list.size() == 0) {
			logger.info("Lista vacia");
			throw new GenericException(List.of("No hay empleados"), EnumHttpMessages.E404);
		}

		return (List<Employee>) repository.findAll();
	}

	@Override
	public Optional<Employee> getEmployee(String idEmployee) {

		logger.info("Obtiene empleado");
		if (vali.searchType(idEmployee)) {
			logger.info("Busqueda por id");
			Optional<Employee> res = repository.findById(NumberUtils.parseNumber(idEmployee, Long.class));
			if (res.isEmpty()) {
				logger.info("No se encontró " + idEmployee);
				throw new GenericException(List.of("Empleado no existe"), EnumHttpMessages.E404);
			}
			return res;
		}
		//
		else {

			logger.info("Busqueda por nombre");
			return repo.findBySegundoApellido(idEmployee);
		}
	}

	@Override
	public Object setEmployee(Employee user) {
		logger.info("Guarda empleado");
		vali.dateFormat(user.getFechaNacimiento());
		if (!repository.findById(user.getId()).isEmpty()) {
			logger.info("Ya existe en la base");
			throw new GenericException(List.of("Empleado existente"), EnumHttpMessages.E500);
		}
		//
		else {
			logger.info("Se asigna por default activo");
			user.setEstatus("activo");
			user.setFechaAlta(Timestamp.from(Instant.now()).toString());
			return repository.save(user);
		}
	}

	@Override
	public Employee updateEmployee(String idEmployee, Employee body) {
		logger.info("Actualiza empleado");
		vali.dateFormat(body.getFechaNacimiento());
		this.getEmployee(idEmployee);
		logger.info("Elimina el regitro");
		repository.deleteById(NumberUtils.parseNumber(idEmployee, Long.class));
		logger.info("Lo vuelve a insertar");
		return repository.save(body);
	}

	@Override
	public void deleteEmployee(String idEmployee) {
		logger.info("Elimina el empleado");
		this.getEmployee(idEmployee);
		logger.info("Elimina id " + idEmployee);
		repository.deleteById(NumberUtils.parseNumber(idEmployee, Long.class));

	}

}
