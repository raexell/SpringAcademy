package net.bitsrl.MyAcademy.dao;

import net.bitsrl.MyAcademy.model.Course;
import net.bitsrl.MyAcademy.model.CourseEdition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.Collection;

@Repository
public class CourseEditionRepository implements CourseEditionCRUD{
    @Autowired
    EntityManager em;

    @Override
    public Collection<CourseEdition> getAll() {
        return em.createQuery("select c from CourseEdition c", CourseEdition.class).getResultList();
    }


}
