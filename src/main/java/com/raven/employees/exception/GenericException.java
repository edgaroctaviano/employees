package com.raven.employees.exception;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

import com.raven.employees.enums.EnumHttpMessages;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GenericException extends RuntimeException {

	@Serial
	private static final long serialVersionUID = 1L;
	private final EnumHttpMessages enumHttpMensajes;
	private final List<String> details;

	/**
	 * Constructor.
	 *
	 * @param detalles         List<String>
	 * @param enumHttpMensajes EnumHttpMensajes
	 */
	public GenericException(List<String> details, EnumHttpMessages enumHttpMensajes) {

		super(details.get(0));
		this.details = new ArrayList<>(details);
		this.enumHttpMensajes = enumHttpMensajes;
	}

}
