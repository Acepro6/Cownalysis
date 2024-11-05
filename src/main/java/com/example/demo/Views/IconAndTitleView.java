package com.example.demo.Views;


import com.example.demo.Enums.Icon;
import com.example.demo.Icons.IconGetter;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class IconAndTitleView extends StackPane {
    public IconAndTitleView(Icon iconName, int iconSize, String title) {
        IconGetter iconGetter = new IconGetter(iconName, iconSize);
        ImageView icon = iconGetter.getImageView();

        Label mainLabel = new Label(title);
        mainLabel.setStyle("-fx-font-family: Arial; -fx-font-weight: bold;  -fx-font-size: 18");
        mainLabel.setPadding(new Insets(0, 00, 00, 10));

        HBox headerHBox = new HBox(icon, mainLabel);
        headerHBox.setAlignment(Pos.CENTER_LEFT);
        this.getChildren().add(headerHBox);
    }
}
