package com.example.demo.Views;

import com.example.demo.Contollers.DataClasses.CattleController;
import com.example.demo.Enums.CurrentView;
import com.example.demo.ModelListeners.CattleModelListener;
import com.example.demo.ModelListeners.InteractionModelListener;
import com.example.demo.Models.CattleModel;
import com.example.demo.Models.InteractionModel;
import javafx.scene.layout.StackPane;



public class MainParentView extends StackPane implements InteractionModelListener, CattleModelListener {
    CurrentView currentView = CurrentView.MAIN;
    InteractionModel interactionModel;
    MainView mainView;
    MainFilterView filterView;
    public AddOrEditCowView addOrEditCowView;

    public MainParentView() {

    }

    public void setSubViews(MainView mainView, MainFilterView filterView, AddOrEditCowView addOrEditCowView) {
        this.mainView = mainView;
        this.filterView = filterView;
        this.addOrEditCowView = addOrEditCowView;
    }
    public void setInteractionModel(InteractionModel interactionModel) {
        this.interactionModel = interactionModel;
        interactionModel.setCurrentView(CurrentView.MAIN);
        this.mainView.setInteractionModel(interactionModel);
        this.filterView.setInteractionModel(interactionModel);
    }

    public void setController(CattleController controller) {
        this.mainView.setController(controller);
        this.filterView.setController(controller);
        this.addOrEditCowView.setController(controller);

    }
    public void setCattleModel(CattleModel model) {
        this.mainView.setCattleModel(model);

        this.filterView.setModel(model);

        this.addOrEditCowView.setModel(model);
        this.mainView.addRemoveEditCowButtonsView.csvImportView.setModel(model);
        this.mainView.addRemoveEditCowButtonsView.csvCowExportView.setModel(model);
        this.mainView.addRemoveEditCowButtonsView.csvMedProcExportView.setModel(model);

    }

    public MainView getMainView() {
        return mainView;
    }

    public MainFilterView getFilterView() {
        return filterView;
    }

    private void updateView() {
        this.getChildren().clear();
        switch (currentView) {
            case MAIN -> {
                this.getChildren().add(mainView);
            }
            case FILTER -> {
                this.getChildren().add(filterView);
            } case ADD -> {
                this.getChildren().add(addOrEditCowView);
            } case EDIT -> {
                addOrEditCowView.editMode();
                this.getChildren().add(addOrEditCowView);
            }
        }
    }

    @Override
    public void iModelChanged() {
        this.currentView = interactionModel.getCurrentView();
        this.filterView.iModelChanged();
        updateView();
    }

    @Override
    public void cattleModelChanged() {
        mainView.cattleModelChanged();
        filterView.cattleModelChanged();
    }
}
