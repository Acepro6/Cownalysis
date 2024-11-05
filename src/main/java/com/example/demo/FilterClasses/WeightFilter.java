package com.example.demo.FilterClasses;

import com.example.demo.DataClasses.Cow;
import com.example.demo.DataClasses.Weight;
import com.example.demo.Enums.Category;
import com.example.demo.Enums.Gender;

import java.time.LocalDate;

public class WeightFilter implements CowFilter {

    private double high, low;

    public WeightFilter (double h, double l) {
        this.high = h;
        this.low = l;
    }

    @Override
    public String toString() {
        return "Weight between: " + low + " - " + high;
    }

    @Override
    public boolean meetsCriteria(Cow cow) {
        if (cow.getCurrentWeight() >= low && cow.getCurrentWeight() <= high) {
            return true;
        }
        else {
            return false;
        }
    }

    // Main for testing
    public static void main (String[] args) {

        Cow cow1 = new Cow("1", "F39", LocalDate.of(2000, 10, 22), Category.COW, null, null, null, Gender.FEMALE);
        Cow cow2 = new Cow("2", "E3", LocalDate.of(2001, 10, 22), Category.HEIFER, null, null, null, Gender.FEMALE);
        Cow cow3 = new Cow("3", "E32", LocalDate.of(2002, 10, 22), Category.BULL, null, null, null, Gender.MALE);
        Cow cow4 = new Cow("4", "A13", LocalDate.of(2003, 10, 22), Category.STEER, null, null, null, Gender.MALE);
        Cow cow5 = new Cow("5", "D3", LocalDate.of(2004, 10, 22), Category.COW, null, null, null, Gender.FEMALE);
        Cow cow6 = new Cow("6", "B2", LocalDate.of(2005, 10, 22), Category.HEIFER, null, null, null, Gender.FEMALE);
        Cow cow7 = new Cow("7", "F49", LocalDate.of(2006, 10, 22), Category.BULL, null, null, null, Gender.MALE);
        Cow cow8 = new Cow("8", "C19", LocalDate.of(2007, 10, 22), Category.STEER, null, null, null, Gender.MALE);
        Cow cow9 = new Cow("9", "C19", LocalDate.of(2007, 10, 22), Category.STEER, null, null, null, Gender.MALE);

        cow1.addWeightRecord(new Weight(125f, LocalDate.now()));
        cow2.addWeightRecord(new Weight(130f, LocalDate.now()));
        cow3.addWeightRecord(new Weight(135f, LocalDate.now()));
        cow4.addWeightRecord(new Weight(140f, LocalDate.now()));
        cow4.addWeightRecord(new Weight(145f, LocalDate.now()));
        cow5.addWeightRecord(new Weight(150f, LocalDate.now()));
        cow6.addWeightRecord(new Weight(155f, LocalDate.now()));
        cow7.addWeightRecord(new Weight(160f, LocalDate.now()));
        cow8.addWeightRecord(new Weight(165f, LocalDate.now()));
        cow9.addWeightRecord(new Weight(170f, LocalDate.now()));

        WeightFilter weightFilter = new WeightFilter(165, 135);

        // should return false
        if (weightFilter.meetsCriteria(cow1)) {
            System.out.println("error in meetsCriteria():test 1 - boolean is wrong");
        }
        // should return false
        if (weightFilter.meetsCriteria(cow2)) {
            System.out.println("error in meetsCriteria():test 2 - boolean is wrong");
        }
        // should return true
        if (!weightFilter.meetsCriteria(cow3)) {
            System.out.println("error in meetsCriteria():test 3 - boolean is wrong");
        }
        // should return true
        if (!weightFilter.meetsCriteria(cow4)) {
            System.out.println("error in meetsCriteria():test 4 - boolean is wrong");
        }
        // should return true
        if (!weightFilter.meetsCriteria(cow5)) {
            System.out.println("error in meetsCriteria():test 5 - boolean is wrong");
        }
        // should return true
        if (!weightFilter.meetsCriteria(cow6)) {
            System.out.println("error in meetsCriteria():test 6 - boolean is wrong");
        }
        // should return true
        if (!weightFilter.meetsCriteria(cow7)) {
            System.out.println("error in meetsCriteria():test 7 - boolean is wrong");
        }
        // should return true
        if (!weightFilter.meetsCriteria(cow8)) {
            System.out.println("error in meetsCriteria():test 8 - boolean is wrong");
        }
        // should return false
        if (weightFilter.meetsCriteria(cow9)) {
            System.out.println("error in meetsCriteria():test 9 - boolean is wrong");
        }
    }
}
