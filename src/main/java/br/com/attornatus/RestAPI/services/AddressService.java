package br.com.attornatus.RestAPI.services;

import br.com.attornatus.RestAPI.Pojos.AddressRequest;
import br.com.attornatus.RestAPI.models.Address;
import br.com.attornatus.RestAPI.models.People;
import br.com.attornatus.RestAPI.repositories.AddressRepository;
import br.com.attornatus.RestAPI.repositories.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PeopleRepository peopleRepository;
    public List<Address> getAddress(){
        return addressRepository.findAll();
    }

    public List<Address> getAddressByPersonID( int id){
        return addressRepository.findAllAddressByPersonID(id);
    }
    public void deleteAddress(int id){
        peopleRepository.deleteById(id);
    }

    public Optional<Address> getAddressByID(int id){
        return addressRepository.findById(id);
    }

    public Address getMainAddressByPersonID(int id){
        return addressRepository.findMainAddressByPersonID(id);
    }

    public Address createAddress(AddressRequest addressRequest, int id) {
        People people = peopleRepository.findPeopleByID(id);
        Address address = new Address();
        address.setStreet(addressRequest.getStreet());
        address.setPostCode(addressRequest.getPostCode());
        address.setNumber(addressRequest.getNumber());
        address.setCity(addressRequest.getCity());
        address.setIsMainAddress(addressRequest.getIsMainAddress());
        address.setPeople(people);
        return addressRepository.save(address);
    }
}
