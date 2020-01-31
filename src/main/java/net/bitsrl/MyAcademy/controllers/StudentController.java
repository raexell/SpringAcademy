package net.bitsrl.MyAcademy.controllers;

import net.bitsrl.MyAcademy.model.Enrollment;
import net.bitsrl.MyAcademy.model.Student;
import net.bitsrl.MyAcademy.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class StudentController {
    private AbstractService service;

    @Autowired
    public StudentController(AbstractService service) {
        this.service = service;
    }

    @GetMapping("/students")
    public Collection<Student> getAll(){
        return service.getAllStudents();
    }
       /* public String studentInEdition(Model theModel,  int courseEditionId){
            Collection<EnrollmentForCourseEdition> theStudent = service.getAllStundentsForCourseEdition(courseEditionId);
            theModel.addAttribute("students", theStudent);
            theStudent.forEach(System.out::println);
            return "/students/studentInEdition";
        }*/
    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        student.setId(0);
        return service.createStudent(student);
    }



}
