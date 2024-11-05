package com.example.demo.ImportExports;

import com.example.demo.DataClasses.Cow;
import com.example.demo.DataClasses.Herd;

import java.io.FileWriter;

public class HerdCSVExport {
    // Delimiters for CSV
    private static final String DELIMITER = ",";
    private static final String SEPERATOR = "\n";

    /**
     * Constructor
     */
    public HerdCSVExport() {
    }

    public void CSVExporter(Herd[] herds, String fileName) {
        DataExporter de = new DataExporter();

        // Create Header line
        String Header = "COW ID, Tag, DoD, Sex, Type, Sire ID, Dam ID, Weight, Last Weight Date";

        try {
            FileWriter file = new FileWriter(fileName);
            // Add header
            file.append(Header);
            file.append(SEPERATOR);

            // Add to CSV
            for (Herd h : herds) {
                // get data
                String[] metadata = de.HerdCSVExport(h);

                file.append(metadata[0]);
                file.append(DELIMITER);
                file.append(metadata[1]);
                file.append(DELIMITER);
                file.append(metadata[2]);
                file.append(DELIMITER);
                file.append(metadata[3]);
                file.append(DELIMITER);
                file.append(metadata[4]);
                file.append(DELIMITER);
                file.append(metadata[5]);
                file.append(SEPERATOR);

            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}