package com.example.demo.Delete;

import com.example.demo.DataClasses.Cow;
import com.example.demo.DataClasses.Field;
import com.example.demo.DataClasses.Herd;
import com.example.demo.DataClasses.Weight;
import com.example.demo.Delete.ModelListener;
import com.example.demo.Enums.Category;
import com.example.demo.Enums.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Model {
    public ArrayList<ModelListener> subscribers;
    private ArrayList<Cow> allCows;

    public Model() {
        this.subscribers = new ArrayList<>();
        this.allCows = new ArrayList<>();


        this.addFakeCows();

    }
    public ArrayList<Cow> getAllCows() {
        return allCows;
    }


    public void addFakeCows(){

        Cow cow1 = new Cow("1", "F39", LocalDate.of(2000, 10, 22), Category.COW, null, null, null, Gender.FEMALE );
        Cow cow2 = new Cow("2", "E3", LocalDate.of(2001, 10, 22), Category.HEIFER, null, null, null, Gender.FEMALE );
        Cow cow3 = new Cow("3", "E32", LocalDate.of(2002, 10, 22), Category.BULL, null, null, null, Gender.MALE );
        Cow cow4 = new Cow("4", "A13", LocalDate.of(2003, 10, 22), Category.STEER, null, null, null, Gender.MALE );

        Cow cow5 = new Cow("5", "D3", LocalDate.of(2004, 10, 22), Category.COW, null, null, null, Gender.FEMALE );
        Cow cow6 = new Cow("6", "B2", LocalDate.of(2005, 10, 22), Category.HEIFER, null, null, null, Gender.FEMALE );
        Cow cow7 = new Cow("7", "F49", LocalDate.of(2006, 10, 22), Category.BULL, null, null, null, Gender.MALE );
        Cow cow8 = new Cow("8", "C19", LocalDate.of(2007, 10, 22), Category.STEER, null, null, null, Gender.MALE );

        cow1.setDam(cow2);
        cow1.setSire(cow3);
        cow4.setDam(cow2);
        cow4.setSire(cow3);

        cow5.setDam(cow2);
        cow5.setSire(cow3);

        cow6.setDam(cow2);
        cow6.setSire(cow3);

        cow7.setDam(cow2);
        cow7.setSire(cow3);

        cow8.setDam(cow2);
        cow8.setSire(cow3);

        cow8.setHerd(new Herd(new Field("OnlyField")));
        cow8.addWeightRecord(new Weight(114.5f, LocalDate.of(2022, 10, 24)));


        allCows.add(cow1);
        allCows.add(cow2);
        allCows.add(cow3);
        allCows.add(cow4);
        allCows.add(cow5);
        allCows.add(cow6);
        allCows.add(cow7);
        allCows.add(cow8);



    }



}
