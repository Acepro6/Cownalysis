package com.example.demo.ImportExports;

import com.example.demo.DataClasses.Cow;
import com.example.demo.DataClasses.MedProc;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MedProcCSVImporter {

    /**
     * CSV Reader
     * @param fileName String of a file PATH
     * @return returns a list of cows
     */
    public static ArrayList<MedProc> readCowsFromCSV(String fileName) {
        DataConverter converter = new DataConverter();
        ArrayList<MedProc> MPs = new ArrayList<>();
        Path pathToFile = Paths.get(fileName);

        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.UTF_8)) {
            String header = br.readLine();
            header.split(",");

            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split(",");
                MedProc medProc = converter.createMedProc(attributes);
                MPs.add(medProc);
                line = br.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return MPs;
    }
}
