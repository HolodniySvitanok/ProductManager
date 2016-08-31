package com.holodniysvitanok.productmanager.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="order_table")
public class Order {

	@Id
    @Column(name = "id_orderr")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	private Set<OrderDetails> orderDetails;
	
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;
	
	@Column(name="description_order")
	private String description;
	
	@Column(name="sum_price_order")
	private int sumPrice;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(int sumPrice) {
		this.sumPrice = sumPrice;
	}
	
	
}
