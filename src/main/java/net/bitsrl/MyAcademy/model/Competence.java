package net.bitsrl.MyAcademy.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "competence", schema = "academia")
public class Competence {
    private int id;
    private byte level;
    private Agent agent;
    private Skill skill;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "competence_id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "level", nullable = false)
    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competence that = (Competence) o;
        return id == that.id &&
                level == that.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, level);
    }

    @ManyToOne
    @JoinColumn(name = "agent_id", referencedColumnName = "agent_id", nullable = false)
    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    @ManyToOne
    @JoinColumn(name = "skill_id", referencedColumnName = "skill_id", nullable = false)
    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
