package br.com.attornatus.RestAPI.services;

import br.com.attornatus.RestAPI.models.People;
import br.com.attornatus.RestAPI.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;

    public List<People> getPeople(){
        return peopleRepository.findAll();
    }

    public Optional<People> getPeopleByID(int id){
        return peopleRepository.findById(id);
    }

    public People createPeople(People people){
        return peopleRepository.save(people);
    }

    public void updatePeople(People people){
        peopleRepository.save(people);
    }
    public void deletePeople(int id){
        peopleRepository.deleteById(id);
    }

}
