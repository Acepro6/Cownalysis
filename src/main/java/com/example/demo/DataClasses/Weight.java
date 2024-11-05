/*
 * CMPT270 T27 Weight class
 */
package com.example.demo.DataClasses;

import java.time.LocalDate;

public class Weight
 {
    // Attributes for Weight object
    private Float weight;
    private LocalDate date;

    /** Constructor for Weight object
     * 
     * @param weight: The weight of the animal
     * @param date: The date the weight was collected dd/mm/yyyy
     */
    public Weight (Float weight, LocalDate date)
    {
        this.weight = weight;
        this.date = date;
    }

    /** Accessor: the weight
     * 
     * @return the weight
     */
    public Float getWeight()
    {
        return weight;
    }

    /** Accessor: the date the weight was collected dd/mm/yyyy 
     * 
     * @return the date the weight was collected dd/mm/yyyy
    */
    public LocalDate getDate()
    {
        return this.date;
    }


    public static void test_Weight(){
        // Testing basic functionality
        LocalDate testDate = LocalDate.of(2022, 1, 1);
        Weight testCase = new Weight(67.34f, testDate);

        if (testCase.getWeight() != 67.34f) {
            System.out.println("Weight is incorrect, something went wrong in constructor or getWeight() method");
        }

        if (!testCase.getDate().equals(testDate)) {
            System.out.println("Weight date is incorret, check constructor or getDate() method");
        }

        // Test a zero value for weight
        LocalDate testDate2 = LocalDate.of(2022, 4, 5);
        Weight testCase1 = new Weight(0f, testDate2);

        if (testCase1.getWeight() != 0) {
            System.out.println("Weight is incorrect, check constructor or getWeight() method");
        }

        if (!testCase1.getDate().equals(testDate2)) {
            System.out.println("Weight date is incorrect, check constructor or getDate() method");
        }


        System.out.println("Weight test cases done\n");
    }

     @Override
     public String toString() {
         return date.toString() + ":   " + weight;
     }

     // Main method for testing/debugging
   public static void main(String[] args) {

     }

 }
