package com.example.demo.Models;

import com.example.demo.DataClasses.Cow;
import com.example.demo.DataClasses.SavedFilter;
import com.example.demo.Enums.CurrentView;
import com.example.demo.Enums.FilterType;
import com.example.demo.FilterClasses.AliveFilter;
import com.example.demo.FilterClasses.CowFilter;
import com.example.demo.FilterClasses.FilterCreator;
import com.example.demo.ModelListeners.InteractionModelListener;
import com.example.demo.Views.FilterView;

import java.util.ArrayList;
import java.util.Stack;

public class InteractionModel {
    /*
 This class is going to be used for the filters
 There will be two views (or subviews of these 2) that can update the list of filters:
     MainView
     FilterView
  It notifies the model when it changes as the model notifies the view to update
  */
    ArrayList<InteractionModelListener> subscribers;
    // Stack of ArrayLists of CowFilter objects
    private Stack<ArrayList<CowFilter>> stack;
    public ArrayList<CowFilter> inProgressFilter = new ArrayList<>(); // this filter is being created and has not yet been added to the stack

    private ArrayList<String> filterTitles;
    private ArrayList<FilterType> filtersToShow;
    private FilterCreator filterCreator;
    private CurrentView currentView;

    private CurrentView prevView;


    // Constructor
    public InteractionModel() {
        subscribers = new ArrayList<>();
        stack = new Stack<ArrayList<CowFilter>>();
        filterTitles = new ArrayList<>();
        filtersToShow = new ArrayList<FilterType>();
        filterTitles.add("age");
        filterTitles.add("alive");
        filterTitles.add("dead");
        filterTitles.add("death");
        filterTitles.add("all cows");
        filterTitles.add("birthdate");
        filterTitles.add("death date");
        filterTitles.add("cow");
        filterTitles.add("steer");
        filterTitles.add("bull");
        filterTitles.add("heifer");
        filterTitles.add("exposure");
        filterTitles.add("gender");
        filterTitles.add("male");
        filterTitles.add("female");
        filterTitles.add("weight");
        filterTitles.add("medical");
        filterTitlesSearch("");
    }

    // Stack functions
    // push
    public void push() {
        stack.push(inProgressFilter);
        notifySubscribers();
    }
    public void push (ArrayList<CowFilter> filter) {
        stack.push(filter);
        notifySubscribers();
    }
    public void append(CowFilter filter) {
        inProgressFilter.add(filter);
        notifySubscribers();
    }

    // pop
    public ArrayList<CowFilter> pop() {
        System.out.println("Testing");
        ArrayList<CowFilter> item = null;
        //Got an empty stack exception if we didn't do this
        if(!stack.isEmpty()) {
            item = stack.pop();
        }

        if (stack.isEmpty()) {

            this.inProgressFilter.clear();
            filterCreator.addAliveCowFilter();
            ArrayList<CowFilter> tempList = new ArrayList<>();
            for (CowFilter filter: inProgressFilter) { // this is needed in order to clear the list without clearing the stack in CattleModel
                tempList.add(filter);
            }
            this.inProgressFilter.clear();

            this.push(tempList);

        }
        inProgressFilter.clear();
        return item;
    }

    // peek
    public ArrayList<CowFilter> peek() {
        if (stack.isEmpty()) {

            return new ArrayList<CowFilter>();
        }
        return stack.peek();

//        if (!stack.isEmpty()) {
//        } else {
////            FilterCreator filterCreator = new FilterCreator();
////            filterCreator.setInteractionModel(this);
//
////            this.inProgressFilter.clear();
////            filterCreator.addAliveCowFilter();
////            this.push(this.inProgressFilter);
////            this.inProgressFilter.clear();
////            return stack.get(0);
//
//
////            filterCreator.createFilter();
////            return stack.peek();
//
//        }

    }
    private void stackEmpty() {

    }

    public void setFilterCreator(FilterCreator filterCreator) {
        this.filterCreator = filterCreator;
    }
    // view
    public Stack<ArrayList<CowFilter>> view() {
        return stack;
    }

    public void filterTitlesSearch(String searchString) {
        filtersToShow.clear();
        String lowerCaseSearchString = searchString.toLowerCase();
        for (String filterTitle: filterTitles) {
            if (filterTitle.contains(searchString)) {
                if (filterTitle == "age") {
                    filtersToShow.add(FilterType.AGE);
                    filtersToShow.add(FilterType.AGE_RANGE);
                } else if (filterTitle == "alive" || filterTitle == "birthdate" ) {
                    filtersToShow.add(FilterType.ALIVE);
                    filtersToShow.add(FilterType.BIRTHDATE);
                    filtersToShow.add(FilterType.BIRTHDATE_RANGE);
                } else if (filterTitle == "dead" || filterTitle == "death" || filterTitle == "death date")  {
                    filtersToShow.add(FilterType.DEAD);
                    filtersToShow.add(FilterType.DEATHDATE);
                    filtersToShow.add(FilterType.DEATHDATE_RANGE);
                } else if (filterTitle == "cow") {
                    filtersToShow.add(FilterType.COW);
                } else if (filterTitle == "heifer") {
                    filtersToShow.add(FilterType.HEIFER);
                } else if (filterTitle == "steer") {
                    filtersToShow.add(FilterType.STEER);
                } else if (filterTitle == "bull") {
                    filtersToShow.add(FilterType.BULL);
                } else if (filterTitle == "gender" || filterTitle == "female" || filterTitle == "male") {
                    filtersToShow.add(FilterType.FEMALE);
                    filtersToShow.add(FilterType.MALE);
                } else if (filterTitle == "weight") {
                    filtersToShow.add(FilterType.WEIGHT_RANGE);
                }
                System.out.println(filterTitle);
            }
        }
        System.out.println(" ");
        notifySubscribers();
    }
    public ArrayList<FilterType> getFilterTypes() {
        return filtersToShow;
    }
    public ArrayList<CowFilter> getInProgressFilter() {
        return inProgressFilter;
    }

    public ArrayList<CowFilter> getCurrentFilter() {


        if (inProgressFilter.isEmpty() && !stack.empty()) {
            return this.peek();
        }
        else if (inProgressFilter.isEmpty()) {
            filterCreator.addAliveCowFilter();
            filterCreator.createFilter();
            return this.peek();
        } else {
            return inProgressFilter;
        }
    }
    public void clearInProgressFilter() {
        inProgressFilter.clear();
        notifySubscribers();
    }

    //Testing
    public void updateFilters() { // this will take a list of filters
        notifySubscribers();
    }
    //!Testing

    public void addSubscriber(InteractionModelListener subscriber) {
        this.subscribers.add(subscriber);
    }

    private void notifySubscribers() {
        for (InteractionModelListener subscriber: subscribers) {
            subscriber.iModelChanged();
        }
    }

    public static void main(String[] args) {
        FilterCreator filterCreator = new FilterCreator();
        InteractionModel interactionModel = new InteractionModel();
        filterCreator.setInteractionModel(interactionModel);
        interactionModel.setFilterCreator(filterCreator);
        filterCreator.addIsDeadFilter();
        filterCreator.createFilter();
//        // test add filter
        if (interactionModel.stack.isEmpty() != false) {
            System.out.println("Error adding filter to stack");
        }
//        // test pop
        interactionModel.pop();
        if (interactionModel.stack.isEmpty() == true) {
            System.out.println("Error popping the filter from the stack (did not create the default class");
        }
        if (!(interactionModel.stack.peek().get(0) instanceof AliveFilter)) {
            System.out.println("Error popping the filter from the stack");
        }
//        if ()
    }

    public void setCurrentView(CurrentView currentView) {
        this.currentView = currentView;
        notifySubscribers();
    }
    public CurrentView getCurrentView() {
        return currentView;
    }

    public void populateInProgressFilter(SavedFilter filters) {
        for (CowFilter filter: filters.getFilters()) {
            inProgressFilter.add(filter);
        }
        notifySubscribers();
    }
}
