package edu.escuelaing.arsw.ASE.app;

import org.apache.commons.math3.stat.descriptive.*;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Calculate Standard Deviation and Mean and both methods return this in a dictionary.
 */
public class Calculate {

    /**
     * Calculates the mean and standard deviation of the provided list of numbers using
     * Apache Commons Math DescriptiveStatistics.
     * Throws IllegalArgumentException if the list is null or empty.
     *
     * @param numbers List of Double values for which statistics are calculated
     * @return TreeMap containing "MEAN" and "SD" as keys with corresponding statistical values
     *         Mean and standard deviation are computed using DescriptiveStatistics methods.
     */
    public static TreeMap<String, Double> standardDeviationAndMean(ArrayList<Double> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("The list of numbers cannot be null or empty");
        }

        TreeMap<String, Double> values = new TreeMap<>();
        System.out.println("entreee");
        DescriptiveStatistics stats = new DescriptiveStatistics();
        System.out.println("entreee");
        // Add the data from the ArrayList to the stats object
        for (Double number : numbers) {
            stats.addValue(number);
        }
        values.put("SD", stats.getStandardDeviation());
        values.put("MEAN", stats.getMean() );

        return values;
    }
    /**
     * Calculates the mean and standard deviation of the given list of numbers.
     * Throws IllegalArgumentException if the list is null or empty.
     *
     * @param numbers List of Double values for which statistics are calculated
     * @return TreeMap containing "MEAN" and "SD" as keys with corresponding statistical values
     *         Mean and standard deviation are calculated using mathematical formulas.
     */
    public static TreeMap<String, Double> calculateStats(ArrayList<Double> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("The list of numbers cannot be null or empty");
        }

        TreeMap<String, Double> values = new TreeMap<>();

        // Calculate mean
        double sum = 0;
        for (Double number : numbers) {
            sum += number;
        }
        double mean = sum / numbers.size();
        values.put("MEAN", mean);

        // Calculate standard deviation
        double sumOfSquares = 0;
        for (Double number : numbers) {
            sumOfSquares += Math.pow(number - mean, 2);
        }
        double standardDeviation = Math.sqrt(sumOfSquares / numbers.size());
        values.put("SD", standardDeviation);

        return values;
    }
}


