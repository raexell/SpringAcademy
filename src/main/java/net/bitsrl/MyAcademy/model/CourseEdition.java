package net.bitsrl.MyAcademy.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "course_edition", schema = "academia")
public class CourseEdition {
    private int id;
    private LocalDate start;
    private LocalDate end;
    private BigDecimal cost;
    private byte isExternal;
    private String address;
    private String city;
    private String zip;
    private Agent leadTeacher;
    private Agent manager;
    private Classroom mainClassroom;
    private Course course;
    private Collection<Enrollment> enrollments;
    private Collection<Lesson> lessons;
    private Collection<TeachingAssignment> teachingAssignments;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "course_edition_id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "start", nullable = false)
    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    @Basic
    @Column(name = "end", nullable = false)
    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    @Basic
    @Column(name = "cost", nullable = false, precision = 2)
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "isExternal", nullable = false)
    public byte getIsExternal() {
        return isExternal;
    }

    public void setIsExternal(byte isExternal) {
        this.isExternal = isExternal;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 45)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "zip", nullable = true, length = 45)
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEdition that = (CourseEdition) o;
        return id == that.id &&
                isExternal == that.isExternal &&
                Objects.equals(start, that.start) &&
                Objects.equals(end, that.end) &&
                Objects.equals(cost, that.cost) &&
                Objects.equals(address, that.address) &&
                Objects.equals(city, that.city) &&
                Objects.equals(zip, that.zip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start, end, cost, isExternal, address, city, zip);
    }

    @ManyToOne
    @JoinColumn(name = "lead_teacher_id", referencedColumnName = "agent_id")
    public Agent getLeadTeacher() {
        return leadTeacher;
    }

    public void setLeadTeacher(Agent leadTeacher) {
        this.leadTeacher = leadTeacher;
    }

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "agent_id", nullable = false)
    public Agent getManager() {
        return manager;
    }

    public void setManager(Agent manager) {
        this.manager = manager;
    }

    @ManyToOne
    @JoinColumn(name = "main_classroom_id", referencedColumnName = "classroom_id")
    public Classroom getMainClassroom() {
        return mainClassroom;
    }

    public void setMainClassroom(Classroom mainClassroom) {
        this.mainClassroom = mainClassroom;
    }

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @OneToMany(mappedBy = "courseEdition")
    public Collection<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Collection<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    @OneToMany(mappedBy = "courseEdition")
    public Collection<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Collection<Lesson> lessons) {
        this.lessons = lessons;
    }

    @OneToMany(mappedBy = "courseEdition")
    public Collection<TeachingAssignment> getTeachingAssignments() {
        return teachingAssignments;
    }

    public void setTeachingAssignments(Collection<TeachingAssignment> teachingAssignments) {
        this.teachingAssignments = teachingAssignments;
    }
}
