package com.csm.enrici.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//classe qui va représenter mes objets User liés à la BDD
@Entity
public class User {
	//j'ai des attributs qui représentent les champs de la table
	//l'annotation @Id mappe la propriété sur la clé primaire de la table, si le nom est le même, ou si on précise la colonne avec @Column
	@Id
	//annonce que mon id est en autoIncrement dans la BDD
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String username;
	private String password;
	
	//nos getters/setters, comme d'habitude
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	
	
	
	
}
