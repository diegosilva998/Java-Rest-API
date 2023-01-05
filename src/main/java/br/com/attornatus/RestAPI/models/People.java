package br.com.attornatus.RestAPI.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class People implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "PEOPLE_ID")
    private int peopleID;
    @Column(name="NAME",length = 255)
    private String name;
    @Column(name="BIRTH_DATE", length=50, unique=false)
    private Date birthDate;

    @OneToMany
    @Column
    private List<Address> addresses;

}
