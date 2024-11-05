package com.example.demo.Views;

import com.example.demo.DataClasses.PassableFieldValuePair;
import com.example.demo.Enums.Icon;
import com.example.demo.Icons.IconGetter;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class DataFieldsView extends StackPane {
    public DataFieldsView(String title, Icon iconName, ArrayList<PassableFieldValuePair> data) {
        IconGetter iconGetter = new IconGetter(iconName, 35);
        ImageView icon = iconGetter.getImageView();

        Label titleLabel = new Label(title);
        titleLabel.setStyle("-fx-font-family: Arial; -fx-font-weight: bold; -fx-font-size: 24");
        titleLabel.setPadding(new Insets(8,0,10,0));


        VBox dataVbox = new VBox(titleLabel);
        dataVbox.setSpacing(5);
        for (PassableFieldValuePair datum: data) {
            FieldValueView fieldView = new FieldValueView(datum.getField(),  datum.getValue());
            dataVbox.getChildren().add(fieldView);
        }
        HBox cellHBox = new HBox(icon, dataVbox);
        cellHBox.setAlignment(Pos.TOP_LEFT);
        cellHBox.setSpacing(10);
        cellHBox.setPadding(new Insets(20, 20, 20, 20));
        cellHBox.setStyle("-fx-background-color: White; -fx-background-radius: 20;");
        this.getChildren().add(cellHBox);
    }
}
