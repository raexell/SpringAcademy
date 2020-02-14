package net.bitsrl.MyAcademy.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DegreeType {
    HIGH_SCHOOL, COLLEGE, MASTER, PHD;
    @JsonValue
    public int toValue(){
        return ordinal();
    }
}
