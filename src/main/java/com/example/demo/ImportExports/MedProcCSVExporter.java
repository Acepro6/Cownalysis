package com.example.demo.ImportExports;

import com.example.demo.DataClasses.Cow;
import com.example.demo.DataClasses.MedProc;
import com.example.demo.DataClasses.Weight;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class MedProcCSVExporter {
    // Delimiters for CSV
    private static final String DELIMITER = ",";
    private static final String SEPERATOR = "\n";


    public void CSVExporter(ArrayList<Cow> cows, File file) {
        // Initialize Stuff
        DataExporter de = new DataExporter();
        try {
            file.createNewFile();
            file.setWritable(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Create Header line
        String Header = "COW ID, Procedure, Date, Reason, Product, Dosage, Route, Notes\n";

        try (BufferedWriter writer = Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8)){
            // Write Header
            writer.write(Header);

            // Add to CSV
            for (Cow c : cows) {
                System.out.println(c.getID());;
                for (MedProc mp : c.getMedicalHistory()) {
                    // get data
                    String[] metadata = de.MedicalCSVExport(c.getID(), mp);
                    System.out.println(Arrays.toString(metadata));
                    System.out.println(mp.getProcedure());

                    writer.write(metadata[0]);
                    writer.write(DELIMITER);
                    writer.write(metadata[1]);
                    writer.write(DELIMITER);
                    writer.write(metadata[2]);
                    writer.write(DELIMITER);
                    writer.write(metadata[3]);
                    writer.write(DELIMITER);
                    writer.write(metadata[4]);
                    writer.write(DELIMITER);
                    writer.write(metadata[5]);
                    writer.write(DELIMITER);
                    writer.write(metadata[6]);
                    writer.write(DELIMITER);
                    writer.write(metadata[7]);
                    writer.write(SEPERATOR);
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
