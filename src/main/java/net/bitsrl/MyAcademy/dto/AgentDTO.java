package net.bitsrl.MyAcademy.dto;

import net.bitsrl.MyAcademy.model.Agent;
import net.bitsrl.MyAcademy.model.Client;
import net.bitsrl.MyAcademy.model.Student;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class AgentDTO {
    private int age;
    private int id;
    private String firstname;
    private String lastname;
    private String sex;
    private LocalDate birthdate;
    private String address;
    private String city;
    private String zip;
    private boolean isEmployee;
    private BigDecimal hourlyRate;
    private String phone;
    private String email;
    private String website;

    public Agent toAgent (){
        Agent agent = new Agent();
        agent.setId(this.id);
        agent.setFirstname(this.firstname);
        agent.setLastname(this.lastname);
        agent.setBirthdate(this.birthdate);
        agent.setSex(this.sex);
        agent.setAddress(this.address);
        agent.setCity(this.city);
        agent.setZip(this.zip);
        agent.setEmployee(this.isEmployee);
        agent.setHourlyRate(this.hourlyRate);
        agent.setWebsite(this.website);
        agent.setEmail(this.email);
        agent.setPhone(this.phone);
        return agent;
    }
public AgentDTO(){}
    public AgentDTO(Agent agent) {
        this.id = agent.getId();
        this.firstname = agent.getFirstname();
        this.lastname = agent.getLastname();
        this.sex = agent.getSex();
        this.age = calculateAge(agent.getBirthdate());
        this.birthdate=agent.getBirthdate();
        this.address=agent.getAddress();
        this.city=agent.getCity();
        this.zip=agent.getZip();
        this.isEmployee=agent.isEmployee();
        this.hourlyRate=agent.getHourlyRate();
        this.phone=agent.getPhone();
        this.email=agent.getEmail();
        this.website=agent.getWebsite();
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }


}
