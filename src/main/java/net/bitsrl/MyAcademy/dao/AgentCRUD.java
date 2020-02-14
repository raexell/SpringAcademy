package net.bitsrl.MyAcademy.dao;

import net.bitsrl.MyAcademy.dto.AgentDTO;
import net.bitsrl.MyAcademy.dto.StudentDTO;
import net.bitsrl.MyAcademy.model.Agent;
import net.bitsrl.MyAcademy.model.Course;
import net.bitsrl.MyAcademy.model.Student;
import net.bitsrl.MyAcademy.viewModel.EnrollmentForCourseEdition;

import java.util.Collection;

public interface AgentCRUD {

    Collection<AgentDTO> getAllAgents();
    Agent create(Agent toInsert);
    boolean delete(int id);
    boolean update(Agent toUpdate);
    Agent getById(int id);

}
