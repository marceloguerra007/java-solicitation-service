package br.com.margb.services.solicitationservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.margb.services.solicitationservice.model.entities.Product;
import br.com.margb.services.solicitationservice.model.entities.Solicitation;
import br.com.margb.services.solicitationservice.model.entities.SolicitationItem;
import br.com.margb.services.solicitationservice.model.repositories.ProductRepository;
import br.com.margb.services.solicitationservice.model.repositories.SolicitationItemRepository;
import br.com.margb.services.solicitationservice.model.repositories.SolicitationRepository;

@Service
public class SolicitationService {
	
	@Autowired
	private SolicitationRepository solicitationRepository;

	@Autowired
	private SolicitationItemRepository solicitationItemRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public Optional<Solicitation> findSolicitationById(int id){
		return solicitationRepository.findById(id);
	}

	public Optional<Solicitation> saveSolicitation(Solicitation solicitation) {
		
		List<SolicitationItem> items = solicitation.getSolicitationItens();
		
		solicitation = solicitationRepository.save(solicitation);		
		
		for (SolicitationItem solicitationItem : items) {
			solicitationItem.setSolicitation(solicitation);
			
			Optional<Product> product = productRepository.findById(solicitationItem.getProduct().getId());
			
			solicitationItem.setProduct(product.get());
		}		
	
		solicitationItemRepository.saveAll(items);
		
		return null;
		//return solicitationRepository.findById(solicitation.getId());
	}
}
