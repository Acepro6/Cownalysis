package com.example.demo.Views;

import com.example.demo.DataClasses.Cow;
import com.example.demo.Delete.ModelListener;
import com.example.demo.ImportExports.CowCSVExport;
import com.example.demo.ImportExports.DataExporter;
import com.example.demo.Models.CattleModel;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;


public class ExportCowCSVView extends StackPane implements ModelListener {

    ButtonComponent saveFileButton;

    CattleModel model;

    VBox mainVBox = new VBox();

    ArrayList<String> csvStrings;

    public ExportCowCSVView(Stage stage){
        //Make the button
        this.saveFileButton = new ButtonComponent("Export Cow Data");

        //This thing helps us call the file system of the user
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));


        //Set the button action
        this.saveFileButton.setOnAction(e -> {
            //Figure out where the file will be saved
            File file = fc.showSaveDialog(stage);
            if(file != null) {
                CowCSVExport exporter = new CowCSVExport();
                exporter.CSVExporter(this.model.getCows(), file);
            }
        });

        DataExporter test = new DataExporter();

        mainVBox.getChildren().addAll(saveFileButton);

        this.getChildren().addAll(mainVBox);
    }

    public void setModel(CattleModel model){
        this.model = model;
    }
}
