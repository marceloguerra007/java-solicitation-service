package br.com.margb.services.solicitationservice.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.margb.services.solicitationservice.model.entities.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

}
