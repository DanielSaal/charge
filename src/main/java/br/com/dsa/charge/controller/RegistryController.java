package br.com.dsa.charge.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.dsa.charge.model.Registry;
import br.com.dsa.charge.model.RegistryStatus;
import br.com.dsa.charge.repository.RegistriesRepository;

@Controller
@RequestMapping("/registries")
public class RegistryController {

	private static final String REGISTRY_VIEW = "registry";
	private static final String NEW_REGISTRY_VIEW = "registryForm";

	@Autowired
	private RegistriesRepository registriesRepo;

	@GetMapping
	public ModelAndView index() {
		List<Registry> registries = registriesRepo.findAll();
		ModelAndView mv = new ModelAndView(REGISTRY_VIEW);
		mv.addObject("registries", registries);

		return mv;
	}

	@GetMapping("/new")
	public ModelAndView create() {
		ModelAndView mv = new ModelAndView(NEW_REGISTRY_VIEW);
		mv.addObject(new Registry());

		return mv;
	}

	@PostMapping
	public String save(@Validated Registry registry, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return NEW_REGISTRY_VIEW;
		}
		try {
			registriesRepo.save(registry);

			attributes.addFlashAttribute("message", "Registry saved with success!");
			return "redirect:/registries/new";
		} catch (DataIntegrityViolationException e) {
			errors.rejectValue("dueDate", null, "Invalid date format");
			return NEW_REGISTRY_VIEW;
		}

	}

	@GetMapping("{id}")
	public ModelAndView edit(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView(NEW_REGISTRY_VIEW);
		Registry registry = registriesRepo.findOne(id);

		mv.addObject(registry);
		return mv;
	}

	@DeleteMapping("{id}")
	public String delete(@PathVariable Long id, RedirectAttributes attributes) {
		registriesRepo.delete(id);

		attributes.addFlashAttribute("message", "Registry deleted with success!");
		return "redirect:/registries";
	}

	@ModelAttribute("allStatus")
	public List<RegistryStatus> allRegisterStatus() {

		return Arrays.asList(RegistryStatus.values());
	}
}
