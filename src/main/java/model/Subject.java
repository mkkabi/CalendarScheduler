package model;

import repos.SubjectRepository;

public class Subject {
    private String name;
    private SubjectRepository repo = SubjectRepository.getInstance();

    public Subject(String name) {
        this.name = name;
        repo.addSubject(this);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
