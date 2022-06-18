package br.com.margb.services.solicitationservice.model.entities;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;;

@Entity
public class Solicitation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date solicitationDate;
	
	private String requesterName;
	
	@OneToMany(mappedBy = "solicitation", fetch = FetchType.LAZY)
	private List<SolicitationItem> solicitationItens;
	
	public Solicitation() {
		// TODO Auto-generated constructor stub
	}

	public Solicitation(int id, Date solicitationDate, String requesterName, List<SolicitationItem> solicitationItens) {
		super();
		this.id = id;
		this.solicitationDate = solicitationDate;
		this.requesterName = requesterName;
		this.solicitationItens = solicitationItens;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Solicitation(Date solicitationDate, String requesterName) {
		super();
		this.solicitationDate = solicitationDate;
		this.requesterName = requesterName;
	}

	public Date getSolicitationDate() {
		return solicitationDate;
	}

	public void setSolicitationDate(Date solicitationDate) {
		this.solicitationDate = solicitationDate;
	}

	public String getRequesterName() {
		return requesterName;
	}

	public void setRequesterName(String requesterName) {
		this.requesterName = requesterName;
	}

	public List<SolicitationItem> getSolicitationItens() {
		return solicitationItens;
	}

	public void setSolicitationItens(List<SolicitationItem> solicitationItens) {
		this.solicitationItens = solicitationItens;
	}	
	
}
