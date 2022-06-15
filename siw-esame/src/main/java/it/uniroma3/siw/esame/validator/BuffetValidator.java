package it.uniroma3.siw.esame.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.esame.model.Buffet;
import it.uniroma3.siw.esame.service.BuffetService;



@Component
public class BuffetValidator implements Validator{
	
	@Autowired
	private BuffetService buffetService;
	
	@Override
	public void validate(Object o, Errors errors) {
		
		Buffet buffet = (Buffet) o;
		
		if(this.buffetService.alreadyExists(buffet)) {
			errors.reject("buffet.duplicato");
			
			if(buffet.getId() != null) {
				if(buffetService.findById(buffet.getId()) != null) {
					errors.reject("buffet.notUpdate");
				}
			}
		}
	}
	
	@Override
	public boolean supports(Class<?> aClass) {
		return Buffet.class.equals(aClass);
	}

}
