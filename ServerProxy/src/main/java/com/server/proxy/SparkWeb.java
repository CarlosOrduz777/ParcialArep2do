package com.server.proxy;

import static spark.Spark.get;
import static spark.Spark.port;

public class SparkWeb {

    public static void main(String[] args) {

        port(getPort());
        HttpConnection httpConnection = new HttpConnection();
        get("/proxy", (req, res) -> {
            res.type("application/json");
            String cadena = req.queryParams("value");
            System.out.println("Esta es mi cadena:  " + cadena);
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
