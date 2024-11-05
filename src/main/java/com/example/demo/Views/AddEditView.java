package com.example.demo.Views;

import com.example.demo.Enums.Icon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class AddEditView extends StackPane {

    public AddEditView() {
        IconAndTitleView header = new IconAndTitleView(Icon.BULL, 25, "New Cow");

        Label idLabel = new Label("ID: ");
        idLabel.setStyle("-fx-font-size: 14");
        idLabel.setPadding(new Insets(0, 0, 0, 35));
        Label farmTagLabel = new Label("Farm Tag: ");
        farmTagLabel.setStyle("-fx-font-size: 14");
        farmTagLabel.setPadding(new Insets(0, 0, 0, 35));
        Label DOBLabel = new Label("Date of Birth: ");
        DOBLabel.setStyle("-fx-font-size: 14");
        DOBLabel.setPadding(new Insets(0, 0, 0, 35));
        Label categoryLabel = new Label("Category: ");
        categoryLabel.setStyle("-fx-font-size: 14");
        categoryLabel.setPadding(new Insets(0, 0, 0, 35));
        Label damIDLabel = new Label("Dam ID: ");
        damIDLabel.setStyle("-fx-font-size: 14");
        damIDLabel.setPadding(new Insets(0, 0, 0, 35));
        Label sireIDLabel = new Label("Sire ID: ");
        sireIDLabel.setStyle("-fx-font-size: 14");
        sireIDLabel.setPadding(new Insets(0, 0, 0, 35));
        Label herdLabel = new Label("Herd: ");
        herdLabel.setStyle("-fx-font-size: 14");
        herdLabel.setPadding(new Insets(0, 0, 0, 35));
        Label genderLabel = new Label("Gender: ");
        genderLabel.setStyle("-fx-font-size: 14");
        genderLabel.setPadding(new Insets(0, 0, 0, 35));

        TextField idField = new TextField();
        idField.setPromptText("Cow's ID");
        TextField farmTagField = new TextField();
        farmTagField.setPromptText("Farm Tag");
        TextField DOBField = new TextField();
        DOBField.setPromptText("Date of Birth (dd/mm/yyyy)");
        TextField categoryField = new TextField();
        categoryField.setPromptText("Category");
        TextField damField = new TextField();
        damField.setPromptText("Dam ID");
        TextField sireField = new TextField();
        sireField.setPromptText("Sire ID");
        TextField herdField = new TextField();
        herdField.setPromptText("Herd");
        TextField genderField = new TextField();
        genderField.setPromptText("Gender");

        ButtonComponent addButton = new ButtonComponent("Add Cow");

        HBox idBox = new HBox(idLabel, idField);
        HBox farmTagBox = new HBox(farmTagLabel, farmTagField);
        HBox DOBBox = new HBox(DOBLabel, DOBField);
        HBox categoryBox = new HBox(categoryLabel, categoryField);
        HBox damBox = new HBox(damIDLabel, damField);
        HBox sireBox = new HBox(sireIDLabel, sireField);
        HBox herdBox = new HBox(herdLabel,herdField);
        HBox genderBox = new HBox(genderLabel, genderField);
        HBox bottomButtonsBox = new HBox(addButton);


        VBox root = new VBox(header, idBox, farmTagBox, DOBBox, categoryBox, damBox, sireBox, herdBox, genderBox, bottomButtonsBox);
        this.getChildren().add(root);
    }
}
