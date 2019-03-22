package com.stackroute.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestAPIs {

//	map the user to the role user during sign in
	@GetMapping("/api/test/user")
	@PreAuthorize("hasRole('USER')")
	public String userAccess() {

		return ">>> User Contents!";
	}
}