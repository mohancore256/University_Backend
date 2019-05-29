package com.university.studentmicroservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.studentmicroservice.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
