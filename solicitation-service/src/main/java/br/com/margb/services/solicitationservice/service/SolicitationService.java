package br.com.margb.services.solicitationservice.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.margb.services.solicitationservice.model.Response;
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
	
	public Optional<Response> findSolicitationById(int id){
		Response response = new Response();
		Optional<Solicitation> solicitation = solicitationRepository.findById(id);
		
		solicitation
			.ifPresentOrElse(
				s -> {
						response.setData(s);
						response.setMessage("Solicitação localizada!");
					}, 
				()-> response.setMessage("Não foi localizada uma solicitação com o id: " + String.valueOf(id))
			);		
		
		return Optional.of(response);
	}
	
	public Response findAllSolicitation(Pageable pageable){
		Response response = new Response();
		Page<Solicitation> solicitation = solicitationRepository.findAll(pageable);
		
		if (solicitation.isEmpty()) {
			response.setMessage("Página inválida ou não há solicitações cadastradas.");
		}else {
			response.setData(solicitation);
			response.setMessage("Solicitações localizadas");
		}		
		
		return response;
	}

	public Optional<Response> saveSolicitation(Solicitation solicitation) {
		Response response = new Response();
		
		try {
			List<SolicitationItem> items = solicitation.getSolicitationItens();
			
			solicitation = solicitationRepository.save(solicitation);		
			
			for (SolicitationItem solicitationItem : items) {
				solicitationItem.setSolicitation(solicitation);
				
				Optional<Product> product = productRepository.findById(solicitationItem.getProduct().getId());
				
				solicitationItem.setProduct(product.get());
			}		
			
			solicitationItemRepository.saveAll(items);
			
			//Trecho referente ao Response			
			Optional<Solicitation> solicitationResponse = Optional.of(solicitation); //solicitationRepository.findById(solicitation.getId());
			
			solicitationResponse.ifPresent(
					s -> {	response.setData(s);
							response.setMessage("Solicitação gravada com sucesso!");
						 });
		} catch (Exception e) {
			response.setMessage("Erro ao gravar a Solicitação. " + e.getMessage());
		}
		
		return Optional.of(response);
	}
}
