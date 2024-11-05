package com.example.demo.Views;

import com.example.demo.Contollers.DataClasses.CattleController;
import com.example.demo.DataClasses.SavedFilter;
import com.example.demo.ModelListeners.CattleModelListener;
import com.example.demo.Models.CattleModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


public class SavedFilterView extends StackPane implements CattleModelListener {
    ListView<SavedFilter> listView;
    ButtonComponent deleteButton;
    CattleModel cattleModel;
    public SavedFilterView() {
        listView = new ListView<SavedFilter>();
        listView.setPrefHeight(10000);

        deleteButton = new ButtonComponent("Delete");
        VBox vBox = new VBox(listView, deleteButton);
        VBox.setVgrow(listView, Priority.ALWAYS);
        this.getChildren().add(vBox);
    }

    public void updateListView() {
        ObservableList<SavedFilter> observableList = FXCollections.observableArrayList();
        ArrayList<SavedFilter> savedFilters = cattleModel.getSavedFilters();
        for (SavedFilter savedFilter: savedFilters) {
            observableList.add(savedFilter);
        }
        listView.setItems(observableList);
    }
    public void setController(CattleController controller) {
        deleteButton.setOnAction(event -> {
//            this.deletePressed();
            controller.deleteSavedFilter(listView.getSelectionModel().getSelectedIndex());
        });

        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                controller.loadSavedFilter(listView.getSelectionModel().getSelectedIndex());
            }
        });
    }
    private void deletePressed() {
//        System.out.println("Hit");
//        System.out.println(listView.getSelectionModel().getSelectedIndex());
    }

    public void setModel(CattleModel model) {
        this.cattleModel = model;
    }

    @Override
    public void cattleModelChanged() {
        updateListView();
    }
}
