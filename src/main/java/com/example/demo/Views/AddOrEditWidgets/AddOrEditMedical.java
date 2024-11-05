package com.example.demo.Views.AddOrEditWidgets;

import com.example.demo.DataClasses.MedProc;
import javafx.geometry.Insets;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;

public class AddOrEditMedical extends StackPane {
    LabelAndTextFieldComponent date;

    LabelAndTextFieldComponent procedure;
    LabelAndTextFieldComponent reason;
    LabelAndTextFieldComponent product;
    LabelAndTextFieldComponent dosage;
    LabelAndTextFieldComponent route;
//    LabelAndTextFieldComponent notes;
    TextArea notes;
    DatePicker datePicker;
    HBox hBox;
    VBox notesVBox;
    public AddOrEditMedical(MedProc possibleMedProc) {
        if (possibleMedProc == null) {
//            date = new LabelAndTextFieldComponent("Date", "");
            Label label = new Label("Date:");
            datePicker = new DatePicker();
            hBox = new HBox(label, datePicker);
            hBox.setSpacing(10);

            procedure = new LabelAndTextFieldComponent("Procedure:", "");
            reason = new LabelAndTextFieldComponent("Reason:", "");
            product = new LabelAndTextFieldComponent("Product:", "");
            dosage = new LabelAndTextFieldComponent("Dosage:", "");
            route = new LabelAndTextFieldComponent("Route:", "");
//            notes = new LabelAndTextFieldComponent("Notes", "");
            Label notesLabel = new Label("Notes:");
            notes = new TextArea();
            notes.setPrefWidth(150);
            notes.setPrefHeight(100);
            notesVBox = new VBox();
            notesVBox.getChildren().add(notesLabel);
            notesVBox.getChildren().add(notes);

        } else {
            date = new LabelAndTextFieldComponent("Date:", possibleMedProc.getDate());
            procedure = new LabelAndTextFieldComponent("Procedure:", possibleMedProc.getProcedure());
            reason = new LabelAndTextFieldComponent("Reason:", possibleMedProc.getReason());
            product = new LabelAndTextFieldComponent("Product:", possibleMedProc.getProduct());
            dosage = new LabelAndTextFieldComponent("Dosage:", possibleMedProc.getDosage());
            route = new LabelAndTextFieldComponent("Route:", possibleMedProc.getRoute());
//            notes = new LabelAndTextFieldComponent("Notes", possibleMedProc.getNotes());
        }
        VBox vbox = new VBox(hBox, procedure, reason, product, dosage, route, notesVBox);
        vbox.setPadding(new Insets(10, 0,10, 0));
        vbox.setSpacing(10);
        this.getChildren().add(vbox);
    }

    public String getProcedure() {
        return procedure.textField.getText();
    }

    public LocalDate getDate() {
        return datePicker.getValue();
    }

    public String getReason() {
        return reason.textField.getText();
    }

    public String getProduct() {
        return product.textField.getText();
    }

    public String getDosage() {
        return dosage.textField.getText();
    }

    public String getRoute() {
        return route.textField.getText();
    }

    public String getNotes() {
        return notes.getText();
    }

    public void clear() {
        datePicker.getEditor().clear();
        procedure.textField.setText("");
        reason.textField.setText("");
        product.textField.setText("");
        dosage.textField.setText("");
        route.textField.setText("");
        notes.setText("");

    }
}
