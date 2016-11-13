package com.fr.africa.saveurs.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({ 
	@NamedQuery(name = UserEntity.QUERY_GET_ALL, query = "SELECT c FROM UserEntity c"),
	@NamedQuery(name = UserEntity.QUERY_GET_BY_ID, query = "SELECT c FROM UserEntity c WHERE c.idUser = :idUser"), })
@Entity
public class UserEntity {
	
	public final static String QUERY_GET_ALL = "findAll";
	public final static String QUERY_DELETE_BY_ID = "deleteById";
	public final static String QUERY_GET_BY_ID = "getById";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idUser;
	private String nom;
	private String prenom;
	private String mail;
	private String mdp;
	private Date date_de_naissance;
	private long mobile;
	private String adresse;
	private String ville;
	private String pays;

	public UserEntity() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public Date getDate_de_naissance() {
		return date_de_naissance;
	}

	public void setDate_de_naissance(Date date_de_naissance) {
		this.date_de_naissance = date_de_naissance;
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

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public long getId() {
		return idUser;
	}

	public void setId(long id) {
		this.idUser = id;
	}

}
