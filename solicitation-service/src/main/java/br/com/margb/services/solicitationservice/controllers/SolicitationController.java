package br.com.margb.services.solicitationservice.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.margb.services.solicitationservice.model.Response;
import br.com.margb.services.solicitationservice.model.entities.Solicitation;
import br.com.margb.services.solicitationservice.service.SolicitationService;

@RestController
@RequestMapping("/api/solicitation")
public class SolicitationController {
	
	@Autowired
	SolicitationService solicitationService;
	
	@GetMapping(path = "/{id}")
	public Optional<Response> getSolicitationById(@PathVariable int id) {
		
		return solicitationService.findSolicitationById(id);		 
	}
	
	@GetMapping(path="/page/{pageNumber}")
	public Response getSolicitationByPage(@PathVariable int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber, 10); 
		
		return solicitationService.findAllSolicitation(pageable);
	}	
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public @ResponseBody Response postSolicitation(@RequestBody Solicitation solicitation) {
		
		Response response = new Response();
		
		try
		{
			Solicitation s = solicitationService.saveSolicitation(solicitation); 
			response.setData(s);
			response.setMessage("Solicitação gravada com sucesso!");
		}
		catch(Exception e){
			response.setMessage(e.toString());
		}
		
		return response;		
	}
}
