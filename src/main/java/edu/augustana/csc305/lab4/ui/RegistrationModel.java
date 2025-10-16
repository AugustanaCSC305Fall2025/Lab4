package edu.augustana.csc305.lab4.ui;

import edu.augustana.csc305.lab4.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class RegistrationModel {

    private final ObservableList<Student> students = FXCollections.observableArrayList();

    public void addStudent(Student student) {
        students.add(student);
    }

    public ObservableList<Student> getStudents() {
        return students;
    }

    public void clearStudents() {
        students.clear();
    }

    public void setStudents(List<Student> students) {
        this.students.clear();
        this.students.addAll(students);
    }
}
