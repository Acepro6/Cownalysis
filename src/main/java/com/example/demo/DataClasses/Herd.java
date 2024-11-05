// CMPT270 T27 Herd class
package com.example.demo.DataClasses;

import com.example.demo.Enums.Category;
import com.example.demo.Enums.Gender;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Herd
{


    // Attributes for Herd objects
    private String herdID;
    private ArrayList<Cow> cows;
    private Field location;
    private Boolean bullExposure;
    private LocalDate bullExposureDate;
    private LocalDate bullEvictionDate;
    private Cow bull;
    
    /** Constructor for Herd objects
     * 
     * @param field: the field the herd is in
     */
    public Herd (String ID, Field field)
    {
        this.herdID = ID;
        this.location = field;
        this.bullExposure = false;
        this.cows = new ArrayList<>();
    }

    public Herd(Field onlyField) {
        this.cows = new ArrayList<>();
    }

    /** Mutator: add a cow to the cows ArrayList
     * 
     * @param newCow: the cow to add to the cows ArrayList
     */
    public void addCow(Cow newCow)
    {
        cows.add(newCow);
    }

    /** Mutator: remove a cow from the cows ArrayList
     * 
     * @param ID: the ID of the cow to remove
     */
    public void removeCow(String ID)
    {
        if(this.cowCount() > 0) {
            for (int i=0; i<this.cowCount(); i++) //iterate through cows
            {   Cow c = this.cows.get(i);
                if (c != null && c.getID() != null && c.getID().contains(ID)) // if the id is not null and the id contains ID
                {
                    this.cows.remove(c); // remove the object
                }
            }
        }
    }

    /**
     *
     * @return - the number of cows at the farm
     */
    public int cowCount(){
        return this.cows.size();
    }


    /**
     * Accessor
     * @return String value of
     */
    public String getHerdID() {
        return herdID;
    }

    /**
     * Mutator
     * @param herdID String value requested to reset the herd name to
     */
    public void setHerdID(String herdID) {
        this.herdID = herdID;
    }
    /** Accessor: check if a specific cow is there
     * 
     * @param ID: the id of the cow
     * @return true if the cow is in the herd, false otherwise
     */
    public Boolean isCow(String ID)
    {
        for(Cow c: cows) // iterate through cows
        {
            if (c.getID() != null && c.getID().contains(ID)) // return true if the id is in the Arraylist cows
            {
                return true;
            }
        }

        return false; // otherwise retrun false
    }

    /** Accessor: get location
     * 
     * @return the location of the herd
     */
    public String getLocation()
    {
        return location.getName();
    }

    /** Mutator: update/ set a location
     * 
     * @param newLocation: the location or new location of the herd
     */
    public void setLocation(Field newLocation)
    {
        location = newLocation;
    }

    /** Accessor: get the bull exposure date
     * 
     * @return the date the bull was exposed (lol) to the herd dd/mm/yyyy
     */
    public String getBullExposureDate()
    {
        return bullExposureDate.toString();
    }

    /** Mutator: set the bull exposure date
     *
     * @param newDate: the new or set date the bull was exposed to the cows
     */
    public void setBullExposureDate(LocalDate newDate)
    {
        this.bullExposureDate = newDate;
    }

    /** Accessor: get the bull eviction date
     * 
     * @return the date the bull was removed from the herd dd/mm/yyyy
     */
    public String getBullEvictionDate()
    {
        return bullEvictionDate.toString();
    }

    /** Mutator: set/update the bull's eviction date
     * 
     * @param newDate: the date the bull was removed from the herd dd/mm/yyyy
     */
    public void setBullEvictionDate(LocalDate newDate)
    {
        bullEvictionDate = newDate;
    }

    /** Accessor: get the lenght of time in days the bull was exposed to the herd
     * 
     * @return the lenght of time in days the bull was exposed to the herd
     */
    public String getExposureLength() // not sure if this guy will work
    {
        // date and time
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // pass eviction and exposure to LocalDate
//        LocalDate date1 = LocalDate.parse(bullExposureDate, dtf);
//        LocalDate date2 = LocalDate.parse(bullEvictionDate, dtf);

        // get the number of days between two dates
        Duration daysBetween = Duration.between(bullExposureDate, bullEvictionDate);
        
        // retrun number of days as a string
        return daysBetween.toString();
    }

    /** Accessor: get the bull in the field
     * 
     * @return the bull in the field
     */
    public Cow getBull()
    {
        return bull;
    }

    /** Mutator: set the bull
     * 
     * @param newBull the bull you want in the field
     */
    public void setBull(Cow newBull)
    {
        bull = newBull;
    }

    /** Accessor: check if there has been exposure
     * 
     * @return true if there was exposure false otherwise
     */
    public Boolean getExposure()
    {
        return bullExposure;
    }

    /** Mutator: change the exposure status
     * 
     * @param setExposure the exposure variable true if exposure false otherwise
     */
    public void setExposure(Boolean setExposure)
    {
        bullExposure = setExposure;
    }

    public ArrayList<Cow> getCows() {
        return cows;
    }

    public static void test_herd(){
            
        Field testField = new Field("Test Field For Herd");
        Herd testHerd = new Herd(testField);


        

        //Making Test Cow:
        String ID = "1234";
        String farmTag = "5678";
        LocalDate DOB = LocalDate.of(2018, 1, 1);

        Cow testCow1 = new Cow(ID, farmTag, DOB, Category.COW, null, null, null, Gender.FEMALE);


        //Adding a cow:
        //testHerd.addCow(testCow1);

        //Test count again

        if(testHerd.cowCount() != 1){
            System.out.println("Cow count is incorrect when calling cowCount()" +
                    "- should be 1,  got " + testHerd.cowCount());
        }

        //Check if a fake and a real cow exist:

        //Fake
        if(testHerd.isCow("9876")){
            System.out.println("isCow is incorrect, should be" +
                    "false ");
        }

        if(!testHerd.isCow("1234")){
            System.out.println("isCow is incorrect, should be" +
                    "true");
        }

        //Now we remove the cow and see:
        testHerd.removeCow("1234");

        if(testHerd.cowCount() != 0){
            System.out.println("Cow count is incorrect when calling cowCount()" +
                    "on after removing the only cow - got " + testHerd.cowCount());
        }

        System.out.println("Herd tests completed\n");


    }


    public static void main(String[] args){

        //Herd testHerd = new Herd()

        Herd.test_herd();

    }

}
