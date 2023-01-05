package br.com.attornatus.RestAPI.services;

import br.com.attornatus.RestAPI.models.Address;
import br.com.attornatus.RestAPI.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAddress(){
        return addressRepository.findAll();
    }

    public List<Address> getAddressByPersonID( int id){
        return addressRepository.findAllAddressByPersonID(id);
    }
}
