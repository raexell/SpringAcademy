package net.bitsrl.MyAcademy.dao;

import net.bitsrl.MyAcademy.model.Course;
import net.bitsrl.MyAcademy.model.CourseEdition;
import net.bitsrl.MyAcademy.model.Enrollment;

import java.util.Collection;

public interface CourseEditionCRUD {
    Collection<CourseEdition> getAll();
    CourseEdition getById(int id);
}
