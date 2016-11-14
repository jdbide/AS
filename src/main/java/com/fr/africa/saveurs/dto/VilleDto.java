package com.fr.africa.saveurs.dto;

public class VilleDto {
	
	private long idVille;
	private String nomVille;
	private PaysDto paysDto;
	
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
