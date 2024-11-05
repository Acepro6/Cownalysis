package com.example.demo.ImportExports;

import com.example.demo.DataClasses.Cow;
import com.example.demo.DataClasses.Weight;
import com.example.demo.Enums.Category;
import com.example.demo.Enums.Gender;
import javafx.util.converter.LocalDateStringConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CowCSVImporter {

    /**
     * CSV Reader
     * @param fileName String of a file PATH
     * @return returns a list of cows
     *
     */
    public static ArrayList<Cow> readCowsFromCSV(String fileName) {
        DataConverter converter = new DataConverter();
        ArrayList<Cow> cows = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
            String header = br.readLine();
            header.split(",");

            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split(",");
                Cow cow = converter.createCow(attributes);
                cows.add(cow);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return cows;
    }

    // Main function used for testing and examining console output only
    public static void main(String[] args) {
        // Hardcoded test cases, for troubleshooting during
 //       List<Cow> Cows = readCowsFromCSV("C:\\My Projects\\team-27-project-cmpt-370\\Example Cow.csv");
 //       for (Cow c : Cows) {
 //           System.out.println("\nID #: " + c.getID());
 //           System.out.println("CowTag: " + c.getFarmTag());
 //           System.out.println("DoB: " + c.getDateOfBirth().toString());
 //           System.out.println("Age: " + c.getAge());
 //           System.out.println("Category: " + c.getCategoryString());
 //           System.out.println("Weight: " + c.getCurrentWeightString());
 //       }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// test CowCSVImporter.readCowsFromCSV()
// We can't test readCowsFromCSV() directly, so we check the data itself that it returns
// these are integration tests because we are checking data correctness from

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // Test 1 -- Test for Regular formatted CSV correctness
        String testItem = "readCowsFromCSV(), Cow dataclass, and DataConverter.createCow()";
        String pathName = "C:\\My Projects\\team-27-project-cmpt-370\\Example Cow.csv";

    // call the operation
        ArrayList<Cow> cowData = readCowsFromCSV(pathName);

    // Expected outputs
        Cow cow1 = new Cow("4564321", "47E", LocalDate.of(2020, 1, 28), Category.COW, null, null, null, Gender.FEMALE);
        Cow cow2 = new Cow("3214321", "18C", LocalDate.of(2020, 6, 30), Category.COW, null, null, null, Gender.FEMALE);
        Cow cow3 = new Cow("1234567", "32XC", LocalDate.of(2020, 12, 1), Category.COW, null, null, null, Gender.FEMALE);

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // Check Data against expected output
        // Check Example Cow 1 data
        String reason = "Verify Cow data from input is matching expected data";
        testClass(testItem, cowData.get(0), cow1, reason);
        testClass(testItem, cowData.get(1), cow2, reason);
        testClass(testItem, cowData.get(2), cow3, reason);

        reason = "Test for empty csv imports";
        pathName = "C:\\My Projects\\team-27-project-cmpt-370\\EmptyCSV.csv";
        try {
            ArrayList<Cow> cowData1 = readCowsFromCSV(pathName);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }


        System.out.println("\nTesting completed");
    }

    /**
     * For Testing Specific Data
     * @param test  Test Description
     * @param resultCow Cow obtained from Method
     * @param expectCow Cow obtained from Expected output
     * @param reason Why this test
     */
    private static void testClass(String test, Cow resultCow, Cow expectCow, String reason) {
        // Verify ID
        if (!resultCow.getID().equals(expectCow.getID())) {
            System.out.println("Error in " + test + " expected " + expectCow.getID() + " but obtained " +
                    resultCow.getID() + " -- " + reason);
        }

        // Verify DoB
        if (resultCow.getAge() != expectCow.getAge()) {
            System.out.println("Error in " + test + " expected " + expectCow.getAge() + " but obtained " +
                    resultCow.getAge() + " -- " + reason);
        }

        // Verify Dam
        // null check
        if (resultCow.getDam() != null) {
            if (!resultCow.getDam().equals(expectCow.getDam())) {
                System.out.println("Error in " + test + " expected " + expectCow.getDam() + " but obtained " +
                        resultCow.getDam() + " -- " + reason);
            }
        }

        // Verify Sire
        // null check
        if (resultCow.getSire() != null) {
            if (!resultCow.getSire().equals(expectCow.getSire())) {
            System.out.println("Error in " + test + " expected " + expectCow.getSire() + " but obtained " +
                    resultCow.getSire() + " -- " + reason);
            }
        }

        // Verify Herd
        // null check
        if (resultCow.getHerd() != null) {
            if (!resultCow.getHerd().equals(expectCow.getHerd())) {
                System.out.println("Error in " + test + " expected " + expectCow.getHerd() + " but obtained " +
                    resultCow.getHerd() + " -- " + reason);
            }
        }

        // Verify Gender
        if (!resultCow.getGender().equals(expectCow.getGender())) {
            System.out.println("Error in " + test + " expected " + expectCow.getGender() + " but obtained " +
                    resultCow.getGender() + " -- " + reason);
        }

        //Verify Category
        if (!resultCow.getCategory().equals(expectCow.getCategory())) {
            System.out.println("Error in " + test + " expected " + expectCow.getCategory() + " but obtained " +
                    resultCow.getCategory() + " -- " + reason);
        }

        // Verify Farm Tag
        if (!resultCow.getFarmTag().equals(expectCow.getFarmTag())) {
        System.out.println("Error in " + test + " expected " + expectCow.getFarmTag() + " but obtained " +
                resultCow.getFarmTag() + " -- " + reason);
        }
    }
}
