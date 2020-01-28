package net.bitsrl.MyAcademy.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "student", schema = "academia")
public class Student {
    private int id;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String sex;
    private DegreeType degreeType;
    private String degreeTitle;
    private boolean isPrivate;
    private String email;
    private String phone;
    private Collection<Enrollment> enrollments;
    private Client client;
    private Collection<StudentFeedback> studentFeedbacks;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstname", nullable = false, length = 45)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname", nullable = false, length = 45)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "date_of_birth", nullable = false, length = 45)
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "sex", nullable = false, length = 1)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "degree_type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    public DegreeType getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(DegreeType degreeType) {
        this.degreeType = degreeType;
    }

    @Basic
    @Column(name = "degree_title", nullable = false, length = 45)
    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    @Basic
    @Column(name = "is_private", nullable = false)
    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 24)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 24)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                degreeType == student.degreeType &&
                isPrivate == student.isPrivate &&
                Objects.equals(firstname, student.firstname) &&
                Objects.equals(lastname, student.lastname) &&
                Objects.equals(dateOfBirth, student.dateOfBirth) &&
                Objects.equals(sex, student.sex) &&
                Objects.equals(degreeTitle, student.degreeTitle) &&
                Objects.equals(email, student.email) &&
                Objects.equals(phone, student.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, dateOfBirth, sex, degreeType, degreeTitle, isPrivate, email, phone);
    }

    @OneToMany(mappedBy = "student")
    public Collection<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Collection<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @OneToMany(mappedBy = "student")
    public Collection<StudentFeedback> getStudentFeedbacks() {
        return studentFeedbacks;
    }

    public void setStudentFeedbacks(Collection<StudentFeedback> studentFeedbacks) {
        this.studentFeedbacks = studentFeedbacks;
    }
}
