package net.bitsrl.MyAcademy.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "course", schema = "academia")
public class Course {
    private int id;
    private String title;
    private String description;
    private String syllabus;
    private int numHours;
    private Level level;
    private BigDecimal cost;
    private Area area;
    private Project project;
    private Collection<CourseEdition> courseEditions;

    public Course() {
    }

    public Course (int id, String title, String description, String syllabus,
                   int numHours, Level level, BigDecimal cost, Area area, Project project) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.syllabus = syllabus;
        this.numHours = numHours;
        this.level = level;
        this.cost = cost;
        this.area = area;
        this.project = project;
    }

    public Course(int id, String title, int numHours) {
        this.id = id;
        this.title = title;
        this.numHours = numHours;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 25)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 100)
    public String getDescription() {
        return description;
    }

    public void setDescription(String decription) {
        this.description = decription;
    }

    @Basic
    @Column(name = "syllabus", nullable = true, length = 120)
    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    @Basic
    @Column(name = "numHours", nullable = false)
    public int getNumHours() {
        return numHours;
    }

    public void setNumHours(int numHours) {
        this.numHours = numHours;
    }

    @Basic
    @Column(name = "level", nullable = true)
    @Enumerated(EnumType.ORDINAL)
    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    @Basic
    @Column(name = "cost", nullable = false, precision = 2)
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id &&
                numHours == course.numHours &&
                level == course.level &&
                Objects.equals(title, course.title) &&
                Objects.equals(description, course.description) &&
                Objects.equals(syllabus, course.syllabus) &&
                Objects.equals(cost, course.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, syllabus, numHours, level, cost);
    }

    @ManyToOne
    @JoinColumn(name = "area_id", referencedColumnName = "area_id", nullable = true)
    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "project_id", nullable = true)
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @OneToMany(mappedBy = "course")
    public Collection<CourseEdition> getCourseEditions() {
        return courseEditions;
    }

    public void setCourseEditions(Collection<CourseEdition> courseEditions) {
        this.courseEditions = courseEditions;
    }
}
