package edu.augustana.csc305.lab4;

import edu.augustana.csc305.lab4.ui.RegistrationController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Lab4App extends Application {

    @Override public void start(Stage stage) throws IOException {
        Scene scene = new Scene(new RegistrationController(stage).getView(), 600, 400);
        stage.setScene(scene);
        stage.setTitle("Student Registration");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}