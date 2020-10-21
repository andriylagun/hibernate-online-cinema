package com.online.cinema.dao.impl;

import com.online.cinema.dao.GenericDao;
import com.online.cinema.exceptions.DataProcessingException;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {
    private static final Logger logger = Logger.getLogger(GenericDaoImpl.class);
    protected final SessionFactory factory;

    @Autowired
    protected GenericDaoImpl(SessionFactory sessionFactory) {
        this.factory = sessionFactory;
    }

    @Override
    public T add(T element) {
        logger.info("Trying to add entity");
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(element);
            transaction.commit();
            logger.info("Entity successfully added: " + element);
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
        logger.info("Trying to get all entities");
        try (Session session = factory.openSession()) {
            CriteriaQuery<T> criteriaQuery = session.getCriteriaBuilder()
                    .createQuery(clazz);
            criteriaQuery.from(clazz);
            return session.createQuery(criteriaQuery).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Error retrieving content ", e);
        }
    }

    protected T get(Class<T> clazz, Long id) {
        logger.info("Trying to get entity");
        try (Session session = factory.openSession()) {
            return session.get(clazz, id);
        }
    }

    public void update(T entity) {
        logger.info("Trying to update entity");
        Transaction transaction = null;
        Session session = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.update(entity);
            transaction.commit();
            logger.info("Entity was successfully updated");
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
