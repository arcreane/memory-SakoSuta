module com.example.memoryy {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.memoryy to javafx.fxml;
    exports com.example.memoryy;
}