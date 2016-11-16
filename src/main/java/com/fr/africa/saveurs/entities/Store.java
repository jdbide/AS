package com.fr.africa.saveurs.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@NamedQueries({ 
	@NamedQuery(name = Store.QUERY_GET_ALL, query = "SELECT c FROM Store c"),
	@NamedQuery(name = Store.QUERY_GET_BY_ID, query = "SELECT c FROM Store c WHERE c.idStore = :idStore"), })
public class Store {
	
	public final static String QUERY_GET_ALL = "Store.findAllUsers";
	public final static String QUERY_DELETE_BY_ID = "Store.deleteUsersById";
	public final static String QUERY_GET_BY_ID = "Store.getUsersById";
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long idStore;
	private String nom;
	private String mail;
	private Date date_de_creation;
	private long mobile;
	private String adresse;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;
	
	@ManyToOne(optional = false)
	@PrimaryKeyJoinColumn
	private Ville ville;

	public Store() {
	}

	public long getIdStore() {
		return idStore;
	}

	public void setIdStore(long idStore) {
		this.idStore = idStore;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getDate_de_naissance() {
		return date_de_creation;
	}

	public void setDate_de_naissance(Date date_de_naissance) {
		this.date_de_creation = date_de_naissance;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}


	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

}
