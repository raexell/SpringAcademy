package net.bitsrl.MyAcademy.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "teaching_assignment", schema = "academia")
public class TeachingAssignment {
    private int id;
    private BigDecimal hourlyRate;
    private BigDecimal hourNumber;
    private String comments;
    private Agent teacher;
    private CourseEdition courseEdition;

    @Id
    @GeneratedValue
    @Column(name = "teaching_assignment_id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "hourly_rate", nullable = true, precision = 2)
    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Basic
    @Column(name = "hour_number", nullable = false, precision = 2)
    public BigDecimal getHourNumber() {
        return hourNumber;
    }

    public void setHourNumber(BigDecimal hourNumber) {
        this.hourNumber = hourNumber;
    }

    @Basic
    @Column(name = "comments", nullable = true, length = 45)
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TeachingAssignment that = (TeachingAssignment) o;
        return id == that.id &&
                Objects.equals(hourlyRate, that.hourlyRate) &&
                Objects.equals(hourNumber, that.hourNumber) &&
                Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hourlyRate, hourNumber, comments);
    }

    @ManyToOne
    @JoinColumn(name = "agent_id", referencedColumnName = "agent_id", nullable = false)
    public Agent getTeacher() {
        return teacher;
    }

    public void setTeacher(Agent teacher) {
        this.teacher = teacher;
    }

    @ManyToOne
    @JoinColumn(name = "course_edition_id", referencedColumnName = "course_edition_id", nullable = false)
    public CourseEdition getCourseEdition() {
        return courseEdition;
    }

    public void setCourseEdition(CourseEdition courseEdition) {
        this.courseEdition = courseEdition;
    }
}
