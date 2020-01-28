package net.bitsrl.MyAcademy.services;

import net.bitsrl.MyAcademy.dao.AgentRepository;
import net.bitsrl.MyAcademy.model.Agent;
import net.bitsrl.MyAcademy.model.Course;

import java.util.Collection;

public class ServiceIMPL implements AbstractService {
    private AgentRepository agent;

    @Override
    public Agent createAgent(Agent toInsert) {
        return agent.create(toInsert);
    }

    @Override
    public boolean deleteAgent(int id) {
        return agent.delete(id);
    }

    @Override
    public boolean updateAgent(Agent toUpdate) {
        return agent.update(toUpdate);
    }

    @Override
    public Collection<Agent> getAllAgent() {
        return agent.getAll();
    }

    @Override
    public Agent getByIdAgent(int id) {
        return agent.getById(id);
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
