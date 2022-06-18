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
	private Long id;
	
	private Date solicitationDate;
	
	private String requesterName;
	
	@OneToMany(mappedBy = "solicitation", fetch = FetchType.LAZY)
	private List<SolicitationItem> solicitationItem;
	
	public Solicitation() {
		// TODO Auto-generated constructor stub
	}

	public Solicitation(Long id, Date solicitationDate, String requesterName, List<SolicitationItem> solicitationItem) {
		super();
		this.id = id;
		this.solicitationDate = solicitationDate;
		this.requesterName = requesterName;
		this.solicitationItem = solicitationItem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<SolicitationItem> getSolicitationItem() {
		return solicitationItem;
	}

	public void setSolicitationItem(List<SolicitationItem> solicitationItem) {
		this.solicitationItem = solicitationItem;
	}	
	
}
