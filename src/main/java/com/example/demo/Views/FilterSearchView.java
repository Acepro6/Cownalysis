package com.example.demo.Views;

import com.example.demo.Contollers.DataClasses.CattleController;
import com.example.demo.Enums.FilterType;
import com.example.demo.Enums.Icon;
import com.example.demo.FilterClasses.AliveFilter;
import com.example.demo.ModelListeners.InteractionModelListener;
import com.example.demo.Models.InteractionModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.text.ParseException;
import java.util.ArrayList;

public class FilterSearchView extends StackPane implements InteractionModelListener {
//    ScrollPane scrollPane;
    ListView<FilterType> listView;
    TextField searchField;
    InteractionModel interactionModel;


    CattleController controller;


    public FilterSearchView() {
//
        listView = new ListView();
        listView.setPrefWidth(500);
        listView.setPrefHeight(10000);


//        scrollPane = new ScrollPane(); // this is for the filter widgets
        searchField = new TextField();
        searchField.setPromptText("Search");
        VBox searchView = new VBox(listView, searchField);
        VBox.setVgrow(listView, Priority.ALWAYS);

        this.getChildren().addAll(searchView);
    }
    public void setInteractionModel(InteractionModel model) {
        this.interactionModel = model;
    }
    public void setController(CattleController controller) {
        searchField.textProperty().addListener((observable, oldValue, newValue)-> {
            controller.searchFieldChanged(newValue);
        });

       this.controller = controller;

    }

    public void clearSearchField() {
        searchField.setText("");
        updateListView();
    }
public void updateListView() {
    System.out.println();
    ArrayList<FilterType> typesToShow = interactionModel.getFilterTypes();
    ObservableList<FilterType> observableList = FXCollections.observableArrayList();
    for (FilterType type: typesToShow) {
        if (!observableList.contains(type)) {
            observableList.add(type);
        }
    }
    this.listView.setItems(observableList);
    ArrayList<FilterType> added = new ArrayList<>();

    this.listView.setCellFactory(new Callback<ListView<FilterType>, ListCell<FilterType>>() {

        @Override
        public ListCell<FilterType> call(ListView<FilterType> filterType) {

            ListCell<FilterType> cell = new ListCell<>() {
                @Override
                protected void updateItem(FilterType type, boolean b) {
                    super.updateItem(type, b);
                    if (type != null) {
                       switch (type) {
                           case AGE:
                               SingleTextFieldFilterView filterAget = new SingleTextFieldFilterView(Icon.AGE,"Age","number: 4");
                               filterAget.addButton.setOnAction(event -> controller.addAgeFilter(filterAget.getTextField(), filterAget.getTextField()));

                               setGraphic(filterAget);
                              break;
                           case AGE_RANGE:
                               RangeFilterView filterAgeRanget = new RangeFilterView(Icon.AGE,"Age Range","number: 2","number:4");
                               filterAgeRanget.addButton.setOnAction(event -> controller.addAgeFilter(filterAgeRanget.getLowerBound(), filterAgeRanget.getUpperBound()));

                               setGraphic(filterAgeRanget);
                               break;
                           case ALIVE:
                               SingleButtonFilterView filterIsAlivet = new SingleButtonFilterView(Icon.BULL,"Alive");
                               filterIsAlivet.addButton.setOnAction(event -> controller.addAliveFilter());

                               setGraphic(filterIsAlivet);
                               break;
                           case DEAD:
                               SingleButtonFilterView filterIsDeadt = new SingleButtonFilterView(Icon.DEATH,"Dead");
                               filterIsDeadt.addButton.setOnAction(event -> controller.addDeadFilter());


                                setGraphic(filterIsDeadt);

                               break;
                           case BIRTHDATE:
                               SingleTextFieldFilterView filterBirthdatet = new SingleTextFieldFilterView(Icon.BIRTH,"Birthdate","dd/mm/yyyy");
                               filterBirthdatet.addButton.setOnAction(event -> {
                                   try {
                                       controller.addBirthdateFilter(filterBirthdatet.getTextField(), filterBirthdatet.getTextField());
                                   } catch (ParseException e) {
                                       e.printStackTrace();
                                   }
                               });
                               setGraphic(filterBirthdatet);
                               break;
                           case BIRTHDATE_RANGE:
                               RangeFilterView filterBirthdateRanget = new RangeFilterView(Icon.BIRTH,"Birthdate Range","dd/mm/yyyy","dd/mm/yyyy");
                               filterBirthdateRanget.addButton.setOnAction(event -> {
                                   try {
                                       controller.addBirthdateFilter(filterBirthdateRanget.getLowerBound(), filterBirthdateRanget.getUpperBound());
                                   } catch (ParseException e) {
                                       e.printStackTrace();
                                   }
                               });
                               setGraphic(filterBirthdateRanget);
                               break;
                           case DEATHDATE:
                               SingleTextFieldFilterView filterDeathDatet = new SingleTextFieldFilterView(Icon.DEATH,"Death Date","dd/mm/yyyy");
                               filterDeathDatet.addButton.setOnAction(event -> {
                                   try {
                                       controller.addDeathDateFilter(filterDeathDatet.getTextField(), filterDeathDatet.getTextField());
                                   } catch (ParseException e) {
                                       e.printStackTrace();
                                   }
                               });
                               setGraphic(filterDeathDatet);
                               break;
                           case DEATHDATE_RANGE:
                               RangeFilterView filterDeathDateRanget = new RangeFilterView(Icon.DEATH,"Death Date Range","dd/mm/yyyy","dd/mm/yyyy");
                               filterDeathDateRanget.addButton.setOnAction(event -> {
                                   try {
                                       controller.addDeathDateFilter(filterDeathDateRanget.getLowerBound(), filterDeathDateRanget.getUpperBound());
                                   } catch (ParseException e) {
                                       e.printStackTrace();
                                   }
                               });
                               setGraphic(filterDeathDateRanget);
                               break;
                           case COW:
                               SingleButtonFilterView filterCowt = new SingleButtonFilterView(Icon.FULLCOW,"Cow");
                               filterCowt.addButton.setOnAction(event -> controller.addIsCowFilter());

                               setGraphic(filterCowt);
                               break;


                           case HEIFER:
                               SingleButtonFilterView filterHeifert = new SingleButtonFilterView(Icon.FULLCOW,"Heifer");
                               filterHeifert.addButton.setOnAction(event -> controller.addIsHeiferFilter());

                               setGraphic(filterHeifert);
                               break;
                           case STEER:
                               SingleButtonFilterView filterSteert = new SingleButtonFilterView(Icon.FULLCOW,"Steer");
                               filterSteert.addButton.setOnAction(event -> controller.addIsSteerFilter());

                               setGraphic(filterSteert);
                               break;
                           case BULL:
                               SingleButtonFilterView filterBullt = new SingleButtonFilterView(Icon.FULLCOW,"Bull");
                               filterBullt.addButton.setOnAction(event -> controller.addIsBullFilter());

                               setGraphic(filterBullt);
                               break;
                           case FEMALE:
                               SingleButtonFilterView filterFemalet = new SingleButtonFilterView(Icon.GENDER,"Female");
                               filterFemalet.addButton.setOnAction(event -> controller.addIsFemaleFilter());

                               setGraphic(filterFemalet);
                               break;
                           case MALE:
                               SingleButtonFilterView filterMalet = new SingleButtonFilterView(Icon.GENDER,"Male");
                               filterMalet.addButton.setOnAction(event -> controller.addIsMaleFilter());

                               setGraphic(filterMalet);
                               break;
                           case WEIGHT_RANGE:
                               RangeFilterView filterWeightRanget = new RangeFilterView(Icon.WEIGHT,"Weight Range","200","590");
                               filterWeightRanget.addButton.setOnAction(event -> controller.addWeightRangeFilter(filterWeightRanget.getLowerBound(), filterWeightRanget.getUpperBound()));

                               setGraphic(filterWeightRanget);
                               break;
//                           default:
//                               System.out.println("hkjahsd");
                       }

                    }
//
                }

            };
            cell.setStyle("-fx-background-color: #F0F0F0");

            return cell;
        }

    });

}

    @Override
    public void iModelChanged() {
        clearSearchField();

    }


}
