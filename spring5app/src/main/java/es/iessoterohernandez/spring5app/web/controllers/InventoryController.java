/**
 * Controlador
 */
package es.iessoterohernandez.spring5app.web.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.iessoterohernandez.spring5app.business.servicies.ProductManager;

@Controller
public class InventoryController {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired //Lo comentamos para ponerlo de forma manual y solventar el problema que estamos teniendo con el Autowired
	private ProductManager producManager;
	
	@RequestMapping(value="/hello.htm")
	public ModelAndView handleRequest() {
		String now = (new Date()).toString();
		logger.info("Returning hello view with " + now);
	
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now", now);
		myModel.put("products", this.producManager.getProducts());		
		
		return new ModelAndView("hello", "model", myModel);
	}
	
}
