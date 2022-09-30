package controller;

import model.Lesson;

import java.util.List;

public interface Controller {
    List<Lesson> getAllLessons();
    List<Lesson> allLessonsByMonthAndGroup(int month, String group);
    List<Lesson> allLessonsByMonthAndTeacher(int month, String groupName);
}
