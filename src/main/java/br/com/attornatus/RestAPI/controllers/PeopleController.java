package br.com.attornatus.RestAPI.controllers;

import br.com.attornatus.RestAPI.models.People;
import br.com.attornatus.RestAPI.services.PeopleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping({"/people"})
public class PeopleController {

    @Autowired
    private PeopleService peopleService;
    @Autowired
    private ModelMapper modelMapper;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public People createPeople(@RequestBody People people){
        return peopleService.createPeople(people);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<People> getPeople(){
        return peopleService.getPeople();
    }

    @GetMapping("/{id}")
    public People getPeopleByID(@PathVariable("id") int id){
        return peopleService.getPeopleByID(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Pessoa não encontrada"));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePeople(@PathVariable("id") int id){
        peopleService.getPeopleByID(id)
                .map(people -> {
                    peopleService.deletePeople(id);
                    return Void.TYPE;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Pessoa não encontrada"));

    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePutPeople(@RequestBody People people, @PathVariable("id") int id){
        peopleService.getPeopleByID(id)
                .map(peopleBase -> {
                    people.setPeopleID(peopleBase.getPeopleID());
                    peopleService.updatePeople(people);
                    return Void.TYPE;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Pessoa não encontrada"));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePatchPeople(@RequestBody People people, @PathVariable("id") int id){
        peopleService.getPeopleByID(id)
                .map(peopleBase -> {
                    people.setPeopleID(peopleBase.getPeopleID());
                    modelMapper.map(people, peopleBase);
                    peopleService.updatePeople(peopleBase);
                    return Void.TYPE;
                }).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Pessoa não encontrada"));
    }

}

