package net.bitsrl.MyAcademy.dao;

import net.bitsrl.MyAcademy.dto.AgentDTO;
import net.bitsrl.MyAcademy.dto.CourseDTO;
import net.bitsrl.MyAcademy.dto.StudentDTO;
import net.bitsrl.MyAcademy.model.Agent;
import net.bitsrl.MyAcademy.model.Course;
import net.bitsrl.MyAcademy.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class AgentRepository implements AgentCRUD {

    private EntityManager entityManager;

    @Autowired
    public AgentRepository(EntityManager entityManager){
        this.entityManager=entityManager;
    }


    @Override
    public Collection<AgentDTO> getAllAgents() {
        Collection<Agent> agents= entityManager.createQuery("select s from Agent s", Agent.class).getResultList();
        Collection<AgentDTO> agentDTOS = new ArrayList<>();
        for (Agent temp:agents){
            agentDTOS.add(new AgentDTO(temp));
        }
        for (AgentDTO dto : agentDTOS){
            System.out.println(dto);
        }
        return agentDTOS;
    }

    @Override
    public Agent create(Agent toInsert) {
        entityManager.persist(toInsert);
        return toInsert;
    }

    @Override
    public boolean delete(int id) {
        // delete object with primary key
        Query theQuery = entityManager.createQuery(
                "delete from Agent where id=:id");

        theQuery.setParameter("id", id);

        theQuery.executeUpdate();
        return true;

    }

    @Override
    public boolean update(Agent toUpdate) {
        entityManager.merge(toUpdate);
        return true;
    }

    @Override
    public Agent getById(int id) {
        Agent agent =
                entityManager.find(Agent.class, id);
        return agent;
    }
}
