package com.raven.employees.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StatusTest {

	@InjectMocks
	public Status controller;

	@Test
	void postEmployeesTest() {

		controller.status();
	}

}
