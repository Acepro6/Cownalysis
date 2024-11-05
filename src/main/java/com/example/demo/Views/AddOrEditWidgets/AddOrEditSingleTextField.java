package com.example.demo.Views.AddOrEditWidgets;

import com.example.demo.Enums.Icon;
import com.example.demo.Views.CardView;
import com.example.demo.Views.IconAndTitleView;
import com.example.demo.Views.TextFieldComponent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class AddOrEditSingleTextField extends CardView {
    TextFieldComponent textField;

    public AddOrEditSingleTextField(Icon icon, int iconSize, String title, String labelText, String textFieldText) {
        super(icon, iconSize, title);
        Label label = new Label(labelText);
        textField = new TextFieldComponent();
        label.setPrefWidth(60);
        HBox content = new HBox(label, textField);
        content.setSpacing(20);
        super.addContent(content);

    }

    public String getText() {
        return textField.getText();
    }
    public void setTextField(String text) {
        this.textField.setText(text);
    }
}
