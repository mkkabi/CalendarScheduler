package repos;

import model.Lesson;
import model.Teacher;

import java.util.*;

public class TeachersRepository {
        private SortedSet<Teacher> teachers = new TreeSet<>();
        private static volatile TeachersRepository instance = null;

    private TeachersRepository() {}

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

        public void addTeacher(Teacher t){
            teachers.add(t);
        }
    }

