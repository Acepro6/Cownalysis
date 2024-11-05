package com.example.demo.Views;

import com.example.demo.Contollers.DataClasses.CattleController;
import com.example.demo.Enums.CurrentView;
import com.example.demo.ModelListeners.CattleModelListener;
import com.example.demo.ModelListeners.InteractionModelListener;
import com.example.demo.Models.CattleModel;
import com.example.demo.Models.InteractionModel;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainFilterView extends StackPane implements InteractionModelListener, CattleModelListener {
    InteractionModel interactionModel;
    CattleModel model;
//    CattleController controller;
    // Views
    TopBarView topBarView;
    public FilterSearchView addFilterView;
    public CurrentFilterView currentFilterView;
    public SavedFilterView savedFilterView;
    public MainFilterView() {
        topBarView = new TopBarView("Filters", "View Filtered Cows");
        currentFilterView = new CurrentFilterView();
        addFilterView = new FilterSearchView();
        savedFilterView = new SavedFilterView();
//        savedFilterView.setPrefHeight(1000);

//        addFilterView.updateListView(); can't have this before



        HBox hBox = new HBox(savedFilterView, addFilterView, currentFilterView);
        HBox.setHgrow(addFilterView, Priority.ALWAYS);



        VBox view = new VBox(topBarView, hBox);
        view.setPadding(new Insets(20,20,20,20));
//        VBox.setVgrow(topBarView, Priority.ALWAYS);
//        view.setPrefHeight(10000);
        this.getChildren().add(view);


    }
    public void setInteractionModel(InteractionModel interactionModel) {
        this.interactionModel = interactionModel;

        addFilterView.setInteractionModel(interactionModel);
        addFilterView.updateListView();

    }
    public void setModel(CattleModel model) {
        this.model = model;
        this.savedFilterView.setModel(model);
    }
    public void setController(CattleController controller) {
//        this.topBarView.setController(controller);
        this.topBarView.changeViewButton.setOnAction(event -> {
//            interactionModel.push;
                controller.updateCurrentFilter();
                controller.changeView(CurrentView.MAIN);

        });
        this.addFilterView.setController(controller);
        this.topBarView.backButton.setOnAction(event -> {
            controller.changeView(CurrentView.MAIN);
        });
    }



    @Override
    public void cattleModelChanged() {

    }

    @Override
    public void iModelChanged() {

        addFilterView.updateListView();
//        currentFilterView.iModelChanged();
    }
}
