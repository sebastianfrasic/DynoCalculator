package edu.eci.arep;

import spark.*;


import java.util.LinkedList;

import static spark.Spark.*;


public class SparkWebApp {

    private static final Calculadora calculadora = new Calculadora();

    public static void main(String[] args) {

        port(getPort());
        get("/hello", (req, res) -> "Hello Heroku");

        get("/hello/:name", (req, res) -> "Hello, " + req.params(":name"));

        get("/inputdata", (req, res) -> inputDataPage());
        get("/results", (req, res) -> resultsPage(req));

        get("/sortlist", (req, res) -> sortListPage());
        get("/resultado", (req, res) -> resultado(req));

    }



    private static String sortListPage() {
        LinkedList<Double> listaDeNumeros = new LinkedList<>();
        for (String data : request.queryParams("input").split(",")) {
            listaDeNumeros.add(Double.parseDouble(data));
        }

        calculadora.setDatos(listaDeNumeros);
        calculadora.calcularMedia();

        return "La media de los datos ingresados es: " + calculadora.calcularMedia() + " y su desviación estándar es: " + calculadora.calcularDesviacionEstandar();
    }

    private static String resultado(Request req) {
    }

    /**
     * @return A string with html code that will build the web page
     */
    private static String inputDataPage() {
        return "<!DOCTYPE html>"
                + "<html>"
                + "<body>"
                + "<h1>Calculadora estadística</h1>"
                + "<h4> Ingrese una lista de números para calcular su media y desviación estándar </h4>"
                + "<p> Hecho por: <strong> Juan Sebastián Frásica Galeano </strong> </p>"
                + "<form action=\"/results\">"
                + "      Ingrese los números separados por un punto y coma (;) <br> <br>"
                + "     <input type=\"text\" name=\"input\" value=\"\">"
                + "     <br><br><br><p> </p> "
                + "     <input type=\"submit\" value=\"Calcular\">"
                + "</form>"
                + "</body>"
                + "</html>";
    }

    /**
     * Este método recibe un conjunto de datos de un parámetro del recurso "inputdata" llamado datos y construye la página web en base a este conjunto.
     *
     * @param request HTTP request
     * @return A string with html code that will build the web page
     * @throws CalculadoraException si los datos estan vacios
     */
    private static String resultsPage(Request request) throws CalculadoraException {
        LinkedList<Double> listaDeNumeros = new LinkedList<>();
        for (String data : request.queryParams("input").split(";")) {
            listaDeNumeros.add(Double.parseDouble(data));
        }

        calculadora.setDatos(listaDeNumeros);
        calculadora.calcularMedia();

        return "La media de los datos ingresados es: " + calculadora.calcularMedia() + " y su desviación estándar es: " + calculadora.calcularDesviacionEstandar();
    }


    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     * <p>
     * Heroku provides the port automatically so you need this to run the
     * project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
