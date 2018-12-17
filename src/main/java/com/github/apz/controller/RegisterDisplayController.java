/**
 *
 */
package com.github.apz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author a-pz
 *
 */
@Controller
@RequestMapping("/register")
public class RegisterDisplayController {

	@GetMapping("")
	public String display() {
		return "register";
	}


}
