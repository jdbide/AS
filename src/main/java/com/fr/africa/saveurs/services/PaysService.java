package com.fr.africa.saveurs.services;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.Query;

import com.fr.africa.saveurs.constantes.Constantes;
import com.fr.africa.saveurs.entities.Pays;
import com.fr.africa.saveurs.entities.User;

@RequestScoped
public class PaysService extends AService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private GenericService genericService;

	public PaysService() {
	}
	
	public List<Pays> getAll() {
		return (List<Pays>) genericService.getAll(Pays.class);		
	}

	public Pays save(Pays userEntity) {

		try {
			this.entityManager.getTransaction().begin();
			this.entityManager.persist(userEntity);
			this.entityManager.flush();
			this.entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			this.entityManager.getTransaction().rollback();
			throw ex;
		}
		return userEntity;
	}

	public void update(Pays userEntity) {
		try {
			this.entityManager.getTransaction().begin();
			this.entityManager.merge(userEntity);
			this.entityManager.flush();
			this.entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.entityManager.getTransaction().rollback();
			throw e;
		}
	}

	public int deleteById(int id) {
		int deleteEntity = 0;
		try {
			this.entityManager.getTransaction().begin();
			deleteEntity = this.entityManager.createNativeQuery(Constantes.DELETE_USER).setParameter(1, id)
					.executeUpdate();
			this.entityManager.getTransaction().commit();

			return deleteEntity;
		} catch (Exception e) {
			e.printStackTrace();
			this.entityManager.getTransaction().rollback();
			throw e;
		}
	}


	public User getAUser(long id) {
		Query requete = this.entityManager.createNamedQuery(User.QUERY_GET_BY_ID);
		requete.setParameter("idUser", id);
		User res = null;
		try {
			res = (User) requete.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return res;
	}
}
