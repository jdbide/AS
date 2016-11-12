package com.fr.africa.saveurs.utils;

import com.fr.africa.saveurs.dto.UserDto;
import com.fr.africa.saveurs.model.UserEntity;

public class Utils {

	
	public static  UserEntity UserDtoToEntity(UserDto userDto){
		UserEntity userEntity =  new UserEntity();
		userEntity.setNom(userDto.getNom());
		userEntity.setPrenom(userDto.getPrenom());
		userEntity.setMail((userDto.getMail()));
		userEntity.setMdp(userDto.getMdp());
		userEntity.setDate_de_naissance(userDto.getDate_de_naissance());
		userEntity.setMobile(userDto.getMobile());
		userEntity.setAdresse(userDto.getAdresse());
		userEntity.setVille(userDto.getVille());
		userEntity.setPays(userDto.getPays());
		return userEntity;
	}
	
}
