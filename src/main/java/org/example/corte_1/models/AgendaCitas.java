package org.example.corte_1.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.corte_1.Util.Validaciones;

import java.time.LocalDate;

public final class AgendaCitas {
    private static final ObservableList<Cita> CITAS = FXCollections.observableArrayList();

    private AgendaCitas() {
    }

    public static ObservableList<Cita> getCitas() {
        return CITAS;
    }

    public static Cita registrarCita(String nombre, String telefono, LocalDate fecha) {
        validarDatos(nombre, telefono, fecha);

        Paciente paciente = new Paciente(nombre.trim(), telefono.trim());
        Cita cita = new Cita(paciente, fecha);
        CITAS.add(cita);
        return cita;
    }

    public static void validarDatos(String nombre, String telefono, LocalDate fecha) {
        Validaciones.validarDatosCita(nombre, telefono, fecha);
    }
}
