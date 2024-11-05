package com.example.demo.Models;

import com.example.demo.DataClasses.*;
import com.example.demo.Enums.Category;
import com.example.demo.FilterClasses.CowFilter;
import com.example.demo.Enums.Gender;
import com.example.demo.ModelListeners.CattleModelListener;
import com.example.demo.ModelListeners.InteractionModelListener;
import com.example.demo.SQLiteDatabase;

import java.time.LocalDate;
import java.util.ArrayList;

public class CattleModel implements InteractionModelListener {
    // this will change into a container for the various pages
    ArrayList<CattleModelListener> cattleModelSubscribers;
    ArrayList<Cow> allCows;
    ArrayList<Cow> filteredCows;
    ArrayList<SavedFilter> savedFilters;
    //Constructor
    public CattleModel() {
        cattleModelSubscribers = new ArrayList<>();
        allCows = new ArrayList<>();
        filteredCows = new ArrayList<>();
        savedFilters = new ArrayList<>();
        //Testing
        addFakeCowData();
//        display();
        //!Testing
    }



    //Testing
    private void addFakeCowData() {
        Cow cow1 = new Cow("8655343858758", "F39", LocalDate.of(2018, 10, 22), Category.COW, null, null, null, Gender.FEMALE );
        LocalDate date = LocalDate.now();
        cow1.addWeightRecord(new Weight(992F, date));

        Cow cow2 = new Cow("3562397507649", "E3", LocalDate.of(2019, 10, 22), Category.HEIFER, null, null, null, Gender.FEMALE );
        cow1.addChild(cow2);

        Cow cow3 = new Cow("1346546547589", "E32", LocalDate.of(2018, 10, 22), Category.BULL, null, null, null, Gender.MALE );
        Cow cow4 = new Cow("5640984328971", "A13", LocalDate.of(2018, 10, 22), Category.STEER, null, null, null, Gender.MALE );
        Cow cow5 = new Cow("8758757907747", "D3", LocalDate.of(2019, 10, 22), Category.COW, null, null, null, Gender.FEMALE );
        Cow cow6 = new Cow("3537658759769", "B2", LocalDate.of(2018, 10, 22), Category.HEIFER, null, null, null, Gender.FEMALE );
        Cow cow7 = new Cow("9865209735495", "F49", LocalDate.of(2019, 10, 22), Category.BULL, null, null, null, Gender.MALE );
        Cow cow8 = new Cow("8868765436536", "C19", LocalDate.of(2018, 10, 22), Category.STEER, null, null, null, Gender.MALE );
        Cow cow9 = new Cow("6875764563747", "D32", LocalDate.of(2019, 10, 22), Category.COW, null, null, null, Gender.FEMALE );
        Cow cow10 = new Cow("9879866757655", "B23", LocalDate.of(2021, 10, 22), Category.HEIFER, null, null, null, Gender.FEMALE );
        Cow cow11 = new Cow("8768775465465", "D1", LocalDate.of(2019, 10, 22), Category.COW, null, null, null, Gender.FEMALE );
        Cow cow12 = new Cow("1245689879787", "B96", LocalDate.of(2019, 10, 22), Category.HEIFER, null, null, null, Gender.FEMALE );
        Cow cow13 = new Cow("5765765734243", "D82", LocalDate.of(2020, 10, 22), Category.COW, null, null, null, Gender.FEMALE );
        Cow cow14 = new Cow("4123876780945", "B87", LocalDate.of(2021, 10, 22), Category.HEIFER, null, null, null, Gender.FEMALE );
        Cow cow15 = new Cow("1327675687697", "D87", LocalDate.of(2019, 10, 22), Category.COW, null, null, null, Gender.FEMALE );
        Cow cow16 = new Cow("7687678665465", "B23", LocalDate.of(2019, 10, 22), Category.HEIFER, null, null, null, Gender.FEMALE );
        Cow cow17 = new Cow("355i798765888", "D34", LocalDate.of(2020, 10, 22), Category.COW, null, null, null, Gender.FEMALE );
        Cow cow18 = new Cow("2547868780776", "B25", LocalDate.of(2021, 10, 22), Category.HEIFER, null, null, null, Gender.FEMALE );
        Cow cow19 = new Cow("7687345309844", "D45", LocalDate.of(2019, 10, 22), Category.COW, null, null, null, Gender.FEMALE );
        Cow cow20 = new Cow("9875340984353", "B19", LocalDate.of(2019, 10, 22), Category.HEIFER, null, null, null, Gender.FEMALE );
        Cow cow21 = new Cow("0982859732583", "D17", LocalDate.of(2020, 10, 22), Category.COW, null, null, null, Gender.FEMALE );
        Cow cow22 = new Cow("9874589723587", "B43", LocalDate.of(2021, 10, 22), Category.HEIFER, null, null, null, Gender.FEMALE );
        Cow cow23 = new Cow("9823985772356", "D92", LocalDate.of(2019, 10, 22), Category.COW, null, null, null, Gender.FEMALE );
        Cow cow24 = new Cow("3726358762385", "B95", LocalDate.of(2019, 10, 22), Category.HEIFER, null, null, null, Gender.FEMALE );



        cow1.addToMedicalHistory(new MedProc("MadCow Vaccine", date.toString(), "Not Vaccinated", "BigPharma404", "500mg", "Intermuscular", "Went Well"));
        cow1.addToMedicalHistory(new MedProc("Apply anti-inflamatory rub", date.toString(), "Swollen joints", "WeedRubber", "420g", "Surface Ointment", "Agitated behavior, probably from application"));
        cow2.addToMedicalHistory(new MedProc("Gave Love and Affection", date.toString(), "Felt Lonely", "Love", "Lots", "Hug and attention", "Went Well"));
        cow3.addToMedicalHistory(new MedProc("Removed Foreign Body", date.toString(), "Cow fell onto metal scrap", "Vet", "1", "Surgery", "See Vet Notes"));
        cow6.addToMedicalHistory(new MedProc("Applied anti-biotics", date.toString(), "Post Surgery Anti-biotics", "Penicillin", "275mg", "Oral Pill", "2x a day"));
        cow8.addToMedicalHistory(new MedProc("Test Procedure", "Test Date", "Test Reason", "Test Product", "Test Dosage", "Test Route", "Test Notes"));


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

        cow8.setHerd(new Herd("NW32", new Field("OnlyField")));
        cow8.addWeightRecord(new Weight(114.5f, LocalDate.of(2022, 10, 24)));


        cow1.addWeightRecord(new Weight(992F, date));
        cow2.addWeightRecord(new Weight(346F, date));
        cow3.addWeightRecord(new Weight(456F, date));
        cow4.addWeightRecord(new Weight(657F, date));
        cow5.addWeightRecord(new Weight(678F, date));
        cow6.addWeightRecord(new Weight(789F, date));
        cow7.addWeightRecord(new Weight(976F, date));
        cow8.addWeightRecord(new Weight(543F, date));
        cow9.addWeightRecord(new Weight(756F, date));
        cow10.addWeightRecord(new Weight(1756F, date));
        cow11.addWeightRecord(new Weight(474F, date));
        cow12.addWeightRecord(new Weight(583F, date));
        cow13.addWeightRecord(new Weight(996F, date));
        cow14.addWeightRecord(new Weight(344F, date));
        cow15.addWeightRecord(new Weight(666F, date));
        cow16.addWeightRecord(new Weight(888F, date));
        cow17.addWeightRecord(new Weight(676F, date));
        cow18.addWeightRecord(new Weight(686F, date));
        cow19.addWeightRecord(new Weight(934F, date));


        allCows.add(cow1);
        allCows.add(cow2);
        allCows.add(cow3);
        allCows.add(cow4);
        allCows.add(cow5);
        allCows.add(cow6);
        allCows.add(cow7);
        allCows.add(cow8);
//        allCows.add(cow9);
//        allCows.add(cow10);
//        allCows.add(cow11);
//        allCows.add(cow12);
//        allCows.add(cow13);
//        allCows.add(cow14);
//        allCows.add(cow15);
//        allCows.add(cow16);
//        allCows.add(cow17);
//        allCows.add(cow18);
//        allCows.add(cow19);
//        allCows.add(cow20);
//        allCows.add(cow21);
//        allCows.add(cow22);
//        allCows.add(cow23);
//        allCows.add(cow24);


//        allCows.add(new Cow("3837383", "F49", new Date(), Category.COW, null, null, null, Gender.FEMALE ));
//        allCows.add(new Cow("93809380983", "F49", new Date(), Category.COW, null, null, null, Gender.FEMALE ));
//        allCows.add(new Cow("48983983", "F49", new Date(), Category.COW, null, null, null, Gender.FEMALE ));


        filteredCows = allCows;
//        allCows.forEach(c->
//                filteredCows.add(c));
    }
    private void display(){
        try {
            SQLiteDatabase database = new SQLiteDatabase();
            database.displayCowID();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //!Testing
    public ArrayList<Cow> getCows() { // Testing, this will return cow objects
        return filteredCows;
    }
    public ArrayList<Cow> getAllCows() {return allCows;}
    public void filterCows(ArrayList<CowFilter> filters) {
        // get filters from iModel
        // iterate through the list of all cows
        // see which ones meet the criteria of every current filters

        if (filters != null && !filters.isEmpty()) {

        filteredCows = new ArrayList<>();
        for (Cow cow: allCows) {
            boolean failed = false;

            for (CowFilter filter: filters) {
                if (!filter.meetsCriteria(cow)) {
                    failed = true;
                }
            }
            if (!filteredCows.contains(cow) && failed == false) {
                filteredCows.add(cow);
            }
        }
    }
        notifySubscribers();
    }



    public void addCattleModelSubscriber(CattleModelListener subscriber) {
        cattleModelSubscribers.add(subscriber);
    }

    private void notifySubscribers() {
        for(CattleModelListener subscriber: cattleModelSubscribers) {
            subscriber.cattleModelChanged();
        }
    }

    public void saveFilter(ArrayList<CowFilter> filters, String title) {
        savedFilters.add(new SavedFilter(title, filters));
        notifySubscribers();
    }
    public ArrayList<SavedFilter> getSavedFilters() {
        return savedFilters;
    }

    public void deleteSavedFilter(int selectedIndex) {
        savedFilters.remove(selectedIndex);
        notifySubscribers();
    }

    public void removeCow(Cow cow) {
        //Cow cow = filteredCows.get(index);
        //Cow cow = allCows.get(index);
//        String cowID = cow.getID();
//        int count = 0;
//        for (Cow cowIterator : allCows) {
//            if (cowIterator.getID().compareTo(cowID) == 0) {
//                break;
//            }
//            count ++;
//        }
        System.out.println("allcows length before: " + this.allCows.size());
        allCows.remove(cow);
        System.out.println("allcows length after: " + this.allCows.size());
        notifySubscribers();
    }

    public void addCow(Cow newCow) {
//        try {
//            SQLiteDatabase database = new SQLiteDatabase();
//            database.insertCow(newCow);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
        allCows.add(newCow);
        notifySubscribers();
    }

    public Cow getCowFromID(String idString) {
        for (Cow cow: allCows) {
            if (cow.getID().compareTo(idString) == 0) {
                return cow;
            }
        }
        return null;
    }

    public Cow getCowToEdit() {
        return filteredCows.get(0);
    }

    public void editCow(Cow newCow) {
        Cow cow = filteredCows.get(0);
        cow.setID(newCow.getID());
        cow.setFarmTag(newCow.getFarmTag());
        cow.setDateOfDeath(newCow.getDateOfBirth());
        cow.setDateOfDeath(newCow.getDateOfDeath());
        cow.setCategory(newCow.getCategory());
        cow.setDam(newCow.getDam());
        cow.setSire(newCow.getSire());
        cow.setHerd(newCow.getHerd());
        cow.setGender(newCow.getGender());
        notifySubscribers();
    }

    @Override
    public void iModelChanged() {

    }

//    public void setCowToEdit() {
//
//    }
}
