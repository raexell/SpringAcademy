package net.bitsrl.MyAcademy.controllers;

import net.bitsrl.MyAcademy.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EnrollmentController {
    private AbstractService service;

    @Autowired
    public EnrollmentController(AbstractService service){
        this.service = service;
    }
}
