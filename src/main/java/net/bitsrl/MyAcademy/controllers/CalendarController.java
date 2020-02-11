package net.bitsrl.MyAcademy.controllers;

import net.bitsrl.MyAcademy.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
@CrossOrigin
@Controller
@RequestMapping("/calendar")
public class CalendarController {
    private AbstractService service;

    @Autowired
    public CalendarController(AbstractService service) {
        this.service = service;
    }
}
