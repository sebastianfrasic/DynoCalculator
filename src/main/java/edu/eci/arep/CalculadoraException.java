package edu.eci.arep;

public class CalculadoraException extends Exception {

    public static final String DATOS_NULOS = "Los datos de la calculadora están vacios.";

    /**
     * Instantiates a new Calculator exception.
     *
     * @param message Mensaje de la excepcion
     */
    public CalculadoraException(String message) {
        super(message);
    }
}
