package com.jtf.junit5.api.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {

	public String getMessage()
	{
		return "Good Morning";
	}
}
