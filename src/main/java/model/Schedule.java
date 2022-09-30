package model;

import controller.Controller;
import controller.FileController;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

import repos.TeachersRepository;

import static utils.Const.*;

public class Schedule {
    private TeachersRepository teacherRepo = TeachersRepository.getInstance();

    private List<Lesson> lessons;

    public Schedule() {
        lessons = contoller.getAllLessons();
    }

    public List<Lesson> getTeachersLesonsByDay(String name, Calendar cal) {
        DateFormat format = numericalDateFormat;
        List<Lesson> lessonsByTeacherAndDay = lessons.stream().filter(l -> l.getTeacher().getName().equals(name)).filter(l ->
                format.format(l.getStartTime().getTime()).equals(format.format(cal.getTime()))).collect(Collectors.toList());
        return lessonsByTeacherAndDay;
    }

    public void createScheduleForGroup(String groupName) {
        Map<String, List<Lesson>> lessonsByWeekAndYear =
                lessons.stream().collect(Collectors.groupingBy(l -> {
                    return yearWeekFormatter.format(l.getStartTime().getTime());
                }));

        lessonsByWeekAndYear.keySet().stream().sorted().forEach(s -> {
            lessonsByWeekAndYear.get(s).stream().forEach(l -> {
                System.out.println(yearWeekFormatter.format(l.getStartTime().getTime()) + "  " + dayFormatter.format(l.getStartTime().getTime()));
                System.out.println(l.toString());
            });
            System.out.println("==========");
        });

    }


}
