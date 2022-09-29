package model;

import repos.StudentGroupsRepository;

import java.util.List;

public class StudentsGroup {
    private String name;
    private StudentGroupsRepository repo = StudentGroupsRepository.getInstance();


    public StudentsGroup(String name) {
        this.name = name;
        repo.addGroup(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
