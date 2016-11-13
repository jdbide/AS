package com.fr.africa.saveurs.services;

import java.io.Serializable;

import javax.annotation.PreDestroy;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.fr.africa.saveurs.qualifiers.PUafricaSaveurs;

/**
 * Classe abstraite servant de base à  tous les services.
 */
public abstract class AService implements Serializable {

	private static final long serialVersionUID = 859706330280545368L;
	/** entity manager. */

	private EntityManager     entityManager;


	/**
	 * méthode de pré-destruction.
	 */
	@PreDestroy
	public void preDestroy() {
		if(this.entityManager.isOpen()) {
			this.entityManager.close();
		}
	}

	/**
	 * retourne l'entity manager.
	 * @return l'entity manager.
	 */
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
}
