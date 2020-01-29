package net.bitsrl.MyAcademy.controllers;

import net.bitsrl.MyAcademy.model.Course;
import net.bitsrl.MyAcademy.model.CourseEdition;
import net.bitsrl.MyAcademy.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/courseEdition")
public class CourseEditionController{
    private AbstractService service;

    @Autowired
    public CourseEditionController(AbstractService service){
        this.service = service;
    }
    @GetMapping("/list")
    public String listCourseEdition (Model theModel){
        Collection<CourseEdition> theCourseEdition = service.getAllCourseEdition();
        theModel.addAttribute("courseEdition", theCourseEdition);
        return "/courseEdition/courseEditionList";
    }

}
