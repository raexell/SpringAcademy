package net.bitsrl.MyAcademy.controllers;

import net.bitsrl.MyAcademy.model.Agent;
import net.bitsrl.MyAcademy.model.Course;
import net.bitsrl.MyAcademy.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class AgentController {
    AbstractService service;

    @Autowired
    public AgentController(AbstractService service){
        this.service=service;
    }
    @GetMapping("/agents")
    public String getAgent(){
        Collection<Agent> agents = service.getAllAgent();
        agents.forEach(System.out:: println);
        return "agents/agentList";
    }
}
