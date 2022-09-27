package model;

import controller.DB;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class Schedule {
    private List<StudentsGroup> groups;
    private List<Teacher>  teachers;

    public void createScheduleForGroup(String groupName){
        List<Lesson> lessons = DB.getAllLessonsByGroup(groupName);
        List<Calendar> days = lessons.stream().map(Lesson::getStartTime).toList();


        for(int x=1; x<=7; x++){

        for(int i=0; i<lessons.size(); i++){

            Calendar start = lessons.get(i).getStartTime();
            Calendar end = lessons.get(i).getEndTIme();



            DateFormat formatter = new SimpleDateFormat("EEEE");
            String dayOfWeekString = formatter.format(start.getTime());
            int dayOfWeekNum = start.get(Calendar.DAY_OF_WEEK);

//            start.setFirstDayOfWeek(3);

            System.out.println(DayName.getDayName(x));
            if(DayName.getDayName(x).equals(dayOfWeekString)){
                System.out.print("Day from Sched "+dayOfWeekString+"    " + lessons.get(i).getSubject() + "       ");
            }


            }


        }System.out.println();
    }
}
