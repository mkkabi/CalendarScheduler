package model;

import controller.DB;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Schedule {
    private List<StudentsGroup> groups;
    private List<Teacher>  teachers;

    public void createScheduleForGroup(String groupName){
        List<Lesson> lessons = DB.getAllLessonsByGroup(groupName);
        List<Calendar> days = lessons.stream().map(Lesson::getStartTime).toList();
        Map<String, List<Lesson>> lessonsByDay = lessons.stream().collect(Collectors.groupingBy(l->{
            DateFormat formatter = new SimpleDateFormat("EEEE");
            return formatter.format(l.getStartTime().getTime());
        }));

        lessonsByDay.get("Monday");
        Set<String> keys = lessonsByDay.keySet();


        DateFormat formatterTime = new SimpleDateFormat("h:mm a");
        for(int i=1; i<=7; i++){
            String dayOfWeek = DayName.getDayName(i);
            List<Lesson> lessonsDayly = lessonsByDay.get(dayOfWeek);
            System.out.println(dayOfWeek);
            if(lessonsDayly!=null) {
                for (Lesson l : lessonsDayly) {
                    String subj = l.getSubject().toString();
                    Date d = l.getStartTime().getTime();
                    System.out.println();

                    System.out.print("    ");
                    System.out.print(subj);
                    System.out.print("    ");
                    System.out.print(formatterTime.format(l.getStartTime().getTime()) + "  -  " + formatterTime.format(l.getEndTIme().getTime()));
                }
                System.out.println();
            }
        }





    }
}
