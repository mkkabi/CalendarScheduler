package controller;

import model.Lesson;
import model.StudentsGroup;
import model.Subject;
import model.Teacher;

import java.util.*;
import java.util.stream.Collectors;

public class DB {
    private static List<StudentsGroup> studentsGroupList = new ArrayList<>();
    private static List<Lesson> lessons = new ArrayList<>();
    private static List<Teacher> teachers = new ArrayList<>();
    private static List<Subject> subjects = new ArrayList<>();

    static{
        studentsGroupList.add(new StudentsGroup("One"));
        studentsGroupList.add(new StudentsGroup("Two"));
        subjects.addAll(Arrays.asList(new Subject("Math"), new Subject("Literature"), new Subject("Chemistry")));
        teachers.addAll(Arrays.asList(new Teacher("Wasya"), new Teacher("Petya")));

         lessons.addAll(Arrays.asList(
                 new Lesson(teachers.get(0), studentsGroupList.get(0), subjects.get(0),
                         new GregorianCalendar(2022, Calendar.SEPTEMBER,28,12,30),
                         new GregorianCalendar(2022,Calendar.SEPTEMBER,28,14, 00)),
                 new Lesson(teachers.get(1), studentsGroupList.get(0), subjects.get(1),
                         new GregorianCalendar(2022, Calendar.SEPTEMBER,28,14,30),
                         new GregorianCalendar(2022,Calendar.SEPTEMBER,28,16,00)),
                 new Lesson(teachers.get(1), studentsGroupList.get(0), subjects.get(2),
                         new GregorianCalendar(2022, Calendar.SEPTEMBER,28,16,30),
                         new GregorianCalendar(2022,Calendar.SEPTEMBER,28,18,00)),
                 new Lesson(teachers.get(0), studentsGroupList.get(0), subjects.get(0),
                         new GregorianCalendar(2022, Calendar.SEPTEMBER,29,12,30),
                         new GregorianCalendar(2022,Calendar.SEPTEMBER,29,14, 00)),
                 new Lesson(teachers.get(1), studentsGroupList.get(0), subjects.get(1),
                         new GregorianCalendar(2022, Calendar.SEPTEMBER,29,14,30),
                         new GregorianCalendar(2022,Calendar.SEPTEMBER,29,16,00)),
                 new Lesson(teachers.get(1), studentsGroupList.get(0), subjects.get(2),
                         new GregorianCalendar(2022, Calendar.SEPTEMBER,29,16,30),
                         new GregorianCalendar(2022,Calendar.SEPTEMBER,29,18,00))
         ));

    }

    public static List<Lesson> getAllLessonsByGroup(String groupName){
        return lessons.stream().filter(lesson -> lesson.getGroup().getName().equals(groupName)).collect(Collectors.toCollection(ArrayList::new));
    }

    public static DB getInstance() {
        return new DB();
    }


}
