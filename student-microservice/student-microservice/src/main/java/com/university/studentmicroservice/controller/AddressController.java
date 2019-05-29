package com.university.studentmicroservice.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.university.studentmicroservice.model.Address;
import com.university.studentmicroservice.service.AddressService;

import java.util.Optional;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

    @Autowired
    public AddressService addressService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> createAddress(@RequestBody Address address){
        ModelMap map = new ModelMap();
        ResponseEntity<?> response;
        Address addressResponse = addressService.addAddress(address);
        if (addressResponse != null && addressResponse.getAddressId() > 0){
            map.put("Address saves", addressResponse);
            response = new ResponseEntity<>(map, HttpStatus.OK);
        }
        else{
            map.put("Address Not saved ", "Please check the input");
            response = new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        return response;

    }

    @GetMapping(value = "/get/{addressId}")
    public ResponseEntity<?> readAddress(@PathVariable Long addressId){
        ModelMap map = new ModelMap();
        ResponseEntity<?> response;
        Optional addressResponse = addressService.getAddress(addressId);
        if(addressResponse != null ){
            map.put("Address Requested", addressResponse);
            response = new ResponseEntity<>(map, HttpStatus.OK);
        }
        else{
            map.put("Response  ", "Please check the input");
            response = new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}

