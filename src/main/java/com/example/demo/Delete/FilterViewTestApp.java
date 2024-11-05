package com.example.demo.Delete;

import com.example.demo.Contollers.DataClasses.CattleController;
import com.example.demo.FilterClasses.FilterCreator;
import com.example.demo.Models.CattleModel;
import com.example.demo.Models.InteractionModel;
import com.example.demo.Views.MainFilterView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class FilterViewTestApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        CattleController controller = new CattleController();
        InteractionModel interactionModel = new InteractionModel();
        CattleModel model = new CattleModel();
        MainFilterView filterView = new MainFilterView();
        FilterCreator filterCreator = new FilterCreator();
        filterCreator.setInteractionModel(interactionModel);
        interactionModel.addSubscriber(filterView);
        controller.setInteractionModel(interactionModel);
        controller.setFilterCreator(filterCreator);
        controller.setCattleModel(model);
        filterView.setInteractionModel(interactionModel);
        filterView.addFilterView.setController(controller);
        filterView.currentFilterView.setInteractionModel(interactionModel);
        filterView.savedFilterView.setModel(model);
        filterView.savedFilterView.setController(controller);
        interactionModel.addSubscriber(filterView.currentFilterView);
        filterView.currentFilterView.setController(controller);
        model.addCattleModelSubscriber(filterView.savedFilterView);

        Scene scene = new Scene(filterView);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
