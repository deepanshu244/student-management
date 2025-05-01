package com.deepanshu.student_management.service;
//
//import com.deepanshu.student_management.model.Student;
//import com.deepanshu.student_management.model.User;
//import com.deepanshu.student_management.repositiory.StudentRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Collections;
//
//@Service
//public class StudentDetailsService implements UserDetailsService {
//
//    @Autowired
//    private StudentRepo studentRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        Student student = studentRepository.findByEmail(email)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//
//        return new org.springframework.security.core.userdetails.User(
//                student.getEmail(),
//                student.getPassword(),
//                Collections.emptyList()    // no roles, just an empty authority list
//        );
//    }
//}

