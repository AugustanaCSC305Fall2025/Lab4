module edu.augustana.csc305.lab4 {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;
    requires com.google.gson;

    opens edu.augustana.csc305.lab4 to com.google.gson;

    exports edu.augustana.csc305.lab4;
    exports edu.augustana.csc305.lab4.ui;
    exports edu.augustana.csc305.lab4.serialization;
    opens edu.augustana.csc305.lab4.serialization to com.google.gson;
}