package br.com.attornatus.RestAPI.controllers;

import br.com.attornatus.RestAPI.models.Address;
import br.com.attornatus.RestAPI.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    public AddressService addressService;

    @GetMapping
    public List<Address> getAddress(){
        return addressService.getAddress();
    }

    @GetMapping("/{id}")
    public List<Address> getAddressByPersonID(@PathVariable("id") int id){
        return addressService.getAddressByPersonID(id);
    }

}
