package com.example.demo.Delete;

import com.example.demo.Contollers.DataClasses.CattleController;
import com.example.demo.Models.CattleModel;
import com.example.demo.Views.AddOrEditCowView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AddOrEditViewTesting extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        AddOrEditCowView root = new AddOrEditCowView();
        CattleController controller = new CattleController();
        CattleModel model = new CattleModel();

        controller.setCattleModel(model);
        root.setController(controller);
        root.setModel(model);


        model.addCattleModelSubscriber(root);

        Scene scene = new Scene(root);
        stage.setTitle("What the fuck is happening");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
