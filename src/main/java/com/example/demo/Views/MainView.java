package com.example.demo.Views;

import com.example.demo.Contollers.DataClasses.CattleController;
import com.example.demo.Delete.UIController;
import com.example.demo.Enums.CurrentView;
import com.example.demo.ModelListeners.CattleModelListener;
import com.example.demo.Models.CattleModel;
import com.example.demo.Models.InteractionModel;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainView extends StackPane implements CattleModelListener {
    CattleController controller;
    CattleModel cattleModel;
    private InteractionModel interactionModel;

    TopBarView topBar;

    public MainListView listView;
    public MainWidgetView widgetView;
    public AddRemoveEditCowButtonsView addRemoveEditCowButtonsView;

    public MainView(Stage stage) {
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();

        topBar = new TopBarView("Cownalysis", "Filter");
        listView = new MainListView();
        widgetView = new MainWidgetView();
        Double value = screenBounds.getWidth() / 2 - 30;
        widgetView.setMaxWidth(screenBounds.getWidth() / 2 - 30);
        widgetView.setStyle("-fx-background-color:transparent;");
//        widgetView.setPrefWidth(1000);
        HBox contentView = new HBox(listView, widgetView);
        HBox.setHgrow(listView, Priority.ALWAYS);
//        HBox.setHgrow(widgetView, Priority.ALWAYS);
        contentView.setSpacing(20);
//        contentView.setPadding(new Insets(20,20,20,20));
//        contentView.setStyle("-fx-background-color: White");
        addRemoveEditCowButtonsView = new AddRemoveEditCowButtonsView(stage);// bottom buttons contain add remove and edit
        addRemoveEditCowButtonsView.setMainListView(listView);
        VBox view = new VBox(topBar, contentView, addRemoveEditCowButtonsView);  // stephen added bottom buttons
        view.setPadding(new Insets(0, 20, 20, 20));
        VBox.setVgrow(contentView, Priority.ALWAYS);
        view.setPrefWidth(screenBounds.getWidth());
        view.setPrefHeight(screenBounds.getHeight());
        this.getChildren().add(view);
    }
    public void setController(CattleController controller) {
        this.controller = controller;
        this.listView.setController(controller);
//        this.topBar.setController(controller);
        this.topBar.changeViewButton.setOnAction(event -> {
            controller.changeView(CurrentView.FILTER);
        });
        this.topBar.backButton.setOnAction(controller::back);
        this.addRemoveEditCowButtonsView.setController(controller);

    }

    public void setCattleModel(CattleModel cattleModel) {
        this.cattleModel = cattleModel;
        this.widgetView.setCattleModel(cattleModel);
        this.addRemoveEditCowButtonsView.setCattleModel(cattleModel);
    }

    public void setInteractionModel(InteractionModel interactionModel) {
        this.interactionModel = interactionModel;
        this.widgetView.setInteractionModel(interactionModel);
    }

    public void cattleModelChanged() {

        listView.updateList(cattleModel.getCows());
        widgetView.cattleModelChanged();
        addRemoveEditCowButtonsView.cattleModelChanged();
    }
}
