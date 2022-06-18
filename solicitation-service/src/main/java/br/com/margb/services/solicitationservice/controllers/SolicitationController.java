package br.com.margb.services.solicitationservice.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.margb.services.solicitationservice.model.entities.Solicitation;
import br.com.margb.services.solicitationservice.service.SolicitationService;

@RestController
@RequestMapping("/api/solicitation")
public class SolicitationController {
	
	@Autowired
	SolicitationService solicitationService;
	
	@GetMapping(path = "/{id}")
	public Optional<Solicitation> getSolicitationById(@PathVariable int id) {
		
		return solicitationService.findSolicitationById(id);
	}
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	public @ResponseBody Optional<Solicitation> postSolicitation(@RequestBody Solicitation solicitation) {
		
		return solicitationService.saveSolicitation(solicitation);
	}
}
