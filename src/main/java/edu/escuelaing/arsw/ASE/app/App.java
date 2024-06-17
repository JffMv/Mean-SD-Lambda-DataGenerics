package edu.escuelaing.arsw.ASE.app;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException {
        try {
            System.out.println("Hello World!");
            ReadAndExtract.Read read = (filePath) -> ReadAndExtract.readCSV(filePath);
            ArrayList<ArrayList<Double>> lists = (ArrayList<ArrayList<Double>>) ReadAndExtract.extractColumnsTheFile(args[0], read);
            LinkendList<TreeMap> results = new LinkendList<>();

            lists.stream().forEach((lista) -> {
                TreeMap<String, Double> result = Calculate.calculateStats(lista);
                // Save mean and standard deviation into results list
                results.add(result);
            });
            results.printer();
        } catch (Throwable e) {
            System.err.println("Error durante la ejecución:");
            e.printStackTrace(); // Imprime la traza completa de cualquier otra excepción
        }
    }
}
