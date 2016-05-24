package br.com.gauge.dao;

import br.com.gauge.dao.impl.*;
import br.com.gauge.hibernate.PersistenceContext;
import br.com.gauge.hibernate.impl.HibernatePersistenceContext;

public class DAOFactory {
	
	
	
	public static PersistenceContext createPersistenceContext() {
		return new HibernatePersistenceContext();
	}
	
	public static brandsDAO getbrandsDAO(PersistenceContext persistenceContext) {
		return new brandsDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}
	
	public static usersDAO getusersDAO(PersistenceContext persistenceContext) {
		return new usersDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}
	
	public static interactionsDAO getinteractionsDAO(PersistenceContext persistenceContext) {
		return new interactionsDAOImpl(
				(HibernatePersistenceContext) persistenceContext);
	}
	
	
}
