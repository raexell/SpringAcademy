package net.bitsrl.MyAcademy.dao;

import net.bitsrl.MyAcademy.dto.AgentDTO;
import net.bitsrl.MyAcademy.dto.CourseDTO;
import net.bitsrl.MyAcademy.model.Agent;
import net.bitsrl.MyAcademy.model.Course;
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
        // save or update the employee
        entityManager.merge(toUpdate);
        return true;
    }

    @Override
    public Collection<Agent> getAll() {
        return  entityManager.createQuery("select a from Agent a", Agent.class).getResultList();
    }

    @Override
    public Agent getById(int id) {
        Agent theAgent =
                entityManager.find(Agent.class, id);
        return theAgent;
    }

    @Override
    public Collection<AgentDTO> getAllDTO() {
        Collection<AgentDTO> dto = new ArrayList<>();
        List<Agent> agenti = entityManager.createQuery("select a from Agent a", Agent.class).getResultList();
        for (Agent tmp: agenti  ) {
            dto.add(new AgentDTO(tmp));
        }
        return dto;
    }

    @Override
    public AgentDTO getByIdDTO(int id) {
        Agent theAgent = entityManager.find(Agent.class, id);
        AgentDTO dto = new AgentDTO(theAgent);
        return dto;
    }
}
