package com.holodniysvitanok.productmanager.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "product_table")
public class Product {

	@Id
    @Column(name = "id_product")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "id_firm")
	private Firm firm; 
	
	@ManyToOne
	@JoinColumn(name = "id_category")
	private Category category;
	
	@Column(name = "price_product")
	private int price;
	
	@Column(name = "image1_product")
	@Basic(fetch=FetchType.LAZY)
	@Lob
	private byte[] image1;
	
	@Column(name = "image2_product")
	@Basic(fetch=FetchType.LAZY)
	@Lob
	private byte[] image2;
	
	@Column(name = "image3_product")
	@Basic(fetch=FetchType.LAZY)
	@Lob
	private byte[] image3;
	
	@Column(name = "volume_product")
	private int volume;
	
	@Column(name = "color_product")
	private short color;
	
	@Column(name = "color_description_product")
	private String colorDescription;
	
	@Column(name = "description_product")
	private String description;

	@Column(name="presence_product")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean presence;

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Firm getFirm() {
		return firm;
	}

	public void setFirm(Firm firm) {
		this.firm = firm;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public byte[] getImage1() {
		return image1;
	}

	public void setImage1(byte[] image1) {
		this.image1 = image1;
	}

	public byte[] getImage2() {
		return image2;
	}

	public void setImage2(byte[] image2) {
		this.image2 = image2;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public short getColor() {
		return color;
	}

	public void setColor(short color) {
		this.color = color;
	}

	public String getColorDescription() {
		return colorDescription;
	}

	public void setColorDescription(String colorDescription) {
		this.colorDescription = colorDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPresence() {
		return presence;
	}

	public void setPresence(boolean presence) {
		this.presence = presence;
	}

	public byte[] getImage3() {
		return image3;
	}

	public void setImage3(byte[] image3) {
		this.image3 = image3;
	}
	
	
	
}
