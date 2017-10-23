package br.com.dsa.charge.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

	/**
	 * Display a listing of the resource.
	 * 
	 * @return
	 */
	public String index() {
		
		return "register";
	}
	
	/**
	 * Show the form for creating a new resource.
	 * 
	 * @return
	 */
	@RequestMapping("/register/new")
	public String create() {
		
		return "register";
	}
}
