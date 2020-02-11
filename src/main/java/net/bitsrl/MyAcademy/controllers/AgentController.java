package net.bitsrl.MyAcademy.controllers;

import net.bitsrl.MyAcademy.dto.AgentDTO;
import net.bitsrl.MyAcademy.model.Agent;
import net.bitsrl.MyAcademy.services.AbstractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class AgentController {
    private AbstractService service;

    @Autowired
    public AgentController(AbstractService service) {
        this.service = service;
    }

    @GetMapping("/agents")
    public Collection<AgentDTO> getAllDTO() {
        return service.getAllAgentDTO();
    }

    @GetMapping("/agents/{agentId}")
    public AgentDTO getAgentbyIdDTO(@PathVariable int agentId) {
        AgentDTO theAgent = service.getByIdAgentDTO(agentId);
        if(theAgent == null){
            throw new RuntimeException("Agent id not found - " + agentId);
        }
        return theAgent;
    }

    @DeleteMapping("/agents/{agentId}")
    public String deleteAgent (@PathVariable int agentId){
        Agent theAgent = service.getByIdAgent(agentId);
        if(theAgent == null){
            throw new RuntimeException("Agent id not found - " + agentId);
        }
        service.deleteAgent(agentId);
        return "Deleted agent id - " + agentId;
    }

    @PostMapping("/agents")
    public Agent createAgent(@RequestBody Agent theAgent) {
        theAgent.setId(0);
        service.createAgent(theAgent);
        return theAgent;
    }

    @PutMapping("/agents")
    public Agent updateAgent(@RequestBody Agent theAgent) {
        service.updateAgent(theAgent);
        return theAgent;
    }

}
