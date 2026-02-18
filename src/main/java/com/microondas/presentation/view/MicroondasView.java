package com.microondas.presentation.view;

import com.microondas.application.usecases.MicroondasUseCase;
import com.microondas.domain.model.Microondas;
import com.microondas.presentation.controller.MicroondasController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class MicroondasView {

    private VBox root = new VBox();

    private TextField tempoField = new TextField();
    private TextField potenciaField = new TextField();

    private Label display = new Label("00:00");
    private Label processamento = new Label("");

    private Timeline timeline;

    private MicroondasController controller;

    public MicroondasView() {

        controller = new MicroondasController(
                new MicroondasUseCase(new Microondas()));

        Button iniciar = new Button("Iniciar");
        Button rapido = new Button("Início Rápido");
        Button pausa = new Button("Pausa / Cancelar");

        iniciar.setOnAction(e -> iniciar());
        rapido.setOnAction(e -> controller.inicioRapido());
        pausa.setOnAction(e -> pausarOuCancelar());

        root.getChildren().addAll(
                tempoField,
                potenciaField,
                iniciar,
                rapido,
                pausa,
                display,
                processamento);
    }

    public Parent getRoot() {
        return root;
    }

    private void iniciar() {
        String erro = controller.iniciar(
                tempoField.getText(),
                potenciaField.getText());

        if (erro != null) {
            new Alert(Alert.AlertType.ERROR, erro).show();
            return;
        }

        iniciarTimer();
    }

    private void iniciarTimer() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            controller.tick();

            display.setText(controller.tempo());
            processamento.setText(
                    processamento.getText()
                            + controller.processamento() + " ");

            if (controller.finalizado()) {
                timeline.stop();
                processamento.setText(
                        processamento.getText()
                                + "Aquecimento concluído");
            }
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void pausarOuCancelar() {
        if (controller.emExecucao() && !controller.pausado()) {
            controller.pausar();
            if (timeline != null)
                timeline.pause();
        } else {
            controller.cancelar();
            if (timeline != null)
                timeline.stop();
            processamento.setText("");
            display.setText("00:00");
        }
    }
}