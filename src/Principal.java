import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ConsultarDivisas buscar = new ConsultarDivisas();
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

        try{
            String divisa = teclado.nextLine();
            String divisa2 = "";

            switch (divisa) {
                case "1":
                    divisa = "USD";
                    divisa2 = "ARS";
                    break;

                case "2":
                    divisa = "ARS";
                    divisa2 = "USD";
                    break;

                case "3":
                    divisa = "BRL";
                    divisa2 = "USD";
                    break;

                case "4":
                    divisa = "USD";
                    divisa2 = "BRL";
                    break;

                case "5":
                    divisa = "USD";
                    divisa2 = "COP";
                    break;

                case "6":
                    divisa = "COP";
                    divisa2 = "USD";
                    break;

                default:
                    System.out.println("Opcion no valida");
            }

            Divisa nuevaDivisa = buscar.buscaDivisa(divisa);
            System.out.println(nuevaDivisa);


            Map<String, Double> conversionRates = nuevaDivisa.conversion_rates();
            System.out.println("Valor de  " + divisa2 + ": " +  conversionRates.get(divisa2));

            System.out.printf("Ingrese el valor a convertir de %s a %s", divisa, divisa2);
            Double valorAConvertir = teclado.nextDouble();
            double resultado = valorAConvertir * conversionRates.get(divisa2);
            System.out.println("Total: " + resultado);

            

        } finally {
            System.out.println("Finalizando");
        }

    }
}
