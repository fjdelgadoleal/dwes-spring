/**
 * Define el DispatcherServlet
 * Su misi�n ser� controlar hacia d�nde ser�n enrutadas todas las solicitudes recibidas por la aplicaci�n
 * Esta clase de lanzar� autom�ticamente a trav�s de la funcionalidad javax.servlet.ServletContainerInitializer
 * del API de Servlet 3 (http://joshlong.com/jl/blogPost/simplified_web_configuration_with_spring.html).
 */
package es.iessoterohernandez.spring5app;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import es.iessoterohernandez.spring5app.business.Spring5appBusinessConfig;
import es.iessoterohernandez.spring5app.web.Spring5appWebConfig;


public class Spring5appWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { Spring5appBusinessConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { Spring5appWebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

}