package br.com.gauge.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import br.com.gauge.dao.usersDAO;
import br.com.gauge.entities.users;
import br.com.gauge.hibernate.impl.AbstractHibernateDAO;
import br.com.gauge.hibernate.impl.HibernatePersistenceContext;

public class usersDAOImpl extends AbstractHibernateDAO implements usersDAO{
	
	public usersDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
	}

	public List<users> listAll() {
		Criteria criteria = getSession().createCriteria(users.class);
		//criteria.setProjection(Projections.distinct(Projections.property("email")));
		List<users> result = criteria.list();
		
		return result;
	}

	public void save(users p) {
		synchronized (usersDAOImpl.class) {
			getSession().persist(p);
			getSession().flush();
		}
		
	}

	public void delete(users p) {
		getSession().delete(p);
		getSession().flush();
		
	}

	public void update(users p) {
		getSession().merge(p);
		getSession().flush();
		
	}

	public List<users> listarKey(long key) {
		Criteria criteria = getSession().createCriteria(users.class);
		criteria.add(Restrictions.eq("idusers", key));
		List<users> result = criteria.list();
		return result;
	}
	
	

}
