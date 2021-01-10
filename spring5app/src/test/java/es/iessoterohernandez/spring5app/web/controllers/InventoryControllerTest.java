package es.iessoterohernandez.spring5app.web.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

import es.iessoterohernandez.spring5app.business.Spring5appBusinessConfig;
import es.iessoterohernandez.spring5app.web.Spring5appWebConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {Spring5appBusinessConfig.class, Spring5appWebConfig.class})
@WebAppConfiguration
class InventoryControllerTest {
	
	@Autowired
	private InventoryController controller;
	
	@Test
	public void testHandleRequest() {
		ModelAndView modelAndView = controller.handleRequest();
		assertEquals("hello", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		
		@SuppressWarnings("unchecked")
		Map<String,Object> modelMap = (Map<String,Object>)modelAndView.getModel().get("model");
		String nowValue = (String) modelMap.get("now");
		assertNotNull(nowValue);
	}

}
