import java.util.Scanner;
import java.util.function.BiFunction;

//Cristopher Farid Vázquez Sánchez

public class Main {

    public static void main(String[] args) {
        // https://github.com/crissanzzz07/operaciones-basicas-java
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n1.- Suma");
            System.out.println("2.- Resta");
            System.out.println("3.- Division");
            System.out.println("4.- Multiplicacion");
            System.out.println("5.- Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    calcularSuma(scanner);
                    break;
                case 2:
                    calcularResta(scanner);
                    break;
                case 3:
                    calcularDivision(scanner);
                    break;
                case 4:
                    calcularMultiplicacion(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 5);

        scanner.close();
    }

    // ---------- Programacion FUNCIONAL ----------

    private static void calcularSuma(Scanner scanner) {
        double a = leerNumero(scanner, "Ingrese el primer numero: ");
        double b = leerNumero(scanner, "Ingrese el segundo numero: ");

        BiFunction<Double, Double, Double> suma = (x, y) -> x + y;
        System.out.println("Resultado: " + suma.apply(a, b));
    }

    private static void calcularDivision(Scanner scanner) {
        double a = leerNumero(scanner, "Ingrese el primer numero: ");
        double b = leerNumero(scanner, "Ingrese el segundo numero: ");

        BiFunction<Double, Double, Double> division = (x, y) -> {
            if (y == 0) {
                throw new ArithmeticException("No se puede dividir entre cero");
            }
            return x / y;
        };

        try {
            System.out.println("Resultado: " + division.apply(a, b));
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // ---------- Programacion ESTRUCTURADA ----------

    private static void calcularResta(Scanner scanner) {
        double a = leerNumero(scanner, "Ingrese el primer numero: ");
        double b = leerNumero(scanner, "Ingrese el segundo numero: ");
        double resultado = restar(a, b);
        System.out.println("Resultado: " + resultado);
    }

    private static double restar(double a, double b) {
        return a - b;
    }

    private static void calcularMultiplicacion(Scanner scanner) {
        double a = leerNumero(scanner, "Ingrese el primer numero: ");
        double b = leerNumero(scanner, "Ingrese el segundo numero: ");
        double resultado = multiplicar(a, b);
        System.out.println("Resultado: " + resultado);
    }

    private static double multiplicar(double a, double b) {
        return a * b;
    }

    // ---------- Utilidad compartida ----------

    private static double leerNumero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextDouble();
    }
}