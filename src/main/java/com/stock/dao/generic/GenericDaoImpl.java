package com.stock.dao.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.persistence.Query;
import javax.transaction.Transactional;
@Transactional
public class GenericDaoImpl<E> implements IGenericDaoInterface<E> {
	@PersistenceContext
	protected EntityManager em;
	private Class<E> type;
	public GenericDaoImpl() {
		super();
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class<E>) pt.getActualTypeArguments()[0];

	}

	@Override
	public E save(E entity) {
		// TODO Auto-generated method stub
		em.persist(entity);
		return entity;
	}

	@Override
	public E update(E entity) {
		// TODO Auto-generated method stub
		return em.merge(entity);
	}

	@Override
	public List selectAll() {
		Query query = em.createQuery("select t from " + type.getSimpleName() + " t");
		return query.getResultList();
	}

	@Override
	public List<E> selectAll(String sortField, String sort) {
		Query query = em.createQuery("select t from " + type.getSimpleName() + " t order by " + sortField + " " + sort);
		return query.getResultList();
	}

	@Override
	public E getById(Long id) {
		// TODO Auto-generated method stub
		return em.find(type, id);
	}

	@Override
	public void remove(Long id) {
		E tab = em.getReference(type, id);
		em.remove(tab);
		// TODO Auto-generated method stub

	}

	@Override
	public E findOne(String paranName, Object paramValue) {
		Query query = em.createQuery("select t from " + type.getSimpleName() + " t order by " + paranName + "=: x");
		query.setParameter(paranName, paramValue);
		return query.getResultList().size() > 0 ? (E) query.getResultList().get(0) : null;
	}

	@Override
	public E findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		if (paramNames != paramValues)
			return null;
		String queryStr = "select t from" + type.getSimpleName() + " t where ";
		for (int i = 0; i < paramNames.length; i++) {
			queryStr += "e." + paramNames[i] + "=:x" + i;
			if (i < paramNames.length)
				queryStr += " and";
		}
		Query query = em.createQuery(queryStr);
		for (int i = 0; i < paramNames.length; i++) {
			query.setParameter("x" + i, paramValues[i]);
		}
		return query.getResultList().size() > 0 ? (E) query.getResultList().get(0) : null;
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		Query query = em.createQuery("select t from" + type.getSimpleName() + " t where " + paramName + "=:x");
		query.setParameter(paramName, paramValue);
		return query.getResultList().size() > 0 ? ((Long) query.getSingleResult()).intValue() : 0;
	}

}
