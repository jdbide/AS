package com.fr.africa.saveurs.services;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.Query;

@RequestScoped
public class GenericService extends AService {

	public GenericService() {
		// TODO Auto-generated constructor stub
	}
	
	   public List<?> getByAttribut(Class<?> entity, String nameQuery, String nameAttribut, Object objetInput) {
		      Query query = this.getEntityManager()
		            .createNamedQuery(entity.getSimpleName() + "." + nameQuery);
		      query.setParameter(nameAttribut, objetInput);
		      return query.getResultList();
		   }
	   
	   public List<?> getAll(Class<?> entity) {
		      Query query = this.getEntityManager()
		            .createNamedQuery(entity.getSimpleName() + ".findAll");
		      return query.getResultList();
		   }
	
}
