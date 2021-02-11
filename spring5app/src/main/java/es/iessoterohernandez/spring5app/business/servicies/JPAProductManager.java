package es.iessoterohernandez.spring5app.business.servicies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.iessoterohernandez.spring5app.business.entities.Product;
import es.iessoterohernandez.spring5app.business.repositories.ProductRepository;

@Service
public class JPAProductManager implements ProductManager {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public void increasePrice(int percentage) {
        List<Product> products = (List<Product>) productRepository.findAll();
        if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrice().doubleValue() * 
                                    (100 + percentage)/100;
                product.setPrice(newPrice);
                productRepository.save(product);
            }
        }  
    }
}
