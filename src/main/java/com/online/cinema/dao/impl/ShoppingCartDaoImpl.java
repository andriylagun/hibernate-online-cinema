package com.online.cinema.dao.impl;

import com.online.cinema.dao.ShoppingCartDao;
import com.online.cinema.entity.ShoppingCart;
import com.online.cinema.entity.User;
import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingCartDaoImpl extends GenericDaoImpl<ShoppingCart> implements ShoppingCartDao {
    private static final Logger logger = Logger.getLogger(ShoppingCartDaoImpl.class);

    protected ShoppingCartDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public List<ShoppingCart> getAll() {
        logger.info("Trying to get all shopping carts");
        try (Session session = factory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<ShoppingCart> getAllShoppingCartsQuery =
                    criteriaBuilder.createQuery(ShoppingCart.class);
            Root<ShoppingCart> root = getAllShoppingCartsQuery.from(ShoppingCart.class);
            root.fetch("tickets", JoinType.LEFT);
            root.fetch("user", JoinType.LEFT);
            getAllShoppingCartsQuery.select(root);
            return session.createQuery(getAllShoppingCartsQuery).getResultList();
        }
    }

    @Override
    public ShoppingCart get(Long id) {
        return super.get(ShoppingCart.class, id);
    }

    @Override
    public Optional<ShoppingCart> getByUser(User user) {
        logger.info("Trying to get shopping cart of user: " + user);
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM ShoppingCart sc left join fetch sc.tickets "
                    + "join fetch sc.user WHERE sc.user = :user", ShoppingCart.class)
                    .setParameter("user", user)
                    .uniqueResultOptional();
        }
    }
}
