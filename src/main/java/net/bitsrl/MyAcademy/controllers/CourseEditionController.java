package net.bitsrl.MyAcademy.controllers;

import net.bitsrl.MyAcademy.model.CourseEdition;
import net.bitsrl.MyAcademy.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class CourseEditionController{
    private AbstractService service;

    @Autowired
    public CourseEditionController(AbstractService service){
        this.service = service;
    }
    @GetMapping("/CourseEdition")
    public Collection<CourseEdition> listCourseEdition (){
        return  service.getAllCourseEdition();
    }


}
