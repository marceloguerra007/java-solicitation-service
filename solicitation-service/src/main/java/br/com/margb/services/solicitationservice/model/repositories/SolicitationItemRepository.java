package br.com.margb.services.solicitationservice.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.margb.services.solicitationservice.model.entities.SolicitationItem;

public interface SolicitationItemRepository extends PagingAndSortingRepository<SolicitationItem, Integer> {

}
