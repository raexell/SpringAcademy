package net.bitsrl.MyAcademy.controllers;

import net.bitsrl.MyAcademy.model.Course;
import net.bitsrl.MyAcademy.model.Days;
import net.bitsrl.MyAcademy.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/calendar")
public class CalendarController {
    private AbstractService service;

    @Autowired
    public CalendarController(AbstractService service) {
        this.service = service;
    }
}
