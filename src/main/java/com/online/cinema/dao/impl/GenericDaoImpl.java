package com.online.cinema.dao.impl;

import com.online.cinema.dao.GenericDao;
import com.online.cinema.exceptions.DataProcessingException;
import com.online.cinema.util.HibernateUtil;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {
    protected final SessionFactory factory;

    protected GenericDaoImpl() {
        this.factory = HibernateUtil.getSessionFactory();
    }

    @Override
    public T add(T element) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(element);
            transaction.commit();
            return element;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't insert entity " + element.toString(), e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    protected List<T> getAll(Class<T> clazz) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaQuery<T> criteriaQuery = session.getCriteriaBuilder()
                    .createQuery(clazz);
            criteriaQuery.from(clazz);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving content ", e);
        }
    }

    protected T get(Class<T> clazz, Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(clazz, id);
        }
    }

    public void update(T entity) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Failed to update the entity - "
                    + entity, exception);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
