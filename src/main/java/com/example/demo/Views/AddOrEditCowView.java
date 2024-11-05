package com.example.demo.Views;

import com.example.demo.Contollers.DataClasses.CattleController;
import com.example.demo.DataClasses.Cow;
import com.example.demo.DataClasses.MedProc;
import com.example.demo.DataClasses.Weight;
import com.example.demo.Enums.CurrentView;
import com.example.demo.Enums.Icon;
import com.example.demo.ModelListeners.CattleModelListener;
import com.example.demo.Models.CattleModel;
import com.example.demo.Views.AddOrEditWidgets.*;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Alert;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AddOrEditCowView extends StackPane implements CattleModelListener {

    CattleModel model;
    AddOrEditDatePicker birthdate, deathdate;
    AddOrEditRadioButtons category, gender;
    AddOrEditSingleTextField id, dam, sire, herd, farmTag;
    AddOrEditWeight editWeightWidget = new AddOrEditWeight(null);
    AddOrEditMedical medicationWiget = new AddOrEditMedical(null);
    AddOrEditChildren addOrEditChildren = new AddOrEditChildren(null);
    AddOrEditList weight, medical, children;
    TopBarView topBar;



    FlowPane flowPane;
    ScrollPane scrollPane;

    //for the file system chooser for CSV stuff
    Stage stage;

    ArrayList<String> categories = new ArrayList<>();
    ArrayList<String> genders = new ArrayList<>();
    String[] categoriesList = {"Heifer", "Bull", "Cow", "Steer"};
    String[] gendersList = {"Male", "Female"};
    boolean editMode = false;
    ArrayList<Weight> weights;
    ArrayList<String> childrenIDs;
    ArrayList<MedProc> medicalItems;
    VBox root;
    public AddOrEditCowView() {

        this.stage = stage;
        weights = new ArrayList<>();
        childrenIDs = new ArrayList<>();
        medicalItems = new ArrayList<>();
        // adding categories and genders to array list
        for (String cat: categoriesList) {
            categories.add(cat);
        }
        for (String gen: gendersList) {
            genders.add(gen);
        }

        // root to hold everything
         root = new VBox();
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        root.setPrefSize(screenBounds.getWidth() - 30, screenBounds.getHeight() - 30);
        root.setPadding(new Insets(10,10,10,10));

        // tile panes for normal widgets and long widgets
        flowPane = new FlowPane(Orientation.VERTICAL);
        flowPane.setVgap(10);
        flowPane.setHgap(10);
//        flowPane.setPrefWrapLength(screenBounds.getHeight() + 50);

//        flowPane.autosize();
        // set up the view
        setUpView();
        scrollPane.setPrefHeight(2000);

        VBox.setVgrow(scrollPane, Priority.ALWAYS);

        //listWidgetsVbox.getChildren().addAll(weight, medical, children);



        root.getChildren().addAll(topBar, scrollPane);
        this.getChildren().add(root);
    }

    private void setUpView() {
//        root.getChildren().clear();

        scrollPane = new ScrollPane();
        scrollPane.setPannable(true);
        scrollPane.setStyle("-fx-background-color:transparent;");


        // create top bar
        if (!editMode) {
            topBar = new TopBarView("AddCow", "Add Cow");

        } else {
//            topBar = new TopBarView("Edit Cow", "Save Edit");
            topBar.setBackButtonTitle("Cancel");
            topBar.changeViewButton.setText("Save Edit");

        }

        // create tile widgets
        birthdate = new AddOrEditDatePicker(Icon.BIRTH, 24, "Date of Birth:");
        deathdate = new AddOrEditDatePicker(Icon.DEATH, 24, "Date of Death:");

        category = new AddOrEditRadioButtons(Icon.FULLCOW, 24, "Category", categories);
        gender = new AddOrEditRadioButtons(Icon.GENDER, 24, "Gender", genders);

        id = new AddOrEditSingleTextField(Icon.ID, 24, "ID", "ID:", "ID");

        dam = new AddOrEditSingleTextField(Icon.BULL, 24, "Dam", "Dam: ", "Dam");
        sire = new AddOrEditSingleTextField(Icon.BULL, 24, "Sire", "Sire:", "Sire");
        herd = new AddOrEditSingleTextField(Icon.LOCATION, 24, "Herd", "Herd:", "Herd");
        farmTag = new AddOrEditSingleTextField(Icon.TAG, 24, "Farm Tag", "Farm Tag:", "Farm Tag");

        // create list widgets
        weight = new AddOrEditList(Icon.WEIGHT, 24, "Weight", editWeightWidget, "Add");
        weight.getButton().setOnAction(event -> {
            this.addWeightValue();
        });
        medical = new AddOrEditList(Icon.MEDICAL, 24, "Medical", medicationWiget, "Add");
        medical.getButton().setOnAction(event -> {
            this.addMedicalValue();
        });
        children = new AddOrEditList(Icon.BULL, 24, "Children", addOrEditChildren, "Add");
        children.getButton().setOnAction(event -> {
            this.addChildrenValue();
        });



        //Put pieces together
        flowPane.getChildren().addAll(id, farmTag, birthdate, deathdate, category, dam, sire, herd,
                gender, weight, children, medical);

        scrollPane.setContent(flowPane);
    }
    public void editMode() {
        flowPane.getChildren().clear();
        editMode = true;
        setUpView();
        Cow cow = model.getCowToEdit();
        weights = cow.getWeightRecords();
        ArrayList<String> list = new ArrayList<>();
        for (Weight weight: weights) {
            list.add(weight.toString());
        }
        weight.populateListView(list);
        medicalItems = cow.getMedicalHistory();
        for (Cow child: cow.getChildren()) {
            childrenIDs.add(child.getID());
        }
        ArrayList<String> list2 = new ArrayList<>();
        for(MedProc item: medicalItems) {
            list2.add(item.getDate() + "    " + item.getProcedure());
        }
        ArrayList<String> list3 = new ArrayList<>();
        for (Cow child: cow.getChildren()) {
            list3.add(child.getID());
        }

        medical.populateListView(list2);
        children.populateListView(list3);
        topBar.backButton.getText();
        topBar.changeViewButton.setText("Save Changes");
        id.setTextField(cow.getID());
        farmTag.setTextField(cow.getFarmTag());
        birthdate.setDate(cow.getDateOfBirth());
        deathdate.setDate(cow.getDateOfDeath());
        category.setCategoryButton(cow.getCategory());
        if (cow.getDam() != null) {
            dam.setTextField(cow.getDam().getID());
        }
        if (cow.getSire() != null) {
            sire.setTextField(cow.getSire().getID());
        }
        gender.setGenderButton(cow.getGender());




    }

    public void setModel(CattleModel newModel) {model = newModel;}

    public void setController (CattleController controller) {
        topBar.changeViewButton.setOnAction(actionEvent -> {
            if (editMode) {
                controller.editCow(newCow());
            } else {
                controller.createCow(newCow());
            }

        });
        topBar.backButton.setOnAction(actionEvent -> {
            controller.changeView(CurrentView.MAIN);
        });
    }

    private Cow newCow() {
        if (id.getText().compareTo("") == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please add a cattle ID.");
            alert.show();
            return null;
        }
        else if (farmTag.getText().compareTo("") == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please add a farm tag.");
            alert.show();
            return null;
        }
        else if (category.getCategory() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please add a category.");
            alert.show();
            return null;
        }
        else if (gender.getGender() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please add a gender.");
            alert.show();
            return null;
        }
        else {
            Cow cowToCreate = new Cow(id.getText(), farmTag.getText(), birthdate.getDate(), category.getCategory(),
                    model.getCowFromID(dam.getText()), model.getCowFromID(sire.getText()), null,
                    gender.getGender());
            if (deathdate.getDate() != null) {
                cowToCreate.setDateOfDeath(deathdate.getDate());
            }
            if (!weights.isEmpty()) {
                cowToCreate.setWeightRecords(weights);
            }
            if (!medicalItems.isEmpty()) {
                cowToCreate.setMedicalRecords(medicalItems);
            }
            if (!childrenIDs.isEmpty()) {
                cowToCreate.setChildrenIDs(childrenIDs);
            }
            cattleModelChanged();
            return cowToCreate;
        }
    }

    public void addWeightValue() {
        AddOrEditWeight dataView = (AddOrEditWeight) weight.getAddOrEditView();
        if (dataView.getWeight().compareTo("") != 0){
            weights.add(new Weight(Float.parseFloat(dataView.getWeight()), dataView.getDate()));
        }
        ArrayList<String> list = new ArrayList<>();
        for (Weight weight: weights) {
            list.add(weight.toString());
        }
        weight.populateListView(list);
        dataView.clear();
    }
    public void addChildrenValue() {
        AddOrEditChildren dataView = (AddOrEditChildren) children.getAddOrEditView();
        childrenIDs.add(dataView.getChildText());
        children.populateListView(childrenIDs);
        dataView.clear();
    }
    public void addMedicalValue() {
        AddOrEditMedical dataView = (AddOrEditMedical) medical.getAddOrEditView();
        medicalItems.add(new MedProc(dataView.getProcedure(), dataView.getDate().toString(), dataView.getReason(), dataView.getProduct(), dataView.getDosage(), dataView.getRoute(), dataView.getNotes() ));
        ArrayList<String> list = new ArrayList<>();
        for(MedProc item: medicalItems) {
            list.add(item.getDate() + "    " + item.getProcedure());
        }
        medical.populateListView(list);
        dataView.clear();
    }


    @Override
    public void cattleModelChanged() {
        flowPane.getChildren().clear();
        setUpView();
    }
}
