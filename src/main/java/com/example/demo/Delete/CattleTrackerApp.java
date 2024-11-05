package com.example.demo.Delete;

import com.example.demo.Contollers.DataClasses.CattleController;
import com.example.demo.FilterClasses.FilterCreator;
import com.example.demo.Models.CattleModel;
import com.example.demo.Models.InteractionModel;
import com.example.demo.Views.MainView;
import com.example.demo.Views.TestView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CattleTrackerApp extends Application {
    public void start(Stage stage) throws IOException {
        // Create Top Level Files
        // Models
        CattleModel cattleModel = new CattleModel();
        InteractionModel interactionModel = new InteractionModel();
        // Controller
        CattleController cattleController = new CattleController();
        // View
        MainView root = new MainView(stage);
        //Filter Creator
        FilterCreator filterCreator = new FilterCreator();

        // Connect
        // Filter Creator
        filterCreator.setInteractionModel(interactionModel);
        // Controller
        cattleController.setCattleModel(cattleModel);
        cattleController.setInteractionModel(interactionModel);
        cattleController.setFilterCreator(filterCreator);
        // View
        root.setController(cattleController);
        root.setCattleModel(cattleModel);
        root.setInteractionModel(interactionModel);
        // Models
        cattleModel.addCattleModelSubscriber(root);
//        cattleModel.setInteractionModel(interactionModel); // needed to iterate through filters
        cattleModel.addCattleModelSubscriber(root.widgetView);
        interactionModel.setFilterCreator(filterCreator);

        //Load Initial Cow Data
        root.cattleModelChanged(); // this will load the initial filter of cows (Alive)

        Scene scene = new Scene(root);
        stage.setTitle("Cows!");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }


}
