package utils;

import entities.Vuelo;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class FiltroVuelos {
    public static List<Vuelo> filtrarVuelos(List<Vuelo> vuelos, LocalDate fechaInicio, LocalDate fechaFin) {
        return vuelos.stream()
                .filter(v ->
                        // Combinamos los 4 tipos de filtro en un único Stream usando el operador lógico OR (||)
                        // para ambas fechas (inicio y fin), que pueden ser válidas o nulas
                        (fechaInicio == null || !v.getFechaSalida().isBefore(fechaInicio)) &&
                                (fechaFin == null || !v.getFechaSalida().isAfter(fechaFin))
                )
                .sorted(Comparator.comparing(Vuelo::getFechaSalida))
                .toList();
    }
}
