package com.raven.employees.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.util.NumberUtils;

import com.raven.employees.enums.EnumHttpMessages;
import com.raven.employees.exception.GenericException;
import com.raven.employees.models.Employee;
import com.raven.employees.repository.IEmployeeRepository1;

@Repository
public class EmployeesRepositoryImpl implements IEmployeeRepository1 {

	String jdbcUrl = "jdbc:h2:mem:testdb"; // Cambia a tu ruta o :mem: si es en memoria
	String usuario = "sa";
	String contrasena = "password";

	@Override
	public Optional<Employee> findBySegundoApellido(String nombre) {
		try {
			Employee res = null;
			Connection conexion = DriverManager.getConnection(jdbcUrl, usuario, contrasena);
			Statement stmt = conexion.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Employee where PRIMER_NOMBRE = '" + nombre + "'");
			while (rs.next()) {

				res = new Employee(NumberUtils.parseNumber(rs.getString("ID"), Long.class), rs.getString("PRIMER_NOMBRE"),
						rs.getString("SEGUNDO_NOMBRE"), rs.getString("PRIMER_APELLIDO"), rs.getString("SEGUNDO_APELLIDO"),
						rs.getString("EDAD"), rs.getString("SEXO"), rs.getString("FECHA_NACIMIENTO"),
						rs.getString("PUESTO"), rs.getString("FECHA_ALTA"), rs.getString("ESTATUS"));
			}
			return Optional.of(res);

		}
		//
		catch (Exception e) {
			throw new GenericException(List.of("Empleado no existe"), EnumHttpMessages.E404);
		}
	}

}
