package repos;

import model.Lesson;

import java.util.ArrayList;
import java.util.List;

public class LessonsRepository {
    private List<Lesson> lessons;

    private static volatile LessonsRepository instance = null;

    private LessonsRepository() {
        lessons = new ArrayList<>();
    }

    public static LessonsRepository getInstance() {
        if (instance == null) {
            synchronized (LessonsRepository.class) {
                if (instance == null) {
                    instance = new LessonsRepository();
                }
            }
        }
        return instance;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void addLesson(Lesson l){
        this.lessons.add(l);
    }
}
