package net.bitsrl.MyAcademy.dto;

import net.bitsrl.MyAcademy.model.Agent;

import java.time.LocalDate;
import java.time.Period;

public class AgentDTO {
    private int id;
    private String firstname;
    private String lastname;
    private String sex;
    private int age;

    public AgentDTO(Agent agent) {
        this.id = agent.getId();
        this.firstname = agent.getFirstname();
        this.lastname = agent.getLastname();
        this.sex = agent.getSex();
        this.age = calculateAge(agent.getBirthdate());
    }

    public int calculateAge(LocalDate bd) {
        LocalDate today = LocalDate.now();
        return Period.between(bd, today).getYears();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSex() {
        return sex.toUpperCase();
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
