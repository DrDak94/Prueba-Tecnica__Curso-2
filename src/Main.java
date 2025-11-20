import entities.Vuelo;
import utils.FiltroVuelos;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Vuelo> vuelos = List.of(
                new Vuelo(1, "IB123", "Iberia", "Madrid", "Londres", LocalDate.of(2025, 11, 26), LocalDate.of(2025, 11, 26)),
                new Vuelo(2, "AF456", "Air France", "París", "Nueva York", LocalDate.of(2026, 12, 1), LocalDate.of(2026, 12, 1)),
                new Vuelo(3, "LH789", "Lufthansa", "Berlín", "Roma", LocalDate.of(2025, 11, 25), LocalDate.of(2025, 11, 25)),
                new Vuelo(4, "RY102", "Ryanair", "Barcelona", "Dublín", LocalDate.of(2026, 11, 18), LocalDate.of(2026, 11, 18)),
                new Vuelo(5, "BA555", "British Airways", "Londres", "Toronto", LocalDate.of(2025, 12, 10), LocalDate.of(2025, 12, 10)),
                new Vuelo(6, "UX230", "Air Europa", "Madrid", "Buenos Aires", LocalDate.of(2025, 12, 31), LocalDate.of(2025, 12, 31)),
                new Vuelo(7, "AZ321", "ITA Airways", "Roma", "Atenas", LocalDate.of(2025, 11, 30), LocalDate.of(2025, 11, 30)),
                new Vuelo(8, "AA777", "American Airlines", "Miami", "Los Ángeles", LocalDate.of(2026, 1, 31), LocalDate.of(2026, 1, 31)),
                new Vuelo(9, "EK404", "Emirates", "Dubái", "Tokio", LocalDate.of(2026, 2, 20), LocalDate.of(2026, 2, 21)),
                new Vuelo(10, "QR909", "Qatar Airways", "Doha", "Sídney", LocalDate.of(2026, 1, 5), LocalDate.of(2026, 1, 6))
        );

        mostrarMenu(vuelos);

    }


    // Fechas de inicio y fin en constantes estáticas
    private static final LocalDate FECHA_INICIO = LocalDate.of(2025, 12, 1);
    private static final LocalDate FECHA_FIN = LocalDate.of(2026, 1, 31);

    // Colores para imprimir las fechas del filtro más visibles
    public static final String ROJO = "\u001B[31m";
    public static final String RESETROJO = "\u001B[0m";
    public static final String AZUL = "\u001B[34m";
    public static final String RESETAZUL = "\u001B[0m";

    // Metodo para crear y desplegar el menu y sus diferentes filtros
    public static void mostrarMenu(List<Vuelo> vuelos) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        boolean salir = false;

        do {
            System.out.println("\n===== MENÚ DE FILTROS =====");
            System.out.println("1. Filtro completo (fechaInicio y fechaFin)");
            System.out.println("2. Filtro hasta fechaFin (sin fechaInicio)");
            System.out.println("3. Filtro desde fechaInicio (sin fechaFin)");
            System.out.println("4. Sin filtros (todas las fechas)");
            System.out.println("5. Mostrar todos los vuelos disponibles");
            System.out.println("0. Salir");
            System.out.print("Elige opción: ");

            // Verificamos si el usuario ingresa un número
            if (!scanner.hasNextInt()) {
                System.out.println("⚠️ Ingresa un número válido.");
                scanner.next();
                continue;
            }

            opcion = scanner.nextInt();

            // Inicializamos fechas y lista para poder pasarlas a la función de imprimir,
            // ya que queremos imprimir no solo los vuelos sino también las fechas proporcionadas
            LocalDate inicio;
            LocalDate fin;
            List<Vuelo> filtrados;

            switch (opcion) {
                case 1 -> {
                    inicio = FECHA_INICIO;
                    fin = FECHA_FIN;
                }
                case 2 -> {
                    inicio = null;
                    fin = FECHA_FIN;
                }
                case 3 -> {
                    inicio = FECHA_INICIO;
                    fin = null;
                }
                case 4 -> {
                    inicio = null;
                    fin = null;
                }
                case 5 -> {
                    System.out.println("-----------------------------");
                    System.out.println(AZUL + "Todos los vuelos disponibles: " + RESETAZUL);
                    System.out.println("-----------------------------");
                    vuelos.forEach(System.out::println);
                    continue;
                }
                case 0 -> {
                    System.out.println("Saliendo…");
                    salir = true;
                    continue;
                }
                default -> {
                    System.out.println("Opción inválida.");
                    continue;
                }
            }
            // Aplicamos filtro e imprimimos los resultados
            filtrados = FiltroVuelos.filtrarVuelos(vuelos, inicio, fin);
            imprimirVuelos(filtrados, inicio, fin);

        } while (!salir);

        scanner.close();
    }

    // Metodo para imprimir los vuelos y las fechas proporcionadas para el filtro
    public static void imprimirVuelos(List<Vuelo> vuelosFiltrados, LocalDate fechaInicio, LocalDate fechaFin) {
        System.out.println("\n======= RESULTADO =======");
        System.out.println(AZUL + "Fecha inicio filtro: " + RESETAZUL + ROJO + (fechaInicio == null ? "N/A" : fechaInicio) + RESETROJO);
        System.out.println(AZUL + "Fecha fin filtro: " + RESETAZUL + ROJO + (fechaFin == null ? "N/A" : fechaFin) + RESETROJO);
        System.out.println("----------------------------");

        vuelosFiltrados.forEach(System.out::println);
    }
}
