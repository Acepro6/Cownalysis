package com.example.demo.ImportExports;

import com.example.demo.DataClasses.Herd;
import com.example.demo.DataClasses.Weight;
import com.example.demo.DataClasses.Cow;
import com.example.demo.Enums.Category;
import com.example.demo.Enums.Gender;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class HerdCSVImporter {

    /**
     * CSV Reader
     * @param fileName String of a file PATH
     * @return returns a list of cows
     */
    private static List<Herd> readHerdFromCSV(String fileName) {
        DataConverter converter = new DataConverter();
        List<Herd> herds = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);


        String[] pHeader;
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
            String header = br.readLine();
            pHeader = header.split(",");
            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split(",");
                Herd herd = converter.createHerd(attributes);
                herds.add(herd);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return herds;
    }


    // Main function used for testing and examining console output only
    public static void main(String[] args) {
        // Hardcoded test case, ignore the
        List<Herd> herds = readHerdFromCSV("C:\\My Projects\\team-27-project-cmpt-370\\Example Herd.csv");
        for (Herd h : herds) {
            System.out.println("\nID #: " + h.getHerdID());
            System.out.println("Field: " + h.getLocation());
            System.out.println("BullExpo: " + h.getBullExposureDate());
            System.out.println("BullExit: " + h.getBullEvictionDate());
            System.out.println("BullID: " + h.getBull());
        }
        System.out.println("\nTesting completed");

    }
}
