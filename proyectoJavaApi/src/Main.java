import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Gson gson =new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();

        Scanner scanner = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();

        while (true) {

            System.out.println("*****************************************");
            System.out.print("1) Dólar >> Sol Peruano\n" +
                    "2) Sol peruano >> Dólar\n" +
                    "3) Dólar >> Real brasileño\n" +
                    "4) Real brasileño >> Dólar\n" +
                    "5) Dólar >> Peso colombiano\n" +
                    "6) Peso colombiano >> Dólar\n" +
                    "7) Sol peruano >> Euro\n" +
                    "8) Euro >> Sol peruano\n" +
                    "9) Salir \n");

            System.out.println("*****************************************");
            System.out.print("Ingrese la opción que desee: ");


            try {
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        consulta.busquedaDolarSol();
                        break;
                    case 2:
                        consulta.busquedaSolDolar();
                        break;
                    case 3:
                        consulta.busquedaDolarBrasileño();
                        break;
                    case 4:
                        consulta.busquedaBrasileñoDolar();
                        break;
                    case 5:
                        consulta.busquedaDolarColombiano();
                        break;
                    case 6:
                        consulta.busquedaColombianoDolar();
                        break;
                    case 7:
                        consulta.busquedaSolEuro();
                        break;
                    case 8:
                        consulta.busquedaEuroSol();
                        break;
                    case 9:
                        System.out.println("Saliendo...");
                        scanner.close();

                        try (FileWriter escritura = new FileWriter("consulta.json")) {
                            escritura.write(gson.toJson(consulta.getConsultas()));
                            escritura.close();
                        } catch (IOException e) {
                            System.out.println("Error al escribir en el archivo: " + e.getMessage());
                        }
                        return; // Termina el programa

                    default:
                        System.out.println("Opción inválida, por favor intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next(); // Limpiar el scanner para permitir nueva entrada
            }
        }

    }
}
