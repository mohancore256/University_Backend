package com.university.studentmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.university.studentmicroservice.model.Address;
import com.university.studentmicroservice.repository.AddressRepository;

import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    public AddressRepository addressRepository;

    public Address addAddress(Address address){
        return addressRepository.save(address);
    }

    public Optional<Address> getAddress(Long addressId){
        return addressRepository.findById(addressId);
    }

    public void deleteAddress(Long addressId){
        addressRepository.deleteById(addressId);
    }

    public Optional<Address> updateAddress(Address address){
        Optional<Address> addressFound = addressRepository.findById(address.getAddressId());
        return addressFound;
    }
}
