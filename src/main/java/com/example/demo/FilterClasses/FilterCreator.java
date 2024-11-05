package com.example.demo.FilterClasses;

import com.example.demo.DataClasses.Cow;
import com.example.demo.Enums.Category;
import com.example.demo.Enums.Gender;
import com.example.demo.Models.InteractionModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class FilterCreator {
    InteractionModel interactionModel;
    public FilterCreator() {

    }

    public void setInteractionModel(InteractionModel interactionModel) {
        this.interactionModel = interactionModel;
    }

    public void clearFilter() {
        this.interactionModel.inProgressFilter.clear();
    }
    // adds the current in progress filter to the iModel
    public void createFilter() {
        // check if in progress filter is the same as the previous in progress filter
        if (!interactionModel.getCurrentFilter().equals(interactionModel.peek())) {
            interactionModel.push(interactionModel.inProgressFilter);
        }
//        interactionModel.push(inProgressFilter);
//        clearFilter(); // resets the temp filter to empty, ready to create the next one
    }

    // Filters
    // use individual methods as each method will have different arguments
    public void addIndividualCowFilter(String ID) {
//        this.inProgressFilter.add(new IndividualCowFilter(ID));
            interactionModel.append(new IndividualCowFilter((ID)));
    }
    public void addAliveCowFilter() {
//        this.inProgressFilter.add(new AliveFilter());
        interactionModel.append(new AliveFilter());
    }
    public void addIsDeadFilter() {
//        this.inProgressFilter.add(new DeadFilter());
        interactionModel.append(new DeadFilter());
    }
    public void addDeathDateFilter(LocalDate h, LocalDate l) {
//        this.inProgressFilter.add(new DeathDateFilter(h, l));
        interactionModel.append(new DeathDateFilter(h, l));
    }
//    public void addDeathDateFilter(LocalDate h, LocalDate l) {this.inProgressFilter.add(new DeathDateFilter(h, l));}
//    public void addAgeFilter(double h, double l) {this.inProgressFilter.add(new AgeFilter(h,l));}
//    public void addBirthdayFilter(LocalDate h, LocalDate l) {this.inProgressFilter.add(new BirthdayFilter(h,l));}
//    public void addCategoryFilter(Category c) {this.inProgressFilter.add(new CategoryFilter(c));}
//    public void addChildFilter(Cow p) {this.inProgressFilter.add(new ChildFilter(p));}
//    public void addExposureFilter(Cow c) {this.inProgressFilter.add(new ExposureFilter(c));}
//    public void addGenderFilter(Gender g) {this.inProgressFilter.add(new GenderFilter(g));}
//    public void addWeightFilter(double h, double l) {this.inProgressFilter.add(new WeightFilter(h,l));}
//    public void addNeedsVaccineFilter(String v) {this.inProgressFilter.add(new NeedsVaccineFilter(v));}
    public void addAgeFilter(double h, double l) {
//        this.inProgressFilter.add(new AgeFilter(h,l));
        interactionModel.append(new AgeFilter(h,l));
    }
    public void addBirthdayFilter(LocalDate h, LocalDate l) {
//        this.inProgressFilter.add(new BirthdayFilter(h,l));
        interactionModel.append(new BirthdayFilter(h,l));
    }
    public void addCategoryFilter(Category c) {
//        this.inProgressFilter.add(new CategoryFilter(c));
        interactionModel.append(new CategoryFilter(c));
    }
    public void addChildFilter(Cow p) {
        interactionModel.append(new ChildFilter(p));
        //this.inProgressFilter.add(new ChildFilter(p));
    }
    public void addExposureFilter(Cow c) {
//        this.inProgressFilter.add(new ExposureFilter(c));
        interactionModel.append(new ExposureFilter(c));
    }
    public void addGenderFilter(Gender g) {
        //this.inProgressFilter.add(new GenderFilter(g));
        interactionModel.append(new GenderFilter(g));
    }
    public void addWeightFilter(double h, double l) {
//        this.inProgressFilter.add(new WeightFilter(h,l));
        interactionModel.append(new WeightFilter(h,l));
    }
    public void addNeedsVaccineFilter(String v) {
       // this.inProgressFilter.add(new NeedsVaccineFilter(v));
        interactionModel.append(new NeedsVaccineFilter(v));
    }
}

