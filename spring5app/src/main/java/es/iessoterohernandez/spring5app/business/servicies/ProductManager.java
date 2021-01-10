/**
 * Servicio responsable de gestionar los productos
 */
package es.iessoterohernandez.spring5app.business.servicies;

import java.util.List;

import es.iessoterohernandez.spring5app.business.entities.Product;

public interface ProductManager {
	
    public void increasePrice(int percentage);
    
    public List<Product> getProducts();
}
