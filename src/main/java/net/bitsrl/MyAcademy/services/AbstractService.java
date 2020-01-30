package net.bitsrl.MyAcademy.services;

import net.bitsrl.MyAcademy.dto.CourseDTO;
import net.bitsrl.MyAcademy.dto.StudentDTO;
import net.bitsrl.MyAcademy.model.Agent;
import net.bitsrl.MyAcademy.model.Course;
import net.bitsrl.MyAcademy.model.CourseEdition;
import net.bitsrl.MyAcademy.model.Student;
import net.bitsrl.MyAcademy.viewModel.EnrollmentForCourseEdition;

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
    Collection<CourseDTO> getAllCourseDTO();
    Course getByIdCourse(int id);

    Collection<CourseEdition> getAllCourseEdition();
    Collection<Student> getAllStudents();
    Collection<StudentDTO> getAllStudentsDTO();
    Collection<EnrollmentForCourseEdition> getAllStundentsForCourseEdition(int courseEditionId);

}
