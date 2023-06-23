module com.example.projetoelectrozone {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.projetoelectrozone to javafx.fxml;
    exports com.example.projetoelectrozone;
    exports com.example.projetoelectrozone.exceptions;
    opens com.example.projetoelectrozone.exceptions to javafx.fxml;
    exports com.example.projetoelectrozone.menu;
    opens com.example.projetoelectrozone.menu to javafx.fxml;
}