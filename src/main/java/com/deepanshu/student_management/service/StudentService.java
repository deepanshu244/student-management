
package com.deepanshu.student_management.service;

import com.deepanshu.student_management.model.Student;
import com.deepanshu.student_management.repositiory.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;
    private final StudentRepo repo;
    private final PasswordEncoder encoder;

    public StudentService(StudentRepo repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public Student add(Student student) {

        student.setPassword(encoder.encode(student.getPassword()));
        return studentRepo.save(student);
    }

    public Optional<Student> get(int id) {
        return studentRepo.findById(id);
    }

    public Optional<Student> update(int id, Student student) {
        return studentRepo.findById(id).map(existingStudent -> {
            existingStudent.setAge(student.getAge());
            existingStudent.setName(student.getName());
            existingStudent.setCourse(student.getCourse());
            existingStudent.setEmail(student.getEmail());
            return studentRepo.save(existingStudent);
        });
    }

    public boolean delete(int id) {
        if (studentRepo.existsById(id)) {
            studentRepo.deleteById(id);
            return true;
        }
        return false;
    }
}






















//package com.deepanshu.student_management.service;
//
//import com.deepanshu.student_management.model.Student;
//import com.deepanshu.student_management.repositiory.StudentRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class StudentService {
//    @Autowired
//    private StudentRepo studentRepo;
//
//    public String add(Student student) {
//        studentRepo.save(student);
//        return "Saved";
//    }
//
//    public String get(int id) {
//        Optional<Student> student= studentRepo.findById(id);
//        if(student.isPresent()){
//            return "Found";
//
//        }
//        else
//            return "Not Found";
//    }
//
//    public String update(int id, Student student) {
//        Optional<Student> student1=studentRepo.findById(id);
//        if(student1.isPresent()){
//            Student student2=student1.get();
//            student2.setAge(student.getAge());
//            student2.setName(student.getName());
//            student2.setCourse(student.getCourse());
//            student2.setEmail(student.getEmail());
//            student2.setId(student2.getId());
//            Student student3=studentRepo.save((student2));
//
//            return "Updated";
//        }
//        else
//            return "Not Found";
//
//    }
//
//    public String delete(int id) {
//        Optional<Student> student=studentRepo.findById(id);
//        if(student.isPresent()){
//            studentRepo.deleteById(id);
//            return "Deleted";
//        }
//        else {
//            return "Not Found";
//        }
//    }
//}
