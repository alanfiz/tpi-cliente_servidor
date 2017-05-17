package dao;

import java.io.Serializable;
import java.util.List;


public interface GenericDao<T, PK extends Serializable>{

	T findById(PK id) throws DaoException;

	List<T> findAll() throws DaoException;

//	List<T> findEntries(int startPosition, int maxResult) throws DaoException;

	T merge(T persistentObject) throws DaoException;

	T persist(T transientObject) throws DaoException;

//	void refresh(T persistentObject) throws DaoException;

	void remove(T persistentObject) throws DaoException;

//	long count() throws DaoException;
	
}
