package dacstpi.dao;

import java.io.Serializable;
import java.util.List;


public interface GenericDao<T, PK extends Serializable>{

	T findById(PK id) throws DaoException;

	List<T> findAll() throws DaoException;

	T merge(T persistentObject) throws DaoException;

	T persist(T transientObject) throws DaoException;

	void remove(T persistentObject) throws DaoException;

}
