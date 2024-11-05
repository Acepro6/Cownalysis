package com.example.demo.Views;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class FieldValueView extends StackPane {
    public FieldValueView(String field, String value) {
        Label fieldLabel = new Label(field + ":");
        fieldLabel.setStyle("-fx-font-size: 14");
        Label valueLabel = new Label(value);
        valueLabel.setStyle("-fx-font-family: Arial; -fx-font-weight: bold; -fx-background-color: #F3F3F3; -fx-background-radius: 8;");
        valueLabel.setPadding(new Insets(5, 10, 5, 10));
        VBox vBox = new VBox(fieldLabel,  valueLabel);
        HBox hbox = new HBox(vBox);
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER_LEFT);
        this.getChildren().add(hbox);
    }
}
