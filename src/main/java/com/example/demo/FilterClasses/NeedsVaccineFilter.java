package com.example.demo.FilterClasses;

import com.example.demo.DataClasses.Cow;
import com.example.demo.DataClasses.MedProc;
import com.example.demo.Enums.Category;
import com.example.demo.Enums.Gender;

import java.time.LocalDate;

public class NeedsVaccineFilter implements CowFilter {

    private String vaccine;

    public NeedsVaccineFilter(String v) {
        this.vaccine = v;
    }

    @Override
    public boolean meetsCriteria(Cow cow) {
        for (int i = 0; i < cow.getMedicalHistory().size(); i++) {
            if (vaccine.equalsIgnoreCase(cow.getMedicalHistory().get(i).getProcedure())) {
                return false;
            }
        }
        return true;
    }

    // main for testing
    public static void main(String[] args) {

        Cow cow1 = new Cow("1", "F39", LocalDate.of(2000, 10, 22), Category.COW, null, null, null, Gender.FEMALE);
        Cow cow2 = new Cow("2", "E3", LocalDate.of(2001, 10, 22), Category.HEIFER, null, null, null, Gender.FEMALE);
        Cow cow3 = new Cow("3", "E32", LocalDate.of(2002, 10, 22), Category.BULL, null, null, null, Gender.MALE);
        Cow cow4 = new Cow("4", "A13", LocalDate.of(2003, 10, 22), Category.STEER, null, null, null, Gender.MALE);
        Cow cow5 = new Cow("5", "D3", LocalDate.of(2004, 10, 22), Category.COW, null, null, null, Gender.FEMALE);
        Cow cow6 = new Cow("6", "B2", LocalDate.of(2005, 10, 22), Category.HEIFER, null, null, null, Gender.FEMALE);
        Cow cow7 = new Cow("7", "F49", LocalDate.of(2006, 10, 22), Category.BULL, null, null, null, Gender.MALE);
        Cow cow8 = new Cow("8", "C19", LocalDate.of(2007, 10, 22), Category.STEER, null, null, null, Gender.MALE);
        Cow cow9 = new Cow("9", "C19", LocalDate.of(2007, 10, 22), Category.STEER, null, null, null, Gender.MALE);

        cow1.addToMedicalHistory(new MedProc("Vaccination 1", "this date", "Prevention", "Something", "50 ml", "Injection", "a note"));
        cow2.addToMedicalHistory(new MedProc("Vaccination 2", "this date", "Prevention", "Something", "50 ml", "Injection", "a note"));
        cow3.addToMedicalHistory(new MedProc("Vaccination 3", "this date", "Prevention", "Something", "50 ml", "Injection", "a note"));
        cow4.addToMedicalHistory(new MedProc("Vaccination 1", "this date", "Prevention", "Something", "50 ml", "Injection", "a note"));
        cow5.addToMedicalHistory(new MedProc("Vaccination 2", "this date", "Prevention", "Something", "50 ml", "Injection", "a note"));
        cow6.addToMedicalHistory(new MedProc("Vaccination 3", "this date", "Prevention", "Something", "50 ml", "Injection", "a note"));
        cow7.addToMedicalHistory(new MedProc("Vaccination 1", "this date", "Prevention", "Something", "50 ml", "Injection", "a note"));
        cow8.addToMedicalHistory(new MedProc("Vaccination 2", "this date", "Prevention", "Something", "50 ml", "Injection", "a note"));

        cow1.addToMedicalHistory(new MedProc("Vaccination 2", "this date", "Prevention", "Something", "50 ml", "Injection", "a note"));
        cow2.addToMedicalHistory(new MedProc("Vaccination 3", "this date", "Prevention", "Something", "50 ml", "Injection", "a note"));
        cow3.addToMedicalHistory(new MedProc("Vaccination 4", "this date", "Prevention", "Something", "50 ml", "Injection", "a note"));
        cow4.addToMedicalHistory(new MedProc("Vaccination 5", "this date", "Prevention", "Something", "50 ml", "Injection", "a note"));
        cow5.addToMedicalHistory(new MedProc("Vaccination 1", "this date", "Prevention", "Something", "50 ml", "Injection", "a note"));
        cow6.addToMedicalHistory(new MedProc("Vaccination 2", "this date", "Prevention", "Something", "50 ml", "Injection", "a note"));
        cow7.addToMedicalHistory(new MedProc("Vaccination 3", "this date", "Prevention", "Something", "50 ml", "Injection", "a note"));
        cow8.addToMedicalHistory(new MedProc("Vaccination 4", "this date", "Prevention", "Something", "50 ml", "Injection", "a note"));

        NeedsVaccineFilter nvFilter = new NeedsVaccineFilter("Vaccination 3");

        // should return true
        if (!nvFilter.meetsCriteria(cow1)) {
            System.out.println("error in meetsCriteria():test 1 - boolean is wrong");
        }
        // should return false
        if (nvFilter.meetsCriteria(cow2)) {
            System.out.println("error in meetsCriteria():test 2 - boolean is wrong");
        }
        // should return false
        if (nvFilter.meetsCriteria(cow3)) {
            System.out.println("error in meetsCriteria():test 3 - boolean is wrong");
        }
        // should return true
        if (!nvFilter.meetsCriteria(cow4)) {
            System.out.println("error in meetsCriteria():test 4 - boolean is wrong");
        }
        // should return true
        if (!nvFilter.meetsCriteria(cow5)) {
            System.out.println("error in meetsCriteria():test 5 - boolean is wrong");
        }
        // should return false
        if (nvFilter.meetsCriteria(cow6)) {
            System.out.println("error in meetsCriteria():test 6 - boolean is wrong");
        }
        // should return false
        if (nvFilter.meetsCriteria(cow7)) {
            System.out.println("error in meetsCriteria():test 7 - boolean is wrong");
        }
        // should return true
        if (!nvFilter.meetsCriteria(cow8)) {
            System.out.println("error in meetsCriteria(): test 8 - boolean is wrong");
        }
        // should return true
        if (!nvFilter.meetsCriteria(cow9)) {
            System.out.println("error in meetsCriteria(): test 9 - boolean is wrong");
        }
    }
}
