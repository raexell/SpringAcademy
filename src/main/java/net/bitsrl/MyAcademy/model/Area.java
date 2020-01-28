package net.bitsrl.MyAcademy.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "area", schema = "academia")
public class Area {
    private int id;
    private String name;
    private String description;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "area_id", nullable = false)
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
        Area area = (Area) o;
        return id == area.id &&
                Objects.equals(name, area.name) &&
                Objects.equals(description, area.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
