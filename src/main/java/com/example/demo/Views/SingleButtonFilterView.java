package com.example.demo.Views;

import com.example.demo.Enums.Icon;
import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class SingleButtonFilterView extends StackPane {
        ButtonComponent addButton;
    public SingleButtonFilterView(Icon icon, String title) {
        IconAndTitleView header = new IconAndTitleView(icon, 25, title);

        addButton = new ButtonComponent("Add");
        VBox view = new VBox(header, addButton);
        view.setSpacing(10);
        this.getChildren().add(view);
        this.setPadding(new Insets(10, 10,10,10));
        this.setStyle("-fx-background-color: White; -fx-background-radius: 14");
    }
}
