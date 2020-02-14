package net.bitsrl.MyAcademy.controllers;

import net.bitsrl.MyAcademy.dto.StudentDTO;
import net.bitsrl.MyAcademy.model.Agent;
import net.bitsrl.MyAcademy.model.Enrollment;
import net.bitsrl.MyAcademy.model.Student;
import net.bitsrl.MyAcademy.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class StudentController {
    private AbstractService service;

    @Autowired
    public StudentController(AbstractService service) {
        this.service = service;
    }

    @GetMapping("/students")
       public Collection<StudentDTO> getAllDTO(){
           return service.getAllStudents();
       }

    @PostMapping("/students")
    public StudentDTO createStudent(@RequestBody StudentDTO student) {
        student.setId(0);
        Student created = service.createStudent(student.toStudent());
        return new StudentDTO(created);

    }

    @PutMapping("/students/{studentId}")
    public StudentDTO updateStudent(@PathVariable int studentId, @RequestBody StudentDTO studentDTO) {
        Student toUpdate = studentDTO.toStudent();
        service.updateStudent(toUpdate);
        return new StudentDTO(toUpdate);
    }

    @DeleteMapping("/students/{studentId}")
    public String deleteStudent (@PathVariable int studentId){
        Student student = service.getByIdStudent(studentId);
        if(student == null){
            throw new RuntimeException("Student id not found - " + studentId);
        }
        service.deleteStudent(studentId);
        return "Deleted student id - " + studentId;
    }

    @GetMapping("/students/{studentId}")
    public StudentDTO getStudent(@PathVariable int studentId) {
        Student student = service.getByIdStudent(studentId);
        if(student == null){
            throw new RuntimeException("Student id not found - " + studentId);
        }
        return new StudentDTO(student);
    }

}
