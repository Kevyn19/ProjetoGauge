package br.com.gauge.service;

import java.util.List;

import br.com.gauge.dao.DAOFactory;
import br.com.gauge.dao.interactionsDAO;
import br.com.gauge.entities.interactions;
import br.com.gauge.hibernate.PersistenceContext;

public class interactionsService {
	
	public List<interactions> listAll() {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		interactionsDAO dao = DAOFactory.getinteractionsDAO(pc);
		List<interactions> result = dao.listAll();
		pc.commitAndClose();
		return result;
	}
	
	public interactions save(interactions p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		interactionsDAO dao = DAOFactory.getinteractionsDAO(pc);
		dao.save(p);
		pc.commitAndClose();
		return p;
	}
	
	public interactions update(interactions p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		interactionsDAO dao = DAOFactory.getinteractionsDAO(pc);
		dao.update(p);
		pc.commitAndClose();
		return p;
	}
	
	public interactions delete(interactions p) {
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		interactionsDAO dao = DAOFactory.getinteractionsDAO(pc);
		dao.delete(p);
		pc.commitAndClose();
		return p;
	}
	
	public long Count(long idUser){
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		interactionsDAO dao = DAOFactory.getinteractionsDAO(pc);
		long result = dao.Count(idUser);
		pc.commitAndClose();
		return result;
	}
	
	public long CountOthers(long idUser, String brand){
		PersistenceContext pc = DAOFactory.createPersistenceContext();
		interactionsDAO dao = DAOFactory.getinteractionsDAO(pc);
		long result = dao.CountOthers(idUser, brand);
		pc.commitAndClose();
		return result;
	}

}
