package com.habuma.santaslist.toy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/toys")
public class ToyController {

	private final ToyRepository toyRepository;

	@Autowired
	public ToyController(ToyRepository toyRepository) {
		this.toyRepository = toyRepository;		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String getAllToys(Model model) {
		model.addAttribute("toys", toyRepository.getAllToys());
		return "toys/list";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public String getToy(@PathVariable("id") long id, Model model) {
		model.addAttribute("toy", toyRepository.getToy(id));
		return "toys/detail";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody Toy getToyData(@PathVariable("id") long id) {
		return toyRepository.getToy(id);
	}	
	
	@RequestMapping(method=RequestMethod.GET, params="new")
	public String toyAdd(Model model) {
		model.addAttribute("toy", new Toy());
		return "toys/form";
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET, params="edit")
	public String toyEdit(@PathVariable("id") long id, Model model) {
		model.addAttribute("toy", toyRepository.getToy(id));
		return "toys/form";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String createToy(Toy toy) {
		long toyId = toyRepository.createToy(toy);
		return "redirect:/toys/" + toyId;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public @ResponseBody void updateToyData(@PathVariable long id, @RequestBody Toy toy) {
		toyRepository.updateToy(toy);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.POST)
	public String updateToy(@PathVariable long id, Toy toy) {
		toyRepository.updateToy(toy);
		return "redirect:/toys/" + id;
	}
}
