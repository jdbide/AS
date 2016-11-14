package com.fr.africa.saveurs.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import com.fr.africa.saveurs.bddutils.EnumAccountType;

@Entity
@NamedQueries({ 
	@NamedQuery(name = User.QUERY_GET_ALL, query = "SELECT c FROM User c"),
	@NamedQuery(name = User.QUERY_GET_BY_ID, query = "SELECT c FROM User c WHERE c.idUser = :idUser"), })
public class User {
	
	public final static String QUERY_GET_ALL = "findAllUsers";
	public final static String QUERY_DELETE_BY_ID = "deleteUsersById";
	public final static String QUERY_GET_BY_ID = "getUsersById";
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
	private EnumAccountType accountType;
	
	@OneToOne
    @JoinColumn(name = "idStore")
	private Store store;
	@ManyToOne(optional = false)
    @JoinColumn(name = "idVille")
	private Ville ville;

	public User() {
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


	public long getId() {
		return idUser;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public Ville getVille() {
		return ville;
	}

	public void setVille(Ville ville) {
		this.ville = ville;
	}

	public void setId(long id) {
		this.idUser = id;
	}

	public EnumAccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(EnumAccountType accountType) {
		this.accountType = accountType;
	}

}
