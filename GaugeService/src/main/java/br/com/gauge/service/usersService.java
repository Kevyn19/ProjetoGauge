package br.com.gauge.service;

import java.util.List;

import br.com.gauge.dao.DAOFactory;
import br.com.gauge.dao.usersDAO;
import br.com.gauge.entities.users;
import br.com.gauge.hibernate.PersistenceContext;

public class usersService {
	
	public List<users> listAll() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		usersDAO dao = DAOFactory.getusersDAO(pc);
		List<users> result = dao.listAll();
		pc.commitAndClose();
		return result;
	}
	
	public users save(users p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		usersDAO dao = DAOFactory.getusersDAO(pc);
		dao.save(p);
		pc.commitAndClose();
		return p;
	}
	
	public users update(users p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		usersDAO dao = DAOFactory.getusersDAO(pc);
		dao.update(p);
		pc.commitAndClose();
		return p;
	}
	
	public users delete(users p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		usersDAO dao = DAOFactory.getusersDAO(pc);
		dao.delete(p);
		pc.commitAndClose();
		return p;
	}
	
	public List<users> listarkey(long key) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		usersDAO dao = DAOFactory.getusersDAO(pc);
		List<users> result = dao.listarKey(key);
		pc.commitAndClose();
		return result;	
	}

}
