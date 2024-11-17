package org.example.service;

import org.example.model.Client;
import org.example.model.Planet;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PlanetCrudService {
    private SessionFactory sessionFactory =
            HibernateUtil.getInstance().getSessionFactory();

    public void save(Planet planet){
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(planet);
            transaction.commit();
        }
    }
    public void delete(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(planet);
            transaction.commit();
        }
    }
    public Planet findById(String id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Planet.class, id);
        }
    }

    public void update(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(planet);
            transaction.commit();
        }
    }
}
