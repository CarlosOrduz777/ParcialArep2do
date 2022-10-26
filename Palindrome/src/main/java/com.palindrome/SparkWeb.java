package com.palindrome;
import static spark.Spark.*;

public class SparkWeb {

    public static void main(String[] args) {

        port(getPort());
        get("/espalindromo", (req, res) -> {
            res.type("application/json");
            String pal = req.queryParams("value");

            String isPal = "";

            if (Palindrone.isPalindrome(pal)){
                isPal = "Si es Palindromo";
            }else {
                isPal = "No es Palindromo";
            }
            String response = "{ "+"operation:\"" + "palindromo\"" +"," + "input:\"" + pal + "\""+
            "," + " output:\"" + isPal + "\" }";

            return response;
        });
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
