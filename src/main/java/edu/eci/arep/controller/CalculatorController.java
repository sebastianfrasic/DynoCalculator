package edu.eci.arep.controller;

import edu.eci.arep.services.Calculadora;
import org.json.JSONObject;
import static spark.Spark.*;
import spark.Request;

public class CalculatorController {


    public static void main(String[] args) {
        port(getPort());
        get("/inputdata", (req, res) -> inputDataPage());
        get("/results", (req, res) -> resultPage(req));
    }

    private static String inputDataPage() {
        return "<!DOCTYPE html>"
        + "<html>"
        + "<head>"
        + "<title>AREP Parcial</title>"
        + " <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">"
        + "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">"
        + "<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\" integrity=\"sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN\" crossorigin=\"anonymous\">"
        + "</head>"
        + "<body>"
        + "<h2>Calculadora trigonometrica</h2>"
        + "<form action=\"/results\">"
        + "  Numero a ingresar:<br>"
        + "  <input type=\"text\" name=\"number\">"
        + "  <br><br>"
        + "  Operacion a ingresar(sin, cos, tan):<br>"
        + "  <input type=\"text\" name=\"operacion\">"
        + "  <input type=\"submit\" value=\"Calcular\">"
        + "</form>"
        + "</body>"
        + "</html>";
    }

    private static JSONObject resultPage(Request req) {

        JSONObject json = new JSONObject();
        double numero = Double.parseDouble(req.queryParams("number"));
        String operacion = req.queryParams("operacion");
        double respuesta = 0.0;

        switch (operacion) {
            case "sin":
                respuesta = Calculadora.calcularSeno(numero);
                break;
            case "cos":
                respuesta = Calculadora.calcularCoseno(numero);
                break;
            case "tan":
                respuesta = Calculadora.calcularTangente(numero);
                break;
            default:
                json.append(operacion, 0);
                break;
        }

        json.append(operacion, respuesta);
        return json;

    }


    /**
     * This method reads the default port as specified by the PORT variable in
     * the environment.
     * Heroku provides the port automatically so you need this to run the project on Heroku.
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
