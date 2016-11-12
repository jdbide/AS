package com.fr.africa.saveurs.services;

import java.io.Serializable;

import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

/**
 * Classe abstraite servant de base à  tous les services.
 * 
 * 
 */
public abstract class AService implements Serializable {

	/** Automatic serial ID */
	private static final long serialVersionUID = 5280845974698170475L;

	/** entity manager. */
	@Inject
	@PersistenceContext(unitName = "Pu_AfricaSaveurs", type = PersistenceContextType.EXTENDED)
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
