module org.example.corte_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.corte_1 to javafx.fxml;
    exports org.example.corte_1;
}