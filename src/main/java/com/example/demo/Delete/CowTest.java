package com.example.demo.Delete;

import com.example.demo.DataClasses.*;
import com.example.demo.Enums.Category;
import com.example.demo.Enums.Gender;

import java.util.ArrayList;
import java.util.Date;

public class CowTest {
    // Attributes for Cow objects
    private String CowID;
    private String CowTag;
    private String dateOfBirth;
    private String dateOfDeath;
    private String category;
    private ArrayList<Weight> weightRecords;
    private ArrayList<MedProc> medicalHistory;
    private String damID;
    private String sireID;
    private ArrayList<String> childrenIDs;
    private String herdID;
    private String gender;
    private ArrayList<FieldData> locations;

    public String getCowID() {
        return CowID;
    }

    public void setCowID(String cowID) {
        CowID = cowID;
    }

    public String getCowTag() {
        return CowTag;
    }

    public void setCowTag(String cowTag) {
        CowTag = cowTag;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public ArrayList<Weight> getWeightRecords() {
        return weightRecords;
    }

    public void addWeightRecord(Weight weight) {
        this.weightRecords.add(weight);
    }

    public ArrayList<MedProc> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(ArrayList<MedProc> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getDamID() {
        return damID;
    }

    public void setDamID(String damID) {
        this.damID = damID;
    }

    public String getSireID() {
        return sireID;
    }

    public void setSireID(String sireID) {
        this.sireID = sireID;
    }

    public ArrayList<String> getChildrenIDs() {
        return childrenIDs;
    }

    public void setChildrenIDs(ArrayList<String> childrenIDs) {
        this.childrenIDs = childrenIDs;
    }

    public String getHerdID() {
        return herdID;
    }

    public void setHerdID(String herdID) {
        this.herdID = herdID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<FieldData> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<FieldData> locations) {
        this.locations = locations;
    }

    public String toString() {
        return ("\nCow ID: " + this.CowID + "\nCow Tag: " + this.CowTag + "\nDOB: " + this.dateOfBirth + "\nDOD: "
                + this.dateOfDeath + "\n Type: " + this.category + "Dam ID: " + this.damID + "Sire ID: " + this.sireID
                + "\nHerd: " );
    }

    public CowTest(String CowID, String TagID, String dateOfBirth, String dateOfDeath, String category, String damID, String sireID,
                   String herdID, String gender)
    {
        this.CowID = CowID;
        this.CowTag = TagID;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.category = category;
        this.damID = damID;
        this.sireID = sireID;
        this.herdID = herdID;
        this.gender = gender;
    }
}
