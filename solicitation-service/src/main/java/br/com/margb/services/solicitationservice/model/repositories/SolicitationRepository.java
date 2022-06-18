package br.com.margb.services.solicitationservice.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.margb.services.solicitationservice.model.entities.Solicitation;

public interface SolicitationRepository extends PagingAndSortingRepository<Solicitation, Integer> {
		
	
}
