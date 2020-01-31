package net.bitsrl.MyAcademy.dto;

import net.bitsrl.MyAcademy.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CourseEditionDTO {
    private int id;
    private String title;
    private int coursid;
    private LocalDate start;
    private LocalDate end;
    private BigDecimal cost;
    private int leadTeacher;
    private int numStudents;
    private BigDecimal ricavatoTot;
    private BigDecimal ricavatoAttuale;
    private int numStudentsHavePaid;
    private int numStudentsHaventPaid;
    private Collection<StudentDTO> iscritti;

    public Collection<StudentDTO> getIscritti() {
        return iscritti;
    }

    public void setIscritti(Collection<StudentDTO> iscritti) {
        this.iscritti = iscritti;
    }

    public CourseEditionDTO(CourseEdition ce) {
        this.id = ce.getId();
        this.title = ce.getCourse().getTitle();
        this.coursid = ce.getCourse().getId();
        this.start = ce.getStart();
        this.end = ce.getEnd();
        this.cost = ce.getCost();
        this.leadTeacher = ce.getLeadTeacher().getId();
        this.numStudents = ce.getEnrollments().size();
       this.ricavatoTot = ce.getCost().multiply(new BigDecimal(ce.getEnrollments().size()));
        this.ricavatoAttuale =ce.getCost().multiply(new BigDecimal(countPayment(ce.getEnrollments(),true)));
        this.numStudentsHavePaid = countPayment(ce.getEnrollments(),true);
        this.numStudentsHaventPaid = countPayment(ce.getEnrollments(),false);
        this.iscritti = this.listaIscritti(ce.getEnrollments());
    }



    public CourseEdition toCourseEdition (){
        CourseEdition ce = new CourseEdition();
        Course corso= new Course();
        Agent manager = new Agent();
        ce.setId(this.id);
        ce.setCost(this.getCost());
        corso.setId(this.getCoursid());
        ce.setCourse(corso);
        manager.setId(this.getLeadTeacher());
        ce.setLeadTeacher(manager);
        ce.setStart(this.getStart());
        ce.setEnd(this.getEnd());
        return ce;
    }

    public int countPayment(Collection<Enrollment> subs, boolean check){
        int cont = 0;
        for (Enrollment e: subs) {
            if(e.isCourseFeePaid()==check){
                cont++;
            }
        }
        return cont;
    }

    public Collection<StudentDTO> listaIscritti (Collection<Enrollment> iscrizioni){
        iscritti = new ArrayList<>();
        for (Enrollment tmp: iscrizioni) {
            iscritti.add(new StudentDTO(tmp.getStudent()));
        }
        return iscritti;
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

    public int getCoursid() {
        return coursid;
    }

    public void setCoursid(int coursid) {
        this.coursid = coursid;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public int getLeadTeacher() {
        return leadTeacher;
    }

    public void setLeadTeacher(int leadTeacher) {
        this.leadTeacher = leadTeacher;
    }

    public int getNumStudents() {
        return numStudents;
    }

    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }

    public BigDecimal getRicavatoTot() {
        return ricavatoTot;
    }

    public void setRicavatoTot(BigDecimal ricavatoTot) {
        this.ricavatoTot = ricavatoTot;
    }

    public BigDecimal getRicavatoAttuale() {
        return ricavatoAttuale;
    }

    public void setRicavatoAttuale(BigDecimal ricavatoAttuale) {
        this.ricavatoAttuale = ricavatoAttuale;
    }

    public int getNumStudentsHavePaid() {
        return numStudentsHavePaid;
    }

    public void setNumStudentsHavePaid(int numStudentsHavePaid) {
        this.numStudentsHavePaid = numStudentsHavePaid;
    }

    public int getNumStudentsHaventPaid() {
        return numStudentsHaventPaid;
    }

    public void setNumStudentsHaventPaid(int numStudentsHaventPaid) {
        this.numStudentsHaventPaid = numStudentsHaventPaid;
    }

    @Override
    public String toString() {
        return "CourseEditionDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", coursid=" + coursid +
                ", start=" + start +
                ", end=" + end +
                ", cost=" + cost +
                ", leadTeacher=" + leadTeacher +
                ", numStudents=" + numStudents +
                ", ricavatoTot=" + ricavatoTot +
                ", ricavatoAttuale=" + ricavatoAttuale +
                ", numStudentsHavePaid=" + numStudentsHavePaid +
                ", getNumStudentsHavePaid=" + numStudentsHaventPaid +
                '}';
    }
}
