package com.example.demo.Delete;

import com.example.demo.Delete.Model;
import com.example.demo.Delete.UIController;
import com.example.demo.Models.CattleModel;
import com.example.demo.Views.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CowApplication extends Application {
    MainView mainView;
    UIController controller;
    CattleModel model;
    com.example.demo.Delete.iModel iModel;
    @Override
    public void start(Stage stage) throws Exception {
        model = new CattleModel();
        controller = new UIController();
        mainView = new MainView(stage);

//        mainView.listView.setController(controller);
//        controller.setModel(model);
//
//        mainView.listView.updateList(model.getAllCows());

        Scene scene = new Scene(mainView);
        stage.setTitle("Cows!");
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch();
    }
}
