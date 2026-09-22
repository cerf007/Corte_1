package org.example.corte_1.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.corte_1.models.AgendaCitas;

import java.time.LocalDate;

public class RegistroController {

    @FXML private Label lbltitulo;
    @FXML private TextField txtNombres;
    @FXML private TextField txtApellidos;
    @FXML private TextField txtTelefono;
    @FXML private DatePicker dpFecha;

    @FXML
    private void initialize() {
        // Bloquear fechas anteriores a hoy en el DatePicker
        dpFecha.setDayCellFactory(picker -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.isBefore(LocalDate.now()));
            }
        });
    }

    @FXML
    protected void registrarCita() {
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        String telefono = txtTelefono.getText();
        LocalDate fecha = dpFecha.getValue();

        try {
            if (nombres == null || nombres.trim().isEmpty()) {
                throw new IllegalArgumentException("El nombre es obligatorio.");
            }
            if (apellidos == null || apellidos.trim().isEmpty()) {
                throw new IllegalArgumentException("El apellido es obligatorio.");
            }

            String nombreCompleto = nombres.trim() + " " + apellidos.trim();

            // AgendaCitas hace las validaciones reales:
            // nombre obligatorio, teléfono obligatorio y de 8 dígitos,
            // fecha obligatoria y no anterior a hoy.
            AgendaCitas.registrarCita(nombreCompleto, telefono, fecha);

            mostrarAlerta(Alert.AlertType.INFORMATION, "Registro exitoso",
                    "La cita fue registrada correctamente.");
            limpiarCampos();

        } catch (IllegalArgumentException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error de validación", e.getMessage());
        }
    }

    private void limpiarCampos() {
        txtNombres.clear();
        txtApellidos.clear();
        txtTelefono.clear();
        dpFecha.setValue(null);
        txtNombres.requestFocus();
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}