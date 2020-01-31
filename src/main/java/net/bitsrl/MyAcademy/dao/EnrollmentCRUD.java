package net.bitsrl.MyAcademy.dao;

import net.bitsrl.MyAcademy.model.Enrollment;

public interface EnrollmentCRUD {

    Enrollment create(Enrollment toInsert);
    boolean delete(int id);
    boolean update(Enrollment toUpdate);
    Enrollment getByStudentId(int id);

}
