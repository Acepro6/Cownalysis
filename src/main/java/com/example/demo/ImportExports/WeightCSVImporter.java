package com.example.demo.ImportExports;

import com.example.demo.DataClasses.Herd;
import com.example.demo.DataClasses.Weight;
import javafx.scene.chart.PieChart;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WeightCSVImporter {

    /**
     * CSV Reader
     * @param fileName String of a file PATH
     * @return returns a hashmap<k,v> where k is the cow ID the weight record belongs to and v is the weight object
     */
    public static HashMap<String, Weight> readWeightFromCSV(String fileName) {
        HashMap<String, Weight> weights = new HashMap<>();
        Path pathToFile = Paths.get(fileName);


        String[] pHeader;
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String header = br.readLine();
            header.split(",");

            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split(",");
                String cowID = attributes[0];
                Weight weight = DataConverter.createWeight(attributes);
                weights.put(cowID, weight);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // TODO find and add weight record to cow

        return weights;
    }

    // Main function used for testing and examining console output only
    public static void main(String[] args) {
        // Hardcoded test case, ignore the
        HashMap<String, Weight> weights = readWeightFromCSV("C:\\My Projects\\team-27-project-cmpt-370\\Example Weight.csv");

        System.out.println("The following are test cases for weight records recorded in the .csv example file");

        for (int x = 0; x < weights.size(); x++) {
            String[] IDs = weights.keySet().toArray(new String[0]);
            System.out.println("\nID #: " + IDs[x]);
            Weight weight = weights.get(IDs[x]);
            System.out.println("Weight: " + weight.getWeight());
            System.out.println("Date: " + weight.getDate().toString());
        }
        System.out.println("\nTesting completed");
    }
}
