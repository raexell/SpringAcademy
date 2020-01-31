package net.bitsrl.MyAcademy.dto;

import net.bitsrl.MyAcademy.model.Course;
import net.bitsrl.MyAcademy.model.Student;

import java.math.BigDecimal;

public class CourseDTO {
    private int id;
    private String title;
    private String description;
    private BigDecimal cost;
    private int numHours;
    private int idArea;
    private int idProject;

    public CourseDTO(Course corso) {
        this.id = corso.getId();
        this.title = corso.getTitle();
        this.description = corso.getDescription();
        this.cost = corso.getCost();
        this.numHours = corso.getNumHours();
        this.idArea = corso.getArea().getId();
        this.idProject = corso.getProject().getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getNumHours() {
        return numHours;
    }

    public void setNumHours(int numHours) {
        this.numHours = numHours;
    }

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", numHours=" + numHours +
                ", idArea=" + idArea +
                ", idProject=" + idProject +
                '}';
    }

}
