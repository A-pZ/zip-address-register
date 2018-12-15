/**
 *
 */
package com.github.apz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j2;

/**
 * @author a-pz
 *
 */
@Controller
@RequestMapping("/")
@Log4j2
public class RegisterController {

	@GetMapping("")
	public String display() {
		return "index";
	}

	@PostMapping("register")
	public ModelAndView register(ModelAndView mnv) {

		mnv.setViewName("redirect:");
		return mnv;
	}
}
