package br.com.gauge.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.gauge.dao.brandsDAO;
import br.com.gauge.entities.brands;
import br.com.gauge.hibernate.impl.AbstractHibernateDAO;
import br.com.gauge.hibernate.impl.HibernatePersistenceContext;

public class brandsDAOImpl extends AbstractHibernateDAO implements brandsDAO{
	
	public brandsDAOImpl(HibernatePersistenceContext persistenceContext) {
		super(persistenceContext);
	}
	

	public List<brands> listAll() {
		Criteria criteria = getSession().createCriteria(brands.class);
		List<brands> result = criteria.list();
		
		return result;
	}

	public void save(brands p) {
		synchronized (brandsDAOImpl.class) {
			getSession().persist(p);
			getSession().flush();
		}
		
	}

	public void delete(brands p) {
		getSession().delete(p);
		getSession().flush();
		
	}

	public void update(brands p) {
		getSession().merge(p);
		getSession().flush();
		
	}

	public List<brands> listarKey(long key) {
		Criteria criteria = getSession().createCriteria(brands.class);
		criteria.add(Restrictions.eq("idbrands", key));
		List<brands> result = criteria.list();
		return result;
	}

}
