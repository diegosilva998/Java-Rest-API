package br.com.attornatus.RestAPI.repositories;

import br.com.attornatus.RestAPI.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {

    @Query(value = "SELECT a FROM Address a WHERE a.people.id = :id")
    List<Address> findAllAddressByPersonID(@Param("id") int id);

    @Query(value = "SELECT a FROM Address a WHERE a.people.id = :id AND a.isMainAddress = true")
    Address findMainAddressByPersonID(@Param("id") int id);
}
