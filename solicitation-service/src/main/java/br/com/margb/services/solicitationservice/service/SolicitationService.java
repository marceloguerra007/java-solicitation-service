package br.com.margb.services.solicitationservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import br.com.margb.services.solicitationservice.model.Response;
import br.com.margb.services.solicitationservice.model.entities.Product;
import br.com.margb.services.solicitationservice.model.entities.Solicitation;
import br.com.margb.services.solicitationservice.model.entities.SolicitationItem;
import br.com.margb.services.solicitationservice.model.repositories.ProductRepository;
import br.com.margb.services.solicitationservice.model.repositories.SolicitationItemRepository;
import br.com.margb.services.solicitationservice.model.repositories.SolicitationRepository;

@Service
@Transactional
public class SolicitationService {
	
	@Autowired
	private SolicitationRepository solicitationRepository;

	@Autowired
	private SolicitationItemRepository solicitationItemRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
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

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Solicitation saveSolicitation(Solicitation solicitation) {
		try {
			List<SolicitationItem> items = solicitation.getSolicitationItens();
			
			solicitation = solicitationRepository.save(solicitation);	
			
			for (SolicitationItem solicitationItem : items) {
				solicitationItem.setSolicitation(solicitation);
				
				Optional<Product> product = productRepository.findById(solicitationItem.getProduct().getId());
				
				if (product.isPresent()) {
					solicitationItem.setProduct(product.get());				
				}else {
					throw new Exception(String.format("Produto solicitado com id %s não está cadastrado.", solicitationItem.getProduct().getId()).toString());
				}
			}		
			
			solicitationItemRepository.saveAll(items);
			
			return solicitation;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao gravar a Solicitação. " + e.getMessage());
		}						
	}
}
