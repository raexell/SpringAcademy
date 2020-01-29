package net.bitsrl.MyAcademy.dao;

import net.bitsrl.MyAcademy.model.CourseEdition;
import net.bitsrl.MyAcademy.model.Student;
import net.bitsrl.MyAcademy.viewModel.EnrollmentForCourseEdition;

import java.util.Collection;

public interface StudentCRUD {
    Collection<Student> getAllStundents();
    Collection<EnrollmentForCourseEdition> getEnrollmentsForCourseEdition(int courseEditionId);
}
