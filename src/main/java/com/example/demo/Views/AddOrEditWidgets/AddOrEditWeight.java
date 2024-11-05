package com.example.demo.Views.AddOrEditWidgets;

import com.example.demo.DataClasses.Weight;
import javafx.geometry.Insets;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class AddOrEditWeight extends StackPane {
//    LabelAndTextFieldComponent date;
    LabelAndTextFieldComponent weight;
    DatePicker datePicker;
    HBox hBox;
    public AddOrEditWeight(Weight possibleWeight) {
        datePicker = new DatePicker();
        hBox = new HBox();
        if (possibleWeight == null) {
            this.weight = new LabelAndTextFieldComponent("Weight:", "");
//            this.date = new LabelAndTextFieldComponent("Date:", possibleWeight.getDate().toString());
            Label label = new Label("Date:");
            datePicker = new DatePicker();
            hBox = new HBox(label, datePicker);
            hBox.setSpacing(20);


        } else {
            this.weight = new LabelAndTextFieldComponent("Weight", "");
        }
        if (datePicker != null) {

        } else {
//            this.datePicker = new LabelAndTextFieldComponent("Date", "");
        }
        VBox vBox = new VBox();
        vBox = new VBox(this.weight, this.hBox);
        vBox.setPadding(new Insets(10, 0, 10, 0));
        vBox.setSpacing(10);
        this.getChildren().add(vBox);


    }
    public String getWeight() {
        return weight.textField.getText();
    }
    public LocalDate getDate() {
        return datePicker.getValue();
    }

    public void clear() {
        weight.textField.setText("");
        datePicker.getEditor().clear();
    }
}
