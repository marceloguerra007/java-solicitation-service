package br.com.margb.services.solicitationservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/solicitation")
public class SolicitationController {

	@GetMapping(path = "/{id}")
	public String getSolicitationById(@PathVariable int id) {
		return "id="+ String.valueOf(id);
	}	
	
}
