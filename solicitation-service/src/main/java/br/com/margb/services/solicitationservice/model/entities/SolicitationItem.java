package br.com.margb.services.solicitationservice.model.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SolicitationItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Solicitation solicitation;
	
	private int sequence;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Produto produto;
	
	private double quantity;
	
	private String status;

	public SolicitationItem() {
		// TODO Auto-generated constructor stub
	}
	
	public SolicitationItem(Long id, int sequence, Produto produto, double quantity, String status) {
		super();
		this.id = id;
		this.sequence = sequence;
		this.produto = produto;
		this.quantity = quantity;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
