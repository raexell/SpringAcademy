package net.bitsrl.MyAcademy.dao;

import net.bitsrl.MyAcademy.dto.StudentDTO;
import net.bitsrl.MyAcademy.model.Agent;
import net.bitsrl.MyAcademy.model.CourseEdition;
import net.bitsrl.MyAcademy.model.Enrollment;
import net.bitsrl.MyAcademy.model.Student;
import net.bitsrl.MyAcademy.viewModel.EnrollmentForCourseEdition;

import java.util.Collection;

public interface StudentCRUD {
    Collection<Student> getAllStundents();
    Collection<EnrollmentForCourseEdition> getEnrollmentsForCourseEdition(int courseEditionId);
    Collection<StudentDTO> getAllStundentsDTO();
    Student create(Student toInsert);
    boolean delete(int id);
    boolean update(Student toUpdate);
    Student getById(int id);
}
