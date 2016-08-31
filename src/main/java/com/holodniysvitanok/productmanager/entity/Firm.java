package com.holodniysvitanok.productmanager.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "firms_table")
public class Firm {

	@Id
    @Column(name = "id_firm")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name_firm")
	private String name;
	
	@Column(name = "country_firm")
	private String country;
	
	@Column(name = "description_firm")
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "firm")
	private Set<Product> products = new HashSet<>();

	@Column(name = "image_firm")
	@Basic(fetch=FetchType.LAZY)
	@Lob
	private byte[] image;
	
	@Column(name = "file_name_firm")
	private String fileName;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Firm(long id) {
		super();
		this.id = id;
	}

	public Firm() {
		super();
	}
	
	
	
	
}
