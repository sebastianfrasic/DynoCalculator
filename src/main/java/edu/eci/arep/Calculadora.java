package edu.eci.arep;

import java.util.ArrayList;
import java.util.LinkedList;

public class Calculadora {


    private static LinkedList<Double> datos;


    public Calculadora() {
        deleteDatos();
        datos = new LinkedList<>();
    }

    public static ArrayList<Double> ordenamientoBurbuja(ArrayList<Double> lista) {
        for (int i = 0; i < lista.size() - 1; i++)
            for (int j = 0; j < lista.size() - i - 1; j++)
                if (lista.get(j) > lista.get(j+1)) {

                    double temp = lista.get(j).doubleValue();
                    lista.set(j, lista.get(j+1).doubleValue());
                    lista.set(j+1, temp);
                }
        return lista;
    }



    public double calcularMedia() throws CalculadoraException {
        if (datos != null) {
            double media = 0;
            int cantidadDeElementos = datos.size();

            for (Double d : datos) {
                media += d;
            }

            media /= cantidadDeElementos;
            return (double) Math.round(media * 100d) / 100d;
        } else {
            throw new CalculadoraException(CalculadoraException.DATOS_NULOS);
        }
    }


    public double calcularDesviacionEstandar() throws CalculadoraException {
        if (datos != null) {
            double media = calcularMedia();
            double desviacion;
            double sumatoria = 0;

            for (Double d : datos) {
                sumatoria += Math.pow(d - media, 2) / (datos.size() - 1);
            }
            desviacion = Math.sqrt(sumatoria);
            return (double) Math.round(desviacion * 100d) / 100d;
        } else {
            throw new CalculadoraException(CalculadoraException.DATOS_NULOS);
        }
    }


    public LinkedList<Double> getDatos() {
        return datos;
    }

    public void setDatos(LinkedList<Double> datos) {
        Calculadora.datos = datos;
    }

    /**
     * Borra los datos de la LinkedList
     */
    public void deleteDatos() {
        datos = null;
    }


}
