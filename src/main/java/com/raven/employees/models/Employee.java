/**
 * 
 */
package com.raven.employees.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * 
 */
@Data
@Entity
public class Employee {

	@Id
	private Long id;
	@NotNull(message = "El campo primerNombre es requerido")
	@NotEmpty
	private String primerNombre;
	private String segundoNombre;
	@NotNull(message = "El campo primerApellido es requerido")
	@NotEmpty
	private String primerApellido;
	@NotNull(message = "El campo segundoApellido es requerido")
	@NotEmpty
	private String segundoApellido;
	@NotNull(message = "El campo edad es requerido")
	@NotEmpty
	private String edad;
	private String sexo;
	@NotNull(message = "El campo fechaNacimiento es requerido")
	@NotEmpty
	private String fechaNacimiento;
	@NotNull(message = "El campo puesto es requerido")
	@NotEmpty
	private String puesto;
	private String fechaAlta;
	private String estatus;

	public Employee() {
		super();
	}

	public Employee(Long id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			String edad, String sexo, String fechaNacimiento, String puesto, String fechaAlta, String estatus) {
		super();
		this.id = id;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.edad = edad;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.puesto = puesto;
		this.fechaAlta = fechaAlta;
		this.estatus = estatus;
	}

}
