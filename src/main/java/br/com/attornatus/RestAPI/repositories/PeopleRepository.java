package br.com.attornatus.RestAPI.repositories;

import br.com.attornatus.RestAPI.models.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Integer> {
}
