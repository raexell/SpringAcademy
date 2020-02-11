package net.bitsrl.MyAcademy.dao;

import net.bitsrl.MyAcademy.dto.AgentDTO;
import net.bitsrl.MyAcademy.model.Agent;
import net.bitsrl.MyAcademy.model.Course;

import java.util.Collection;

public interface AgentCRUD {

    Agent create(Agent toInsert);
    boolean delete(int id);
    boolean update(Agent toUpdate);
    Collection<Agent> getAll();
    Agent getById(int id);

    Collection<AgentDTO> getAllDTO();
    AgentDTO getByIdDTO(int id);

}
