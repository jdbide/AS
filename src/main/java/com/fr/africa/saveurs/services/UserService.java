package com.fr.africa.saveurs.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.Query;

import com.fr.africa.saveurs.constantes.Constantes;
import com.fr.africa.saveurs.model.UserEntity;

@RequestScoped
public class UserService extends AService implements Serializable {

	private static final long serialVersionUID = 1L;

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	public UserEntity save(UserEntity userEntity) {
		try {
			this.getEntityManager().getTransaction().begin();
			this.getEntityManager().persist(userEntity);
			this.getEntityManager().flush();
			this.getEntityManager().getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			this.getEntityManager().getTransaction().rollback();
			throw ex;
		}
		return userEntity;
	}

	public void update(UserEntity userEntity) {
		try {
			this.getEntityManager().getTransaction().begin();
			this.getEntityManager().merge(userEntity);
			this.getEntityManager().flush();
			this.getEntityManager().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			this.getEntityManager().getTransaction().rollback();
			throw e;
		}
	}

	public int deleteById(int id) {
		int deleteEntity = 0;
		try {
			this.getEntityManager().getTransaction().begin();
			deleteEntity = this.getEntityManager().createNativeQuery(Constantes.DELETE_USER).setParameter(1, id)
					.executeUpdate();
			this.getEntityManager().getTransaction().commit();

			return deleteEntity;
		} catch (Exception e) {
			e.printStackTrace();
			this.getEntityManager().getTransaction().rollback();
			throw e;
		}
	}

	public List<UserEntity> getAllUsers(int idCompagnieEnvironnement) {
		Query requete = this.getEntityManager().createNamedQuery(Constantes.GET_ALL_USERS);
		List<UserEntity> res = null;
		try {
			res = ((ArrayList<UserEntity>) requete.getResultList());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return res;
	}
}
