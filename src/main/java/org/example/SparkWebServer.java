package org.example;


import static spark.Spark.*;

public class SparkWebServer {

    public static void main(String... args){
        port(getPort());
        get("hello", (req,res) -> "Hello Docker!");
        get("/operaciones", (req,res) -> getPage());
        get("sin", (req,res) -> Math.sin(Double.parseDouble(req.queryParams("value"))));
        get("cos", (req,res) -> Math.cos(Double.parseDouble(req.queryParams("value"))));

        get("ispalindrome", (req, res) -> {
            String request = req.queryParams("value");
            boolean isPalindrome = true;
            String result = "es palindromo";

            for (int i = 0; i < request.length(); i++) {
                if (!(request.charAt(i) == request.charAt(request.length() - 1 - i))) {
                    isPalindrome = false;
                    result = "no es palindromo";
                    break;
                }
            }

            return result;
        });

        get("vector", (req,res) -> {
            float value1 = Float.parseFloat(req.queryParams("value1"));
            float value2 = Float.parseFloat(req.queryParams("value2"));
            return Math.sqrt(Math.pow(value1, 2)+Math.pow(value2, 2));
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    public static String getPage(){
        String page = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Cálculos</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <main>\n" +
                "        <section>\n" +
                "            <h2>Calcular Seno</h2>\n" +
                "            <form id=\"sinForm\">\n" +
                "                <label for=\"sinValor\">Ingrese un valor:</label>\n" +
                "                <input type=\"text\" id=\"sinValor\" name=\"sinValor\" required>\n" +
                "                <button type=\"button\" onclick=\"calcularSeno()\">Calcular</button>\n" +
                "            </form>\n" +
                "            <div id=\"resultadoSeno\"></div>\n" +
                "        </section>\n" +
                "\n" +
                "        <section>\n" +
                "            <h2>Calcular Coseno</h2>\n" +
                "            <form id=\"cosForm\">\n" +
                "                <label for=\"cosValor\">Ingrese un valor:</label>\n" +
                "                <input type=\"text\" id=\"cosValor\" name=\"cosValor\" required>\n" +
                "                <button type=\"button\" onclick=\"calcularCoseno()\">Calcular</button>\n" +
                "            </form>\n" +
                "            <div id=\"resultadoCoseno\"></div>\n" +
                "        </section>\n" +
                "\n" +
                "        <section>\n" +
                "            <h2>Verificar Palíndromo</h2>\n" +
                "            <form id=\"palindromeForm\">\n" +
                "                <label for=\"palindromeValor\">Ingrese una palabra:</label>\n" +
                "                <input type=\"text\" id=\"palindromeValor\" name=\"palindromeValor\" required>\n" +
                "                <button type=\"button\" onclick=\"verificarPalindromo()\">Verificar</button>\n" +
                "            </form>\n" +
                "            <div id=\"resultadoPalindromo\"></div>\n" +
                "        </section>\n" +
                "\n" +
                "        <section>\n" +
                "            <h2>Calcular la Magnitud de un Vector</h2>\n" +
                "            <form id=\"sqrtForm\">\n" +
                "                <label for=\"sqrtValor1\">Primer valor:</label>\n" +
                "                <input type=\"text\" id=\"sqrtValor1\" name=\"sqrtValor1\" required>\n" +
                "                <label for=\"sqrtValor2\">Segundo valor:</label>\n" +
                "                <input type=\"text\" id=\"sqrtValor2\" name=\"sqrtValor2\" required>\n" +
                "                <button type=\"button\" onclick=\"calcularRaizCuadrada()\">Calcular</button>\n" +
                "            </form>\n" +
                "            <div id=\"resultadoRaizCuadrada\"></div>\n" +
                "        </section>\n" +
                "    </main>\n" +
                "    <script>\n" +
                "        function calcularSeno() {\n" +
                "            const valorIngresado = document.getElementById('sinValor').value;\n" +
                "            const resultadoElement = document.getElementById('resultadoSeno');\n" +
                "\n" +
                "            fetch(`/sin?value=${valorIngresado}`)\n" +
                "                .then(response => response.text())\n" +
                "                .then(data => {\n" +
                "                    resultadoElement.textContent = `El seno de ${valorIngresado} es: ${data}`;\n" +
                "                })\n" +
                "                .catch(error => {\n" +
                "                    console.error('Error:', error);\n" +
                "                    resultadoElement.textContent = 'Error al comunicarse con el servidor.';\n" +
                "                });\n" +
                "        }\n" +
                "\n" +
                "        function calcularCoseno() {\n" +
                "            const valorIngresado = document.getElementById('cosValor').value;\n" +
                "            const resultadoElement = document.getElementById('resultadoCoseno');\n" +
                "\n" +
                "            fetch(`/cos?value=${valorIngresado}`)\n" +
                "                .then(response => response.text())\n" +
                "                .then(data => {\n" +
                "                    resultadoElement.textContent = `El coseno de ${valorIngresado} es: ${data}`;\n" +
                "                })\n" +
                "                .catch(error => {\n" +
                "                    console.error('Error:', error);\n" +
                "                    resultadoElement.textContent = 'Error al comunicarse con el servidor.';\n" +
                "                });\n" +
                "        }\n" +
                "\n" +
                "        function verificarPalindromo() {\n" +
                "            const cadenaIngresada = document.getElementById('palindromeValor').value;\n" +
                "            const resultadoElement = document.getElementById('resultadoPalindromo');\n" +
                "\n" +
                "            fetch(`/ispalindrome?value=${cadenaIngresada}`)\n" +
                "                .then(response => response.text())\n" +
                "                .then(data => {\n" +
                "                    resultadoElement.textContent = `${cadenaIngresada} ${data}`;\n" +
                "                })\n" +
                "                .catch(error => {\n" +
                "                    console.error('Error:', error);\n" +
                "                    resultadoElement.textContent = 'Error al comunicarse con el servidor.';\n" +
                "                });\n" +
                "        }\n" +
                "\n" +
                "        function calcularRaizCuadrada() {\n" +
                "            const valor1 = document.getElementById('sqrtValor1').value;\n" +
                "            const valor2 = document.getElementById('sqrtValor2').value;\n" +
                "            const resultadoElement = document.getElementById('resultadoRaizCuadrada');\n" +
                "\n" +
                "            fetch(`/vector?value1=${valor1}&value2=${valor2}`)\n" +
                "                .then(response => response.text())\n" +
                "                .then(data => {\n" +
                "                    resultadoElement.textContent = `La magnitud del vector es: ${data}`;\n" +
                "                })\n" +
                "                .catch(error => {\n" +
                "                    console.error('Error:', error);\n" +
                "                    resultadoElement.textContent = 'Error al comunicarse con el servidor.';\n" +
                "                });\n" +
                "        }\n" +
                "    </script>\n" +
                "</body>\n" +
                "</html>\n";
        return page;
    }

}
