package model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Lesson {
    private Teacher teacher;
    private StudentsGroup group;
    private Subject subject;
    private Calendar startTime, endTIme;

    public Lesson(Teacher teacher, StudentsGroup group, Subject subject, Calendar startTime, Calendar endTIme) {
        this.teacher = teacher;
        this.group = group;
        this.subject = subject;
        this.startTime = startTime;
        this.endTIme = endTIme;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public StudentsGroup getGroup() {
        return group;
    }

    public void setGroup(StudentsGroup group) {
        this.group = group;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public Calendar getEndTIme() {
        return endTIme;
    }

    public void setEndTIme(Calendar endTIme) {
        this.endTIme = endTIme;
    }
}