package com.fr.africa.saveurs.dto;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

public class VilleDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long idVille;
	private String nomVille;
	private PaysDto paysDto;
	
	public VilleDto() {
	}
	
	public long getIdVille() {
		return idVille;
	}
	public void setIdVille(long idVille) {
		this.idVille = idVille;
	}
	public String getNomVille() {
		return nomVille;
	}
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	public PaysDto getPaysDto() {
		return paysDto;
	}
	public void setPaysDto(PaysDto paysDto) {
		this.paysDto = paysDto;
	}

}
