package net.bitsrl.MyAcademy.dto;

import net.bitsrl.MyAcademy.model.Agent;
import net.bitsrl.MyAcademy.model.Client;
import net.bitsrl.MyAcademy.model.DegreeType;
import net.bitsrl.MyAcademy.model.Student;

import java.time.LocalDate;
import java.time.Period;

public class StudentDTO {
    private int id;
    private String firstname;
    private String lastname;
    private LocalDate dateOfBirth;
    private String sex;
    private String email;
    private int age;
    private String phone;
    private DegreeType degreeType;
    private String degreeTitle;
    private boolean independent;

    private int idClient;
    public StudentDTO(Student student) {
        this.id = student.getId();
        this.firstname = student.getFirstname();
        this.lastname = student.getLastname();
        this.dateOfBirth = student.getDateOfBirth();
        this.sex = student.getSex();
        this.email = student.getEmail();
        this.idClient = student.getClient().getId();
        this.age=calculateAge(student.getDateOfBirth());
        this.phone = student.getPhone();
        this.degreeType=student.getDegreeType();
        this.degreeTitle = student.getDegreeTitle();
        this.independent = student.isPrivate();
    }

    public StudentDTO(){

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public DegreeType getDegreeType() {
        return degreeType;
    }

    public void setDegreeType(DegreeType degreeType) {
        this.degreeType = degreeType;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public boolean isIndependent() {
        return independent;
    }

    public void setIndependent(boolean independent) {
        this.independent = independent;
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
        student.setPhone(this.phone);
        student.setDegreeType(this.degreeType);
        student.setDegreeTitle(this.degreeTitle);
        student.setPrivate(this.independent);
        return student;
    }
}
