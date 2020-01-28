package net.bitsrl.MyAcademy.dao;

import net.bitsrl.MyAcademy.model.Agent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

public class AgentCRUD implements AbstractCRUD {

    private EntityManager entityManager;

    @Autowired
    public AgentCRUD(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    public Object create(Object toInsert) {
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
    public boolean update(Object toUpdate) {
        // save or update the employee
        entityManager.merge(toUpdate);
        return true;
    }

    @Override
    public Collection<Object> getAll() {
        return  entityManager.createQuery("from Agent").getResultList();
    }

    @Override
    public Agent getById(int id) {
        // get employee
        Agent theAgent =
                entityManager.find(Agent.class, id);
        // return employee
        return theAgent;
    }
}
