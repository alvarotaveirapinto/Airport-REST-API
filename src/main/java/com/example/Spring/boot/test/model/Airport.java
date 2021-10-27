package com.example.Spring.boot.test.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "airport_passengers",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "airport_id"))
    public List<Passenger> passengers;

    @ManyToOne
    @JoinColumn(name = "id_passenger")
    private Passenger passenger;
}


