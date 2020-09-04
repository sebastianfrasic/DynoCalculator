package edu.eci.arep.controller;

import edu.eci.arep.services.Calculadora;
import org.json.JSONObject;
import static spark.Spark.*;
import spark.Request;
import spark.Response;

public class CalculatorController {


    public static void main(String[] args) {
        port(getPort());
        get("/inputdata", (req, res) -> inputDataPage(req, res));
        get("/results", (req, res) -> resultPage(req, res));
    }

    private static String inputDataPage(Request req, Response res) {
        String pageContent
                = "<!DOCTYPE html>"
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
        return pageContent;
    }

    private static JSONObject resultPage(Request req, Response res) {

        JSONObject json = new JSONObject();
        Double numero = Double.parseDouble(req.queryParams("number"));
        String operacion = req.queryParams("operacion");
        Double ans = 0.0;

        if (operacion.equals("sin")) {
            ans = Calculadora.calcularSeno(numero);
        } else if (operacion.equals("cos")) {
            ans = Calculadora.calcularCoseno(numero);
        } else if (operacion.equals("tan")) {
            ans = Calculadora.calcularTangente(numero);
        } else {
            json.append(operacion, 0);
        }

        json.append(operacion, ans);
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
