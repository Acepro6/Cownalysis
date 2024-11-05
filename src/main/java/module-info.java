module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.DataClasses;
    opens com.example.demo.DataClasses to javafx.fxml;
    exports com.example.demo.Enums;
    opens com.example.demo.Enums to javafx.fxml;
    exports com.example.demo.Delete;
    opens com.example.demo.Delete to javafx.fxml;
    exports com.example.demo.Views;
    opens com.example.demo.Views to javafx.fxml;
    exports com.example.demo.Icons;
    opens com.example.demo.Icons to javafx.fxml;
    exports com.example.demo.ImportExports;
    opens com.example.demo.ImportExports to javafx.fxml;
}