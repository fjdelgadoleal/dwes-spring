/**
 * Define la configuración del contexto general de la aplicación
 */
package es.iessoterohernandez.spring5app.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import es.iessoterohernandez.spring5app.business.entities.Product;
import es.iessoterohernandez.spring5app.business.servicies.ProductManager;
import es.iessoterohernandez.spring5app.business.servicies.SimpleProductManager;

@Configuration
@ComponentScan
public class Spring5appBusinessConfig {
	
    private static Double CHAIR_PRICE = 20.50;
    private static String CHAIR_DESCRIPTION = "Chair";

    private static String TABLE_DESCRIPTION = "Table";
    private static Double TABLE_PRICE = 150.10;

    @Bean
    public ProductManager loadProductManager() {
        SimpleProductManager simpleProductManager = new SimpleProductManager();
        
        List<Product> products = new ArrayList<Product>();
        Product product = new Product();
        product.setDescription(CHAIR_DESCRIPTION);
        product.setPrice(CHAIR_PRICE);
        products.add(product);
        product = new Product();
        product.setDescription(TABLE_DESCRIPTION);
        product.setPrice(TABLE_PRICE);
        products.add(product);

        simpleProductManager.setProducts(products);
        return simpleProductManager;
    }
}
