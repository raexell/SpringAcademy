package net.bitsrl.MyAcademy.model;

import net.bytebuddy.asm.Advice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;

public class Days {
    private enum Month{
        JAN,FEB,MAR,APR,MAY,JUN,JUL,AUG,SEP,OCT,NOV,DEC
    }
    private Month mese;
    private int num;
    private enum Day{
        MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY
    }
    private Day giorno;
    private Collection<Lesson> lesson;


    public Days(Month mese, Day giorno,int num){
        this.mese = mese;
        this.giorno = giorno;
        this.num =num;
    }

    public Month getMese() {
        return mese;
    }

    public void setMese(Month mese) {
        this.mese = mese;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Day getGiorno() {
        return giorno;
    }

    public void setGiorno(Day giorno) {
        this.giorno = giorno;
    }

    public Collection<Days> getCalendar(){
        Collection<Days> calendar = new ArrayList<>();
        int contDays = 7;
        for(int m = 1; m <= 12 ;m++){
            switch (m){
                case 1:
                    for (int d = 1; d<=31;d++){
                        calendar.add(new Days(Month.JAN,nameDay(contDays),d));
                        contDays++;
                    }
                case 2:
                    for (int d = 1; d<=29;d++){
                        calendar.add(new Days(Month.FEB,nameDay(contDays),d));
                        contDays++;
                    }
                case 3:
                    for (int d = 1; d<=31;d++){
                        calendar.add(new Days(Month.MAR,nameDay(contDays),d));
                        contDays++;
                    }
                case 4:
                    for (int d = 1; d<=30;d++){
                        calendar.add(new Days(Month.APR,nameDay(contDays),d));
                        contDays++;
                    }
                case 5:
                    for (int d = 1; d<=31;d++){
                        calendar.add(new Days(Month.MAY,nameDay(contDays),d));
                        contDays++;
                    }
                case 6:
                    for (int d = 1; d<=30;d++){
                        calendar.add(new Days(Month.JUN,nameDay(contDays),d));
                        contDays++;
                    }
                case 7:
                    for (int d = 1; d<=31;d++){
                        calendar.add(new Days(Month.JUL,nameDay(contDays),d));
                        contDays++;
                    }
                case 8:
                    for (int d = 1; d<=31;d++){
                        calendar.add(new Days(Month.AUG,nameDay(contDays),d));
                        contDays++;
                    }
                case 9:
                    for (int d = 1; d<=30;d++){
                        calendar.add(new Days(Month.SEP,nameDay(contDays),d));
                        contDays++;
                    }
                case 10:
                    for (int d = 1; d<=31;d++){
                        calendar.add(new Days(Month.OCT,nameDay(contDays),d));
                        contDays++;
                    }
                case 11:
                    for (int d = 1; d<=30;d++){
                        calendar.add(new Days(Month.NOV,nameDay(contDays),d));
                        contDays++;
                    }
                case 12:
                    for (int d = 1; d<=31;d++){
                        calendar.add(new Days(Month.DEC,nameDay(contDays),d));
                        contDays++;
                    }
            }
        }
        return calendar;
    }

    public Day nameDay(int count){
        int r = count % 7;
        Day retuned = null;
        switch (r){
            case 0:
                retuned = Day.WEDNESDAY;
                break;
            case 1:
                retuned = Day.THURSDAY;
                break;
            case 2:
                retuned = Day.FRIDAY;
                break;
            case 3:
                retuned = Day.SATURDAY;
                break;
            case 4:
                retuned = Day.SUNDAY;
                break;
            case 5:
                retuned = Day.MONDAY;
                break;
            case 6:
                retuned = Day.TUESDAY;
                break;
        }
        return retuned;
    }

    public Collection<Lesson> getLesson() {
        return lesson;
    }

    public void setLesson(Collection<Lesson> lesson) {
        this.lesson = lesson;
    }
}
