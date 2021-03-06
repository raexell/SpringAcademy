package net.bitsrl.MyAcademy.dao;


import net.bitsrl.MyAcademy.dto.CourseDTO;
import net.bitsrl.MyAcademy.model.Course;

import java.util.Collection;

public interface CourseCRUD {
    Course create(Course toInsert);
    boolean delete(int id);
    boolean update(Course toUpdate);
    Collection<Course> getAll();
    Collection<CourseDTO> getAllDTO();
    Course getById(int id);

}
