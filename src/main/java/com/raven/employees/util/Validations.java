package com.raven.employees.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.NumberUtils;

import com.raven.employees.enums.EnumHttpMessages;
import com.raven.employees.exception.GenericException;

@Component
public class Validations {
	
	public boolean searchType(String value) {
		try {
			NumberUtils.parseNumber(value, Long.class);
			return true;
		}
		//
		catch (Exception e) {
			return false;
		}
	}
	
	public void dateFormat(String date) {
		final String regex = "^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[012])-\\d{4}$";
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(date);
		
		if (!matcher.find()) {
			throw new GenericException(List.of("Fromato de fecha incorrecto"), EnumHttpMessages.E400);
		}
		
	}

}
