package net.bitsrl.MyAcademy.controllers;

import net.bitsrl.MyAcademy.dto.CourseDTO;
import net.bitsrl.MyAcademy.dto.CourseEditionDTO;
import net.bitsrl.MyAcademy.model.Course;
import net.bitsrl.MyAcademy.model.CourseEdition;
import net.bitsrl.MyAcademy.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class CourseController {
    private AbstractService service;

    @Autowired
    public CourseController(AbstractService service){
        this.service = service;
    }
    @GetMapping("/courses")
    public Collection<CourseDTO> getAll() {
        return service.getAllCourseDTO();
    }

    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable int courseId) {
        Course theCourse = service.getByIdCourse(courseId);
        if(theCourse == null){
            throw new RuntimeException("Course id not found - " + courseId);
        }
        return theCourse;
    }

    @DeleteMapping("/courses/{courseId}")
    public String deleteCourse (@PathVariable int courseId){
        Course theCourse = service.getByIdCourse(courseId);
        if(theCourse == null){
            throw new RuntimeException("Course id not found - " + courseId);
        }
        service.deleteCourse(courseId);
        return "Deleted course id - " + courseId;
    }

    @PostMapping("/courses")
    public Course createCourse(@RequestBody Course theCourse) {
        theCourse.setId(0);
        service.createCourse(theCourse);
        return theCourse;
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course theCourse) {
        service.updateCourse(theCourse);
        return theCourse;
    }

    @GetMapping("/courses/courseEdition/{courseId}")
    public Collection<CourseEditionDTO> getCourseEditionByCourseId(@PathVariable int courseId) {
        Collection<CourseEditionDTO> listCe = service.getCourseEditionDTObyCourseId(courseId);
        return listCe;
    }




}
