package com.example.demo.Contollers.DataClasses;

import com.example.demo.DataClasses.Cow;
import com.example.demo.DataClasses.SavedFilter;
import com.example.demo.Enums.Category;
import com.example.demo.Enums.CurrentView;
import com.example.demo.Enums.FilterFlag;
import com.example.demo.Enums.Gender;
import com.example.demo.FilterClasses.CowFilter;
import com.example.demo.FilterClasses.FilterCreator;
import com.example.demo.ImportExports.CowCSVImporter;
import com.example.demo.Models.CattleModel;
import com.example.demo.Models.InteractionModel;
import javafx.event.ActionEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CattleController {


    // Models
    CattleModel cattleModel;
    InteractionModel interactionModel;
    // Filter Creator
    FilterCreator filterCreator;

    // Constructor
    public CattleController() {
    }

    // Set Models
    public void setCattleModel(CattleModel model) {
        this.cattleModel = model;
    }
    public void setInteractionModel(InteractionModel model) {
        this.interactionModel = model;
    }
    public void setFilterCreator(FilterCreator filterCreator) {this.filterCreator = filterCreator;}

    public void back(ActionEvent event) {

        interactionModel.pop();
        ArrayList<CowFilter> filter = interactionModel.peek();
        cattleModel.filterCows(filter);
    }

    public void searchFieldChanged(String text) {
        interactionModel.filterTitlesSearch(text);
    }

    // Uses individual methods because it simplifies the way to select the correct action
    // Could use a switch statement but that will be complicated
    public void addIndividualCowFilter(Cow cow, FilterFlag filterFlag) {
        filterCreator.clearFilter();
        filterCreator.addIndividualCowFilter(cow.getID());
        if (filterFlag == FilterFlag.CREATE) {
            filterCreator.createFilter();
            cattleModel.filterCows(interactionModel.peek());
        }
    }

    public void addAgeFilter(String lowerBound, String upperbound) {
        //TODO: need to check if successful conversion
        filterCreator.addAgeFilter(Integer.parseInt(upperbound), Integer.parseInt(lowerBound));
    }

    public void addAliveFilter() {
        filterCreator.addAliveCowFilter();
    }

    public void addDeadFilter() {
        filterCreator.addIsDeadFilter();
    }

    public void addBirthdateFilter(String lowerBound, String upperBound) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        lowerBound = dateFixer(lowerBound);
        upperBound = dateFixer(upperBound);
        LocalDate lowerDate = LocalDate.parse(lowerBound, formatter);
        LocalDate upperDate = LocalDate.parse(upperBound, formatter);

        filterCreator.addBirthdayFilter(upperDate, lowerDate);
    }

    /**
     * Quick string fixer to check if dates are written incorrectly
     * @param date - string
     * @return - a fixed string
     */
    private String dateFixer(String date){

        String[] splitUp = date.split("/");

        if(splitUp[0].length() == 1){
            splitUp[0] = "0" + splitUp[0];
        }
        if(splitUp[1].length() == 1){
            splitUp[1] = "0" + splitUp[1];
        }

        date = splitUp[0] + "/" + splitUp[1] + "/" + splitUp[2];

        return date;

    }

    public void addDeathDateFilter(String lowerBound, String upperBound) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        lowerBound = dateFixer(lowerBound);
        upperBound = dateFixer(upperBound);

        LocalDate lowerDate = LocalDate.parse(lowerBound, formatter);
        LocalDate upperDate = LocalDate.parse(upperBound, formatter);

        filterCreator.addDeathDateFilter(upperDate, lowerDate);
    }

    public void addIsCowFilter() {
        filterCreator.addCategoryFilter(Category.COW);
    }

    public void addIsHeiferFilter() {
        filterCreator.addCategoryFilter(Category.HEIFER);

    }

    public void addIsSteerFilter() {
        filterCreator.addCategoryFilter(Category.STEER);

    }

    public void addIsBullFilter() {
        filterCreator.addCategoryFilter(Category.BULL);
    }

    public void addIsFemaleFilter() {
        filterCreator.addGenderFilter(Gender.FEMALE);

    }

    public void addIsMaleFilter() {
        filterCreator.addGenderFilter(Gender.MALE);
    }

    public void addWeightRangeFilter(String lowerBound, String upperBound) {
        filterCreator.addWeightFilter(Double.parseDouble(upperBound), Double.parseDouble(lowerBound));
    }

    public void saveFilter(String title) {
        cattleModel.saveFilter(interactionModel.inProgressFilter, title);
    }

    public void deleteSavedFilter(int selectedIndex) {
        if (selectedIndex >= 0) {
            cattleModel.deleteSavedFilter(selectedIndex);
        }
    }



    public void goToAddCowView(ActionEvent actionEvent) {
        interactionModel.setCurrentView(CurrentView.ADD);
    }

    public void removeCowFromList() {

        cattleModel.removeCow(cattleModel.getCows().get(0));
        interactionModel.pop();
//        interactionModel.updateFilters();
//        interactionModel.getCurrentView(
        ArrayList<CowFilter> currentFilter = interactionModel.getCurrentFilter();
        cattleModel.filterCows(currentFilter);
    }

    public void goToEditCowView() {

        interactionModel.setCurrentView(CurrentView.EDIT);
    }

    public void changeView(CurrentView view) {
        interactionModel.setCurrentView(view);
//        if (interactionModel.getCurrentView() == CurrentView.MAIN) {
//            interactionModel.setCurrentView(CurrentView.FILTER);
//        } else if (interactionModel.getCurrentView() == CurrentView.FILTER) {
//            interactionModel.setCurrentView(CurrentView.MAIN);
//        }

    }
//    public void changeViewAddCow(ActionEvent event) {
//        interactionModel.setCurrentView(CurrentView.ADDOREDIT);
//    }

    public void createCow(Cow newCow) {
        if (newCow != null) {
            cattleModel.addCow(newCow);
            cattleModel.filterCows(interactionModel.getCurrentFilter());
        }
    }

    public void editCow(Cow newCow) {
        if (newCow != null) {
            cattleModel.editCow(newCow);
            interactionModel.setCurrentView(CurrentView.MAIN);
        }
    }

    public void updateCurrentFilter() {
        cattleModel.filterCows(interactionModel.getCurrentFilter());
    }

    public void loadSavedFilter(int selectedIndex) {
        SavedFilter filter = cattleModel.getSavedFilters().get(selectedIndex);
        interactionModel.clearInProgressFilter();
        interactionModel.populateInProgressFilter(filter);
    }
}
