module epsilon {
    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires transitive java.sql;

    opens epsilon;

    exports epsilon;
    exports epsilon.layouts;
    exports auxiliary;
}