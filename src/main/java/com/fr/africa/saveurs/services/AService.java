package com.fr.africa.saveurs.services;

import java.io.Serializable;

import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;

import com.fr.africa.saveurs.constantes.Constantes;

/**
 * Classe abstraite servant de base à  tous les services.
 */

public  class AService implements Serializable {

	/** entity manager. */

	//@Inject
	protected EntityManager  entityManager   ;
	
	public AService() {
		entityManager = Constantes.getEntitymanager();
	}

	/**
	 * méthode de pré-destruction.
	 */
//	@PreDestroy
//	public void preDestroy() {
//		if(this.entityManager.isOpen()) {
//			this.entityManager.close();
//		}
//	}

	/**
	 * retourne l'entity manager.
	 * @return l'entity manager.
	 */
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
