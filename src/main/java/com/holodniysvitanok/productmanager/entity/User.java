package com.holodniysvitanok.productmanager.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="user_table")
public class User {

	@Id
    @Column(name = "id_user")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="name_user")
	private String name;

	@Column(name="login_user")
	private String login;

	@Column(name="password_user")
	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;

	@Column(name="date_registration_user")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateRegistration;
	
	@Column(name="address_description_user")
	private String addressDescription;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private Set<Order> order = new HashSet<>();
	
	@Column(name="mobile_phone_user")
	private String mobilePhone;
	
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getDateRegistration() {
		return dateRegistration;
	}

	public void setDateRegistration(Date dateRegistration) {
		this.dateRegistration = dateRegistration;
	}

	public String getAddressDescription() {
		return addressDescription;
	}

	public void setAddressDescription(String addressDescription) {
		this.addressDescription = addressDescription;
	}

	public Set<Order> getOrder() {
		return order;
	}

	public void setOrder(Set<Order> order) {
		this.order = order;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}



	public static enum Role {
		root("root"),  moder("moder"), customer("customer"),  webUser("webUser"), webVisitor("webVisitor");

		private String text;

		private Role(String text) {
			this.text = text;
		}

		public String getText() {
			return this.text;
		}

		public static Role fromString(String text) {
			if (text != null) {
				for (Role type : Role.values()) {
					if (text.equalsIgnoreCase(type.text)) {
						return type;
					}
				}
			}
			return null;
		}
	}

	public User(long id) {
		this.id = id;
	}
	
	public User() {
	}

	
	
}
