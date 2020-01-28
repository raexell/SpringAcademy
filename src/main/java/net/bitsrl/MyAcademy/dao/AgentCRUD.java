package net.bitsrl.MyAcademy.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.Collection;

public class AgentCRUD implements AbstractCRUD {

    private EntityManager entityManager;

    @Autowired
    public AgentCRUD(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    public Object create(Object toInsert) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean update( Object toUpdate) {
        return false;
    }

    @Override
    public Collection<Object> getAll() {
        return null;
    }

    @Override
    public Object getById(int id) {
        return null;
    }
}
