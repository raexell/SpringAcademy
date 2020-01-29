package net.bitsrl.MyAcademy.controllers;

import net.bitsrl.MyAcademy.model.Course;
import net.bitsrl.MyAcademy.model.CourseEdition;
import net.bitsrl.MyAcademy.model.Student;
import net.bitsrl.MyAcademy.services.AbstractService;
import net.bitsrl.MyAcademy.viewModel.EnrollmentForCourseEdition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/students")
public class StudentController {
    private AbstractService service;

    @Autowired
    public StudentController(AbstractService service) {
        this.service = service;
    }

    @GetMapping("/studentInEdition")
    public String studentInEdition(Model theModel,  int courseEditionId){
        Collection<EnrollmentForCourseEdition> theStudent = service.getAllStundentsForCourseEdition(courseEditionId);
        theModel.addAttribute("students", theStudent);
        theStudent.forEach(System.out::println);
        return "/students/studentInEdition";
    }




}
