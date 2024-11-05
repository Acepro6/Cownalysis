package com.example.demo;

import com.example.demo.Contollers.DataClasses.CattleController;
import com.example.demo.Enums.Icon;
import com.example.demo.FilterClasses.FilterCreator;
import com.example.demo.Models.CattleModel;
import com.example.demo.Models.InteractionModel;
import com.example.demo.Views.*;
import com.example.demo.Views.AddOrEditWidgets.*;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

// This is for me to test my stuff without chance of working in the same app file as someone else
public class CownalysisApp extends Application {

    public static void main(String[] args) {
        launch();

    }

    @Override
    public void start(Stage stage) throws Exception {
        // Make views
        MainParentView parentView = new MainParentView();
        MainView mainView = new MainView(stage);
        MainFilterView mainFilterView = new MainFilterView();
        AddOrEditCowView addOrEditCowView = new AddOrEditCowView();

        // Make Controller
        CattleController controller = new CattleController();
        // Make Model
        CattleModel model = new CattleModel();

        // Make Interaction Model
        InteractionModel interactionModel = new InteractionModel();
        // Filter Creator
        FilterCreator filterCreator = new FilterCreator();

        mainFilterView.currentFilterView.setInteractionModel(interactionModel);
        mainFilterView.addFilterView.setInteractionModel(interactionModel);

        // Connect Files
        filterCreator.setInteractionModel(interactionModel);
        parentView.setSubViews(mainView, mainFilterView, addOrEditCowView);
        parentView.setInteractionModel(interactionModel);


        parentView.setController(controller);
        controller.setInteractionModel(interactionModel);
        controller.setFilterCreator(filterCreator);
        controller.setCattleModel(model);
        interactionModel.addSubscriber(parentView);



        interactionModel.setFilterCreator(filterCreator);
        model.addCattleModelSubscriber(parentView);
        parentView.setCattleModel(model);


        filterCreator.setInteractionModel(interactionModel);
        interactionModel.addSubscriber(mainFilterView);
        controller.setFilterCreator(filterCreator);
        controller.setCattleModel(model);
        mainFilterView.setInteractionModel(interactionModel);
        mainFilterView.addFilterView.setController(controller);
        mainFilterView.currentFilterView.setInteractionModel(interactionModel);
        mainFilterView.savedFilterView.setModel(model);
        mainFilterView.savedFilterView.setController(controller);
        interactionModel.addSubscriber(mainFilterView.currentFilterView);
        mainFilterView.currentFilterView.setController(controller);
        model.addCattleModelSubscriber(mainFilterView.savedFilterView);



        // Sets the correct view
        // Keep down here as it can cause crashing if things aren't initialized properly
        parentView.iModelChanged();
        // Add data to the view
        parentView.cattleModelChanged();


//        AddEditView test = new AddEditView();
//        CardView test = new CardView(Icon.BULL, 24, "ID");
//        AddOrEditSingleTextField test = new AddOrEditSingleTextField(Icon.BULL, 24, "ID", "ID Number", "");
        ArrayList<String> radioButtons = new ArrayList<>();
        radioButtons.add("Hello");
        radioButtons.add("Goodbye");
        radioButtons.add("Salmon");
//        AddOrEditRadioButtons test = new AddOrEditRadioButtons(Icon.BULL, 25, "ID", radioButtons);
//        AddOrEditDatePicker test = new AddOrEditDatePicker(Icon.BULL, 24, "ID");
//        AddOrEditWeight editWeightWidget = new AddOrEditWeight(null);
//        AddOrEditMedical medicationWigfet = new AddOrEditMedical(null);
//        AddOrEditChildren addOrEditChildren = new AddOrEditChildren(null);
//        AddOrEditList test = new AddOrEditList(Icon.AGE, 24, "ID", addOrEditChildren, "Add");
        Scene scene = new Scene(parentView);
        stage.setScene(scene);
        stage.show();


    }
}
