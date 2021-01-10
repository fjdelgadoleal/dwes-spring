package es.iessoterohernandez.spring5app.web.controllers;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.iessoterohernandez.spring5app.business.servicies.PriceIncrease;
import es.iessoterohernandez.spring5app.business.servicies.ProductManager;

@Controller
@RequestMapping(value="/priceincrease.htm")
public class PriceIncreaseFormController {
	
	/** Logger for this class and subclasses */
	protected Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private ProductManager productManager;
	
    @RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@Valid PriceIncrease priceIncrease, BindingResult result) {
    	if (result.hasErrors()) {
    		return "priceIncrease";
    	}
    	
    	int increase = priceIncrease.getPercentage();
    	logger.info("Increasing prices by " + increase + "%.");
    	
    	productManager.increasePrice(increase);
    	
    	return "redirect:/hello.htm";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    protected PriceIncrease formBackingObject() {
    	PriceIncrease priceIncrease = new PriceIncrease();
    	priceIncrease.setPercentage(15); //incremento por defecto del 15%
    	return priceIncrease;
    }

}
