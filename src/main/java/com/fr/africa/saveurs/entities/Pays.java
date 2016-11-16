package com.fr.africa.saveurs.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity

@NamedQueries({ @NamedQuery(name = Pays.QUERY_GET_ALL, query = "SELECT c FROM Pays c"),
		@NamedQuery(name = Pays.QUERY_GET_BY_ID, query = "SELECT c FROM Pays c WHERE c.idPays = :idPays"), })
public class Pays {

	public final static String QUERY_GET_ALL = "Pays.findAll";
	public final static String QUERY_DELETE_BY_ID = "Pays.deleteById";
	public final static String QUERY_GET_BY_ID = "Pays.getById";
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

	public List<Ville> getListeVilles() {
		return listeVilles;
	}

	public void setListeVilles(List<Ville> listeVilles) {
		this.listeVilles = listeVilles;
	}

	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}

}
