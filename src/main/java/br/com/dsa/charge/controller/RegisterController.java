package br.com.dsa.charge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.dsa.charge.model.Register;
import br.com.dsa.charge.repository.RegistersRepository;

@Controller
@RequestMapping("/registers")
public class RegisterController {

	@Autowired
	private RegistersRepository registersRepo;

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
	@RequestMapping("/new")
	public String create() {

		return "register";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String save(Register register) {

		registersRepo.save(register);
		return "register";
	}
}
