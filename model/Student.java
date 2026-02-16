package model;

import java.sql.Date;

public class Student {
    public int id;
    public String fn;
    public String type;
    public Date doj;

    public Student() {}

    public Student(int id, String fn, String type, Date doj) {
        this.id = id;
        this.fn = fn;
        this.type = type;
        this.doj = doj;
    }
}