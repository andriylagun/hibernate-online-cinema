package com.online.cinema.util;

import com.online.cinema.exceptions.DataProcessingException;
import com.online.cinema.model.Movie;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory = initSessionFactory();

    private static SessionFactory initSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Movie.class);
            return configuration.buildSessionFactory();
        } catch (Exception e) {
            throw new DataProcessingException("Error creating session factory", e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
