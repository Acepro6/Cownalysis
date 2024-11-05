package com.example.demo.ImportExports;

import com.example.demo.DataClasses.Herd;
import com.example.demo.DataClasses.Weight;

import java.io.FileWriter;

public class WeightCSVExport {
    // Delimiters for CSV
    private static final String DELIMITER = ",";
    private static final String SEPERATOR = "\n";

    /**
     * Constructor
     */
    public WeightCSVExport() {
    }

    public void CSVExporter(Weight[] weights, String fileName) {
        DataExporter de = new DataExporter();

        // Create Header line
        String Header = "COW ID, Tag, DoD, Sex, Type, Sire ID, Dam ID, Weight, Last Weight Date";

        try {
            FileWriter file = new FileWriter(fileName);
            // Add header
            file.append(Header);
            file.append(SEPERATOR);

            // Add to CSV
            for (Weight w : weights) {
                // get data
                String[] metadata = de.WeightCSVExport("112321", w);

                file.append(metadata[0]);
                file.append(DELIMITER);
                file.append(metadata[1]);
                file.append(DELIMITER);
                file.append(metadata[2]);
                file.append(SEPERATOR);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}