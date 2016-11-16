package com.fr.africa.saveurs.dto;

import java.util.Date;

import com.fr.africa.saveurs.Enums.EnumAccountType;

public class StoreDto {
	private long idStore;
	private String nom;
	private String mail;
	private Date date_de_creation;
	private long mobile;
	private String adresse;
	private UserDto userDto;
	private EnumAccountType accountType;
	
	public StoreDto() {
		// TODO Auto-generated constructor stub
	}
	
	public void initStoreDto(){
		userDto = new UserDto();
		idStore = 0;
		adresse = "test";
		date_de_creation = new Date();
		mobile = 0;
		mail ="";
		nom = "";
		setAccountType(EnumAccountType.CLIENT);
	}
	public long getIdStore() {
		return idStore;
	}
	public void setIdStore(long idStore) {
		this.idStore = idStore;
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
	public Date getDate_de_creation() {
		return date_de_creation;
	}
	public void setDate_de_creation(Date date_de_creation) {
		this.date_de_creation = date_de_creation;
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
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	public VilleDto getVilleDto() {
		return villeDto;
	}
	public void setVilleDto(VilleDto villeDto) {
		this.villeDto = villeDto;
	}
	public EnumAccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(EnumAccountType accountType) {
		this.accountType = accountType;
	}
	private VilleDto villeDto;

}
