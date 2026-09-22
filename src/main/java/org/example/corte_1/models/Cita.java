package org.example.corte_1.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import java.time.LocalDate;

public class Cita {
    private final ObjectProperty<Paciente> paciente = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalDate> fecha = new SimpleObjectProperty<>();

    public Cita(Paciente paciente, LocalDate fecha) {
        setPaciente(paciente);
        setFecha(fecha);
    }

    public Paciente getPaciente() {
        return paciente.get();
    }

    public void setPaciente(Paciente paciente) {
        this.paciente.set(paciente);
    }

    public ObjectProperty<Paciente> pacienteProperty() {
        return paciente;
    }

    public LocalDate getFecha() {
        return fecha.get();
    }

    public void setFecha(LocalDate fecha) {
        this.fecha.set(fecha);
    }

    public ObjectProperty<LocalDate> fechaProperty() {
        return fecha;
    }

    public String getNombrePaciente() {
        return getPaciente().getNombre();
    }

    public String getTelefonoPaciente() {
        return getPaciente().getTelefono();
    }
}
