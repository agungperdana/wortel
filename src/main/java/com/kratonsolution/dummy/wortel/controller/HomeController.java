package com.kratonsolution.dummy.wortel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Agung Dodi Perdana
 * @email agung.dodi.perdana@gmail.com
 * @since 0.1
 */
@RestController
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
}
