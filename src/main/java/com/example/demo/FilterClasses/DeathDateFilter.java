package com.example.demo.FilterClasses;

import com.example.demo.DataClasses.Cow;
import com.example.demo.DataClasses.Field;
import com.example.demo.DataClasses.Herd;
import com.example.demo.DataClasses.Weight;
import com.example.demo.Enums.Category;
import com.example.demo.Enums.FilterType;
import com.example.demo.Enums.Gender;

import java.time.LocalDate;

public class DeathDateFilter implements CowFilter {
    private LocalDate dateHigh, dateLow;

    public DeathDateFilter(LocalDate h, LocalDate l) {
        this.dateHigh = h;
        this.dateLow = l;
    }

    @Override
    public String toString() {
        return "Died between: " + dateLow + " and " + dateHigh;
    }

    @Override
    public boolean meetsCriteria(Cow cow) {
        if (dateHigh.compareTo(cow.getDateOfDeath()) > 0 && dateLow.compareTo(cow.getDateOfDeath()) < 0 ) {
            return true;
        }
        else {
            return false;
        }
    }

    // main for testing
    public static void main(String[] args) {

        Cow cow1 = new Cow("1", "F39", LocalDate.of(2000, 10, 22), Category.COW, null, null, null, Gender.FEMALE );
        Cow cow2 = new Cow("2", "E3", LocalDate.of(2001, 10, 22), Category.HEIFER, null, null, null, Gender.FEMALE );
        Cow cow3 = new Cow("3", "E32", LocalDate.of(2002, 10, 22), Category.BULL, null, null, null, Gender.MALE );
        Cow cow4 = new Cow("4", "A13", LocalDate.of(2003, 10, 22), Category.STEER, null, null, null, Gender.MALE );
        Cow cow5 = new Cow("5", "D3", LocalDate.of(2004, 10, 22), Category.COW, null, null, null, Gender.FEMALE );
        Cow cow6 = new Cow("6", "B2", LocalDate.of(2005, 10, 22), Category.HEIFER, null, null, null, Gender.FEMALE );
        Cow cow7 = new Cow("7", "F49", LocalDate.of(2006, 10, 22), Category.BULL, null, null, null, Gender.MALE );
        Cow cow8 = new Cow("8", "C19", LocalDate.of(2007, 10, 22), Category.STEER, null, null, null, Gender.MALE );

        cow1.setDateOfDeath(LocalDate.of(1990, 1, 1));
        cow2.setDateOfDeath(LocalDate.of(1994,1,1));
        cow3.setDateOfDeath(LocalDate.of(1998,2,3));
        cow4.setDateOfDeath(LocalDate.of(2000,1,1));
        cow5.setDateOfDeath(LocalDate.of(2003,1,1));
        cow6.setDateOfDeath(LocalDate.of(2010,9,9));
        cow7.setDateOfDeath(LocalDate.of(2019,5,5));
        cow8.setDateOfDeath(LocalDate.now());

        DeathDateFilter deathFilter = new DeathDateFilter(LocalDate.of(2009,2,2), LocalDate.of(1996,2,2));

        // should return false
        if (deathFilter.meetsCriteria(cow1)) {
            System.out.println("error in meetsCriteria():test 1 - boolean is wrong");
        }
        // should return false
        if (deathFilter.meetsCriteria(cow2)) {
            System.out.println("error in meetsCriteria():test 2 - boolean is wrong");
        }
        // should return true
        if (!deathFilter.meetsCriteria(cow3)) {
            System.out.println("error in meetsCriteria():test 3 - boolean is wrong");
        }
        // should return true
        if (!deathFilter.meetsCriteria(cow4)) {
            System.out.println("error in meetsCriteria():test 4 - boolean is wrong");
        }
        // should return true
        if (!deathFilter.meetsCriteria(cow5)) {
            System.out.println("error in meetsCriteria():test 5 - boolean is wrong");
        }
        // should return false
        if (deathFilter.meetsCriteria(cow6)) {
            System.out.println("error in meetsCriteria():test 6 - boolean is wrong");
        }
        // should return false
        if (deathFilter.meetsCriteria(cow7)) {
            System.out.println("error in meetsCriteria():test 7 - boolean is wrong");
        }
        // should return false
        if (deathFilter.meetsCriteria(cow8)) {
            System.out.println("error in meetsCriteria():test 8 - boolean is wrong");
        }
    }
}
