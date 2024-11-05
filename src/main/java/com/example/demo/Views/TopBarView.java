package com.example.demo.Views;

import com.example.demo.Contollers.DataClasses.CattleController;
import com.example.demo.DataClasses.Cow;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class TopBarView extends StackPane {
    // create getter setter methods and make private
    Label viewTitle;
    HBox filterHBox;
    ButtonComponent changeViewButton; // will be used to switch between filter view and main view
    ButtonComponent backButton;
    public TopBarView(String title, String changeViewTitle) {

        viewTitle = new Label(title);
        viewTitle.setStyle("-fx-font-family: Arial;-fx-font-size: 30; -fx-font-weight: 900");

        // bottomBar is the list of filters and the change view button
        backButton = new ButtonComponent("Back");
        filterHBox = new HBox(backButton);
        changeViewButton = new ButtonComponent(changeViewTitle);
        HBox bottomBar = new HBox(filterHBox, changeViewButton);
        HBox.setHgrow(filterHBox, Priority.ALWAYS);

        VBox topBarVBox = new VBox(viewTitle, bottomBar);

        topBarVBox.setPadding(new Insets(10,20,20,0));
        this.getChildren().add(topBarVBox);
    }
    public void setBackButtonTitle(String title) {
        backButton.setText(title);
    }

    public void setController(CattleController controller) {

        backButton.setOnAction(controller::back);
//        changeViewButton.setOnAction(event -> {
//            controller.changeView();
//        });
    }

    public void setAddEditController(CattleController controller, Cow newCow) {
        changeViewButton.setOnAction(actionEvent -> {
            controller.createCow(newCow);
        });
    }

}
