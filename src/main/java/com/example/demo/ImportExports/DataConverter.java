package com.example.demo.ImportExports;

import com.example.demo.DataClasses.*;
import com.example.demo.Enums.Category;
import com.example.demo.Enums.Gender;

import java.time.LocalDate;

public class DataConverter {

    /**
     * Constructor
     */
    private static void DateConverter() {}

    /**
     * creates a LocalDate object from String, must have DD/MM/YYYY format.
     * @param s a string in the format of DD/MM/YYYY
     * @return LocalDate object storing the input date
     */
    public static LocalDate createLocalDate(String s) {
        if(s.length() >= 8) {
            try {
                int year = Integer.parseInt(s.substring(6, 10));
                int month = Integer.parseInt(s.substring(3, 5));
                int day = Integer.parseInt(s.substring(0, 2));
                return LocalDate.of(year, month, day);
            } catch (Exception e) {
                System.out.println("Improper Formatted String" + s);
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    /**
     * Converting function
     * @param metadata input is a line of data from the csv
     * @return returns a cow that has been generated from the data
     */
    public static Cow createCow(String[] metadata) {
        // Check validity of arguments
        if (metadata == null) {
            System.out.println("Input parameters are null in createCow(), please fix");
            return null;
        }
//        if (metadata.length != 10) {
//            System.out.println("Incorrect metadata formatting in createCow()");
//            return null;
//        }

        // Initialize date converter
        DataConverter converter = new DataConverter();

        // Splitting up cattle data into specific records
        try {
            String cowID = metadata[0];
            String cowTag = metadata[1];
            LocalDate DoB = createLocalDate(metadata[2]);
            String DoD = metadata[3];
            String gender = metadata[4];
            String category = metadata[5];
            String damID = metadata[6];
            String sireID = metadata[7];
            String weight = metadata[8];
            String strWeightDate = metadata[9];

            Gender cowGender = null;

            if (gender.equals("M") || gender.equals("Male")) {
                cowGender = Gender.MALE;
            }
            if (gender.equals("F") || gender.equals("Female")) {
                cowGender = Gender.FEMALE;
            }

            Category cowCategory = null;
            if (category.equals("Heifer") || category.equals("H")) {
                cowCategory = Category.HEIFER;
            }

            if (category.equals("Bull") || category.equals("B")) {
                cowCategory = Category.BULL;
            }

            if (category.equals("Cow") || category.equals("C")) {
                cowCategory = Category.COW;
            }

            if (category.equals("Steer") || category.equals("S")) {
                cowCategory = Category.STEER;
            }

            // Troubleshooting date stuff
//        System.out.println(strWeightDate.substring(6,9));

            // Construct new cow
            Cow cow = new Cow(cowID, cowTag, DoB, cowCategory, null, null, null, cowGender);

            // Create weight dataclass and storing it

            if (!strWeightDate.equals("N/A")) {
                // creating dataclass for weight Date
                Float cowWeight = Float.parseFloat(weight);
                LocalDate weightDate = createLocalDate(strWeightDate);
                Weight weight1 = new Weight(cowWeight, weightDate);
                cow.addWeightRecord(weight1);
            }

            // Update Date of Death
            LocalDate deathDate;
            if (DoD.length() == 10) {
                deathDate = createLocalDate(DoD);
                cow.setDateOfDeath(deathDate);
            }

            // Reminder that parents are not being stored
            if (cow.getSire() == null || cow.getDam() == null) {
                System.out.println("Please update cowID # " + cow.getID() + "'s Dam and Sire information");
            }
            return cow;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Converting function
     * @param metadata input is a line of data from the csv
     * @return returns a weight that has been generated from the data
     */
    public static Weight createWeight(String[] metadata) {
        // Check validity of arguments
        if (metadata == null) {
            System.out.println("Input parameters are null in createWeight(), please fix");
            return null;
        }
        if (metadata.length != 3) {
            System.out.println("Incorrect metadata formatting in createWeight()");
            return null;
        }

        // Splitting up cattle data into specific records
        try {
            String cowID = metadata[0];
            Float weight = Float.valueOf(metadata[1]);
            LocalDate date = createLocalDate(metadata[2]);

            Weight out = new Weight(weight, date);
            return out;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Herd createHerd(String[] metadata) {
        // Check validity of arguments
        if (metadata == null) {
            System.out.println("Input parameters are null in createHerd(), please fix");
            return null;
        }
        if (metadata.length != 6) {
            System.out.println("Incorrect metadata formatting in createHerd()");
            return null;
        }

        // Initialize date converter
        DataConverter converter = new DataConverter();

        try {
            //splitting herd data into specific records
            String herdID = metadata[0];
            String fieldID = metadata[1];
            LocalDate bullExpo = createLocalDate(metadata[2]);
            LocalDate bullExit = createLocalDate(metadata[3]);
            Boolean bullStatus = false;
            if (metadata[4].equals("TRUE") || metadata[4].equals("True") || metadata[4].equals("true")) {
                bullStatus = true;
            }
            String bullID = metadata[5];

            // Create new Herd from input data
            Field field = new Field(fieldID);
            Herd herd = new Herd(herdID, field);

            herd.setBullExposureDate(bullExpo);
            herd.setBullEvictionDate(bullExit);
            herd.setExposure(bullStatus);

            return herd;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Date conversion method
     * @param metadata imported data to be converted
     * @return medproc object generated from metadata
     */
    public static MedProc createMedProc(String[] metadata) {
        // Check validity of arguments
        if (metadata == null) {
            System.out.println("Input parameters are null in createMedProc(), please fix");
            return null;
        }
        if (metadata.length != 8) {
            System.out.println("Incorrect metadata formatting in createMedProc()");
            return null;
        }
        try {
            // Extract data in format
            String cowID = metadata[0];
            String proc = metadata[1];
            String date = metadata[2];
            String reason = metadata[3];
            String product = metadata[4];
            String dosage = metadata[5];
            String route = metadata[6];
            String notes = metadata[7];

            MedProc mp = new MedProc(proc, date, reason, product, dosage, route, notes);

            return mp;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Main method used for testing
     * @param args default parameter
     */
    public static void main(String[] args) {
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("\n---------------------------------------------------------\n" +
                "Testing createLocalDate() \n --------------------------------------------------------");

        // Testing createLocaleDate()
        // Unit Testing
        // Test Case 1
        String testItem = "createLocaleDate() method";
        String reason = "Verify correctness of createLocaleDate() method";
        String testDate1 = "28/01/1999";

        // Expected
        LocalDate expectedDate = LocalDate.of(1999, 01, 28);

        // Run method
        LocalDate result = createLocalDate(testDate1);

        // Check result against expected
        if (!expectedDate.toString().equals(result.toString())) {
            System.out.println("Error in " + testItem + " expected " + expectedDate + " but obtained " +
                    result + " -- Testing Reason: " + reason);
        }

        // Testing createLocalDate()
        // Unit Testing
        // Test Case 2
        testItem = "createLocaleDate() method";
        reason = "Verify the try/catch body for invalid arguments";
        testDate1 = "Today's date";

        // Expected
        // Exception thrown

        // Run Method
        // Try to catch exception being thrown to verify bad data is caught
        try {
            LocalDate invalid = createLocalDate(testDate1);
        } catch (RuntimeException e) {
            System.out.println("Try/Catch for createLocalDate() works");
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        /////////// Test Suite by Arthur Fritzke    Date: November 19th, 2022   //////////////////////////////////////////
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        System.out.println("\n---------------------------------------------------------\n" +
                "Testing createCow() method " + "\n---------------------------------------------------------");

        // Testing createCow()
        // Unit Testing
        // Test Case 1
        testItem = "createCow() method";
        reason = "Verify correctness of createCow() method";

        // Expected
        Cow expectedCow = new Cow("4564321", "47E",
                LocalDate.of(2020, 1, 28), Category.COW, null, null, null,
                Gender.FEMALE);

        // Run method
        String[] test = {"4564321", "47E", "28/01/2020", "null", "F", "Cow", "null", "null", "715.8", "28/06/2022"};
        Cow result1 = createCow(test);

        // Check results against expected
        if (!expectedCow.getID().equals(result1.getID())) {
            System.out.println("Error in " + testItem + " expected " + expectedCow.getID() + " but obtained " +
                    result1.getID() + " -- Testing Reason: " + reason);
        }

        if (!expectedCow.getFarmTag().equals(result1.getFarmTag())) {
            System.out.println("Error in " + testItem + " expected " + expectedCow.getFarmTag() + " but obtained " +
                    result1.getFarmTag() + " -- Testing Reason: " + reason);
        }

        if (!expectedCow.getGender().equals(result1.getGender())) {
            System.out.println("Error in " + testItem + " expected " + expectedCow.getGender() + " but obtained " +
                    result1.getGender() + " -- Testing Reason: " + reason);
        }

        if (!expectedCow.getCategory().equals(result1.getCategory())) {
            System.out.println("Error in " + testItem + " expected " + expectedCow.getCategory() + " but obtained " +
                    result1.getCategory() + " -- Testing Reason: " + reason);
        }

        if (expectedCow.getAge() != result1.getAge()) {
            System.out.println("Error in " + testItem + " expected " + expectedCow.getAge() + " but obtained " +
                    result1.getAge() + " -- Testing Reason: " + reason);
        }

        // Testing createCow()
        // Unit Testing
        // Test Case 2
        reason = "Verify the null check is working";

        // Expected
        // null value to be passed as well as console output

        // Run test method
        Cow nullCheck = createCow(null);

        if (nullCheck != null) {
            System.out.println("Error in " + testItem + " expected null but obtained " + nullCheck + " -- Testing Reason: " + reason);
        }

        // Testing createCow()
        // Unit Testing
        // Test Case 3
        reason = "Verify we check if we have large enough metadata list. Basically checking for bad data inputs";

        // Expected
        // null value to be passed as well as console output

        // Run test method
        String[] shortData = {"4564321", "47E", "28/01/2020", "null", "F"};
        nullCheck = createCow(shortData);

        if (nullCheck != null) {
            System.out.println("Error in " + testItem + " expected null but obtained " + nullCheck + " -- Testing Reason: " + reason);
        }

        // Testing createCow()
        // Unit Testing
        // Test Case 4
        reason = "Verify index out of range error is avoided, basically trying to check for bad input data";

        // Expected
        // null value to be passed as well as console output

        // Run test method
        String[] longData = {"4564321", "47E", "28/01/2020", "null", "F", "4564321", "47E", "28/01/2020", "null", "F", "4564321", "47E", "28/01/2020", "null", "F"};
        nullCheck = createCow(longData);

        if (nullCheck != null) {
            System.out.println("Error in " + testItem + " expected null but obtained " + nullCheck + " -- Testing Reason: " + reason);
        }

        // Testing createCow()
        // Unit Testing
        // Test Case 5
        reason = "Verify try catch statement is working";

        // Expected
        // Runtime Error, will catch

        // Run test method
        String[] fakeData = {"4564321", "47E", "Today", "null", "X", "Goat", "null", "null", "seven-hundred", "break system"};

        try {
            Cow fake = createCow(fakeData);
            System.out.println("Error in " + testItem + " expected exception but obtained a real cow -- Testing Reason: " + reason);
        } catch (RuntimeException e) {
            System.out.println("Try/Catch for createCow() works");
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("\n---------------------------------------------------------\n" +
                "Testing createWeight() \n --------------------------------------------------------");
        // Testing createWeight()
        // Unit Testing
        // Test Case 1
        testItem = "createWeight() method";
        reason = "Verify correctness of createWeight() method";

        // Expected
        Weight expectedWeight = new Weight(783.5F, LocalDate.of(2020, 6, 28));

        // Run method
        String[] testWeight = {"54332", "783.5", "28/06/2020"};
        Weight result2 = createWeight(testWeight);

        // Check results against expected
        if (!result2.getWeight().equals(expectedWeight.getWeight())) {
            System.out.println("Error in " + testItem + " expected " + expectedWeight.getWeight() + " but obtained " +
                    result2.getWeight() + " -- Testing Reason: " + reason);
        }

        if (!result2.getDate().toString().equals(expectedWeight.getDate().toString())) {
            System.out.println("Error in " + testItem + " expected " + expectedWeight.getDate().toString() + " but obtained " +
                    result2.getDate().toString() + " -- Testing Reason: " + reason);
        }

        // Testing createWeight()
        // Unit Testing
        // Test Case 2
        reason = "Verify the null check is working";

        // Expected
        // null value to be passed as well as console output

        // Run test method
        Weight nullWeight = createWeight(null);

        if (nullWeight != null) {
            System.out.println("Error in " + testItem + " expected null but obtained " + nullCheck + " -- Testing Reason: " + reason);
        }

        // Testing createWeight()
        // Unit Testing
        // Test Case 3
        reason = "Verify we check if we have large enough metadata list. Basically checking for bad data inputs";

        // Expected
        // null value to be passed as well as console output

        // Run test method
        String[] shortWeight = {"4564321", "47E"};
        nullWeight = createWeight(shortWeight);

        if (nullWeight != null) {
            System.out.println("Error in " + testItem + " expected null but obtained " + nullCheck + " -- Testing Reason: " + reason);
        }

        // Testing createWeight()
        // Unit Testing
        // Test Case 4
        reason = "Verify index out of range error is avoided, basically trying to check for bad input data";

        // Expected
        // null value to be passed as well as console output

        // Run test method
        String[] longWeight = {"4564321", "47E", "28/01/2020", "null", "F", "4564321", "47E", "28/01/2020", "null"};
        nullWeight = createWeight(longWeight);

        if (nullWeight != null) {
            System.out.println("Error in " + testItem + " expected null but obtained " + nullCheck + " -- Testing Reason: " + reason);
        }

        // Testing createWeight()
        // Unit Testing
        // Test Case 5
        reason = "Verify try/catch for invalid data";

        // Expected
        // Will Catch Runtime error

        // Run Method
        String[] invalidWeight = {"break", "stupid", "method"};

        try {
            Weight fake = createWeight(invalidWeight);
            System.out.println("Error in " + testItem + " expected exception but obtained a real cow -- Testing Reason: " + reason);
        } catch (RuntimeException e) {
            System.out.println("Try/Catch for createWeight() works");
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("\n---------------------------------------------------------\n" +
                "Testing createHerd() \n --------------------------------------------------------");
        // Testing createHerd()
        // Unit Testing
        // Test Case 1
        testItem = "createHerd() method";
        reason = "Verify correctness of createHerd() method";

        // Expected
        Field inField = new Field("Field 1");
        Herd expectedHerd = new Herd("4351", inField);
        expectedHerd.setExposure(true);
        expectedHerd.setBullExposureDate(LocalDate.of(2022, 6, 5));
        expectedHerd.setBullEvictionDate(LocalDate.of(2022, 7, 31));

        // Run method
        String[] testHerd = {"4351", "Field 1", "05/06/2022", "31/07/2022", "TRUE", "54564"};
        Herd result3 = createHerd(testHerd);

        // Check results against expected
        if (!result3.getHerdID().equals(expectedHerd.getHerdID())) {
            System.out.println("Error in " + testItem + " expected " + expectedHerd.getHerdID() + " but obtained " +
                    result3.getHerdID() + " -- Testing Reason: " + reason);
        }

        if (!result3.getLocation().equals(expectedHerd.getLocation())) {
            System.out.println("Error in " + testItem + " expected " + expectedHerd.getHerdID() + " but obtained " +
                    result3.getHerdID() + " -- Testing Reason: " + reason);
        }

        if (!result3.getBullExposureDate().equals(expectedHerd.getBullExposureDate())) {
            System.out.println("Error in " + testItem + " expected " + expectedHerd.getBullExposureDate() + " but obtained " +
                    result3.getBullExposureDate() + " -- Testing Reason: " + reason);
        }

        if (!result3.getBullEvictionDate().equals(expectedHerd.getBullEvictionDate())) {
            System.out.println("Error in " + testItem + " expected " + expectedHerd.getBullEvictionDate() +
                    " but obtained " + result3.getBullEvictionDate() + " -- " + reason);
        }

        if (result3.getExposure() != expectedHerd.getExposure()) {
            System.out.println("Error in " + testItem + " expected " + expectedHerd.getExposure().toString() + " but obtained " +
                    result3.getExposure().toString() + " -- " + reason);
        }

        // Testing createHerd()
        // Unit Testing
        // Test Case 2
        reason = "Verify the null check is working";

        // Expected
        // null value to be passed as well as console output

        // Run test method
        Herd nullHerd = createHerd(null);

        if (nullHerd != null) {
            System.out.println("Error in " + testItem + " expected null but obtained " + nullCheck + " -- Testing Reason: " + reason);
        }

        // Testing createHerd()
        // Unit Testing
        // Test Case 3
        reason = "Verify we check if we have large enough metadata list. Basically checking for bad data inputs";

        // Expected
        // null value to be passed as well as console output

        // Run test method
        String[] shortHerd = {"4564321", "47E"};
        nullHerd = createHerd(shortHerd);

        if (nullCheck != null) {
            System.out.println("Error in " + testItem + " expected null but obtained " + nullCheck + " -- Testing Reason: " + reason);
        }

        // Testing createHerd()
        // Unit Testing
        // Test Case 4
        reason = "Verify index out of range error is avoided, basically trying to check for bad input data";

        // Expected
        // null value to be passed as well as console output

        // Run test method
        String[] longHerd = {"4564321", "47E", "28/01/2020", "null", "F", "4564321", "47E", "28/01/2020", "null"};
        nullHerd = createHerd(longHerd);

        if (nullCheck != null) {
            System.out.println("Error in " + testItem + " expected null but obtained " + nullCheck + " -- Testing Reason: " + reason);
        }

        // Testing createWeight()
        // Unit Testing
        // Test Case 5
        reason = "Verify try/catch for invalid data";

        // Expected
        // Will Catch Runtime error

        // Run Method
        String[] invalidHerd = {"break", "the", "method", "into", "many", "pieces"};

        try {
            Herd fakeHerd = createHerd(invalidHerd);
            System.out.println("Error in " + testItem + " expected exception but obtained a real herd -- Testing Reason: " + reason);
        } catch (RuntimeException e) {
            System.out.println("Try/Catch for createWeight() works");
        }

        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        System.out.println("\n---------------------------------------------------------\n" +
                "Testing createMedProc() \n --------------------------------------------------------\n");
        // Testing createMedProc()
        // Unit Testing
        // Test Case 1
        testItem = "createMedProc() method";
        reason = "Verify correctness of createMedProc() method";

        // Expected
        MedProc expectedMP = new MedProc("Vaccination", "14/11/2022", "Unvaccinated", "Modern",
                "500mg", "Intramuscular", "Went well");

        // Run method
        String[] testMP = {"4325", "Vaccination", "14/11/2022", "Unvaccinated", "Modern",
                "500mg", "Intramuscular", "Went well"};
        MedProc result4 = createMedProc(testMP);

        // Check results against expected
        if (!result4.getProcedure().equals(expectedMP.getProcedure())) {
            System.out.println();
        }

        // Testing createHerd()
        // Unit Testing
        // Test Case 2
        reason = "Verify the null check is working";

        // Expected
        // null value to be passed as well as console output

        // Run test method
        MedProc nullMP = createMedProc(null);

        if (nullMP != null) {
            System.out.println("Error in " + testItem + " expected null but obtained " + nullCheck + " -- Testing Reason: " + reason);
        }

        // Testing createHerd()
        // Unit Testing
        // Test Case 3
        reason = "Verify we check if we have large enough metadata list. Basically checking for bad data inputs";

        // Expected
        // null value to be passed as well as console output

        // Run test method
        String[] shortMP = {"4564321", "47E"};
        nullMP = createMedProc(shortHerd);

        if (nullMP != null) {
            System.out.println("Error in " + testItem + " expected null but obtained " + nullCheck + " -- Testing Reason: " + reason);
        }

        // Testing createHerd()
        // Unit Testing
        // Test Case 4
        reason = "Verify index out of range error is avoided, basically trying to check for bad input data";

        // Expected
        // null value to be passed as well as console output

        // Run test method
        String[] longMP= {"4564321", "47E", "28/01/2020", "null", "F", "4564321", "47E", "28/01/2020", "null","4564321", "47E", "28/01/2020", "null", "F", "4564321"};
        nullMP = createMedProc(longMP);

        if (nullMP != null) {
            System.out.println("Error in " + testItem + " expected null but obtained " + nullMP + " -- Testing Reason: " + reason);
        }
    }
}

