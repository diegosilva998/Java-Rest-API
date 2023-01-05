package br.com.attornatus.RestAPI.controllers;

import br.com.attornatus.RestAPI.Pojos.AddressRequest;
import br.com.attornatus.RestAPI.models.Address;
import br.com.attornatus.RestAPI.models.People;
import br.com.attornatus.RestAPI.services.AddressService;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/isMain/{id}")
    public Address getMainAddressByPersonID(@PathVariable("id") int id){
        return addressService.getMainAddressByPersonID(id);
    }

    @PostMapping("/{id}")
    public Address createAddress(@RequestBody AddressRequest addressRequest, @PathVariable("id") int id){
        System.out.println(addressRequest);
        return addressService.createAddress(addressRequest, id);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable("id") int id){
        addressService.deleteAddress(id);
    }

}
