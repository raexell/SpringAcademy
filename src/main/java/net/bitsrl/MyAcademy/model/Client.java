package net.bitsrl.MyAcademy.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "client", schema = "academia")
public class Client {
    private int id;
    private String name;
    private String pIva;
    private String fiscalCode;
    private String addess;
    private String city;
    private String zip;
    private String phone;
    private String email;
    private Agent agentManager;
    private Collection<Student> students;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "client_id", nullable = false)
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
    @Column(name = "p_iva", nullable = false, length = 45)
    public String getpIva() {
        return pIva;
    }

    public void setpIva(String pIva) {
        this.pIva = pIva;
    }

    @Basic
    @Column(name = "fiscal_code", nullable = false, length = 45)
    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    @Basic
    @Column(name = "addess", nullable = false, length = 45)
    public String getAddess() {
        return addess;
    }

    public void setAddess(String addess) {
        this.addess = addess;
    }

    @Basic
    @Column(name = "city", nullable = false, length = 45)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "zip", nullable = false, length = 18)
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 18)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 32)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id &&
                Objects.equals(name, client.name) &&
                Objects.equals(pIva, client.pIva) &&
                Objects.equals(fiscalCode, client.fiscalCode) &&
                Objects.equals(addess, client.addess) &&
                Objects.equals(city, client.city) &&
                Objects.equals(zip, client.zip) &&
                Objects.equals(phone, client.phone) &&
                Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pIva, fiscalCode, addess, city, zip, phone, email);
    }

    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "agent_id")
    public Agent getAgentManager() {
        return agentManager;
    }

    public void setAgentManager(Agent agentManager) {
        this.agentManager = agentManager;
    }

    @OneToMany(mappedBy = "client")
    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }
}
