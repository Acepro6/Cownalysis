package com.example.demo.Views.AddOrEditWidgets;

import com.example.demo.DataClasses.Cow;
import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class AddOrEditChildren extends StackPane {
    LabelAndTextFieldComponent child;
    public AddOrEditChildren(Cow possibleChild) {
        if (possibleChild == null) {
            child = new LabelAndTextFieldComponent("Child:","");
        } else {
            child = new LabelAndTextFieldComponent("Child:", possibleChild.getID());
        }
        child.setPadding(new Insets(10, 0, 10, 0));
        this.getChildren().add(child);

    }
    public String getChildText() {
        return child.textField.getText();
    }
    public void clear() {
        child.textField.setText("");
    }
}
