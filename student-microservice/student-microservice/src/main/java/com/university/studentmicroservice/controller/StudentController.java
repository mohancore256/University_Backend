package com.university.studentmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.university.studentmicroservice.model.Student;
import com.university.studentmicroservice.service.StudentService;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    public StudentService studentService;

    @PostMapping(value = "/create")
    public ResponseEntity<?> createStudent(@RequestBody Student studentObj, Model model, BindingResult result) {
        ResponseEntity<?> response;
        ModelMap map = new ModelMap();
        Student studentResponse = studentService.addStudent(studentObj);
        if (studentResponse != null && studentResponse.getStudentID() > 0) {
            map.put("Student Save", studentResponse);
            response = new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.put("Student Save", studentResponse);
            response = new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }
        return response;

    }

    @GetMapping(value = "/get/{studentID}")
    public ResponseEntity<?> readStudent(@PathVariable Long studentID) {
        ResponseEntity<?> response;
        ModelMap map = new ModelMap();
        Optional studentResponse = studentService.getStudent(studentID);

        if (studentResponse != null) {
            map.put("Student data requested ", studentResponse);
            response = new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.put("Student data requested ", studentResponse);
            response = new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }

        return response;
    }

    @DeleteMapping(value = "/delete/{studentID}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long studentID) {
        ModelMap map = new ModelMap();
        studentService.deleteStudent(studentID);
        map.put("Student Deleted Succesfully", "STUDENTID DELETED WAS " + studentID);
        ResponseEntity<?> response = new ResponseEntity<>(map, HttpStatus.OK);
        return response;
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> updateStudent(@RequestBody Student student) {
        ModelMap map = new ModelMap();
        ResponseEntity<?> response;
        Student studentResponse = studentService.updateStudent(student);

        if (studentResponse != null && studentResponse.getStudentID() > 0) {
            map.put("Student got updated", studentResponse);
            response = new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            map.put("Student got created ", studentResponse);
            response = new ResponseEntity<>(map, HttpStatus.OK);
        }
        return response;
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<?>  getAllStudents(){
        ModelMap map = new ModelMap();
        ResponseEntity<?> response = null;
        List<Student> studendResponse = studentService.getAllStudent();
        if (studendResponse != null){
            map.put("All student data",studendResponse);
            response = new ResponseEntity<>(map, HttpStatus.OK);
        }
        return response;
    }


}
