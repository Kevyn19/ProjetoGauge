package br.com.gauge.dao;

import java.util.List;

import br.com.gauge.entities.users;

public interface usersDAO {
	
	/**
	 * List all.
	 *
	 * @return the list
	 */
	public List<users> listAll();
	
	/**
	 * save.
	 *
	 * @param p the p
	 */
	public void save (users p);
	
	/**
	 * delete.
	 *
	 * @param p the p
	 */
	public void delete(users p);
	
	/**
	 * update.
	 *
	 * @param p the p
	 */
	public void update (users p);
	
	/**
	 * List key.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<users> listarKey(long key);

}
