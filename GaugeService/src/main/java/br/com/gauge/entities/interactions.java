package br.com.gauge.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "interactions")
public class interactions {
	
	@Id
	@GeneratedValue
	private Long idinteractions;
	
	@ManyToOne
	@JoinColumn(name="brand_id")
	private brands brands;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private users users;
	
	private String type;
	private String text;
	
	
	public brands getBrand() {
		return brands;
	}
	public void setBrand(brands brand) {
		this.brands = brand;
	}
	public users getUser() {
		return users;
	}
	public void setUser(users user) {
		this.users = user;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getIdinteractions() {
		return idinteractions;
	}
	public void setIdinteractions(Long idinteractions) {
		this.idinteractions = idinteractions;
	}
	
	

}
