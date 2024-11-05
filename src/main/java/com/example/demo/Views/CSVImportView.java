package com.example.demo.Views;

import com.example.demo.Contollers.DataClasses.CattleController;
import com.example.demo.DataClasses.Cow;
import com.example.demo.ImportExports.CowCSVImporter;
import com.example.demo.Models.CattleModel;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CSVImportView extends StackPane {

    CattleModel model;
    CattleController controller;

    ImageView cowCSVTemplate;

    public Button chooseFileButton;
    public CSVImportView(Stage stage) {
        VBox mainVBox = new VBox();
        String instructions = "Please be sure to follow the format laid out for CSV files exactly.\n" +
                "Your VBP certification depends on you being honest about your herd's data.\n" +
                "Mouse over the button for an example template of how to lay out your CSV file:\n";

        Label instruct = new Label(instructions);

        this.chooseFileButton = new ButtonComponent("Choose File");


        //Read in tooltip image
        InputStream stream = null;
        try {

            stream = new FileInputStream("src/main/java/com/example/demo/Icons/cowCSVExample.png");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image = new Image(stream);

        //Creating the image view
        this.cowCSVTemplate = new ImageView(image);

        Tooltip tooltip = new Tooltip();
        tooltip.setGraphic(cowCSVTemplate);
        this.chooseFileButton.setTooltip(tooltip);


        //this.getScene().getWindow();
        mainVBox.getChildren().addAll(this.chooseFileButton);

        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));



        this.chooseFileButton.setOnAction(e -> {

            showTemplateAlert();
            File file = fc.showOpenDialog(stage);
            //CowCSVImporter reader = new CowCSVImporter();
            if(file != null) {
                List<Cow> test = CowCSVImporter.readCowsFromCSV(file.getAbsolutePath());
                //Add the cows
                for (Cow c : test) {
//                    this.model.addCow(c);
                    this.controller.createCow(c);
                }
            }
        });
        //Add everything in the main VBox
        this.getChildren().addAll(mainVBox);
    }
    public void setController(CattleController controller) {
        this.controller = controller;
    }


    /**
     * This shows an alert box with the required template for CSV importing
     */
    public void showTemplateAlert(){
        Alert alertBox = new Alert(Alert.AlertType.INFORMATION);
        alertBox.setContentText("Required Template:");
        alertBox.setGraphic(cowCSVTemplate);
        alertBox.showAndWait();
    }


    public void setModel(CattleModel model){
        this.model = model;
    }


}
