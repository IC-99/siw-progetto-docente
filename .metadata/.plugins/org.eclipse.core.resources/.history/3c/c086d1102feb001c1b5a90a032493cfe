package it.uniroma3.siw.esame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerApplication {

	@Autowired
	private MainController mainController;
	
	@GetMapping("/")
	public String health(Model model) {
		return mainController.index(model);
	}
}