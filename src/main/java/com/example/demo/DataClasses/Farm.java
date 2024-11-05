// CMPT370 T27 Farm Class
package com.example.demo.DataClasses;

import com.example.demo.DataClasses.Cow;
import com.example.demo.Enums.Category;
import com.example.demo.Enums.Gender;

import java.time.LocalDate;
import java.util.ArrayList;

public class Farm
{
    // Attributes for Farm object
    private String farmName;
    private ArrayList<Cow> cows = new ArrayList<Cow>();

    /** Constructor for Farm object
     * 
     * @param name: the farm's name
     */
    public Farm(String name)
    {
        this.farmName = name;
    }

    /** Accessor: farm's name
     * 
     * @return the farms name
     */
    public String getFarmName()
    {
        return farmName;
    }

    /** Mutator: change the farms name
     * 
     * @param newName: the farms new name
     */
    public void setName(String newName)
    {
        farmName = newName;
    }

    /** Add a cow to the ArrayList cows
     * 
     * @param cow: the cow to add to the ArrayList
     */
    public void addCow(Cow cow)
    {
        cows.add(cow);
    }

    /** Search for a cow by the cow's ID
     * DO WE EVEN USE THIS?
     * @param ID: the string representation of the cow's ID
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

    /** Check if a specific cow is there
     * 
     * @param ID: the id of the cow
     * @return true if the cow is in the herd, false otherwise
     */
    public Boolean isCow(String ID)
    {
        if(this.cowCount() > 0) {
            for (Cow c : cows) // iterate through cows
            {
                if (c.getID() != null && c.getID().contains(ID)) // return true if the id is in the Arraylist cows
                {
                    return true;
                }
            }
        }

        return false; // otherwise return false
    }

    /**
     *
     * @return - the number of cows at the farm
     */
    public int cowCount(){
        return this.cows.size();
    }

    public static void test_farm(){

        Farm testFarm = new Farm("Test Farm 1");

        //Test getters and setters
        if(!testFarm.getFarmName().equals("Test Farm 1")){
            System.out.println("Name is incorrect for testFarm calling " +
                    "getFarmName() - got " + testFarm.getFarmName());
        }

        testFarm.setName("NewName Test");


        if(!testFarm.getFarmName().equals("NewName Test")){
            System.out.println("Name is incorrect for testFarm calling " +
                    "getFarmName() after setName() - got " + testFarm.getFarmName());
        }

        //Test the cow count before adding:

        if(testFarm.cowCount() != 0){
            System.out.println("Cow count is incorrect when calling cowCount()" +
                    "on an empty farm - got " + testFarm.cowCount());
        }

        //Making Test Cow:
        String ID = "1234";
        String farmTag = "5678";
        LocalDate DOB = LocalDate.of(2018, 1, 1);

        Cow testCow1 = new Cow(ID, farmTag, DOB, Category.COW, null, null, null, Gender.FEMALE);


        //Adding a cow:
        testFarm.addCow(testCow1);

        //Test count again

        if(testFarm.cowCount() != 1){
            System.out.println("Cow count is incorrect when calling cowCount()" +
                    "- should be 1,  got " + testFarm.cowCount());
        }

        //Check if a fake and a real cow exist:

        //Fake
        if(testFarm.isCow("9876")){
            System.out.println("isCow is incorrect, should be" +
                    "false ");
        }

        if(!testFarm.isCow("1234")){
            System.out.println("isCow is incorrect, should be" +
                    "true");
        }

        //Now we remove the cow and see:
        testFarm.removeCow("1234");

        if(testFarm.cowCount() != 0){
            System.out.println("Cow count is incorrect when calling cowCount()" +
                    "on after removing the only cow - got " + testFarm.cowCount());
        }

        //Try and remove it again when the farm is empty.
        // The method should just do nothing, so basically we are testing
        // for random exceptions here:

        testFarm.removeCow("1234");



        System.out.println("Testing for Farm class complete\n");

    }



    public static void main(String[] args){
        Farm.test_farm();
    }

}
