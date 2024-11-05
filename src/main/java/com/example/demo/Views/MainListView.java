package com.example.demo.Views;

import com.example.demo.Contollers.DataClasses.CattleController;
import com.example.demo.DataClasses.Cow;
import com.example.demo.Delete.UIController;
import com.example.demo.Enums.FilterFlag;
import com.example.demo.Views.CowListCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

import java.util.ArrayList;

public class MainListView extends StackPane {
    ListView<Cow> listView;
    CattleController controller;
    public MainListView() {
        listView = new ListView();
        listView.setStyle("-fx-selection-bar: LightGrey; -fx-background-color:transparent; " +
                "-fx-border-radius: 40px; -fx-background-radius: 40px;"); // black for testing
//        listView.setPrefSize(10000, 10000);
//        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
//        listView.maxWidth(screenBounds.getWidth() / 2 - 30);
        this.getChildren().add(listView);
    }
    public void setController(CattleController controller) {
        this.controller = controller;
    }


    public void updateList(ArrayList<Cow> cows) {
        System.out.println("testing updatelist");
        ObservableList<Cow> observableList = FXCollections.observableArrayList();
        for (Cow cow: cows) {
            observableList.add(cow);
        }


        this.listView.setItems(observableList);
        this.listView.setCellFactory(new Callback<ListView<Cow>, ListCell<Cow>>() {
            @Override
            public ListCell<Cow> call(ListView<Cow> cowListView) {

                ListCell<Cow> cell = new ListCell<>() {
                    @Override
                    protected void updateItem(Cow cow, boolean b) {
                        super.updateItem(cow, b);
                        if (cow != null) {


                            setPrefHeight(34);
                            CowListCell customView = new CowListCell(cow);
                            customView.addEventHandler(MouseEvent.MOUSE_PRESSED, e ->  // needs to be mouse pressed not clicked. clicked works for blank cells
                                controller.addIndividualCowFilter(cow, FilterFlag.CREATE)
                            );
                            setGraphic(customView); // displays custom view
                        }
                    }

                };

                return cell;
            }

        });

        int count = cows.size();
        if (count == 1) {

            listView.getSelectionModel().select(0);
        }
        listView.getSelectionModel().clearSelection();
    }
}


