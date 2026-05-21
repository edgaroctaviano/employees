/**
 * 
 */
package com.raven.employees.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.raven.employees.enums.EnumHttpMessages;

import lombok.Data;

/**
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class GenericResponse {

	private String code;
	private String message;
	/**
	 * Detalles del error si la solicitud ha fallado.
	 */
	private List<String> detalles;

	private Object response;
	
	public GenericResponse() {

		this.message = "Operacion exitosa.";
	}

	public GenericResponse(Object resultado) {

		this.message = "Operacion exitosa.";
		this.response = resultado;
	}

	public GenericResponse(List<String> detalles, EnumHttpMessages enumHttpMessages) {
		super();
		this.message = enumHttpMessages.getMensaje();
		this.detalles = new ArrayList<>(detalles);
	}

}
