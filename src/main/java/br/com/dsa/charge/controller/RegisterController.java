package br.com.dsa.charge.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.dsa.charge.model.Register;
import br.com.dsa.charge.model.RegisterStatus;
import br.com.dsa.charge.repository.RegistersRepository;

@Controller
@RequestMapping("/registers")
public class RegisterController {

	private static final String REGISTER_VIEW = "register";
	private static final String NEW_REGISTER_VIEW = "newRegister";

	@Autowired
	private RegistersRepository registersRepo;

	@GetMapping
	public ModelAndView index() {
		List<Register> registers = registersRepo.findAll();
		ModelAndView mv = new ModelAndView(REGISTER_VIEW);
		mv.addObject("registers", registers);

		return mv;
	}

	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mv = new ModelAndView(NEW_REGISTER_VIEW);
		mv.addObject(new Register());

		return mv;
	}

	@PostMapping
	public String save(@Validated Register register, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return NEW_REGISTER_VIEW;
		}
		registersRepo.save(register);

		attributes.addFlashAttribute("message", "Register saved with success!");
		return "redirect:/registers/new";
	}

	@GetMapping("{id}")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView(NEW_REGISTER_VIEW);
		Register register = registersRepo.findOne(id);

		mv.addObject(register);
		return mv;
	}

	@ModelAttribute("allStatus")
	public List<RegisterStatus> allRegisterStatus() {

		return Arrays.asList(RegisterStatus.values());
	}
}
