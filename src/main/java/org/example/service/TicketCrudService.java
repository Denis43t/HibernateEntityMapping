package org.example.service;

import org.example.model.Client;
import org.example.model.Ticket;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TicketCrudService {
    private final SessionFactory sessionFactory =
            HibernateUtil.getInstance().getSessionFactory();
    private final ClientCrudService clientCrudService=new ClientCrudService();
    private final PlanetCrudService planetCrudService=new PlanetCrudService();

    public void save(Ticket ticket){
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            try {
                clientCrudService.findById(ticket.getClient().getId());
            } catch (Exception e) {
                throw new RuntimeException("Client is not existing or null");
            }
            try {
                planetCrudService.findById(ticket.getToPlanetId());
                planetCrudService.findById(ticket.getFromPlanetId());
            } catch (Exception e) {
                throw new RuntimeException("Planet is not existing or null");
            }

            session.save(ticket);
            transaction.commit();
        }
    }
    public void delete(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(ticket);
            transaction.commit();
        }
    }

    public Ticket findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    public void update(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(ticket);
            transaction.commit();
        }
    }
}
