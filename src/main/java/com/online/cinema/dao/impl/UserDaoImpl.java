package com.online.cinema.dao.impl;

import com.online.cinema.dao.UserDao;
import com.online.cinema.entity.User;
import com.online.cinema.exceptions.DataProcessingException;
import com.online.cinema.lib.Dao;
import com.online.cinema.util.HibernateUtil;
import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.apache.log4j.Logger;
import org.hibernate.Session;

@Dao
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
    private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

    @Override
    public Optional<User> findByEmail(String email) {
        logger.info("Trying to user by email: " + email);
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
            Root<User> root = query.from(User.class);
            return session.createQuery(query.distinct(true)
                    .where(criteriaBuilder.equal(root.get("email"), email)))
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException(
                    "There was an error retrieving a user with email " + email, e);
        }
    }

    @Override
    public List<User> getAll() {
        return super.getAll(User.class);
    }

    @Override
    public User get(Long id) {
        return super.get(User.class, id);
    }
}
