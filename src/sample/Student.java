package sample;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class Student implements Comparable<Student> {
    private Integer studentID;
    private Double diveRate;
    private LocalTime lunchTime;
    private Integer lunchPeriod;
    private boolean havingLunch;
    private DateTimeFormatter format = DateTimeFormatter.ofPattern("HHmm");

    public Student(Integer studentID) {

        this.studentID = studentID;
        this.diveRate = (Math.random()*(100));
        this.lunchPeriod = (int) (Math.random()*(60 - 5))+5;
        this.havingLunch = false;

        int randomTime = ThreadLocalRandom
                .current()
                .nextInt(39600, 50400);
        this.lunchTime = LocalTime.ofSecondOfDay(randomTime);

    }

    public Integer getStudentID(){
        return studentID;
    }

    public Double getDiveRate() {
        return diveRate;
    }

    public Integer getLunchTime() {
        return Integer.valueOf(lunchTime.format(format).toString());
    }

    public Integer getLunchEndTime(){
        LocalTime end = lunchTime.plusMinutes(lunchPeriod);
        return Integer.valueOf(end.format(format).toString());
    }

    public Integer getLunchPeriod() {
        return lunchPeriod;
    }

    public void haveLunch(){
        this.havingLunch = true;
    }

    public void endLunch(){
        this.havingLunch = false;
    }

    @Override
    public int compareTo(Student o) {
        return this.studentID.compareTo(o.studentID);
    }

    public String toString(){return String.valueOf(this.studentID);};
}
