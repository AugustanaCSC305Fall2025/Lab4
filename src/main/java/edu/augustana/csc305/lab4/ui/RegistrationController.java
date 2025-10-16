package edu.augustana.csc305.lab4.ui;

import edu.augustana.csc305.lab4.serialization.GsonSaver;
import edu.augustana.csc305.lab4.serialization.SerializableSaver;
import edu.augustana.csc305.lab4.Student;
import edu.augustana.csc305.lab4.serialization.StudentSaver;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationController {

    /**
     * Swap out different strategies for saving students by constructing
     * this data member with different StudentSaver instances.
     */
    private final StudentSaver studentSaver = new GsonSaver();

    private final RegistrationModel model = new RegistrationModel();
    private final RegistrationView view = new RegistrationView();

    public RegistrationController(Stage stage) {
        model.addStudent(new Student("Foo", "", "", "", "", ""));
        view.setStudentListContent(model.getStudents());
        view.getAddStudentButton().setOnAction(_ -> {
            model.addStudent(view.buildStudent());
        });
        view.getSaveButton().setOnAction(_ -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save Location");
            File saveLocation = fileChooser.showSaveDialog(stage);
            saveStudents(saveLocation);
        });
        view.getLoadButton().setOnAction(_ -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Load From...");
            File loadLocation = fileChooser.showOpenDialog(stage);
            this.loadStudents(loadLocation);
        });
        view.getClearButton().setOnAction(_ -> {
           model.clearStudents();
        });
    }

    private void saveStudents(File saveLocation) {
        try {
            if (saveLocation != null) {
                // Convert the ObservableList (which does not implement Serializable) to a
                // List (which does). Note that the `toList()` method on stream returns an
                // object typed as a List, which we assume will be some Serializable
                // implementation. If it ever isn't, then our code will break at runtime.
                // This is one of the ways using Serializable breaks encapsulation!
                List<Student> studentList = model.getStudents().stream().toList();
                studentSaver.saveStudents(saveLocation, studentList);
            }
        } catch (IOException e) {
            // Rethrowing checked exceptions as runtime exceptions is not always the
            // best way to handle checked exceptions, but it's fine for our purposes.
            throw new RuntimeException(e);
        }
    }

    private void loadStudents(File loadLocation) {
        try {
            if (loadLocation != null) {
                this.model.setStudents(studentSaver.loadStudents(loadLocation));
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public RegistrationView getView() {
        return this.view;
    }
}
