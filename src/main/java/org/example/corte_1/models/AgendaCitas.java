package org.example.corte_1.models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del paciente es obligatorio.");
        }

        if (telefono == null || telefono.trim().isEmpty()) {
            throw new IllegalArgumentException("El telefono del paciente es obligatorio.");
        }

        if (!telefono.trim().matches("\\d{8}")) {
            throw new IllegalArgumentException("El telefono debe tener 8 digitos.");
        }

        if (fecha == null) {
            throw new IllegalArgumentException("La fecha de la cita es obligatoria.");
        }

        if (fecha.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de la cita no puede ser anterior a hoy.");
        }
    }
}
