package com.fr.africa.saveurs.utils;

import com.fr.africa.saveurs.dto.PaysDto;
import com.fr.africa.saveurs.dto.UserDto;
import com.fr.africa.saveurs.dto.VilleDto;
import com.fr.africa.saveurs.entities.Pays;
import com.fr.africa.saveurs.entities.User;
import com.fr.africa.saveurs.entities.Ville;

public class Utils {

	//
	// public static UserEntity UserDtoToEntity(UserDto userDto){
	// UserEntity userEntity = new UserEntity();
	// userEntity.setId((userDto.getId()));
	// userEntity.setNom(userDto.getNom());
	// userEntity.setPrenom(userDto.getPrenom());
	// userEntity.setMail((userDto.getMail()));
	// userEntity.setMdp(userDto.getMdp());
	// userEntity.setDate_de_naissance(userDto.getDate_de_naissance());
	// userEntity.setMobile(userDto.getMobile());
	// userEntity.setAdresse(userDto.getAdresse());
	// userEntity.setVille(new Ville());
	// userEntity.setVille(userDto.getIdVille());
	// return userEntity;
	// }
	//
	// public static UserDto UserEntityToDto(UserEntity userEntity){
	// UserDto userDto = new UserDto();
	// userDto.setId((userEntity.getId()));
	// userDto.setNom(userEntity.getNom());
	// userDto.setPrenom(userEntity.getPrenom());
	// userDto.setMail((userEntity.getMail()));
	// userDto.setMdp(userEntity.getMdp());
	// userDto.setDate_de_naissance(userEntity.getDate_de_naissance());
	// userDto.setMobile(userEntity.getMobile());
	// userDto.setAdresse(userEntity.getAdresse());
	// userDto.setVille(userEntity.getVille());
	// userDto.setPays(userEntity.getPays());
	// return userDto;
	// }

	public static User UserDtoToEntity(UserDto userDto) {
		User userEntity = new User();
		userEntity.setId((userDto.getId()));
		userEntity.setNom(userDto.getNom());
		userEntity.setPrenom(userDto.getPrenom());
		userEntity.setMail((userDto.getMail()));
		userEntity.setMdp(userDto.getMdp());
		userEntity.setDate_de_naissance(userDto.getDate_de_naissance());
		userEntity.setMobile(userDto.getMobile());
		userEntity.setAdresse(userDto.getAdresse());
		userEntity.setVille(Utils.VilleDtoToEntity(userDto.getVille()));
		return userEntity;
	}

	private static Ville VilleDtoToEntity(VilleDto villeDto) {
		Ville ville = new Ville();
		ville.setIdVille(villeDto.getIdVille());
		ville.setNomVille(villeDto.getNomVille());
		Pays pays = new Pays();
//		pays.setIdPays(villeDto.getPaysDto().getIdPays());
//		pays.setNomPays(villeDto.getPaysDto().getNomPays());		
		pays.setIdPays(1);
		pays.setNomPays("");	
		ville.setPays(pays);
		
		return ville;
	}

	public static UserDto UserEntityToDto(User userEntity) {
		UserDto userDto = new UserDto();
		userDto.setId((userEntity.getId()));
		userDto.setNom(userEntity.getNom());
		userDto.setPrenom(userEntity.getPrenom());
		userDto.setMail((userEntity.getMail()));
		userDto.setMdp(userEntity.getMdp());
		userDto.setDate_de_naissance(userEntity.getDate_de_naissance());
		userDto.setMobile(userEntity.getMobile());
		userDto.setAdresse(userEntity.getAdresse());
		userDto.setVille(VilleEntityToDto(userEntity.getVille()));
		return userDto;
	}
	
	private static VilleDto VilleEntityToDto(Ville ville) {
		VilleDto villeDto = new VilleDto();
		villeDto.setIdVille(ville.getIdVille());
		villeDto.setNomVille(ville.getNomVille());
		PaysDto paysDto = new PaysDto();
		paysDto.setIdPays(ville.getPays().getIdPays());
		paysDto.setNomPays(ville.getPays().getNomPays());
		villeDto.setPaysDto(paysDto);
		return villeDto;
	}

}
