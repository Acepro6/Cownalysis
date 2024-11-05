package com.example.demo.Views;

import com.example.demo.Enums.Icon;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class RangeFilterView extends StackPane {
    ButtonComponent addButton;
    FilterTextField lowerBoundField;
    FilterTextField upperBoundField;
    public RangeFilterView(Icon icon, String title, String lowerPrompt, String upperPrompt) {
        IconAndTitleView header = new IconAndTitleView(icon, 25, title);
         lowerBoundField = new FilterTextField();
        lowerBoundField.setPromptText(lowerPrompt);
        Label to = new Label("-");
         upperBoundField = new FilterTextField();
        upperBoundField.setPromptText(upperPrompt);
        HBox hbox = new HBox(lowerBoundField, to, upperBoundField);

         addButton = new ButtonComponent("Add");
        VBox view = new VBox(header, hbox, addButton);
        view.setSpacing(10);
        this.getChildren().add(view);
        this.setPadding(new Insets(10, 10,10,10));
        this.setStyle("-fx-background-color: White; -fx-background-radius: 14");

    }
    public String getLowerBound() {
        return lowerBoundField.getText();
    }
    public String getUpperBound() {
        return upperBoundField.getText();
    }
}
