package com.university.studentmicroservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.university.studentmicroservice.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
