package br.com.attornatus.RestAPI.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "ADDRESS_ID")
    private int addressID;
    @Column(name = "STREET",length = 255,nullable = false)
    private String street;
    @Column(name = "POST_CODE",length = 255,nullable = false)
    private String postCode;
    @Column(name = "NUMBER",length = 255,nullable = false)
    private String number;
    @Column(name = "CITY",length = 255,nullable = false)
    private String city;

    @Column(name="IS_MAIN_ADDRESS")
    private Boolean isMainAddress;

    @ManyToOne
    @JoinColumn(name="people_id", nullable=false)
    @JsonIgnore
    private People people;

}
