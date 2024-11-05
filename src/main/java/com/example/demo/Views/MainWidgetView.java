package com.example.demo.Views;

import com.example.demo.DataClasses.Cow;
import com.example.demo.DataClasses.KeyValuePair;
import com.example.demo.DataClasses.PassableFieldValuePair;
import com.example.demo.DataGetters.GetDataForWidgets;
import com.example.demo.Enums.Icon;
import com.example.demo.ModelListeners.CattleModelListener;
import com.example.demo.ModelListeners.InteractionModelListener;
import com.example.demo.Models.CattleModel;
import com.example.demo.Models.InteractionModel;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

public class MainWidgetView extends ScrollPane implements CattleModelListener {
    private CattleModel cattleModel;
    private InteractionModel interactionModel;
//    VBox widgetVBox;
    TilePane widgetBox;

    public MainWidgetView() {

        widgetBox = new TilePane();
        widgetBox.setHgap(10);
        widgetBox.setVgap(10);
        widgetBox.setPrefColumns(2);
        widgetBox.setStyle("-fx-background-color:transparent;");


//        addPieChart("Hello");
//        widgetVBox = new VBox();
//        widgetVBox.setSpacing(20);
//        ArrayList<PassableFieldValuePair> IDData = new ArrayList<>();
//        IDData.add(new PassableFieldValuePair("ID", "93893080948"));
//        IDData.add(new PassableFieldValuePair("Farm Tag", "F489"));
//        ArrayList<PassableFieldValuePair> temp3list = new ArrayList<>();
//        temp3list.add(new PassableFieldValuePair("Age", "4"));
//        temp3list.add(new PassableFieldValuePair("Birthdate", "29/29/2934"));
//        temp3list.add(new PassableFieldValuePair("Deathdate", "94/29/4822"));
//
//        DataFieldsView test1 = new DataFieldsView("ID", Icon.AGE, IDData);
//        DataFieldsView test2 = new DataFieldsView("Age", Icon.AGE, temp3list);
//
//        HBox hBox1 = new HBox(test1, test2);
//        hBox1.setSpacing(20);
//        widgetVBox.getChildren().add(hBox1);
//
//
//        this.setStyle("-fx-background-color: White; -fx-background-radius: 20;");
//
//
        this.setContent(widgetBox);

    }
    private void addPieChart(String title, HashMap<String, Integer> items) {

        WidgetPieChart pieChart = new WidgetPieChart(title, items);
        pieChart.setPrefSize(300, 300);
        widgetBox.getChildren().add(pieChart);

    }
    private void addBarChart(String title, String xAxisTitle, ArrayList<KeyValuePair> items) {
        WidgetBarGraph barGraph = new WidgetBarGraph(title, xAxisTitle, items);
        barGraph.setPrefSize(300, 300);
        widgetBox.getChildren().add(barGraph);
    }

    @Override
    public void cattleModelChanged() {
        widgetBox.getChildren().clear();
        if (cattleModel != null) {
                GetDataForWidgets dataForWidgets = new GetDataForWidgets();
                HashMap<String, Integer> data = dataForWidgets.getGenderData(this.cattleModel.getCows());
//            System.out.println();
            addPieChart("Gender Ratio", data);
            addPieChart("Classification Ratio", dataForWidgets.getCategoryData(this.cattleModel.getCows()));
            addBarChart("Age Range", "Ages", dataForWidgets.getAgeData(this.cattleModel.getCows()));
            addBarChart("Weight Range", "Weights", dataForWidgets.getWeightData(this.cattleModel.getCows()));
        }


        if (cattleModel.getCows().size() == 1) {
            displayIndividualCowWidgets(cattleModel.getCows().get(0));
        }
        if (cattleModel.getCows().size() > 1) {
//            GetDataForWidgets dataForWidgets = new GetDataForWidgets();
//
//            dataForWidgets.getWeight(5, this.cattleModel.getCows());
        }
    }

    public void setCattleModel(CattleModel cattleModel) {
        this.cattleModel = cattleModel;

    }
    public void setInteractionModel(InteractionModel interactionModel) {
        this.interactionModel = interactionModel;
    }

    private DataFieldsView createIDWidget(Cow cow) {
        ArrayList<PassableFieldValuePair> IDData = new ArrayList<>();
        IDData.add(new PassableFieldValuePair("ID", cow.getID()));
        IDData.add(new PassableFieldValuePair("Farm Tag", cow.getFarmTag()));
        return new DataFieldsView("ID", Icon.ID, IDData);
    }
    private DataFieldsView createAgeWidget(Cow cow) {
        ArrayList<PassableFieldValuePair> ageData = new ArrayList<>();
        ageData.add(new PassableFieldValuePair("Age", Integer.toString(cow.getAge())));
        ageData.add(new PassableFieldValuePair("Birthdate", cow.getBirthdateString()));
        if (cow.isDead()) {
            ageData.add(new PassableFieldValuePair("Deathdate", cow.getDeathdateString()));
        }
        return new DataFieldsView("Age", Icon.AGE, ageData);
    }
    private DataFieldsView createGenderWidget(Cow cow) {
        ArrayList<PassableFieldValuePair> genderData = new ArrayList<>();
        genderData.add(new PassableFieldValuePair("Gender", cow.getGenderString()));
        genderData.add(new PassableFieldValuePair("Status", cow.getCategoryString()));

        return new DataFieldsView("Gender", Icon.GENDER, genderData);
    }
    private DataFieldWithButtonView createLocationWidget(Cow cow) {
        return new DataFieldWithButtonView("Location", Icon.LOCATION, new PassableFieldValuePair("Location", cow.getCurrentLocationString()), "Location History");
    }
    private DataFieldWithButtonView createWeightWidget(Cow cow) {
        return new DataFieldWithButtonView("Weight", Icon.WEIGHT, new PassableFieldValuePair("Weight", cow.getCurrentWeightString()), "Weight History");
    }
    private GeneologyViewWidget createGeneologyWidget(Cow cow) {
        Cow sire = cow.getSire();

        return new GeneologyViewWidget(cow.getSire(), cow.getDam());
    }
    private DataFieldWithButtonView createMedicalWidget(Cow cow) {
        return new DataFieldWithButtonView("Medical", Icon.MEDICAL, new PassableFieldValuePair("Last Treatment", cow.getLastMedicalTreatmentString()), "Medical History");
    }

//    @Override
//    public void iModelChanged() {
//        if (interactionModel.peek().size() == 1) {
//            displayIndividualCowWidgets(cattleModel.getCows().get(0));
//        }
//
//    }





    private void displayIndividualCowWidgets(Cow cow) {
        widgetBox.getChildren().clear();
//        WidgetHBox hBox1 = new WidgetHBox();

        DataFieldsView IDWidget = createIDWidget(cow);
        IDWidget.setMaxWidth(300);
        DataFieldsView ageWidget = createAgeWidget(cow);
        ageWidget.setMaxWidth(300);

//        WidgetHBox hBox2 = new WidgetHBox();
        DataFieldsView genderWidget = createGenderWidget(cow);
        genderWidget.setMaxWidth(300);
        DataFieldWithButtonView locationWidget = createLocationWidget(cow);
        locationWidget.setMaxWidth(300);
//        hBox2.getChildren().addAll(genderWidget, locationWidget);

//        WidgetHBox hBox3 = new WidgetHBox();
        DataFieldWithButtonView weightWidget = createWeightWidget(cow);
        weightWidget.setMaxWidth(300);
        GeneologyViewWidget genealogyWidget = createGeneologyWidget(cow);
        genealogyWidget.setMaxWidth(300);
//        hBox3.getChildren().addAll(weightWidget, genealogyWidget);

        DataFieldWithButtonView medicalWidget = createMedicalWidget(cow);
        medicalWidget.setMaxWidth(300);


        widgetBox.getChildren().addAll(IDWidget, ageWidget, genderWidget, locationWidget, weightWidget, genealogyWidget, medicalWidget);

    }

}
