package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="ticket")
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
    @SequenceGenerator(name = "ticket_seq", sequenceName = "ticket_id_seq", allocationSize = 1)
    private long id;
    @Column(nullable = false,name = "created_at")
    private Timestamp CreatedAt;
    @Column(nullable = false,length = 10,name = "from_planet_id")
    private String fromPlanetId;
    @Column(nullable = false,length = 10,name = "to_planet_id")
    private String toPlanetId;

    @ManyToOne
    @JoinColumn(name = "client_id",nullable = false)
    private Client client;
}
