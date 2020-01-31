package net.bitsrl.MyAcademy.dto;

import net.bitsrl.MyAcademy.model.Course;
import net.bitsrl.MyAcademy.model.Enrollment;

import java.math.BigDecimal;

public class EnrollmentDTO {
        private int id;
        private String title;
        private String description;
        private BigDecimal cost;
        private int numHours;
        private int idArea;
        private int idProject;

        public EnrollmentDTO(Enrollment enrollment) {

        }
}
