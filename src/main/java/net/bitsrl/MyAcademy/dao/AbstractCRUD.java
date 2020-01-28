package net.bitsrl.MyAcademy.dao;

import net.bitsrl.MyAcademy.model.Agent;
import net.bitsrl.MyAcademy.model.Course;

import java.util.Collection;

public interface AbstractCRUD {

    Object create(Object toInsert);
    boolean delete(int id);
    boolean update(Object toUpdate);
    Collection<Object> getAll();
    Object getById(int id);

}
