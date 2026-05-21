package com.raven.employees.enums;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum EnumHttpMessages {

	/**
	 * The E 400.
	 */
	E400(HttpStatus.BAD_REQUEST.value() + ".", EnumHttpMessages.E400_MENSAJE, HttpStatus.BAD_REQUEST),
	/**
	 * The E 404.
	 */
	E404(HttpStatus.NOT_FOUND.value() + ".", EnumHttpMessages.E404_MENSAJE, HttpStatus.NOT_FOUND),
	/**
	 * The E 500.
	 */
	E500(HttpStatus.INTERNAL_SERVER_ERROR.value() + ".", EnumHttpMessages.E500_MENSAJE,
			HttpStatus.INTERNAL_SERVER_ERROR);

	public static final String EOK_MENSAJE = "Operacion exitosa.";
	public static final String E400_MENSAJE = "Parametros no validos, por favor valide su informacion.";
	public static final String E404_MENSAJE = "Informacion no encontrada, favor de validar.";
	public static final String E500_MENSAJE = "Problema interno en el servidor, favor de validar.";
	private final String codigo;
	private final String mensaje;
	private final HttpStatus httpStatus;

	EnumHttpMessages(String codigo, String mensaje, HttpStatus httpStatus) {
		
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.httpStatus = httpStatus;
	}

}
