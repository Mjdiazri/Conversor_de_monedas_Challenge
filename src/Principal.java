import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        int intento = 0;
        Scanner teclado = new Scanner(System.in);
        ConsultarDivisas buscar = new ConsultarDivisas();

        while (intento != 7) {
            System.out.println("""
                    *****************************
                    Bienvenido al conversor de monedas JAVA
                    
                    Por favor ingrese una de las siguientes opciones validas:
                    1) Dolar >>>>> Peso argentino
                    2) Peso argentino >>>>> Dolar
                    3) Real brasileño >>>>> Dolar
                    4) Dolar >>>>> Real brasileño
                    5) Dolar >>>>> Peso colombiano
                    6) Peso colombiano >>>>> Dolar
                    7) Salir 
                                        
                    *****************************                
                    """);

            try {

                intento = Integer.parseInt(teclado.nextLine().trim());
                String divisa = "";
                String divisa2 = "";

                switch (intento) {
                    case 1:
                        divisa = "USD";
                        divisa2 = "ARS";
                        break;

                    case 2:
                        divisa = "ARS";
                        divisa2 = "USD";
                        break;

                    case 3:
                        divisa = "BRL";
                        divisa2 = "USD";
                        break;

                    case 4:
                        divisa = "USD";
                        divisa2 = "BRL";
                        break;

                    case 5:
                        divisa = "USD";
                        divisa2 = "COP";
                        break;

                    case 6:
                        divisa = "COP";
                        divisa2 = "USD";
                        break;

                    case 7:
                        System.out.println("Saliendo...");
                        continue;

                    default:
                        System.out.println("Opcion no valida");
                        continue;
                }

                Divisa nuevaDivisa = buscar.buscaDivisa(divisa);

                Map<String, Double> conversionRates = nuevaDivisa.conversion_rates();

                System.out.println("Ingrese el valor que desea convertir");
                double valorAConvertir = teclado.nextDouble();
                double resultado = valorAConvertir * conversionRates.get(divisa2);


                System.out.println("""
                        ******************************
                        Resultado de la operacion""");
                System.out.println("Transaccion: " + divisa + ">>>" + divisa2 );
                System.out.println("Fecha de actualizacion: " + nuevaDivisa.time_last_update_utc());
                System.out.println("Valor ingresado: "+ valorAConvertir);
                System.out.println("Total: " + resultado + " " + divisa2);
                System.out.println("******************************");
                teclado.nextLine();
            } catch (RuntimeException e) {
                System.out.println("Valor no valido");

            } catch (Exception e) {
                System.out.println("Error del sistema");
            }

        }

        System.out.println("Programa finalizado");
    }
}
