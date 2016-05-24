package br.com.gauge.dao;

import java.util.List;

import br.com.gauge.entities.interactions;

public interface interactionsDAO {

	/**
	 * List all.
	 *
	 * @return the list
	 */
	public List<interactions> listAll();
	
	/**
	 * save.
	 *
	 * @param p the p
	 */
	public void save (interactions p);
	
	/**
	 * delete.
	 *
	 * @param p the p
	 */
	public void delete(interactions p);
	
	/**
	 * update.
	 *
	 * @param p the p
	 */
	public void update (interactions p);
	
	/**
	 * Count
	 * @param idUser
	 * @return
	 */
	public long Count(long idUser);
	
	/**
	 * 
	 * @param idUser
	 * @return
	 */
	public long CountOthers(long idUser, String brand);

	
}
