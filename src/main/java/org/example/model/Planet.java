package org.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "planet")
@Data
public class Planet {
    @Id
    private String id;
    @Column(length = 500)
    private String name;
}
