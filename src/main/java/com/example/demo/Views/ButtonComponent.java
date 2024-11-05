package com.example.demo.Views;

import javafx.geometry.Insets;
import javafx.scene.control.Button;


public class ButtonComponent extends Button {
    public ButtonComponent(String title) {

        this.setStyle("-fx-font-family: Arial;-fx-background-color: #454545; -fx-background-radius: 40; -fx-text-fill: White; -fx-font-size: 14; -fx-font-weight: 300");
        this.setText(title);
        this.setPadding(new Insets(5,20, 5, 20));
    }
}
