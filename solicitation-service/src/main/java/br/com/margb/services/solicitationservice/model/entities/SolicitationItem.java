package br.com.margb.services.solicitationservice.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class SolicitationItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	private Solicitation solicitation;
	
	private int sequence;
	
	@OneToOne
	private Product product;
	
	private double quantity;
	
	private String status;

	public SolicitationItem() {
		// TODO Auto-generated constructor stub
	}
	
	public SolicitationItem(Solicitation solicitation, int sequence, Product product, double quantity, String status) {
		super();
		this.solicitation = solicitation;
		this.sequence = sequence;
		this.product = product;
		this.quantity = quantity;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Solicitation getSolicitation() {
		return solicitation;
	}

	public void setSolicitation(Solicitation solicitation) {
		this.solicitation = solicitation;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
