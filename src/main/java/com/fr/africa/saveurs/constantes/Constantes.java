package com.fr.africa.saveurs.constantes;

public class Constantes {

    public static String tableuser = "User";
	
	public static String GET_ALL_USERS = "select *  From "+ tableuser;
	public static String DELETE_USER = "Delete From "+ tableuser + " where idUser = ?";

}
