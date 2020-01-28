package net.bitsrl.MyAcademy.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student_feedback", schema = "academia")
public class StudentFeedback {
    private int id;
    private int vote;
    private String feedback;
    private TeachingAssignment teachingAssignment;
    private Student student;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "student_feedback_id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "vote", nullable = false)
    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    @Basic
    @Column(name = "feedback", nullable = true, length = 45)
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentFeedback that = (StudentFeedback) o;
        return id == that.id &&
                vote == that.vote &&
                Objects.equals(feedback, that.feedback);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vote, feedback);
    }

    @ManyToOne
    @JoinColumn(name = "teaching_assignment_id", referencedColumnName = "teaching_assignment_id")
    public TeachingAssignment getTeachingAssignment() {
        return teachingAssignment;
    }

    public void setTeachingAssignment(TeachingAssignment teachingAssignment) {
        this.teachingAssignment = teachingAssignment;
    }

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false)
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
