package net.bitsrl.MyAcademy.controllers;

import net.bitsrl.MyAcademy.model.Agent;
import net.bitsrl.MyAcademy.model.Course;
import net.bitsrl.MyAcademy.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/agents")
public class AgentController {
    private AbstractService service;

    @Autowired
    public AgentController(AbstractService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        Collection<Agent> agents = service.getAllAgent();
        agents.forEach(System.out::println);
        model.addAttribute("agents", agents);
        return "/agents/agentList";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model) {
        Agent agent = new Agent();
        model.addAttribute("agent", agent);
        return "/agents/agentForm";
    }

    @PostMapping("/delete")
    public String deleteAgent (int agentId){
        service.deleteAgent(agentId);
        return "redirect:/agents/list";
    }


    @PostMapping("/save")
    public String createAgent(@ModelAttribute("agent") Agent agent) {
        service.createAgent(agent);
        return "redirect:/agents/list";
    }
}
