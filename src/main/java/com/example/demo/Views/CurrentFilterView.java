package com.example.demo.Views;

import com.example.demo.Contollers.DataClasses.CattleController;
import com.example.demo.FilterClasses.CowFilter;
import com.example.demo.ModelListeners.InteractionModelListener;
import com.example.demo.Models.InteractionModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class CurrentFilterView extends StackPane implements InteractionModelListener {

    // need a way to delete filters
    ListView<CowFilter> listView;
    FilterTextField textField;
    ButtonComponent saveButton;
    ButtonComponent clearButton;

    InteractionModel interactionModel;
    public CurrentFilterView() {
        listView = new ListView<>();
        listView.setPrefHeight(10000);
        textField = new FilterTextField();
        textField.setPromptText("Give your filter a name");
        saveButton = new ButtonComponent("Save Filter");
        clearButton = new ButtonComponent("Clear Current Filters");
        HBox hBox = new HBox(saveButton, clearButton);
        VBox view = new VBox(listView, textField, hBox);
        VBox.setVgrow(listView, Priority.ALWAYS);
        this.getChildren().add(view);
    }
    public void setInteractionModel(InteractionModel model) {
        this.interactionModel = model;
    }
    private void clearList() {
        textField.setText("");
        interactionModel.clearInProgressFilter();
    }

    public void setController(CattleController controller) {
//      saveButton.setOnAction(e -> controller.saveFilter(textField.getText()));
        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                controller.saveFilter((textField.getText()));

                textField.textProperty().set("");
                clearList();
            }
        });
      clearButton.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent event) {
              textField.textProperty().set("");
                interactionModel.clearInProgressFilter();
          }
      });
    }

    @Override
    public void iModelChanged() {
        ObservableList<CowFilter> observableList = FXCollections.observableArrayList();
        ArrayList<CowFilter> currentFilters = interactionModel.getInProgressFilter();
        if (currentFilters != null) {
            for (CowFilter filter : currentFilters) {
                observableList.add(filter);
//            System.out.println(filter.toString());
            }
            listView.setItems(observableList);
        }
    }

    }

