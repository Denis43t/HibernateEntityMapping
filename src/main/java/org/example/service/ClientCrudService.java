package org.example.service;

import org.example.model.Client;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ClientCrudService {
    private SessionFactory sessionFactory =
            HibernateUtil.getInstance().getSessionFactory();

    public void save(Client client){
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }
    }
    public void delete(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
        }
    }

    public Client findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Client.class, id);
        }
    }

    public void update(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        }
    }
}
