package com.example.demo.FilterClasses;

import com.example.demo.DataClasses.Cow;
import com.example.demo.DataClasses.Field;
import com.example.demo.DataClasses.Herd;
import com.example.demo.DataClasses.Weight;
import com.example.demo.Enums.Category;
import com.example.demo.Enums.Gender;

import java.time.LocalDate;


public class BirthdayFilter implements CowFilter {

    private LocalDate dateHigh, dateLow;

    public BirthdayFilter(LocalDate h, LocalDate l) {
        this.dateHigh = h;
        this.dateLow = l;
    }

    @Override
    public String toString() {
        return "Born between: " + dateLow + " and " + dateHigh ;
    }

    @Override
    public boolean meetsCriteria(Cow cow) {
        if (cow.getDateOfBirth() != null) {
            if (dateHigh.compareTo(cow.getDateOfBirth()) > 0 && dateLow.compareTo(cow.getDateOfBirth()) < 0 ) {
                return true;
            }
            else {
                return false;
            }
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
        Cow cow8 = new Cow("8", "C19", null, Category.STEER, null, null, null, Gender.MALE );

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

        BirthdayFilter birthdayFilter = new BirthdayFilter(LocalDate.of(2006,2,2), LocalDate.of(2002,2,2));

        // should return false
        if (birthdayFilter.meetsCriteria(cow1)) {
            System.out.println("error in meetsCriteria():test 1 - boolean is wrong");
        }
        // should return false
        if (birthdayFilter.meetsCriteria(cow2)) {
            System.out.println("error in meetsCriteria():test 2 - boolean is wrong");
        }
        // should return true
        if (!birthdayFilter.meetsCriteria(cow3)) {
            System.out.println("error in meetsCriteria():test 3 - boolean is wrong");
        }
        // should return true
        if (!birthdayFilter.meetsCriteria(cow4)) {
            System.out.println("error in meetsCriteria():test 4 - boolean is wrong");
        }
        // should return true
        if (!birthdayFilter.meetsCriteria(cow5)) {
            System.out.println("error in meetsCriteria():test 5 - boolean is wrong");
        }
        // should return true
        if (!birthdayFilter.meetsCriteria(cow6)) {
            System.out.println("error in meetsCriteria():test 6 - boolean is wrong");
        }
        // should return false
        if (birthdayFilter.meetsCriteria(cow7)) {
            System.out.println("error in meetsCriteria():test 7 - boolean is wrong");
        }
        // should return false
        if (birthdayFilter.meetsCriteria(cow8)) {
            System.out.println("error in meetsCriteria():test 8 - boolean is wrong");
        }
    }
}
