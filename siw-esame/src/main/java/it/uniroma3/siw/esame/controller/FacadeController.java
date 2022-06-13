package it.uniroma3.siw.esame.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.uniroma3.siw.esame.model.Buffet;
import it.uniroma3.siw.esame.model.Chef;
import it.uniroma3.siw.esame.model.Ingrediente;
import it.uniroma3.siw.esame.model.Piatto;
import it.uniroma3.siw.esame.service.BuffetService;
import it.uniroma3.siw.esame.service.ChefService;

@Controller
public class FacadeController {
	
	@Autowired 
	private BuffetService buffetService;
	
	@Autowired 
	private ChefService chefService;
	
	@Autowired 
	private AuthenticationController authenticationController;



	@GetMapping("/admin/creaOggettiTest")
	public String creaOggettiTest(Model model) {
		Buffet b1 = new Buffet();
		Buffet b2 = new Buffet();
		b1.setNome("Colazione Dolce");
		b2.setNome("Colazione Salata");
		b1.setDescrizione("Una strepitosa colazione dolce tipica della cultura italiana composta da numerose portate rappresentanti delle varie regioni del paese.");
		b2.setDescrizione("Un'ottima colazione salata, importata direttamente dal Belgio dallo chef Brian White.");

		Piatto p1 = new Piatto();
		Piatto p2 = new Piatto();
		Piatto p3 = new Piatto();
		Piatto p4 = new Piatto();
		Piatto p5 = new Piatto();

		p1.setNome("Cornetto");
		p1.setDescrizione("Morbido cornetto al cioccolato");
		p2.setNome("Cappuccino");
		p2.setDescrizione("Un classico cappuccino italiano (contiene lattosio)");
		p3.setNome("Uova Sbattute");
		p3.setDescrizione("Uova sbattute in padella con un filo di olio");
		p4.setNome("Toast");
		p4.setDescrizione("Classico toast al formaggio (contiene lattosio)");
		p5.setNome("Bacon");
		p5.setDescrizione("Tipico beacon alla griglia preparato sul momento");

		Ingrediente i1 = new Ingrediente();
		Ingrediente i2 = new Ingrediente();
		Ingrediente i3 = new Ingrediente();
		Ingrediente i4 = new Ingrediente();
		Ingrediente i5 = new Ingrediente();
		Ingrediente i6 = new Ingrediente();
		Ingrediente i7 = new Ingrediente();

		i1.setNome("Nutella");
		i1.setDescrizione("Classica Nutella");
		i1.setOrigine("Italia");
		i2.setNome("Latte");
		i2.setDescrizione("Latte di mucca");
		i2.setOrigine("Italia");
		i3.setNome("Caffè");
		i3.setDescrizione("Caffè tipico italiano");
		i3.setOrigine("Italia");
		i4.setNome("Uova");
		i4.setDescrizione("Uova di gallina");
		i4.setOrigine("Belgio");
		i5.setNome("Pane");
		i5.setDescrizione("Pane integrale");
		i5.setOrigine("America");
		i6.setNome("Formaggio");
		i6.setDescrizione("Formaggio Cheddar");
		i6.setOrigine("Belgio");
		i7.setNome("Pancetta");
		i7.setDescrizione("Pancetta da allevamento");
		i7.setOrigine("Belgio");

		p1.addIngrediente(i1);
		p2.addIngrediente(i2);
		p2.addIngrediente(i3);
		p3.addIngrediente(i4);
		p4.addIngrediente(i5);
		p4.addIngrediente(i6);
		p5.addIngrediente(i7);

		b1.addPiatto(p1);
		b1.addPiatto(p2);
		b2.addPiatto(p3);
		b2.addPiatto(p4);
		b2.addPiatto(p5);
		
		Chef c1 = new Chef();
		c1.setNome("Mario");
		c1.setCognome("Verdi");
		c1.setNazionalita("Italia");
		Chef c2 = new Chef();
		c2.setNome("Brian");
		c2.setCognome("White");
		c2.setNazionalita("Belgio");
		
		b1.setChef(c1);
		b2.setChef(c2);
		
		chefService.save(c1);
		chefService.save(c2);
		
		buffetService.save(b1);
		buffetService.save(b2);

		return authenticationController.defaultAfterLogin(model);
	}
}
