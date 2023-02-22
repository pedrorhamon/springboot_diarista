package com.starking.diarista.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AuthController {

	@GetMapping("/login")
	public String login() {
		return "admin/auth/login";
	}
}