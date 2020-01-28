package net.bitsrl.MyAcademy.services;

import net.bitsrl.MyAcademy.dao.AgentRepository;
import net.bitsrl.MyAcademy.dao.CourseRepository;
import net.bitsrl.MyAcademy.model.Agent;
import net.bitsrl.MyAcademy.model.Course;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class ServiceIMPL implements AbstractService {
    private AgentRepository agent;
    private CourseRepository course;

    public ServiceIMPL(AgentRepository agent, CourseRepository course){
        this.agent = agent;
        this.course = course;
    }

    @Override
    @Transactional
    public Agent createAgent(Agent toInsert) {
        return agent.create(toInsert);
    }

    @Override
    @Transactional
    public boolean deleteAgent(int id) {
        return agent.delete(id);
    }

    @Override
    @Transactional
    public boolean updateAgent(Agent toUpdate) {
        return agent.update(toUpdate);
    }

    @Override
    @Transactional
    public Collection<Agent> getAllAgent() {
        return agent.getAll();
    }

    @Override
    @Transactional
    public Agent getByIdAgent(int id) {
        return agent.getById(id);
    }

    @Override
    @Transactional
    public Course createCourse(Course toInsert) {
        return course.create(toInsert);
    }

    @Override
    @Transactional
    public boolean deleteCourse(int id) {
        return course.delete(id);
    }

    @Override
    @Transactional
    public boolean updateCourse(Course toUpdate) {
        return course.update(toUpdate);
    }

    @Override
    @Transactional
    public Collection<Course> getAllCourse() {
        return course.getAll();
    }

    @Override
    @Transactional
    public Course getByIdCourse(int id) {
        return course.getById(id);
    }
}
