package edu.escuelaing.arsw.ASE.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class Read and Extract columns in ArrayList of ArrayList.
 * Have implementation for read CSV but can extends for any document.
 */
public class ReadAndExtract {

    /**
     * Interface for reading data from a specified source.
     */
    interface Read{
        ArrayList<?> extact(String fileReader);
    }

    /**
     * Extracts columns from a file using a specified Read implementation.
     *
     * @param url  String representing the location of the file to be read
     * @param read Read implementation for extracting data from the file
     * @return ArrayList containing extracted data (specific type depends on implementation)
     * @throws FileNotFoundException If the specified file path is invalid or cannot be found
     */
    public static ArrayList<?> extractColumnsTheFile(String url, Read read) throws FileNotFoundException {
        return read.extact(url);
    }

    /**
     * Reads a CSV file and organizes its data into columns of Double values.
     *
     * @param filePath String representing the path to the CSV file to be read
     * @return ArrayList of ArrayLists, where each inner list represents a column of Double values from the CSV
     */
    public static ArrayList<ArrayList<Double>> readCSV(String filePath){
        ArrayList<ArrayList<Double>> columns = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isHeader = true;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (isHeader) {
                    // Initialize columns based on the header
                    for (int i = 0; i < values.length; i++) {
                        columns.add(new ArrayList<Double>());
                    }
                    isHeader = false;
                } else {
                    // Add values to the respective columns
                    for (int i = 0; i < values.length; i++) {
                        columns.get(i).add(Double.parseDouble(values[i]));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return columns;
    }


}
