package br.com.margb.services.solicitationservice.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.margb.services.solicitationservice.model.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
