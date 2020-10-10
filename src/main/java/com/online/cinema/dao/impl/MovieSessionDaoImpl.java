package com.online.cinema.dao.impl;

import com.online.cinema.dao.MovieSessionDao;
import com.online.cinema.entity.MovieSession;
import com.online.cinema.exceptions.DataProcessingException;
import com.online.cinema.lib.Dao;
import com.online.cinema.util.HibernateUtil;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

@Dao
public class MovieSessionDaoImpl extends GenericDaoImpl<MovieSession>
        implements MovieSessionDao {

    @Override
    public List<MovieSession> getAll() {
        return super.getAll(MovieSession.class);
    }

    @Override
    public MovieSession get(Long id) {
        return super.get(MovieSession.class, id);
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<MovieSession> query
                    = criteriaBuilder.createQuery(MovieSession.class);
            Root<MovieSession> root = query.from(MovieSession.class);
            root.fetch("movie", JoinType.LEFT);
            root.fetch("cinemaHall", JoinType.INNER);
            Predicate idPredicate
                    = criteriaBuilder.equal(root.get("movie"), movieId);
            Predicate datePredicate = criteriaBuilder.between(
                    root.get("showTime"), date.atStartOfDay(), date.atTime(LocalTime.MAX));
            return session.createQuery(query.where(idPredicate, datePredicate)).getResultList();
        } catch (Exception e) {
            throw new DataProcessingException(
                    "There was an error retrieving available sessions for movie with id "
                            + movieId + " and date " + date.toString(), e);
        }
    }
}
