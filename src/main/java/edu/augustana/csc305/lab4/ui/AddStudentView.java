package edu.augustana.csc305.lab4.ui;

import edu.augustana.csc305.lab4.Student;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class AddStudentView extends GridPane {

    private final TextField name = new TextField();
    private final TextField address1 = new TextField();
    private final TextField address2 = new TextField();
    private final TextField city = new TextField();
    private final TextField state = new TextField();
    private final TextField zip = new TextField();

    private final Button addButton = new Button("Add Student");

    public AddStudentView() {
        setPadding(new Insets(10, 10, 10, 10));
        setHgap(10);
        setVgap(10);

        add(new Label("Name:"), 0, 0);
        add(name, 1, 0);

        add(new Label("Address:"), 0, 1);
        add(address1, 1, 1);
        add(address2, 1, 2);

        add(new Label("City:"), 0, 3);
        add(city, 1, 3);

        add(new Label("State:"), 0, 4);
        add(state, 1, 4);

        add(new Label("Zip:"), 0, 5);
        add(zip, 1, 5);

        add(addButton, 1, 6);
    }

    public Student buildStudent() {
        return new Student(
                this.name.getText(),
                this.address1.getText(),
                this.address2.getText(),
                this.city.getText(),
                this.state.getText(),
                this.zip.getText());
    }

    public Button getAddButton() {
        return this.addButton;
    }
}
