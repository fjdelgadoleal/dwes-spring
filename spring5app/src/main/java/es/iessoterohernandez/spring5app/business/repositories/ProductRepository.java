package es.iessoterohernandez.spring5app.business.repositories;

import org.springframework.data.repository.CrudRepository;

import es.iessoterohernandez.spring5app.business.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}