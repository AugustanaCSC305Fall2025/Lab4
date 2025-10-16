package edu.augustana.csc305.lab4.ui;

import edu.augustana.csc305.lab4.Student;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class RegistrationView extends BorderPane {

    private final Button saveButton = new Button("Save");
    private final Button clearButton = new Button("Clear");
    private final Button loadButton = new Button("Load");

    private final ListView<Student> studentListView = new ListView<>();
    private final AddStudentView addStudentView = new AddStudentView();

    public RegistrationView() {
        this.setCenter(new ScrollPane(studentListView));
        this.setRight(addStudentView);
        this.setBottom(buildButtonBox());
    }

    public void setStudentListContent(ObservableList<Student> content) {
        studentListView.setItems(content);
    }

    public Button getSaveButton() {
        return this.saveButton;
    }

    public Button getClearButton() {
        return this.clearButton;
    }

    public Button getLoadButton() {
        return this.loadButton;
    }

    public Button getAddStudentButton() {
        return addStudentView.getAddButton();
    }

    public Student buildStudent() {
        return addStudentView.buildStudent();
    }

    private HBox buildButtonBox() {
        HBox buttonBox = new HBox(this.saveButton, this.clearButton, this.loadButton);
        buttonBox.setSpacing(7);
        buttonBox.setPadding(new Insets(10, 10, 10, 10));
        buttonBox.setAlignment(Pos.CENTER);
        return buttonBox;
    }
}
