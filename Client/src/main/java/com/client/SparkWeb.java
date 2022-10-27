package com.client;
import static spark.Spark.*;
public class SparkWeb {
    public static void main(String[] args) {

        port(getPort());
        staticFileLocation("/public");
        HttpConnection httpConnection = new HttpConnection();
        get("/client", (req, res) -> {
            res.type("application/json");
            String cadena = req.queryParams("value");
            return httpConnection.getLogServiceData(cadena);
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
