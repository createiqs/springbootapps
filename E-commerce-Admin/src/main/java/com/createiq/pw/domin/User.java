package com.createiq.pw.domin;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id", nullable = false, updatable = false)
	private Integer id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	
	@Column(name="email", nullable = false, updatable = false)
	private String email;
	private String phone;
	private boolean enabled=true;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
	private ShoppingCart shoppingCart;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<UserShipping> userShippingList;
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<UserPayment> userPaymentList;

	@OneToMany(mappedBy = "user")
	private List<Order> orderList;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "id") }, inverseJoinColumns = {
			@JoinColumn(name = "roleId") })
	private Set<Role> roles = new HashSet<>();
	

	
	
}
