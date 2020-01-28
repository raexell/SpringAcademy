package net.bitsrl.MyAcademy.services;

import net.bitsrl.MyAcademy.model.Agent;
import net.bitsrl.MyAcademy.model.Course;

import java.util.Collection;

public interface AbstractService {
    Agent createAgent(Agent toInsert);
    boolean deleteAgent(int id);
    boolean updateAgent(Agent toUpdate);
    Collection<Agent> getAllAgent();
    Agent getByIdAgent(int id);

    Course createCourse(Course toInsert);
    boolean deleteCourse(int id);
    boolean updateCourse(Course toUpdate);
    Collection<Course> getAllCourse();
    Course getByIdCourse(int id);
}
