package net.bitsrl.MyAcademy.controllers;

import net.bitsrl.MyAcademy.dto.CourseEditionDTO;
import net.bitsrl.MyAcademy.model.CourseEdition;
import net.bitsrl.MyAcademy.model.Enrollment;
import net.bitsrl.MyAcademy.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class CourseEditionController{
    private AbstractService service;

    @Autowired
    public CourseEditionController(AbstractService service){
        this.service = service;
    }
    @GetMapping("/CourseEditions")
    public Collection<CourseEdition> listCourseEdition (){
        return  service.getAllCourseEdition();
    }


    @GetMapping("CourseEditions/{courseEDId}")
    public CourseEditionDTO getCourseEditionById(@PathVariable int courseEDId) {
        return service.getCourseEditionById(courseEDId);
    }

    @PostMapping("CourseEditions/{courseEDId}/Enrollment/{studentId}")
    public Enrollment getCourseEditionById(@PathVariable int courseEDId, @PathVariable int studentId) {


        return service.createEnrollmentByStudentId(service.getCEById(courseEDId),service.getByIdStudent(studentId));

    }
}
