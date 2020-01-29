package net.bitsrl.MyAcademy.viewModel;

import net.bitsrl.MyAcademy.model.Student;

public class EnrollmentForCourseEdition {
    private int idCourseEdition;
    private int idStudent;
    private String firstname;
    private String lastname;
    private boolean hasPaid;

    public EnrollmentForCourseEdition(int idCourseEdition, int idStudent, String firstname, String lastname, boolean hasPaid) {
        this.idCourseEdition = idCourseEdition;
        this.idStudent = idStudent;
        this.firstname = firstname;
        this.lastname = lastname;
        this.hasPaid = hasPaid;
    }

    public int getIdCourseEdition() {
        return idCourseEdition;
    }

    public void setIdCourseEdition(int idCourseEdition) {
        this.idCourseEdition = idCourseEdition;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }
}
