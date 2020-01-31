package net.bitsrl.MyAcademy.dao;

import net.bitsrl.MyAcademy.dto.StudentDTO;
import net.bitsrl.MyAcademy.model.Course;
import net.bitsrl.MyAcademy.model.CourseEdition;
import net.bitsrl.MyAcademy.model.Enrollment;
import net.bitsrl.MyAcademy.model.Student;
import net.bitsrl.MyAcademy.viewModel.EnrollmentForCourseEdition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public class StudentRepository implements StudentCRUD {
    @Autowired
    EntityManager em;

    @Override
    public Collection<Student> getAllStundents() {
        return em.createQuery("select s from Student s", Student.class)
                .getResultList();
        /*return em.createQuery("select s.firstname, s.lastname, e.courseFeePaid from Enrollment e join e.courseEdition s.id where e.courseEdition = :ceId", Student.class)
                .setParameter("ceId",ceId)
                .getResultList();*/
    }
    @Override
    public Collection<StudentDTO> getAllStundentsDTO() {
        Collection<Student> students= em.createQuery("select s from Student s", Student.class).getResultList();
        Collection<StudentDTO> studentDTO = new ArrayList<>();
        for (Student temp:students){
            studentDTO.add(new StudentDTO(temp));
        }
        return studentDTO;
    }

    @Override
    public Student create(Student toInsert) {
        em.persist(toInsert);
        return toInsert;
    }




    @Override
    public Collection<EnrollmentForCourseEdition> getEnrollmentsForCourseEdition(int courseEditionId) {
        TypedQuery<EnrollmentForCourseEdition> query =  em.createQuery("select new net.bitsrl.MyAcademy.viewModel.EnrollmentForCourseEdition(e.id,e.student.id,e.student.firstname,e.student.lastname,e.courseFeePaid) from Enrollment e where e.courseEdition.id = :courseEditionId", EnrollmentForCourseEdition.class);
        query.setParameter("courseEditionId", courseEditionId);
        return query.getResultList();
    }
}
