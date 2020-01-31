package net.bitsrl.MyAcademy.dto;

import net.bitsrl.MyAcademy.model.Agent;
import net.bitsrl.MyAcademy.model.Client;
import net.bitsrl.MyAcademy.model.Student;

import java.time.LocalDate;

public class StudentDTO {
    private int id;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String sex;
    private String email;
    private int idClient;

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.firstname = student.getFirstname();
        this.lastname = student.getLastname();
        this.dateOfBirth = student.getDateOfBirth();
        this.sex = student.getSex();
        this.email = student.getEmail();
        this.idClient = student.getClient().getId();
    }

    public StudentDTO(){

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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", idClient=" + idClient +
                '}';
    }

    public Student toStudent (){
        Student student = new Student();
        student.setId(this.id);
        student.setFirstname(this.firstname);
        student.setLastname(this.lastname);
        student.setDateOfBirth(this.dateOfBirth);
        student.setSex(this.sex);
        student.setEmail(this.email);
        Client client = new Client();
        client.setId(this.idClient);
        student.setClient(client);
        return student;
    }
}
