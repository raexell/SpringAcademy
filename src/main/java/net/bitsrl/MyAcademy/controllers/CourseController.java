package net.bitsrl.MyAcademy.controllers;

import net.bitsrl.MyAcademy.model.Course;
import net.bitsrl.MyAcademy.services.AbstractService;
import net.bitsrl.MyAcademy.services.ServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/courses")
public class CourseController {
    private AbstractService service;

    @Autowired
    public CourseController(AbstractService service){
        this.service = service;
    }

    /*@GetMapping("/courses")
    public String getCourse(){
        Collection<Course> courses = service.getAllCourse();
        courses.forEach(System.out:: println);
        return "courses/courseList";
    }
*/
    @GetMapping("/list")
    public String listCourses (Model theModel){
        Collection<Course> theCourse = service.getAllCourse();
        theModel.addAttribute("courses", theCourse);
        return "/courses/courseList";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Course theCourse = new Course();

        theModel.addAttribute("course", theCourse);

        return "/courses/courses-form";
    }

    @PostMapping("/delete")
    public String deleteCourse (int courseId){
        service.deleteCourse(courseId);
        return "redirect:/courses/list";
    }

    @GetMapping("/showFormById")
    public String showFormById(Model theModel, int courseId) {
        Course cc = service.getByIdCourse(courseId);

                theModel.addAttribute("course", cc);
        // create model attribute to bind form data

        return "/courses/courseUpdate";
    }



    @PostMapping("/save")
    public String saveCourse(@ModelAttribute("course") Course theCourse) {

        // save the course
        service.createCourse(theCourse);

        // use a redirect to prevent duplicate submissions
        return "redirect:/courses/list";
    }



}
