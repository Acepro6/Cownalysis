package com.example.demo.Views;

import com.example.demo.Enums.Icon;
import com.example.demo.Icons.IconGetter;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class SingleFieldWithDescriptorView extends StackPane {
    public SingleFieldWithDescriptorView(Icon iconName, String mainText, String descriptor, Double value) {
        IconGetter iconGetter = new IconGetter(Icon.AGE, 45);
        ImageView icon = iconGetter.getImageView();

        Label mainLabel = new Label(mainText);
        mainLabel.setStyle("-fx-font-family: Arial; -fx-font-weight: bold");
        Label descriptionLabel = new Label(descriptor);
        VBox textVBox = new VBox(mainLabel, descriptionLabel);
        textVBox.setAlignment(Pos.CENTER_LEFT);

//        Pane valuePane = new Pane();
//        valuePane.setPrefSize(38, 38);
//        valuePane.setStyle("-fx-background-colour: #F5F5F5; -fx-fill-radius: 19");
        Label valueLabel = new Label(Double.toString(value));
        valueLabel.setPrefSize(38, 38);
        valueLabel.setStyle("-fx-background-color: #F5F5F5; -fx-background-radius: 19; -fx-font-family: Arial; -fx-font-weight: bold;");
        valueLabel.setAlignment(Pos.CENTER);
//        valuePane.getChildren().add(valueLabel);

        HBox widget = new HBox(icon, textVBox, valueLabel);
        widget.setStyle("-fx-background-color: White; -fx-background-radius: 18;");
        widget.setPadding(new Insets(10, 20, 10, 20));
        widget.setSpacing(20);
        widget.setAlignment(Pos.CENTER);


        this.getChildren().add(widget);
    }
}
