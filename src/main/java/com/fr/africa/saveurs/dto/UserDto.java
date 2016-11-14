package com.fr.africa.saveurs.dto;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fr.africa.saveurs.model.UserEntity;

@RequestScoped
public class UserDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idUser;
	private String nom;
	private String prenom;
	private String mail;
	private String mdp;
	private Date date_de_naissance;
	private long mobile;
	private String adresse;
	private VilleDto ville;


	public UserDto() {
		super();
		idUser = 0;
		nom = "test";
		prenom = "test";
		mail = "test";
		mdp = "test";
		date_de_naissance = new Date();
		mobile =  0;
		adresse = "test";
		setVille(new VilleDto());
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

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public long getId() {
		return idUser;
	}

	public void setId(long id) {
		this.idUser = id;
	}


	public VilleDto getVille() {
		return ville;
	}



	public void setVille(VilleDto ville) {
		this.ville = ville;
	}

}
