package net.bitsrl.MyAcademy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgentController {
    @GetMapping("/employees")
    public String getEmployees(){
        return "employees";
    }
}
