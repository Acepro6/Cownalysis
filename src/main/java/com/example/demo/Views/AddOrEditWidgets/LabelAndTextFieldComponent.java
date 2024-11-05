package com.example.demo.Views.AddOrEditWidgets;

import com.example.demo.Views.TextFieldComponent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class LabelAndTextFieldComponent extends StackPane {
    Label label;
    TextFieldComponent textField;
    public LabelAndTextFieldComponent(String labelText, String textFieldText) {
         label = new Label(labelText);
         label.setPrefWidth(60);
        textField = new TextFieldComponent();
        textField.setText(textFieldText);
        HBox hBox = new HBox(label, textField);
        hBox.setSpacing(20);
        this.getChildren().add(hBox);
    }
}
