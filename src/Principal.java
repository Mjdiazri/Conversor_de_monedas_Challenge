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
            switch (divisa) {
                case "1","4","5":
                    divisa = "USD";
                    System.out.println(divisa);
                    break;

                    //Se valida direccion api ok pero no muestra datos de la divisa
                case "2":
                    divisa = "ARS";
                    System.out.println(divisa);
                    break;

                case "3":
                    divisa = "BRL";
                    System.out.println(divisa);
                    break;

                case "6":
                    divisa = "COP";
                    System.out.println(divisa);
                    break;

                default:
                    System.out.println("Opcion no valida");
            }

            Divisa nuevaDivisa = buscar.buscaDivisa(divisa);
            System.out.println(nuevaDivisa);

        } finally {
            System.out.println("Finalizando");
        }

    }
}
