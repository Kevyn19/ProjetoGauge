package br.com.gauge.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "brands")
public class brands{
	
	
	@Id
	@GeneratedValue
	private Long idbrands;
	
	private String name;
	private String image;
	public Long getIdbrands() {
		return idbrands;
	}
	public void setIdbrands(Long idbrands) {
		this.idbrands = idbrands;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}	
	

}
