package net.bitsrl.MyAcademy.services;

import net.bitsrl.MyAcademy.dao.*;
import net.bitsrl.MyAcademy.dto.CourseDTO;
import net.bitsrl.MyAcademy.dto.CourseEditionDTO;
import net.bitsrl.MyAcademy.dto.StudentDTO;
import net.bitsrl.MyAcademy.model.*;
import net.bitsrl.MyAcademy.viewModel.EnrollmentForCourseEdition;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class ServiceIMPL implements AbstractService {
    private AgentRepository agent;
    private CourseRepository course;
    private CourseEditionRepository courseEdition;
    private StudentRepository student;
    private EnrollmentRepository iscrizioni;


    public ServiceIMPL(AgentRepository agent, CourseRepository course, CourseEditionRepository courseEdition, StudentRepository student){
        this.agent = agent;
        this.course = course;
        this.courseEdition = courseEdition;
        this.student = student;
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
    public Collection<CourseDTO> getAllCourseDTO() {
        return course.getAllDTO();
    }

    @Override
    @Transactional
    public Course getByIdCourse(int id) {
        return course.getById(id);
    }

    @Override
    @Transactional
    public Collection<CourseEdition> getAllCourseEdition() { return courseEdition.getAll();}

    @Override
    @Transactional
    public Collection<Student> getAllStudents() { return student.getAllStundents();}

    @Override
    @Transactional
    public Collection<StudentDTO> getAllStudentsDTO() { return student.getAllStundentsDTO();}

    @Override
    @Transactional
    public Student createStudent(Student toInsert) {
        return student.create(toInsert);
    }



    @Override
    @Transactional
    public Collection<EnrollmentForCourseEdition> getAllStundentsForCourseEdition(int courseEditionId) {
        return student.getEnrollmentsForCourseEdition(courseEditionId);
    }

    @Override
    @Transactional
    public boolean deleteStudent(int id) {
        return student.delete(id);
    }

    @Override
    @Transactional
    public boolean updateStudent(Student toUpdate) {
        return student.update(toUpdate);
    }

    @Override
    @Transactional
    public Student getByIdStudent(int id) {
        return student.getById(id);
    }

    @Override
    @Transactional
    public Collection<CourseEdition> getAllCEByCourseId(int courseId){
        return course.getAllCourseEditionById(courseId);
    }
    @Override
    @Transactional
    public Collection<CourseEditionDTO> getCourseEditionDTObyCourseId(int courseId){
        return courseEdition.getCourseEditionDTObyCourseId(courseId);
    }

    @Override
    @Transactional
    public CourseEditionDTO getCourseEditionById(int courseEDId){
        return new CourseEditionDTO(courseEdition.getById(courseEDId));
    }
    @Override
    @Transactional
    public CourseEdition getCEById(int courseEDId){
        return courseEdition.getById(courseEDId);
    }

@Override
    @Transactional
    public Enrollment createEnrollmentByStudentId(CourseEdition courseEDId, Student studentId){
        return iscrizioni.createByStudentId(courseEDId,  studentId);
    }


}
