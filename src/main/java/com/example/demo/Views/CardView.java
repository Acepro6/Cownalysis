package com.example.demo.Views;

import com.example.demo.Enums.Icon;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CardView extends StackPane {
    IconAndTitleView iconAndTitleView;
    VBox content;
    public CardView(Icon icon, int iconSize, String title) {
        this.iconAndTitleView = new IconAndTitleView(icon, iconSize, title);
//        iconAndTitleView.setPadding(new Insets(20,20,20,20));

        content = new VBox(iconAndTitleView);
        content.setSpacing(20);
        content.setPadding(new Insets(20,20,20,20));

        this.setStyle("-fx-background-color: #ffffff; -fx-background-radius: 20");
        this.getChildren().add(content);


    }
    public void addContent(Node content) {
//        this.content.getChildren().clear();
        this.content.getChildren().add(content);
    }
}
