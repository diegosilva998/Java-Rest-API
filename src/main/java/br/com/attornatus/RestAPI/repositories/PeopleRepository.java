package br.com.attornatus.RestAPI.repositories;

import br.com.attornatus.RestAPI.models.Address;
import br.com.attornatus.RestAPI.models.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, Integer> {
    @Query(value = "SELECT p FROM People p WHERE p.id = :id")
    People findPeopleByID(@Param("id") int id);
}
