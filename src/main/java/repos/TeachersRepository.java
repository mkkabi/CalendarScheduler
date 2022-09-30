package repos;

import model.Lesson;
import model.Teacher;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static utils.Const.*;

public class TeachersRepository {
    private SortedSet<Teacher> teachers = new TreeSet<>();
    private static volatile TeachersRepository instance = null;


    private TeachersRepository() {
    }

    public static TeachersRepository getInstance() {
        if (instance == null) {
            synchronized (TeachersRepository.class) {
                if (instance == null) {
                    instance = new TeachersRepository();
                }
            }
        }
        return instance;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher t) {
        teachers.add(t);
    }

    public boolean isTeacherAvailableForTime(String name, List<Lesson> lessonsByDay, Calendar newStart, Calendar newEnd) {
        for (Lesson l : lessonsByDay) {
            Calendar start = l.getStartTime();
            Calendar end = l.getEndTIme();
            return newEnd.before(start) || newStart.after(end);
        }
        return false;
    }

    public void testTeacherAvailability(List<Lesson> lessonsByDay, String name, Calendar calendar) throws ParseException {
        calendar.setTime(numericalDateTimeFormat.parse("2022,10,17 14:30"));
        if (lessonsByDay != null) {
            for (Lesson l : lessonsByDay) {
                System.out.println(l.getSubject() + " " +
                        numericalDateTimeFormat.format(l.getStartTime().getTime()) + " - " +
                        numericalDateTimeFormat.format((l.getEndTIme().getTime())));
            }
        }
    }

}

