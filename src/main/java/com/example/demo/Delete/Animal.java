/*
 * CMPT270 T27 Animal Class
 */
package com.example.demo.Delete;

 import com.example.demo.DataClasses.MedProc;

 import java.util.ArrayList;

 public class Animal
 {
    // Attributes for Animal objects
    private String ID;
    private String birthdate; // TODO; this is dangerous. We should either use a Date property to make our own
    private ArrayList<MedProc> medicalRecords = new ArrayList<MedProc>();
    private String sex; // TODO safer as an enum, not a string
    private Boolean aliveStatus = true;

    /** Constructor for Animal object
     * 
     * @param ID: The animal's identification number or string
     * @param birthdate: The animal's date of birth dd/mm/yyyy
     * @param sex: The animal's sex
     * 
     */
    public Animal (String ID, String birthdate, String sex)
    {
        this.ID = ID;
        this.birthdate = birthdate;
        this.sex = sex;
        this.aliveStatus = true;
    }

     @Override
     public String toString() {
         return "ID: " + ID;
     }

     /** Accessor: animal's ID
     * 
     * @return the animal's ID
     */
    public String getID()
    {
        return ID;
    }

    /** Accessor: animal's birthdate dd/mm/yyyy
     * 
     * @return the animal's birthdate dd/mm/yyyy
     */
    public String getBirthdate()
    {
        return birthdate;
    }

    /** Accessor: animal's sex
     * 
     * @return the animal's sex
     */
    public String getSex()
    {
        return sex;
    }

    /** Mutator: alive status
     * 
     * @return the animal's alive status
     */
    public Boolean getAliveStatus()
    {
        return aliveStatus;
    }

    /** Mutator: animal's aliveStatus
     * 
     * @param newStatus: the animal's new aliveStatus: false for dead, true for alive
     */
    public void updateAliveStatus(Boolean newStatus)
    {
        aliveStatus = newStatus;
    }

    // Should we add a toString() in Animal or just in Cow?
    // Add getters and setters for medical records lol!
    // should we put in an addRecord, editRecord, removeRecord, searchRecord method?
     public ArrayList<MedProc> getRecords()
     {
        return medicalRecords;
     }

     // Main method for testing/debugging
     public static void main(String[] args) {
        Animal testCase1 = new Animal("206213", "04-10-2021", "M");

        // Checking constructor and basic functionality
        // testing getID() method for basic functionality
        if (testCase1.getID() != "206213") {
            System.out.println("ID incorrect, error in constructor or getID() method");
        }

        // testing getBirthdate() for basic functionality
        if (testCase1.getBirthdate() != "04-10-2021") {
            System.out.println("Birthdate incorrect, error in constructor or getBirthDate() method");
        }

        // testing getSex() for basic functionality
        if (testCase1.getSex() != "M") {
            System.out.println("Sex is incorrect, error in constructor or getSex() method");
        }

        // testing getAliveStatus()
        if (testCase1.getAliveStatus() != true) {
            System.out.println("Error, alive status is wrong, check constructor/attributes");
        }

        // testing updateAliveStatus()
        testCase1.updateAliveStatus(false);
        if (testCase1.getAliveStatus() != false) {
            System.out.println("Error, alive status is wrong, check constructor/attributes");
        }
     }
 }