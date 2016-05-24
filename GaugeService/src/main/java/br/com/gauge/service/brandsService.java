package br.com.gauge.service;

import java.util.List;

import br.com.gauge.dao.DAOFactory;
import br.com.gauge.dao.brandsDAO;
import br.com.gauge.entities.brands;
import br.com.gauge.hibernate.PersistenceContext;

public class brandsService {
	
	public List<brands> listAll() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		brandsDAO dao = DAOFactory.getbrandsDAO(pc);
		List<brands> result = dao.listAll();
		pc.commitAndClose();
		return result;
	}
	
	public brands save(brands p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		brandsDAO dao = DAOFactory.getbrandsDAO(pc);
		dao.save(p);
		pc.commitAndClose();
		return p;
	}
	
	public brands update(brands p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		brandsDAO dao = DAOFactory.getbrandsDAO(pc);
		dao.update(p);
		pc.commitAndClose();
		return p;
	}
	
	public brands delete(brands p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		brandsDAO dao = DAOFactory.getbrandsDAO(pc);
		dao.delete(p);
		pc.commitAndClose();
		return p;
	}
	
	public List<brands> listarkey(long key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		brandsDAO dao = DAOFactory.getbrandsDAO(pc);
		List<brands> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;	
	}

}
