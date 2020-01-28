package net.bitsrl.MyAcademy.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "classroom", schema = "academia")
public class Classroom {
    private int id;
    private String name;
    private int capacity;
    private boolean computerized;
    private Collection<CourseEdition> courseEditions;
    private Collection<Lesson> lessons;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "classroom_id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 18)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "capacity", nullable = false)
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "computerized", nullable = false)
    public boolean isComputerized() {
        return computerized;
    }

    public void setComputerized(boolean computerized) {
        this.computerized = computerized;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return id == classroom.id &&
                capacity == classroom.capacity &&
                computerized == classroom.computerized &&
                Objects.equals(name, classroom.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, capacity, computerized);
    }

    @OneToMany(mappedBy = "mainClassroom")
    public Collection<CourseEdition> getCourseEditions() {
        return courseEditions;
    }

    public void setCourseEditions(Collection<CourseEdition> courseEditions) {
        this.courseEditions = courseEditions;
    }

    @OneToMany(mappedBy = "classroom")
    public Collection<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Collection<Lesson> lessons) {
        this.lessons = lessons;
    }
}
