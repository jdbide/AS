package com.fr.africa.saveurs.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Pays {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPays;
	private String nomPays;

	@OneToMany(mappedBy = "pays", cascade = CascadeType.ALL)
	private List<Ville> listeVilles;

	
	public int getIdPays() {
		return idPays;
	}

	public void setIdPays(int idPays) {
		this.idPays = idPays;
	}

	public Pays() {
	}

	public String getNomPays() {
		return nomPays;
	}

	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}

}
