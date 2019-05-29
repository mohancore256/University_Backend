package com.university.studentmicroservice.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STUDENT_ID", unique = true, nullable = false)
    private Long studentID;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "AGE")
    private String age;

    @Column(name = "DOB")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date DOB;

    @Column(name = "USERBNAME")
    private String  userName;

    @Column(name = "PASSWORD")
    private String password;
    
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Address> address;


    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Payment> payments;


	public Long getStudentID() {
		return studentID;
	}


	public void setStudentID(Long studentID) {
		this.studentID = studentID;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public Date getDOB() {
		return DOB;
	}


	public void setDOB(Date dOB) {
		DOB = dOB;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Set<Address> getAddress() {
		return address;
	}


	public void setAddress(Set<Address> address) {
		this.address = address;
	}


	public Set<Payment> getPayments() {
		return payments;
	}


	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}
    
    
}
