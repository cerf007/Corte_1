package org.example.corte_1.Util;

import java.time.LocalDate;

public final class Validaciones {
    private static final int LONGITUD_TELEFONO = 8;

    private Validaciones() {
    }

    public static void validarDatosCita(String nombre, String telefono, LocalDate fecha) {
        validarNombrePaciente(nombre);
        validarTelefono(telefono);
        validarFechaCita(fecha);
    }

    public static void validarNombrePaciente(String nombre) {
        if (esTextoVacio(nombre)) {
            throw new IllegalArgumentException("El nombre del paciente es obligatorio.");
        }

        if (!nombre.trim().matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            throw new IllegalArgumentException("El nombre solo debe contener letras.");
        }
    }

    public static void validarTelefono(String telefono) {
        if (esTextoVacio(telefono)) {
            throw new IllegalArgumentException("El telefono del paciente es obligatorio.");
        }

        if (!telefono.trim().matches("\\d{" + LONGITUD_TELEFONO + "}")) {
            throw new IllegalArgumentException("El telefono debe tener 8 digitos.");
        }
    }

    public static void validarFechaCita(LocalDate fecha) {
        if (fecha == null) {
            throw new IllegalArgumentException("La fecha de la cita es obligatoria.");
        }

        if (fecha.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de la cita no puede ser anterior a hoy.");
        }
    }

    public static boolean esTextoVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }
}
