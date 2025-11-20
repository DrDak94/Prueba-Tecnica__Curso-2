package entities;

import java.time.LocalDate;

public class Vuelo {
    private final int id;
    private final String nombreVuelo;
    private final String empresa;
    private final String lugarSalida;
    private final String lugarLlegada;
    private final LocalDate fechaSalida;
    private final LocalDate fechaLlegada;

    public Vuelo(int id, String nombreVuelo, String empresa, String lugarSalida, String lugarLlegada, LocalDate fechaSalida, LocalDate fechaLlegada) {
        this.id = id;
        this.nombreVuelo = nombreVuelo;
        this.empresa = empresa;
        this.lugarSalida = lugarSalida;
        this.lugarLlegada = lugarLlegada;
        this.fechaSalida = fechaSalida;
        this.fechaLlegada = fechaLlegada;
    }
    // Creamos, en este caso, solo el getter que se necesita para el filtrado
    public LocalDate getFechaSalida() {
        return fechaSalida;
    }
    // Hacemos Override del toString para que cada vuelo impreso sea fácil de entender y leer
    @Override
    public String toString() {
        return "\n✈️ Vuelo #" + id +
                "\n────────────────────────────" +
                "\n🆔 Código: " + nombreVuelo +
                "\n🏢 Empresa: " + empresa +
                "\n🌍 Origen: " + lugarSalida +
                "\n🎯 Destino: " + lugarLlegada +
                "\n📅 Fecha salida: " + fechaSalida +
                "\n📅 Fecha llegada: " + fechaLlegada +
                "\n";
    }
}
