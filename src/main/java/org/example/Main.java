package org.example;

import org.example.model.Client;
import org.example.model.Planet;
import org.example.model.Ticket;
import org.example.service.ClientCrudService;
import org.example.service.PlanetCrudService;
import org.example.service.TicketCrudService;
import org.example.util.HibernateUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        Client client = Client.builder()
                .id(11l)
                .name("suu2")
                .build();
//        Client client2 = Client.builder()
//                .name("suu")
//                .build();
//        ClientCrudService crudService = new ClientCrudService();
//        crudService.save(client);
////        crudService.delete(client);
//        Client client1 = crudService.findById(11L);
//        System.out.println(client1);
//        crudService.update(client);


//        Planet planet = Planet.builder()
//                .id("CARS")
//                .name("Carus")
//                .build();
//        PlanetCrudService planetCrudService = new PlanetCrudService();
//        planetCrudService.save(planet);
////        planetCrudService.delete(planet);

        TicketCrudService ticketCrudService = new TicketCrudService();
        Ticket ticket=Ticket.builder()
                .fromPlanetId("marsh")
                .toPlanetId("VENUS")
                .CreatedAt(Timestamp.valueOf("2024-11-16 22:15:07.217517"))
                .client(client)
                .build();
        ticketCrudService.save(ticket);
    }
}