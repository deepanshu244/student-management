
package com.deepanshu.student_management.controller;

import com.deepanshu.student_management.model.Student;
import com.deepanshu.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<Student> add(@RequestBody Student student) {
        Student savedStudent = studentService.add(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> get(@PathVariable int id) {
        Optional<Student> student = studentService.get(id);
        return student.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> updatedStudent = studentService.update(id, student);
        return updatedStudent.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        if (studentService.delete(id)) {
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }
}



























//package com.deepanshu.student_management.controller;
//
//import com.deepanshu.student_management.model.Student;
//import com.deepanshu.student_management.repositiory.StudentRepo;
//import com.deepanshu.student_management.service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatusCode;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/student")
//public class StudentController {
//    @Autowired
//    private StudentService studentService;
//    private StudentRepo studentRepo;
//
//    @PostMapping("/add")
//    public ResponseEntity<String> add(@RequestBody Student student){
//        return new ResponseEntity<>(studentService.add(student), HttpStatus.CREATED);
//    }
//
//    @GetMapping("/get")
//    public ResponseEntity<String> get(@RequestParam int id){
//        String s=studentService.get(id);
//        if(s.equalsIgnoreCase("Found")){
//            return new ResponseEntity<>("Found", HttpStatus.OK);
//
//        }
//        else {
//            return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @PostMapping("/update")
//    public ResponseEntity<String> update(@RequestParam int id, @RequestBody Student student){
//        String s=studentService.update(id,student);
//        if(s.equalsIgnoreCase("Updated")){
//            return new ResponseEntity<>("Updated",HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
//        }
//    }
//    @DeleteMapping("/delete")
//    public ResponseEntity<String> delete(@RequestParam int id){
//        String s=studentService.delete(id);
//        if(s.equalsIgnoreCase("Deleted")){
//            return new ResponseEntity<>("Deleted",HttpStatus.OK);
//        }
//        else{
//            return new ResponseEntity<>("Not Found",HttpStatus.NOT_FOUND);
//        }
//    }
//
//}