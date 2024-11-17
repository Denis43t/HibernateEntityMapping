package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Set;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "client")
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_seq")
    @SequenceGenerator(name = "client_seq", sequenceName = "client_id_seq", allocationSize = 1)
    private long id;
    @Column(length = 200)
    private String name;

    @OneToMany(mappedBy="client",fetch = FetchType.EAGER)
    private Set<Ticket> tickets;
}
