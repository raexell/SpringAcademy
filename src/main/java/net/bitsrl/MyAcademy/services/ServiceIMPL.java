package net.bitsrl.MyAcademy.services;

import net.bitsrl.MyAcademy.dao.AgentCRUD;
import net.bitsrl.MyAcademy.model.Agent;
import net.bitsrl.MyAcademy.model.Course;

import java.util.Collection;

public class ServiceIMPL implements AbstractService {
    private AgentCRUD agent;


    @Override
    public Agent createAgent(Agent toInsert) {
        return null;
    }

    @Override
    public boolean deleteAgent(int id) {
        return false;
    }

    @Override
    public boolean updateAgent(Agent toUpdate) {
        return false;
    }

    @Override
    public Collection<Agent> getAllAgent() {
        return null;
    }

    @Override
    public Agent getByIdAgent(int id) {
        return null;
    }

    @Override
    public Course createCourse(Course toInsert) {
        return null;
    }

    @Override
    public boolean deleteCourse(int id) {
        return false;
    }

    @Override
    public boolean updateCourse(Course toUpdate) {
        return false;
    }

    @Override
    public Collection<Course> getAllCourse() {
        return null;
    }

    @Override
    public Course getByIdCourse(int id) {
        return null;
    }
}
