package repos;

import model.Lesson;
import model.StudentsGroup;

import java.util.ArrayList;
import java.util.List;

public class StudentGroupsRepository {
    private static List<StudentsGroup> groups = new ArrayList<>();

    private static volatile StudentGroupsRepository instance = null;

    private StudentGroupsRepository() {
    }

    public static StudentGroupsRepository getInstance() {
        if (instance == null) {
            synchronized (StudentGroupsRepository.class) {
                if (instance == null) {
                    instance = new StudentGroupsRepository();
                }
            }
        }
        return instance;
    }
    public void addGroup(StudentsGroup g){
        this.groups.add(g);
    }
    public List<StudentsGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<StudentsGroup> groups) {
        this.groups = groups;
    }
}
