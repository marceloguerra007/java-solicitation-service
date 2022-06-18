package br.com.margb.services.solicitationservice.model.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.margb.services.solicitationservice.model.entities.SolicitationItem;

public interface SolicitationItemRepository extends CrudRepository<SolicitationItem, Integer> {

}
