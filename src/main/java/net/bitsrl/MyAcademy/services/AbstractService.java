package net.bitsrl.MyAcademy.services;

import net.bitsrl.MyAcademy.dto.CourseDTO;
import net.bitsrl.MyAcademy.dto.CourseEditionDTO;
import net.bitsrl.MyAcademy.dto.StudentDTO;
import net.bitsrl.MyAcademy.model.*;
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
    CourseEditionDTO getCourseEditionById(int courseEDId);
    Collection<CourseEdition> getAllCourseEdition();
    Collection<CourseEdition> getAllCEByCourseId(int courseId);
    Collection<CourseEditionDTO> getCourseEditionDTObyCourseId(int courseId);
    Collection<Student> getAllStudents();
    Collection<StudentDTO> getAllStudentsDTO();
    Student createStudent(Student toInsert);
    Collection<EnrollmentForCourseEdition> getAllStundentsForCourseEdition(int courseEditionId);

    boolean deleteStudent(int id);
    boolean updateStudent(Student toUpdate);
    Student getByIdStudent(int id);
    CourseEdition getCEById(int courseEDId);
    Enrollment createEnrollmentByStudentId(CourseEdition courseEDId, Student studentId);

}
