package net.bitsrl.MyAcademy.dao;

import net.bitsrl.MyAcademy.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.Collection;


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
    public Course getById(int id) {
        Course theCourse =
                em.find(Course.class, id);
        return theCourse;
    }
}
