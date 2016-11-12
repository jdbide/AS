package com.fr.africa.saveurs.bddutils;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryProvider {
	
	public static final boolean                 DEBUG    = true;
	/**
	 * Instance unique pré-initialisée
	 */
	private static EntityManagerFactoryProvider instance = null;
	/**
	 * Map représente les entityManagerFactory par persistanceUnitName
	 */
	private Map<String, EntityManagerFactory> emfs;

	/**
	 * Constructeur privé
	 */
	private EntityManagerFactoryProvider() {
		this.emfs = new HashMap<>();
	}

	/**
	 * Point d'accès pour l'instance unique du singleton
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
	    * Methode qui récupere l'instance entityManagerFactory enregistré par persistUnitName.
	    * 
	    * <p>
	    * Si aucune entityManagerFactory n'est enregistré avec le même persistUnitName, la méthode s'occupera de la création de celui la
	    * </p>
	    * </br>
	    * 
	    * <p>
	    * La méthode utilise la configuration déclaré dans la persistance-unit (Persistance.xml)
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
	               System.out.println(new java.util.Date() + " - EntityManagerFactoryProvider : Création de l'entity manager factory \"" + persistUnitName + "\"");

	            // "No Persistence provider for EntityManager named " + persistenceUnitName
	         } catch (Exception ex) {
	            if (DEBUG)
	               System.err.println(new java.util.Date() + " - EntityManagerFactoryProvider : Erreur de création de l'entity manager factory \"" + persistUnitName + "\"");
	            // Ajout d'un log
	            ex.printStackTrace();
	            throw ex;
	         }
	      } else if (DEBUG) {
	         System.out.println(new java.util.Date() + " - EntityManagerFactoryProvider : Entity manager factory existe déja avec le persistance-unit name : \"" + persistUnitName + "\"");
	      }

	      return this.emfs.get(persistUnitName);
	   }
	   
	   /**
	    * Methode qui s'occupe de la ferméture de l'entityManagerFactory par persistUnitName.
	    * 
	    * <p>
	    * L'entityManagerFactory n'existera plus aprés l'appel à cette methode
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
