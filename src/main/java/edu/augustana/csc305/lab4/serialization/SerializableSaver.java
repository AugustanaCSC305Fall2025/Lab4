package edu.augustana.csc305.lab4.serialization;

import edu.augustana.csc305.lab4.Student;

import java.io.*;
import java.util.List;

public class SerializableSaver implements StudentSaver {

    @Override public void saveStudents(File savePath, Iterable<Student> students)
            throws IOException {
        FileOutputStream fos = new FileOutputStream(savePath);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(students);
        oos.flush();
        oos.close();
    }

    @Override public List<Student> loadStudents(File loadPath)
            throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(loadPath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        List<Student> students = (List<Student>) ois.readObject();
        ois.close();
        return students;
    }
}
