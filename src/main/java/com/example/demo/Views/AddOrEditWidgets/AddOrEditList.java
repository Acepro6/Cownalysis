package com.example.demo.Views.AddOrEditWidgets;

import com.example.demo.Enums.Icon;
import com.example.demo.Views.ButtonComponent;
import com.example.demo.Views.CardView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class AddOrEditList extends CardView {
    ListView listView;
    ButtonComponent button;
    Node addOrEditView;
    public AddOrEditList(Icon icon, int iconSize, String title, Node addOrEditView, String buttonTitle) {
        super(icon, iconSize, title);
        VBox content = new VBox();
        listView = new ListView();
        listView.setPrefHeight(200);
        content.getChildren().add(listView);
        if (addOrEditView != null) {
            content.getChildren().add(addOrEditView);
        }
        button = new ButtonComponent(buttonTitle);
        content.getChildren().add(button);
        this.addOrEditView = addOrEditView;
        addContent(content);
    }

    public Node getAddOrEditView() {
        return addOrEditView;
    }
    public ButtonComponent getButton() {
        return button;
    }
    public void populateListView(ArrayList<String> items) {
        ObservableList<String> list = FXCollections.observableArrayList();
        for (String item: items) {
            list.add(item);
        }
        listView.setItems(list);
    }


}
