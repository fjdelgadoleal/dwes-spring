/**
 * Define el contexto de la capa web, es decir, las definiciones de los beans usados por el DispatcherServlet
 */
package es.iessoterohernandez.spring5app.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan
@EnableWebMvc
public class Spring5appWebConfig {

	/**
	 * Bean 'messageSource' que permitirá recuperar mensajes desde la ubicación 'messages.properties'
	 * @return messageSource
	 */
    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
    
	/**
	 * Creamos un mapeo básico entre una vista y una localización configurando
	 * un prefijo y un sufijo en un bean InternalResourceViewResolver 
	 * definido en el contexto del ServletDispatcher
	 * @return
	 */
	@Bean
	public ViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
		internalResourceViewResolver.setSuffix(".jsp");
		return internalResourceViewResolver;
	}

}
