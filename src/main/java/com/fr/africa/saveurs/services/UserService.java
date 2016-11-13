package com.fr.africa.saveurs.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.fr.africa.saveurs.constantes.Constantes;
import com.fr.africa.saveurs.model.UserEntity;

public class UserService extends AService implements Serializable {

	private static final long serialVersionUID = 1L;
	private EntityManager entityManager;

	public UserService() {
		entityManager = Constantes.getEntitymanager();
	}

	public UserEntity save(UserEntity userEntity) {

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

	public void update(UserEntity userEntity) {
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

	public List<UserEntity> getAllUsers() {
		Query requete = this.entityManager.createNamedQuery(UserEntity.QUERY_GET_ALL);
		List<UserEntity> res = null;
		try {
			res = (ArrayList<UserEntity>) requete.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return res;
	}

	public UserEntity getAUser(long id) {
		Query requete = this.entityManager.createNamedQuery(UserEntity.QUERY_GET_BY_ID);
		requete.setParameter("idUser", id);
		UserEntity res = null;
		try {
			res = (UserEntity) requete.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return res;
	}
}
