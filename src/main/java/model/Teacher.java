package model;

import repos.TeachersRepository;

import java.util.List;
import java.util.Objects;

public class Teacher implements Comparable{
    private String name;
    private TeachersRepository repo = TeachersRepository.getInstance();

    public Teacher(String name) {
        this.name = name;
        repo.addTeacher(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return this.getName().equals(teacher.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public int compareTo(Object o) {
        Teacher teacher = (Teacher)o;
        return getName().compareTo(teacher.getName());
    }
}
