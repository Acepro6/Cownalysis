package com.example.demo.Views;

import com.example.demo.DataClasses.Cow;
import com.example.demo.Enums.Icon;
import com.example.demo.Icons.IconGetter;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GeneologyViewWidget extends StackPane {
    public GeneologyViewWidget(Cow sire, Cow dam) {
        IconGetter iconGetter = new IconGetter(Icon.GENEOLOGY, 35);
        ImageView icon = iconGetter.getImageView();

        Label mainLabel = new Label("Geneology");
        mainLabel.setStyle("-fx-font-family: Arial; -fx-font-weight: bold;  -fx-font-size: 24");
        mainLabel.setPadding(new Insets(10, 0, 10, 0));

        HBox headerHBox = new HBox(icon, mainLabel);
        headerHBox.setSpacing(20);
        VBox view = new VBox(mainLabel);
        if (sire != null) {
            ButtonComponent sireButton  = new ButtonComponent("Sire: " + sire.getID());
            view.getChildren().add(sireButton);
        }

        if (dam != null) {
            ButtonComponent damButton  = new ButtonComponent("Dam: " + dam.getID());
            view.getChildren().add(damButton);
        }

//        if(dam == null && sire == null){
//            System.out.println("hi");
//            Label noparents = new Label("No Parents Listed");
//            view.getChildren().add(noparents);
//        }

        ButtonComponent childrenButton  = new ButtonComponent("See Children");

        //view = new VBox(childrenButton);
        HBox hBox = new HBox(icon, view);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(20, 20, 20,20));
        hBox.setStyle("-fx-background-color: White; -fx-background-radius: 20;");
        view.setSpacing(5);
        this.getChildren().add(hBox);

    }
}
