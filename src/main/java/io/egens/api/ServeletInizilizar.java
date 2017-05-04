package io.egens.api;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * create a Pojo class
 * 
 * @author kirti gupta
 *
 */
public class ServeletInizilizar extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { WebConfig.class,JPAConfig.class,SwaggerConfig.class, };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}
//The Spring Web MVC framework is designed around a DispatcherServlet that handles all the HTTP requests and responses.
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/*" };

	}

}
