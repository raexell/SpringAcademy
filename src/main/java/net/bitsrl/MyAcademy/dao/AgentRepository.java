package net.bitsrl.MyAcademy.dao;

import net.bitsrl.MyAcademy.model.Agent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;

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
        return  entityManager.createQuery("from Agent").getResultList();
    }

    @Override
    public Agent getById(int id) {
        Agent theAgent =
                entityManager.find(Agent.class, id);
        return theAgent;
    }
}
