package edu.escuelaing.arsw.ASE.app;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.TreeMap;

public class CalculusStatsTest {

    @Test
    public void testCalculateStatsWithPositiveNumbers() {
        ArrayList<Double> numbers = new ArrayList<>();
        numbers.add(1.0);
        numbers.add(2.0);
        numbers.add(3.0);
        numbers.add(4.0);
        numbers.add(5.0);

        TreeMap<String, Double> result = Calculate.calculateStats(numbers);

        assertEquals(3.0, result.get("MEAN"), 0.0001);
        assertEquals(1.4142, result.get("SD"), 0.0001);
    }

    @Test
    public void testCalculateStatsWithNegativeNumbers() {
        ArrayList<Double> numbers = new ArrayList<>();
        numbers.add(-1.0);
        numbers.add(-2.0);
        numbers.add(-3.0);
        numbers.add(-4.0);
        numbers.add(-5.0);

        TreeMap<String, Double> result = Calculate.calculateStats(numbers);

        assertEquals(-3.0, result.get("MEAN"), 0.0001);
        assertEquals(1.4142, result.get("SD"), 0.0001);
    }

    @Test
    public void testCalculateStatsWithMixedNumbers() {
        ArrayList<Double> numbers = new ArrayList<>();
        numbers.add(-1.0);
        numbers.add(0.0);
        numbers.add(1.0);
        numbers.add(2.0);
        numbers.add(3.0);

        TreeMap<String, Double> result = Calculate.calculateStats(numbers);

        assertEquals(1.0, result.get("MEAN"), 0.0001);
        assertEquals(1.41421, result.get("SD"), 0.0001);
    }

    @Test
    public void testCalculateStatsWithSingleElement() {
        ArrayList<Double> numbers = new ArrayList<>();
        numbers.add(10.0);

        TreeMap<String, Double> result = Calculate.calculateStats(numbers);

        assertEquals(10.0, result.get("MEAN"), 0.0001);
        assertEquals(0.0, result.get("SD"), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateStatsWithEmptyList() {
        ArrayList<Double> numbers = new ArrayList<>();
        Calculate.calculateStats(numbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateStatsWithNullList() {
        Calculate.calculateStats(null);
    }
}
