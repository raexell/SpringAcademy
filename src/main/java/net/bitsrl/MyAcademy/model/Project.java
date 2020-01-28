package net.bitsrl.MyAcademy.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "project", schema = "academia")
public class Project {
    private int id;
    private String name;
    private String description;
    private LocalDate start;
    private LocalDate end;
    private BigDecimal budget;
    private boolean isFinanced;
    private Collection<Course> courses;
    private Agent manager;


    public Project() {
    }

    public Project(int id, String name, String description, LocalDate start, LocalDate end, BigDecimal budget,
                     boolean isFinanced, Agent manager) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
        this.budget = budget;
        this.isFinanced = isFinanced;
        this.manager = manager;
    }


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "project_id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 25)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 45)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    @Column(name = "end", nullable = true)
    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    @Basic
    @Column(name = "budget", nullable = false, precision = 2)
    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    @Basic
    @Column(name = "isFinanced", nullable = false)
    public boolean getIsFinanced() {
        return isFinanced;
    }

    public void setIsFinanced(boolean isFinanced) {
        this.isFinanced = isFinanced;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return id == project.id &&
                isFinanced == project.isFinanced &&
                Objects.equals(name, project.name) &&
                Objects.equals(description, project.description) &&
                Objects.equals(start, project.start) &&
                Objects.equals(end, project.end) &&
                Objects.equals(budget, project.budget);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, start, end, budget, isFinanced);
    }

    @OneToMany(mappedBy = "project")
    public Collection<Course> getCourses() {
        return courses;
    }

    public void setCourses(Collection<Course> courses) {
        this.courses = courses;
    }

    @ManyToOne
    @JoinColumn(name = "managerId", referencedColumnName = "agent_id", nullable = false)
    public Agent getManager() {
        return manager;
    }

    public void setManager(Agent manager) {
        this.manager = manager;
    }
}
