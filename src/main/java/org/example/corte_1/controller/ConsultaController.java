package org.example.corte_1.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.example.corte_1.models.AgendaCitas;
import org.example.corte_1.models.Cita;

import java.time.LocalDate;

public class ConsultaController {

    @FXML private TableView<Cita> tablaCitas;
    @FXML private TableColumn<Cita, String> colNombre;
    @FXML private TableColumn<Cita, String> colTelefono;
    @FXML private TableColumn<Cita, LocalDate> colFecha;

    @FXML
    private void initialize() {
        colNombre.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getNombrePaciente()));

        colTelefono.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getTelefonoPaciente()));

        colFecha.setCellValueFactory(cellData ->
                cellData.getValue().fechaProperty());

        tablaCitas.setItems(AgendaCitas.getCitas());
    }
}