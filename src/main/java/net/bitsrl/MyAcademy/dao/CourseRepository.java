package net.bitsrl.MyAcademy.dao;

import net.bitsrl.MyAcademy.dto.CourseDTO;
import net.bitsrl.MyAcademy.model.Course;
import net.bitsrl.MyAcademy.model.CourseEdition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Repository
public class CourseRepository implements CourseCRUD {

    @Autowired
    EntityManager em;


    @Override
    public Course create(Course toInsert) {
        em.persist(toInsert);
        return toInsert;
    }

    @Override
    public boolean delete(int id) {
        Course toDelete = em.getReference(Course.class, id);
        em.remove(toDelete);
        return true;
    }

    @Override
    public boolean update(Course toUpdate) {
        em.merge(toUpdate);
        return true;
    }

    @Override
    public Collection<Course> getAll() {
        return em.createQuery("select c from Course c", Course.class).getResultList();
    }

    @Override
    public Collection<CourseDTO> getAllDTO() {
        Collection<CourseDTO> dto = new ArrayList<>();
        List<Course>  corsi = em.createQuery("select c from Course c", Course.class).getResultList();
        for (Course tmp: corsi  ) {
            dto.add(new CourseDTO(tmp));
        }
        return dto;
    }

    @Override
    public Course getById(int id) {
        Course theCourse =
                em.find(Course.class, id);
        return theCourse;
    }

    public Collection<CourseEdition> getAllCourseEditionById(int courseId){
        Collection<CourseEdition> ce = new ArrayList<>();
        ce = em.createQuery("select c from CourseEdition c where c.course.id= :courseId", CourseEdition.class)
                .setParameter("courseId", courseId)
                .getResultList();
        return ce;
    }
}
