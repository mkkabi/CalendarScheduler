package model;

import controller.Controller;
import controller.DB;
import controller.FileController;
import repos.LessonsRepository;
import repos.TeachersRepository;
import utils.DayName;

import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Schedule {
    private final DateFormat yearWeekFormatter = new SimpleDateFormat("YYYY ww");
    private final DateFormat dayFormatter = new SimpleDateFormat("EEEE");
    private final DateFormat numericalDateTimeFormat = new SimpleDateFormat("yyyy,MM,dd HH:mm");
    private final DateFormat numericalDateFormat = new SimpleDateFormat("yyyy,MM,dd");
    private final DateFormat timeFormat = new SimpleDateFormat("HH:mm");
    private final Controller controller = FileController.getInstance();
    private List<Lesson> lessons;

    public Schedule(){
        lessons = controller.getLessons();
    }

    public List<Lesson> getTeachersLesonsByDay(String name, Calendar cal){
        DateFormat format = numericalDateFormat;
        List<Lesson> lessonsByTeacherAndDay = lessons.stream().filter(l->l.getTeacher().getName().equals(name)).filter(l->
                format.format(l.getStartTime().getTime()).equals(format.format(cal.getTime()))).collect(Collectors.toList());
        return lessonsByTeacherAndDay;
    }

    public void createScheduleForGroup(String groupName){
         Map<String,List<Lesson>> lessonsByWeekAndYear =
        lessons.stream().collect(Collectors.groupingBy(l->{
             return yearWeekFormatter.format(l.getStartTime().getTime());
        }));

        lessonsByWeekAndYear.keySet().stream().sorted().forEach(s->{
            lessonsByWeekAndYear.get(s).stream().forEach(l->{
//                System.out.println(yearWeekFormatter.format(l.getStartTime().getTime())+"  "+dayFormatter.format(l.getStartTime().getTime()));
//                System.out.println(l.toString());
            });
            System.out.println("==========");
        });

        try {
            this.testTeacherAvailability();

            Calendar newStart = Calendar.getInstance();
            Calendar newEnd = Calendar.getInstance();
            newStart.setTime(numericalDateTimeFormat.parse("2022,10,17 15:00"));
            newEnd.setTime(numericalDateTimeFormat.parse("2022,10,17 15:30"));
            System.out.println(isTeacherAvailableForTime("Ivan Tsarevich", newStart, newEnd));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public boolean isTeacherAvailableForTime(String name, Calendar newStart, Calendar newEnd){
        for(Lesson l : getTeachersLesonsByDay(name, newStart)) {
            Calendar start = l.getStartTime();
            Calendar end = l.getEndTIme();
            return newEnd.before(start) || newStart.after(end);
        }
        return false;
    }

    public void testTeacherAvailability() throws ParseException {
        Calendar calendar = Calendar.getInstance();
        DateFormat format = new SimpleDateFormat("YYYY ww EEEE");
        calendar.setTime(numericalDateTimeFormat.parse("2022,10,17 14:30"));
        List<Lesson> list = getTeachersLesonsByDay("Ivan Tsarevich", calendar);
        if(list!=null){
            for(Lesson l : list){
                System.out.println(l.getSubject() + " " +
                        numericalDateTimeFormat.format(l.getStartTime().getTime())+" - "+
                        numericalDateTimeFormat.format((l.getEndTIme().getTime())));
            }
        }
    }

    boolean isInTimeRange(int startingHour, int endingHour, int hourOfDayToCheck) {
        if (endingHour > startingHour) {
            return hourOfDayToCheck >= startingHour && hourOfDayToCheck < endingHour;
        } else {
            return hourOfDayToCheck >= startingHour || hourOfDayToCheck < endingHour;
        }
    }
}
