package com.example.demo.Views;

import com.example.demo.Contollers.DataClasses.CattleController;
import com.example.demo.ModelListeners.CattleModelListener;
import com.example.demo.Models.CattleModel;
import javafx.geometry.Insets;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AddRemoveEditCowButtonsView extends StackPane implements CattleModelListener {
    ButtonComponent addButton;
    ButtonComponent removeButton;
    ButtonComponent editCow;
    MainListView mainListView;
    ExportCowCSVView csvCowExportView;
    ExportMedProcView csvMedProcExportView;
    CSVImportView csvImportView;
    CattleModel model;
    HBox root;

    public AddRemoveEditCowButtonsView(Stage stage) {
        addButton = new ButtonComponent("Add Cow");
        removeButton = new ButtonComponent("Remove Cow");
        editCow = new ButtonComponent("Edit Cow");

        csvImportView = new CSVImportView(stage);
        csvCowExportView = new ExportCowCSVView(stage);
        csvMedProcExportView = new ExportMedProcView(stage);
        System.out.println("AddRemove model is: " + model);
        csvCowExportView.setModel(model);
        csvMedProcExportView.setModel(model);


        root = new HBox();
        root.setSpacing(10);

        root.getChildren().addAll(addButton, editCow, removeButton, csvImportView, csvCowExportView, csvMedProcExportView);
        this.getChildren().add(root);
        this.setPadding(new Insets(10, 10,10,0));

    }


    public void setMainListView(MainListView mainListView){
        this.mainListView = mainListView;
    }

    public void setController(CattleController controller) {
        addButton.setOnAction(controller :: goToAddCowView);
        removeButton.setOnAction(event->{
            controller.removeCowFromList();
        });
        editCow.setOnAction(event -> {
            controller.goToEditCowView();
        });
        csvImportView.setController(controller);
    }

    @Override
    public void cattleModelChanged() {
        //Make relevant buttons on the bottom visible and invisible when we
        //Have one cow selected vs multiple showing
        System.out.println(model.getCows().size());
        if (model.getCows().size() == 1) {
            if(model.getAllCows().size() <= 1) {
                addButton.setVisible(true);
            }
            else {
                addButton.setVisible(false);
            }

            editCow.setVisible(true);
            removeButton.setVisible(true);
            editCow.setDisable(false);
            removeButton.setDisable(false);
            addButton.setDisable(false);
        }
        else {
            addButton.setVisible(true);

            editCow.setVisible(false);
            removeButton.setVisible(false);
            editCow.setDisable(true);
            removeButton.setDisable(true);
            addButton.setDisable(false);
        }
    }

    public void setCattleModel(CattleModel cattleModel) {
        model = cattleModel;
    }
}
