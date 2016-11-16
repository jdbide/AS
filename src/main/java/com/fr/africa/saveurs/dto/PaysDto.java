package com.fr.africa.saveurs.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaysDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idPays;
	private String nomPays;
	private List<VilleDto> listeVilles;
	
	public PaysDto() {
		listeVilles = new ArrayList<>();
	}
	
	public int getIdPays() {
		return idPays;
	}
	public void setIdPays(int idPays) {
		this.idPays = idPays;
	}
	public List<VilleDto> getListeVilles() {
		return listeVilles;
	}
	public void setListeVilles(List<VilleDto> listeVilles) {
		this.listeVilles = listeVilles;
	}
	public String getNomPays() {
		return nomPays;
	}
	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}

}
