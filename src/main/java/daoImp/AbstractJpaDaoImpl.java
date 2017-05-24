package daoImp;

import dao.DaoException;
import dao.GenericDao;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class AbstractJpaDaoImpl<T, PK extends Serializable> implements
        GenericDao<T, PK> {

	@PersistenceContext
	protected EntityManager entityManager;

	private Class<T> persistentClass;

	public AbstractJpaDaoImpl() {
		ParameterizedType thisType = (ParameterizedType) getClass()
				.getGenericSuperclass();
		persistentClass = (Class<T>) thisType.getActualTypeArguments()[0];
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@Override
	public T findById(PK id) throws DaoException {
		return entityManager.find(getPersistentClass(), id);
	}

	@Override
	public List<T> findAll() throws DaoException {

		TypedQuery<T> typedQuery = this.createTypedQuery();
		return typedQuery.getResultList();

	}

	@Override
	public T merge(T persistentObject) throws DaoException {
		try {
			T mergeEntity = entityManager.merge(persistentObject);
			entityManager.flush();
			return mergeEntity;
		} catch (PersistenceException e) {
			throw new DaoException(e.getMessage());
		} catch (Exception e) {
			throw new DaoException(e.getMessage());
		}
	}

	@Override
	public T persist(T transientObject) throws DaoException {
		try {
			entityManager.persist(transientObject);
			entityManager.flush();
			return transientObject;
		} catch (PersistenceException e) {
			throw new DaoException(e);
		} catch (Exception e) {
			throw new DaoException(e);
		}
	}


	@Override
	public void remove(T persistentObject) throws DaoException {
		try {
			T entity = entityManager.merge(persistentObject);
			entityManager.remove(entity);
			entityManager.flush();
		} catch (IllegalArgumentException e) {
			throw new DaoException(e.getCause());
		} catch (TransactionRequiredException e) {
			throw new DaoException(e.getCause());
		} catch (Exception e) {
			throw new DaoException(e.getCause());
		}
	}

	private TypedQuery<T> createTypedQuery() {
		Class<T> persistentClass = getPersistentClass();
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<T> criteriaQuery = criteriaBuilder
				.createQuery(persistentClass);

		criteriaQuery.from(persistentClass);

		TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);
		return typedQuery;

	}


}
