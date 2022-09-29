package controller;

import model.Lesson;

import java.util.List;

public interface Controller {
    List<Lesson> readAllData();
    public List<Lesson> getLessons();
    List<Lesson> readDataByWeek(int week);
    List<Lesson> allLessonsByGroup(String groupName);
}
