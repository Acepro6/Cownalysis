package com.example.demo.FilterClasses;

import com.example.demo.DataClasses.Cow;

public class IndividualCowFilter implements CowFilter{
    private String ID;

    public IndividualCowFilter(String ID) {
        this.ID = ID;
    }

    @Override
    public boolean meetsCriteria(Cow cow) {
        if (cow.getID().equals(this.ID)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "ID =" + ID;
    }

    public static void main(String[] args) {
        // Test Suite
        IndividualCowFilter filter1 = new IndividualCowFilter("1938485");

        boolean allPassed = true;
//        if (filter1.meetsCriteria("1938485") == false) {
//            System.out.println("Test 1 failed");
//            allPassed = false;
//        }
//
//        if (filter1.meetsCriteria("49484") == true) {
//            System.out.println("Test 2 failed");
//            allPassed = false;
//        }
//        if (allPassed) {
//            System.out.println("All tests passed");
//        }

    }
}
