package repos;

import model.Subject;
import java.util.ArrayList;
import java.util.List;

public class SubjectRepository {
    private List<Subject> subjects;
        private static volatile SubjectRepository instance = null;
        private SubjectRepository() {
            subjects = new ArrayList<>();
        }

        public static SubjectRepository getInstance() {
            if (instance == null) {
                synchronized (repos.TeachersRepository.class) {
                    if (instance == null) {
                        instance = new SubjectRepository();
                    }
                }
            }
            return instance;
        }

        public void addSubject(Subject s){
            this.subjects.add(s);
        }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
