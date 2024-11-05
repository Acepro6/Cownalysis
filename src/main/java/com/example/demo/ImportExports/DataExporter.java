package com.example.demo.ImportExports;

import com.example.demo.DataClasses.Cow;
import com.example.demo.DataClasses.Herd;
import com.example.demo.DataClasses.MedProc;
import com.example.demo.DataClasses.Weight;

import java.time.LocalDate;

public class DataExporter {



    /**
     * Constructor
     */
    public DataExporter() {
    }

    /**
     * creates a string for the date value stored in LocalDate
     * @param d a LocalDate java.time. object
     * @return a String of the input date
     */
    public String createStringDate(LocalDate d) {
        String out = Integer.toString(d.getDayOfMonth()) + "//" + Integer.toString(d.getMonthValue())
                + "//" + Integer.toString(d.getYear());

        return out;
    }

    /**
     * Converts a cow data class to a list of strings to be used in .csv's
     * @param cow a cow object with full data
     * @return a list of strings representing cow data
     */
    public String[] CowCSVExport(Cow cow) {
        // Initialize array
        String[] metadata = new String[10];

        // Assign Data in correct format
        metadata[0] = cow.getID();
        metadata[1] = cow.getFarmTag();
        if(cow.getDateOfBirth() != null){
        metadata[2] = String.valueOf(cow.getDateOfBirth().getDayOfMonth()) + "/" + String.valueOf(cow.getDateOfBirth().getMonthValue()) + "/" + String.valueOf(cow.getDateOfBirth().getYear());
        }
        else{
            metadata[2] = "";}
        if (cow.getDateOfDeath() != null) {
            metadata[3] = cow.getDateOfDeath().toString();
        }
        else { metadata[3] = ""; }
        metadata[4] = cow.getGenderString();
        metadata[5] = cow.getCategoryString();
        if(cow.getSire() != null) {
            metadata[6] = cow.getSire().getID();
        }
        else{
            metadata[6] = "";
        }
        if (cow.getDam() != null) {
            metadata[7] = cow.getDam().getID();
        }
        else {
            metadata[7] = "";
        }
        metadata[8] = cow.getCurrentWeightString();
        if (cow.getWeightRecords().size() >= 1) {
            String temp = cow.getWeightRecords().get(0).getDate().toString();
            metadata[9] = temp.substring(8) + "/" + temp.substring(5, 7) + "/" + temp.substring(0, 4);
        }
        else {
            metadata[9] = "N/A";
        }

        return metadata;
    }

    /**
     *
     * @param herd
     * @return
     */
    public String[] HerdCSVExport(Herd herd) {
        // Initalize array
        String[] metadata = new String[6];

        // Assign Data in correct format
        metadata[0] = herd.getHerdID();
        metadata[1] = herd.getLocation();
        metadata[2] = herd.getBullExposureDate();
        metadata[3] = herd.getBullEvictionDate();
        if (herd.getBull() != null) {
            metadata[4] = "TRUE";
            metadata[5] = herd.getBull().getID();
        }
        else {
            metadata[4] = "FALSE";
            metadata[5] = null;
        }

        return metadata;
    }

    /**
     *
     * @param weight
     * @return
     */
    public String[] WeightCSVExport(String cowID, Weight weight) {
        // Initalize array
        String[] metadata = new String[3];

        // Assign Data in correct format
        metadata[0] = cowID;
        metadata[1] = weight.getWeight().toString();
        metadata[2] = weight.getDate().toString();

        return metadata;
    }

    /**
     *
     * @param medProc
     * @return
     */
    public String[] MedicalCSVExport(String cowID, MedProc medProc) {
        // Initalize array
        String[] metadata = new String[8];

        // Assign data to array
        metadata[0] = cowID;
        metadata[1] = medProc.getProcedure();
        metadata[2] = medProc.getDate();
        metadata[3] = medProc.getReason();
        metadata[4] = medProc.getProduct();
        metadata[5] = medProc.getDosage();
        metadata[6] = medProc.getRoute();
        metadata[7] = medProc.getNotes();


        return metadata;
    }
}
