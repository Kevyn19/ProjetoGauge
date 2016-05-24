package br.com.gauge.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


import br.com.gauge.dao.interactionsDAO;
import br.com.gauge.entities.interactions;
import br.com.gauge.hibernate.impl.AbstractHibernateDAO;
import br.com.gauge.hibernate.impl.HibernatePersistenceContext;

public class interactionsDAOImpl extends AbstractHibernateDAO implements interactionsDAO {

	public interactionsDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
	}

	public List<interactions> listAll() {
		Criteria criteria = getSession().createCriteria(interactions.class);
		List<interactions> result = criteria.list();
		
		return result;
	}

	public void save(interactions p) {
		synchronized (interactionsDAOImpl.class) {
			getSession().persist(p);
			getSession().flush();
		}
	}

	public void delete(interactions p) {
		getSession().delete(p);
		getSession().flush();
	}

	public void update(interactions p) {
		getSession().merge(p);
		getSession().flush();
		
	}
	
	public long Count(long idUser){
		Criteria criteria = getSession().createCriteria(interactions.class);
		criteria.createAlias("users","users");
		criteria.add(Restrictions.eq("users.idusers", idUser));
		criteria.setProjection(Projections.count("idinteractions"));
		long result = (Long)criteria.list().get(0);
		return result;
	}
	
	
	public long CountOthers(long idUser, String brand){
		Criteria criteria = getSession().createCriteria(interactions.class);
		criteria.createAlias("users","users");
		criteria.add(Restrictions.eq("users.idusers", idUser));
		criteria.createAlias("brands","brands");
		criteria.add(Restrictions.eq("brands.name",  brand));
		criteria.setProjection(Projections.count("idinteractions"));
		long result = (Long)criteria.list().get(0);
		return result;
	}

	
}
