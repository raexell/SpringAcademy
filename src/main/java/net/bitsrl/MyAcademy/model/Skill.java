package net.bitsrl.MyAcademy.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "skill", schema = "academia")
public class Skill {
    private int id;
    private String name;
    private String description;
    private Collection<Competence> competences;
    private Area area;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "skill_id", nullable = false)
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
    @Column(name = "description", nullable = true, length = 45)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return id == skill.id &&
                Objects.equals(name, skill.name) &&
                Objects.equals(description, skill.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }

    @OneToMany(mappedBy = "skill")
    public Collection<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(Collection<Competence> competences) {
        this.competences = competences;
    }

    @ManyToOne
    @JoinColumn(name = "area_id", referencedColumnName = "area_id", nullable = false)
    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}
