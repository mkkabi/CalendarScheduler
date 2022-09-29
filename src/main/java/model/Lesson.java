package model;

import repos.LessonsRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Lesson {
    private Teacher teacher;
    private StudentsGroup group;
    private Subject subject;
    private LessonsRepository repo = LessonsRepository.getInstance();
    private Calendar startTime = Calendar.getInstance(Locale.UK),
            endTIme = Calendar.getInstance(Locale.UK);

    public Lesson(Teacher teacher, StudentsGroup group, Subject subject, Calendar startTime, Calendar endTIme) {
        this.teacher = teacher;
        this.group = group;
        this.subject = subject;
        this.startTime = startTime;
        this.endTIme = endTIme;
        repo.addLesson(this);
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

    @Override
    public String toString() {
        DateFormat formatterTime = new SimpleDateFormat("yyyy,MM,dd HH:mm");
//        DateFormat formatterTime = new SimpleDateFormat("YYYY-'W'ww");
        return "Lesson " +
                "teacher = " + teacher.getName() +
                ", group = " + group.getName() +
                ", subject = " + subject +
                ", startTime = " + formatterTime.format(startTime.getTime()) +
                ", endTIme = " + formatterTime.format(endTIme.getTime()) +
                '}';
    }
}