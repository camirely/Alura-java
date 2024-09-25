import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ConsultaMoneda {

    private List<String> conversiones= new ArrayList<>();
    private List<String> HorasConsultadas= new ArrayList<>();
    Modenas buscaModenas(String base_code){

        String direccion = "https://v6.exchangerate-api.com/v6/b02d313843dd05da62974e20/latest/"+base_code;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return  new Gson().fromJson(response.body(), Modenas.class);
        } catch (Exception e) {
            throw new RuntimeException("no se encontro modena");
        }

    }

    public void busquedaDolarSol() {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el valor a convertir: ");
            double valor = scanner.nextDouble();
            Modenas modena1 = buscaModenas("USD");
            if (modena1 != null) {
                Double tasa = modena1.conversion_rates.get("PEN");
                String nombre = modena1.base_code;
                if (tasa != null) {
                    double resultado = valor * tasa;
                    System.out.println("El valor del dólar en soles es " + resultado );
                    conversiones.add("dolar a sol: " + resultado);
                    LocalTime HoraHoy = LocalTime.now();
                    HorasConsultadas.add("dolar a sol:Hora registrada " + HoraHoy);
                } else {
                    System.out.println("Código de moneda no válido.");
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("no se encontro modena");
        }
    }

    public void busquedaSolDolar(){

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el valor a convertir: ");
            double valor = scanner.nextDouble();

            Modenas modena1 = buscaModenas("PEN");
            Double tasa = modena1.conversion_rates.get("USD");

            if (tasa != null) {
                double resultado = valor * tasa;
                System.out.println("El valor del soles en dolares es " + resultado);
                conversiones.add("sol a dolar:" +resultado);
                LocalTime HoraHoy = LocalTime.now();
                HorasConsultadas.add("sol a dolar:Hora registrada " + HoraHoy);
            } else {
                System.out.println("Código de moneda no válido.");
            }
        } catch (Exception e) {
            throw new RuntimeException("no se encontro modena");
        }

    }


    public void busquedaDolarBrasileño(){

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el valor a convertir: ");
            double valor = scanner.nextDouble();

            Modenas modena1 = buscaModenas("USD");
            Double tasa = modena1.conversion_rates.get("BRL");

            if (tasa != null) {
                double resultado = valor * tasa;
                System.out.println("El valor del Dolar en Real Brasileño es " + resultado);
                conversiones.add("dolar a real brasileño:" + resultado);
                LocalTime HoraHoy = LocalTime.now();
                HorasConsultadas.add("dolar  a real brasileño:Hora registrada " + HoraHoy);
            } else {
                System.out.println("Código de moneda no válido.");
            }
        } catch (Exception e) {
            throw new RuntimeException("no se encontro modena");
        }

    }


    public void busquedaBrasileñoDolar(){

        try  {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el valor a convertir: ");
            double valor = scanner.nextDouble();

            Modenas modena1 = buscaModenas("BRL");
            Double tasa = modena1.conversion_rates.get("USD");

            if (tasa != null) {
                double resultado = valor * tasa;
                System.out.println("El valor del Real Brasileño en dolares es " + resultado);
                conversiones.add("real brasileño a dolar:" +resultado);
                LocalTime HoraHoy = LocalTime.now();
                HorasConsultadas.add("real brasileño a dolar:Hora registrada " + HoraHoy);
            } else {
                System.out.println("Código de moneda no válido.");
            }
        } catch (Exception e) {
            throw new RuntimeException("no se encontro modena");
        }

    }


    public void busquedaDolarColombiano(){

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el valor a convertir: ");
            double valor = scanner.nextDouble();

            Modenas modena1 = buscaModenas("USD");
            Double tasa = modena1.conversion_rates.get("COP");

            if (tasa != null) {
                double resultado = valor * tasa;
                System.out.println("El valor del DOlares en Peso Colombinas es " + resultado);
                conversiones.add("dolar a peso colombiano:" +resultado);
                LocalTime HoraHoy = LocalTime.now();
                HorasConsultadas.add("dolar a peso colombiano:Hora registrada " + HoraHoy);
            } else {
                System.out.println("Código de moneda no válido.");
            }
        } catch (Exception e) {
            throw new RuntimeException("no se encontro modena");
        }

    }



    public void busquedaColombianoDolar(){

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el valor a convertir: ");
            double valor = scanner.nextDouble();

            Modenas modena1 = buscaModenas("COP");
            Double tasa = modena1.conversion_rates.get("USD");

            if (tasa != null) {
                double resultado = valor * tasa;
                System.out.println("El valor del Peso Colombinas en Dolares es " + resultado);
                conversiones.add("peso colombinao  a dolar:" +resultado);
                LocalTime HoraHoy = LocalTime.now();
                HorasConsultadas.add("peso colombiano a dolar:Hora registrada " + HoraHoy);
            } else {
                System.out.println("Código de moneda no válido.");
            }
        } catch (Exception e) {
            throw new RuntimeException("no se encontro modena");
        }

    }

    public void busquedaSolEuro(){

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el valor a convertir: ");
            double valor = scanner.nextDouble();

            Modenas modena1 = buscaModenas("PEN");
            Double tasa = modena1.conversion_rates.get("EUR");

            if (tasa != null) {
                double resultado = valor * tasa;
                System.out.println("El valor del sol peruano en euros es " + resultado);
                conversiones.add("sol peruano  a euro:" +resultado);
                LocalTime HoraHoy = LocalTime.now();
                HorasConsultadas.add("sol peruano a euro:Hora registrada " + HoraHoy);
            } else {
                System.out.println("Código de moneda no válido.");
            }
        } catch (Exception e) {
            throw new RuntimeException("no se encontro modena");
        }

    }

    public void busquedaEuroSol(){

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese el valor a convertir: ");
            double valor = scanner.nextDouble();

            Modenas modena1 = buscaModenas("EUR");
            Double tasa = modena1.conversion_rates.get("PEN");

            if (tasa != null) {
                double resultado = valor * tasa;
                System.out.println("El valor del sol peruano en euros es " + resultado);
                conversiones.add("Euro  a Sol peruano:" +resultado);
                LocalTime HoraHoy = LocalTime.now();
                HorasConsultadas.add("euro a sol peruano:Hora registrada " + HoraHoy);
            } else {
                System.out.println("Código de moneda no válido.");
            }
        } catch (Exception e) {
            throw new RuntimeException("no se encontro modena");
        }

    }

    public List<String> getConsultas(){

         List<String> consultas= new ArrayList<>();

        consultas.addAll(conversiones);
        consultas.addAll(HorasConsultadas);


        return  consultas;

    }





}

