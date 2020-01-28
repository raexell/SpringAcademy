package net.bitsrl.MyAcademy.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "lesson", schema = "academia")
public class Lesson {
    private int id;
    private LocalDate start;
    private LocalDate end;
    private String subject;
    private Agent instructor;
    private CourseEdition courseEdition;
    private Classroom classroom;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "lesson_id", nullable = false)
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
    @Column(name = "subject", nullable = true, length = 45)
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return id == lesson.id &&
                Objects.equals(start, lesson.start) &&
                Objects.equals(end, lesson.end) &&
                Objects.equals(subject, lesson.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start, end, subject);
    }

    @ManyToOne
    @JoinColumn(name = "instructor_id", referencedColumnName = "agent_id")
    public Agent getInstructor() {
        return instructor;
    }

    public void setInstructor(Agent instructor) {
        this.instructor = instructor;
    }

    @ManyToOne
    @JoinColumn(name = "course_edition_id", referencedColumnName = "course_edition_id", nullable = false)
    public CourseEdition getCourseEdition() {
        return courseEdition;
    }

    public void setCourseEdition(CourseEdition courseEdition) {
        this.courseEdition = courseEdition;
    }

    @ManyToOne
    @JoinColumn(name = "classroom_id", referencedColumnName = "classroom_id")
    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
