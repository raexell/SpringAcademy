package net.bitsrl.MyAcademy.controllers;

import net.bitsrl.MyAcademy.model.Course;
import net.bitsrl.MyAcademy.services.AbstractService;
import net.bitsrl.MyAcademy.services.ServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class CourseController {
    private AbstractService service;

    @Autowired
    public CourseController(AbstractService service){
        this.service = service;
    }

    @GetMapping("/courses")
    public String getCourse(){
        Collection<Course> courses = service.getAllCourse();
        courses.forEach(System.out:: println);
        return "courses/courseList";
    }
}
