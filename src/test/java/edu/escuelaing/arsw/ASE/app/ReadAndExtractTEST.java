package edu.escuelaing.arsw.ASE.app;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;

public class ReadAndExtractTEST {

    @Test
    public void testReadCSV() {
        String filePath = "Resource/MOCK_DATA.csv";
        ArrayList<ArrayList<Double>> result = ReadAndExtract.readCSV("Resource/MOCK_DATA.csv");

        // Check the number of columns
        assertEquals(6, result.size());

        // Check the number of rows in each column
        for (ArrayList<Double> column : result) {
            assertEquals(1000, column.size());
        }

    }

}
