package com.example.demo.Views.AddOrEditWidgets;

import com.example.demo.Enums.Icon;
import com.example.demo.Views.CardView;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;

public class AddOrEditDatePicker extends CardView {

    DatePicker datePicker;
    public AddOrEditDatePicker(Icon icon, int iconSize, String title) {
        super(icon, iconSize, title);
        datePicker = new DatePicker();
        addContent(datePicker);
    }

    public LocalDate getDate() {
        return datePicker.getValue();
    }
    public void setDate(LocalDate date) {
        if (date != null) {
            datePicker.setValue(date);
        }
    }
}
