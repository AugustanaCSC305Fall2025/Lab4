package edu.augustana.csc305.lab4.serialization;

import edu.augustana.csc305.lab4.Student;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface StudentSaver {
    void saveStudents(File savePath, Iterable<Student> students) throws IOException;
    List<Student> loadStudents(File loadPath) throws IOException, ClassNotFoundException;
}
