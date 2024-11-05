// CMPT270 T27 Field class
package com.example.demo.DataClasses;

import java.util.ArrayList;

public class Field
{
    // Attributes for Field object
    private String name;
    private ArrayList<FieldData> fieldRecords = new ArrayList<FieldData>();

    /** Constructor for Field object
     * 
     * @param name: the name of the field
     */
    public Field (String name)
    {
        this.name = name;
    }

    /** Accessor: get the name of the field
     * 
     * @return the name of the field
     */
    public String getName()
    {
        return this.name;
    }

    /** Mutator: set the name of the field
     * 
     * @param newName: the new name of the field
     */
    public void setName(String newName)
    {
        this.name = newName;
    }

    public ArrayList<FieldData> getFieldRecords() {
        return this.fieldRecords;
    }

    public void setFieldRecords(ArrayList<FieldData> fieldRecords) {
        this.fieldRecords = fieldRecords;
    }

    public static void test_field(){
        Field testField = new Field("Test Field");

        if(!testField.getName().equals("Test Field")){
            System.out.println("getName failed on Field, " +
                    "got" + testField.getName());
        }

        //Now we test the set:
        testField.setName("New Test Field");
        if(!testField.getName().equals("New Test Field")){
            System.out.println("setName failed on Field, " +
                    "got" + testField.getName());
        }

        ArrayList<FieldData> testFieldRecords = new ArrayList<>();

        testField.setFieldRecords(testFieldRecords);

        if(!testField.getFieldRecords().equals(testFieldRecords)){
            System.out.println("setFieldRecords failed on Field");
        }


        System.out.println("Tests for Field done\n");
    }


// Main method for testing/debugging
    public static void main(String[] args) {






//        Field testField = new Field("SW34", "Empty", "Grazing");
//
//        // Testing getName() for basic functionality
//        if (testField.getName() != "SW34") {
//            System.out.println("Incorrect field name, error in getName() method or constructor.");
//        }
//
//        // Testing setName() for basic functionality
//        testField.setName("NE31");
//        if (testField.getName() != "NE31") {
//            System.out.println("Incorrect field name, error in setName() method.");
//        }
//
//        // Testing getTurnoutDate() for basic functionality
//        if (testField.getTurnoutDate() != "Empty") {
//            System.out.printf("Incorrect turnout date, error in getTurnoutDate() method or constructor.");
//        }
//
//        // Testing setTurnoutDate() for basic functionality
//        Date test1 = new Date(5,10,2022);
//        testField.setTurnoutDate(test1);
//        if (testField.getTurnoutDate() != "05-10-2022") {
//            System.out.printf("Incorrect turnout date, error in setTurnoutDate() method.");
        }

  }


