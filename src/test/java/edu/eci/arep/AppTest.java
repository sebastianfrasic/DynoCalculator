package edu.eci.arep;

import org.junit.Before;
import org.junit.Test;


import java.util.LinkedList;

import static org.junit.Assert.assertEquals;


public class AppTest {

    private Calculadora calculator;

    private final double[] dataSetProxy = {160, 591, 114, 229, 230, 270, 128, 1657, 624, 1503};
    private final double[] dataSetDevelopment = {15.0, 69.9, 6.5, 22.4, 28.4, 65.9, 19.4, 198.7, 38.8, 138.2};
    private final double[] dataSet1 = {16.0, 32.9, 6.5, 23.4, 28.4, 65.9, 1.4, 198.6, 36.8, 22.2};
    private final double[] dataSet2 = {17.0, 45.9, 2.5, 25.3, 28.5, 66.9, 10.4, 192.1, 24.8, 12.2};
    private final double[] dataSet3 = {12.0, 12.9, 11.5, 21.4, 28.4, 7.9, 12.4, 10.3, 13.8, 11.2};
    private final double[] dataSet4 = {10.0, 15.9, 30.5, 41.4, 68.4, 17.9, 78.4, 111.3, 24.8, 1422.2};
    private final double[] dataSet5 = {100.0, 11.9, 31.5, 51.4, 18.4, 27.9, 11.45, 112.3, 145.8, 1424.2};


    private final LinkedList<Double> linkedListProxy = new LinkedList<>();
    private final LinkedList<Double> linkedListDevelopment = new LinkedList<>();
    private final LinkedList<Double> linkedList1 = new LinkedList<>();
    private final LinkedList<Double> linkedList2 = new LinkedList<>();
    private final LinkedList<Double> linkedList3 = new LinkedList<>();
    private final LinkedList<Double> linkedList4 = new LinkedList<>();
    private final LinkedList<Double> linkedList5 = new LinkedList<>();


    /**
     * Estableciendo los datos que se usarán
     */
    @Before
    public void setup() {
        calculator = new Calculadora();

        for (Double i : dataSetProxy) {
            linkedListProxy.add(i);
        }
        for (Double i : dataSetDevelopment) {
            linkedListDevelopment.add(i);
        }
        for (int i = 0; i < dataSet1.length; i++) {
            linkedList1.add(dataSet1[i]);
            linkedList2.add(dataSet2[i]);
            linkedList3.add(dataSet3[i]);
            linkedList4.add(dataSet4[i]);
            linkedList5.add(dataSet5[i]);
        }
    }

    /**
     * Should calculate the mean and coincide with the expected value
     */
    @Test
    public void shouldCalculateMean() throws CalculadoraException {
        calculator.setDatos(linkedListProxy);
        assertEquals(550.6, calculator.calcularMedia(), 0.0);

        calculator.setDatos(linkedListDevelopment);
        assertEquals(60.32, calculator.calcularMedia(), 0.0);

    }

    /**
     * Should calculate the mean and coincide with the expected value
     */
    @Test
    public void shouldCalculateMeanSets() throws CalculadoraException {
        calculator.setDatos(linkedList1);
        assertEquals(43.21, calculator.calcularMedia(), 0.0);

        calculator.setDatos(linkedList2);
        assertEquals(42.56, calculator.calcularMedia(), 0.0);

        calculator.setDatos(linkedList3);
        assertEquals(14.18, calculator.calcularMedia(), 0.0);

        calculator.setDatos(linkedList4);
        assertEquals(182.08, calculator.calcularMedia(), 0.0);

        calculator.setDatos(linkedList5);
        assertEquals(193.49, calculator.calcularMedia(), 0.0);
    }

    /**
     * Should calculate the standard deviation and coincide with the expected value
     */
    @Test
    public void shouldCalculateStandarD() throws CalculadoraException {
        calculator.setDatos(linkedListProxy);
        assertEquals(572.03, calculator.calcularDesviacionEstandar(), 0.05);

        calculator.setDatos(linkedListDevelopment);
        assertEquals(62.26, calculator.calcularDesviacionEstandar(), 0.05);
    }

    /**
     * Should calculate the standard deviation and coincide with the expected value
     */
    @Test
    public void shouldCalculateSdSets() throws CalculadoraException {
        calculator.setDatos(linkedList1);
        assertEquals(57.44, calculator.calcularDesviacionEstandar(), 0.05);

        calculator.setDatos(linkedList2);
        assertEquals(55.77, calculator.calcularDesviacionEstandar(), 0.05);

        calculator.setDatos(linkedList3);
        assertEquals(6.1, calculator.calcularDesviacionEstandar(), 0.05);

        calculator.setDatos(linkedList4);
        assertEquals(436.94, calculator.calcularDesviacionEstandar(), 0.05);

        calculator.setDatos(linkedList5);
        assertEquals(434.98, calculator.calcularDesviacionEstandar(), 0.05);
    }


}