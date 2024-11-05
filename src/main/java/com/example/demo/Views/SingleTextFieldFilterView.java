package com.example.demo.Views;

import com.example.demo.Enums.FilterType;
import com.example.demo.Enums.Icon;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class SingleTextFieldFilterView extends StackPane {
    ButtonComponent addButton;

    FilterTextField textField;
    public SingleTextFieldFilterView(Icon icon, String title, String promptText) {
        IconAndTitleView header = new IconAndTitleView(icon, 25, title);
         textField = new FilterTextField();
        textField.setPromptText(promptText);
         addButton = new ButtonComponent("Add");
        VBox view = new VBox(header, textField, addButton);
        view.setSpacing(10);
        this.getChildren().add(view);
        this.setPadding(new Insets(10, 10,10,10));
        this.setStyle("-fx-background-color: White; -fx-background-radius: 14");

    }
    public String  getTextField() {
        return textField.getText();
    }

}
