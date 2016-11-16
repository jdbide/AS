package com.fr.africa.saveurs.constantes;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Constantes {

    public static String tableuser = "userentity";
    public static String IdUser = " idUser ";
    public static String WHERE = " where ";
	
	public static String GET_ALL_USERS = "select *  From "+ tableuser;
	public static String GET_A_USER = "select *  From "+ tableuser + WHERE + IdUser + "= ?";
	public static String DELETE_USER = "Delete From "+ tableuser + WHERE + IdUser + "=?";
	
	public static String AppDirectory = "D://Africasaveurs//Restaurants";
	public static String ImagesDirectory = "";
	
	public static EntityManager getEntitymanager(){
		return Persistence.createEntityManagerFactory("Pu_AfricaSaveurs").createEntityManager();
	}

}
