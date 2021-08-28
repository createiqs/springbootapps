package com.createiq.pw.domin;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer roleId;
	private String name;
	@ManyToMany(mappedBy = "roles")
	private Set<User> users = new HashSet<>();

	

}
