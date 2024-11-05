package com.example.demo.Views;

import com.example.demo.Contollers.DataClasses.CattleController;
import com.example.demo.DataClasses.Cow;
import com.example.demo.Enums.Category;
import com.example.demo.Enums.FilterFlag;
import com.example.demo.Enums.Gender;
import com.example.demo.ModelListeners.CattleModelListener;
import com.example.demo.Models.CattleModel;
import com.example.demo.Models.InteractionModel;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class TestView extends StackPane implements CattleModelListener {
    CattleController cattleController; // why do we store this? We will need to add actions to widget buttons after they are dynamically created
    CattleModel cattleModel;
    InteractionModel interactionModel; // this needs connection to iModel because it's going to be able to set new filters

    // Testing
    Button testingButton;
    //!Testing
    public TestView() {
        // Testing
        testingButton = new Button("Change Filter");
        this.getChildren().add(testingButton);
        //!Testing
    }

    public void setController(CattleController controller) {
        this.cattleController = controller;
        //Testing
        Cow cow1 = new Cow("3", "F39", LocalDate.now(), Category.COW, null, null, null, Gender.FEMALE );

        this.testingButton.setOnAction(event -> controller.addIndividualCowFilter(cow1, FilterFlag.CREATE));
        //!Testing
    }

    private void updateUI() {
        ArrayList<Cow> cows = cattleModel.getCows();
        for (Cow cow: cows) {
            System.out.println(cow.getID());
        }
    }

    public void cattleModelChanged() {
        updateUI();
    }

    // Set Models
    public void setCattleModel(CattleModel model) {
        this.cattleModel = model;
    }
    public void setInteractionModel(InteractionModel interactionModel) {
        this.interactionModel = interactionModel;
    }
}
