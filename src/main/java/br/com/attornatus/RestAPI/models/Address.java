package br.com.attornatus.RestAPI.models;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "STREET",length = 255,nullable = false)
    private String street;
    @Column(name = "POST_CODE",length = 255,nullable = false)
    private String postCode;
    @Column(name = "NUMBER",length = 255,nullable = false)
    private String number;
    @Column(name = "CITY",length = 255,nullable = false)
    private String city;

    @ManyToOne()
    @JoinColumn(name = "person_id", nullable = false)
    private People people;
}
