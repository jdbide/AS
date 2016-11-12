package com.fr.africa.saveurs.bddutils;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryProvider {
	
	public static final boolean                 DEBUG    = true;
	/**
	 * Instance unique pr�-initialis�e
	 */
	private static EntityManagerFactoryProvider instance = null;
	/**
	 * Map repr�sente les entityManagerFactory par persistanceUnitName
	 */
	private Map<String, EntityManagerFactory> emfs;

	/**
	 * Constructeur priv�
	 */
	private EntityManagerFactoryProvider() {
		this.emfs = new HashMap<>();
	}

	/**
	 * Point d'acc�s pour l'instance unique du singleton
	 */
	public static synchronized EntityManagerFactoryProvider getInstance() {
		if (instance == null) {
			instance = new EntityManagerFactoryProvider();
		}

		return instance;
	}

	public static EntityManager getEntityManager(String pu) {
		return Persistence.createEntityManagerFactory(pu).createEntityManager();
	}
	
	   /**
	    * Methode qui r�cupere l'instance entityManagerFactory enregistr� par persistUnitName.
	    * 
	    * <p>
	    * Si aucune entityManagerFactory n'est enregistr� avec le m�me persistUnitName, la m�thode s'occupera de la cr�ation de celui la
	    * </p>
	    * </br>
	    * 
	    * <p>
	    * La m�thode utilise la configuration d�clar� dans la persistance-unit (Persistance.xml)
	    * </p>
	    * 
	    * @param persistUnitName
	    *           (String) le libelle de persistance-unit name
	    * @return EntityManagerFactory
	    */
	   public EntityManagerFactory getEntityManagerFactory(String persistUnitName) {
	      if (this.emfs.isEmpty() || !this.emfs.containsKey(persistUnitName)) {
	         // ajout de entityManagerFactory
	         try {
	            this.emfs.put(persistUnitName, Persistence.createEntityManagerFactory(persistUnitName));
	            if (DEBUG)
	               System.out.println(new java.util.Date() + " - EntityManagerFactoryProvider : Cr�ation de l'entity manager factory \"" + persistUnitName + "\"");

	            // "No Persistence provider for EntityManager named " + persistenceUnitName
	         } catch (Exception ex) {
	            if (DEBUG)
	               System.err.println(new java.util.Date() + " - EntityManagerFactoryProvider : Erreur de cr�ation de l'entity manager factory \"" + persistUnitName + "\"");
	            // Ajout d'un log
	            ex.printStackTrace();
	            throw ex;
	         }
	      } else if (DEBUG) {
	         System.out.println(new java.util.Date() + " - EntityManagerFactoryProvider : Entity manager factory existe d�ja avec le persistance-unit name : \"" + persistUnitName + "\"");
	      }

	      return this.emfs.get(persistUnitName);
	   }
	   
	   /**
	    * Methode qui s'occupe de la ferm�ture de l'entityManagerFactory par persistUnitName.
	    * 
	    * <p>
	    * L'entityManagerFactory n'existera plus apr�s l'appel � cette methode
	    * </p>
	    * 
	    * @param persistUnitName
	    */
	   public void closeEntityManagerFactory(String persistUnitName) {
	      if (!this.emfs.isEmpty() && this.emfs.containsKey(persistUnitName)) {
	         this.emfs.get(persistUnitName).close();
	         this.emfs.remove(persistUnitName);
	         if (DEBUG)
	            System.out.println(new java.util.Date() + " - EntityManagerFactoryProvider : Fermeture de l'entity manager factory \"" + persistUnitName + "\"");
	      }
	   }


}
