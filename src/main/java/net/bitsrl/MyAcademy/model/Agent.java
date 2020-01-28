package net.bitsrl.MyAcademy.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "agent", schema = "academia")
public class Agent {

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
    private Collection<Client> clients;
    private Collection<Competence> competences;
    private Collection<CourseEdition> primaryCourses;
    private Collection<CourseEdition> managedCourseEditions;
    private Collection<Lesson> lessons;
    private Collection<Project> managedProjects;
    private Collection<TeachingAssignment> teachingAssignments;

    public Agent() {}

    public Agent(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "agent_id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstname", nullable = false, length = 45)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname", nullable = false, length = 45)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "sex", nullable = true, length = 1)
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "birthdate", nullable = true)
    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 45)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "zip", nullable = true, length = 13)
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Basic
    @Column(name = "isEmployee", nullable = true)
    public boolean isEmployee() {
        return isEmployee;
    }

    public void setEmployee(boolean employee) {
        isEmployee = employee;
    }

    @Basic
    @Column(name = "hourlyRate", nullable = true, precision = 2)
    public BigDecimal getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(BigDecimal hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 18)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 18)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "website", nullable = true, length = 18)
    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agent agent = (Agent) o;
        return id == agent.id &&
                isEmployee == agent.isEmployee &&
                Objects.equals(firstname, agent.firstname) &&
                Objects.equals(lastname, agent.lastname) &&
                Objects.equals(sex, agent.sex) &&
                Objects.equals(birthdate, agent.birthdate) &&
                Objects.equals(address, agent.address) &&
                Objects.equals(city, agent.city) &&
                Objects.equals(zip, agent.zip) &&
                Objects.equals(hourlyRate, agent.hourlyRate) &&
                Objects.equals(phone, agent.phone) &&
                Objects.equals(email, agent.email) &&
                Objects.equals(website, agent.website);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, sex, birthdate, address, city, zip, isEmployee, hourlyRate, phone, email, website);
    }

    @OneToMany(mappedBy = "agentManager")
    public Collection<Client> getClients() {
        return clients;
    }

    public void setClients(Collection<Client> clients) {
        this.clients = clients;
    }

    @OneToMany(mappedBy = "agent")
    public Collection<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(Collection<Competence> competences) {
        this.competences = competences;
    }

    @OneToMany(mappedBy = "leadTeacher")
    public Collection<CourseEdition> getPrimaryCourses() {
        return primaryCourses;
    }

    public void setPrimaryCourses(Collection<CourseEdition> primaryCourses) {
        this.primaryCourses = primaryCourses;
    }

    @OneToMany(mappedBy = "manager")
    public Collection<CourseEdition> getManagedCourseEditions() {
        return managedCourseEditions;
    }

    public void setManagedCourseEditions(Collection<CourseEdition> managedCourseEditions) {
        this.managedCourseEditions = managedCourseEditions;
    }

    @OneToMany(mappedBy = "instructor")
    public Collection<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Collection<Lesson> lessons) {
        this.lessons = lessons;
    }

    @OneToMany(mappedBy = "manager")
    public Collection<Project> getManagedProjects() {
        return managedProjects;
    }

    public void setManagedProjects(Collection<Project> managedProjects) {
        this.managedProjects = managedProjects;
    }

    @OneToMany(mappedBy = "teacher")
    public Collection<TeachingAssignment> getTeachingAssignments() {
        return teachingAssignments;
    }

    public void setTeachingAssignments(Collection<TeachingAssignment> teachingAssignments) {
        this.teachingAssignments = teachingAssignments;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
