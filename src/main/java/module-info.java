module epsilon {
    requires javafx.controls;
    requires javafx.fxml;

    opens epsilon to javafx.fxml;
    exports epsilon;
}
