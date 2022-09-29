package controller;

import model.Lesson;
import model.StudentsGroup;
import model.Subject;
import model.Teacher;
import repos.StudentGroupsRepository;
import utils.FileUtils;

import javax.swing.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

public class FileController implements Controller{
    private static volatile FileController instance;
    private String lessonsFIle = "src/main/java/lessons";
    private List<Lesson> lessons;

    private FileController(){

    }

    public static FileController getInstance() {
        if (instance == null) {
            synchronized (FileController.class) {
                if (instance == null) {
                    instance = new FileController();
                }
            }
        }
        return instance;
    }

    public List<Lesson> getLessons(){
        if(lessons!=null)
            return lessons;
        else
            return readAllData();
    }

    public void notifyChange(){
        this.lessons = readAllData();
    }

    @Override
    public List<Lesson> readAllData() {
        List<String> lines = FileUtils.readFileString(lessonsFIle);

        List<Lesson> allLessons = lines.stream().map(s->{
            String[] strArr = s.split(";");
            DateFormat df = new SimpleDateFormat("yyyy,MM,dd HH:mm");
            Date dateStart = null ;
            Date dateEnd = null;
            try {
                dateStart = df.parse(strArr[3]);
                dateEnd = df.parse(strArr[4]);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Calendar calStart = Calendar.getInstance(Locale.UK);
            Calendar calEnd = Calendar.getInstance(Locale.UK);
            calStart.setTime(dateStart);
            calEnd.setTime(dateEnd);

            return new Lesson(new Teacher(strArr[0]),new StudentsGroup(strArr[1]),
                    new Subject(strArr[2]),calStart, calEnd);
        }).collect(Collectors.toList());
        return allLessons;
    }

    @Override
    public List<Lesson> readDataByWeek(int week) {
        return null;
    }

    @Override
    public List<Lesson> allLessonsByGroup(String groupName) {
        return null;
    }
}
