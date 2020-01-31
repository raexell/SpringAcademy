package net.bitsrl.MyAcademy.dao;

import net.bitsrl.MyAcademy.dto.CourseEditionDTO;
import net.bitsrl.MyAcademy.model.Course;
import net.bitsrl.MyAcademy.model.CourseEdition;
import net.bitsrl.MyAcademy.model.Enrollment;
import net.bitsrl.MyAcademy.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class EnrollmentRepository implements EnrollmentCRUD {
    @Autowired
    EntityManager em;


    @Override
    public Enrollment create(Enrollment toInsert) {
        em.persist(toInsert);
        return toInsert;
    }

    @Override
    public boolean delete(int id) {
        Enrollment toDelete = em.getReference(Enrollment.class, id);
        em.remove(toDelete);
        return true;
    }

    @Override
    public boolean update(Enrollment toUpdate) {
        em.merge(toUpdate);
        return true;
    }

    @Override
    public Enrollment getByStudentId(int id) {
        Enrollment enrollment =
                em.find(Enrollment.class, id);
        return enrollment;
    }

    public Enrollment createByStudentId(CourseEdition courseED, Student student) {
        Enrollment newIscrizione= new Enrollment( student, courseED);
        em.persist(newIscrizione);
        return newIscrizione;
    }
}
