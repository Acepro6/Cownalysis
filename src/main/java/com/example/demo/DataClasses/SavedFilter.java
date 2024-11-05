package com.example.demo.DataClasses;

import com.example.demo.FilterClasses.CowFilter;

import java.util.ArrayList;

public class SavedFilter {
    String title;
     ArrayList<CowFilter> filters = new ArrayList<>();
    public SavedFilter(String title, ArrayList<CowFilter> filters) {
        this.title = title;
        for (CowFilter filter: filters) {
            this.filters.add(filter);
        }

    }
    public ArrayList<CowFilter> getFilters() {
        return filters;
    }

    @Override
    public String toString() {
        return title;
    }


    public static void test_SavedFilter(){
        ArrayList<CowFilter> filters1 = new ArrayList<>();
        SavedFilter test1 = new SavedFilter("SFTest", filters1);

        if(!test1.toString().equals("SFTest")){
            System.out.println("toString failed on SavedFilter, got" +
                    test1.toString());
        }



        System.out.println("SavedFilter tests done\n");
    }


    public static void main(String[] args){



    }
}
