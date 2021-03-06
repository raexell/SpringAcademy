package net.bitsrl.MyAcademy.dao;

import net.bitsrl.MyAcademy.dto.StudentDTO;
import net.bitsrl.MyAcademy.model.*;
import net.bitsrl.MyAcademy.viewModel.EnrollmentForCourseEdition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Collection;

@Repository
public class StudentRepository implements StudentCRUD {
    @Autowired
    EntityManager em;

    @Override
    public Collection<StudentDTO> getAllStundents() {
        Collection<Student> students= em.createQuery("select s from Student s", Student.class).getResultList();
        Collection<StudentDTO> studentDTOs = new ArrayList<>();
        for (Student temp:students){
            studentDTOs.add(new StudentDTO(temp));
        }
        for (StudentDTO dto : studentDTOs){
            System.out.println(dto);
        }
        return studentDTOs;
    }

    @Override
    public Student create(Student toInsert) {
        em.persist(toInsert);
        return toInsert;
    }

    @Override
    public boolean delete(int id)  {
        // delete object with primary key
        Query theQuery = em.createQuery(
                "delete from Student where id=:id");

        theQuery.setParameter("id", id);

        theQuery.executeUpdate();
        return true;
    }

    @Override
    public boolean update(Student toUpdate) {
        // save or update the employee
        em.merge(toUpdate);
        return true;
    }

    @Override
    public Student getById(int id)  {
        Student student =
                em.find(Student.class, id);
        return student;
    }


    @Override
    public Collection<EnrollmentForCourseEdition> getEnrollmentsForCourseEdition(int courseEditionId) {
        TypedQuery<EnrollmentForCourseEdition> query =  em.createQuery("select new net.bitsrl.MyAcademy.viewModel.EnrollmentForCourseEdition(e.id,e.student.id,e.student.firstname,e.student.lastname,e.courseFeePaid) from Enrollment e where e.courseEdition.id = :courseEditionId", EnrollmentForCourseEdition.class);
        query.setParameter("courseEditionId", courseEditionId);
        return query.getResultList();
    }
}
