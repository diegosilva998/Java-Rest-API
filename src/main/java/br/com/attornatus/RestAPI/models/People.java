package br.com.attornatus.RestAPI.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class People implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column(name="NAME",length = 255,nullable = false)
    private String name;
    @Column(name="BIRTH_DATE", length=50, nullable=false, unique=false)
    private Date birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "people")
    private Set<Address> address;
}
