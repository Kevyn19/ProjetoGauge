package br.com.gauge.dao;

import java.util.List;

import br.com.gauge.entities.brands;

public interface brandsDAO {
	
	/**
	 * List all.
	 *
	 * @return the list
	 */
	public List<brands> listAll();
	
	/**
	 * save.
	 *
	 * @param p the p
	 */
	public void save (brands p);
	
	/**
	 * delete.
	 *
	 * @param p the p
	 */
	public void delete(brands p);
	
	/**
	 * update.
	 *
	 * @param p the p
	 */
	public void update (brands p);
	
	/**
	 * List key.
	 *
	 * @param key the key
	 * @return the list
	 */
	public List<brands> listarKey(long key);

}
