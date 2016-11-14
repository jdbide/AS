package com.fr.africa.saveurs.dto;

import java.util.List;

import com.fr.africa.saveurs.entities.Ville;

public class PaysDto {

	private int idPays;
	private String nomPays;
	private List<Ville> listeVilles;
	
	public int getIdPays() {
		return idPays;
	}
	public void setIdPays(int idPays) {
		this.idPays = idPays;
	}
	public List<Ville> getListeVilles() {
		return listeVilles;
	}
	public void setListeVilles(List<Ville> listeVilles) {
		this.listeVilles = listeVilles;
	}
	public String getNomPays() {
		return nomPays;
	}
	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}

}
