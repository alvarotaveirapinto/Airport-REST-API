package com.example.Spring.boot.test.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name ="passenger")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany( mappedBy = "passenger")
    private List<Airport> airport;

}
