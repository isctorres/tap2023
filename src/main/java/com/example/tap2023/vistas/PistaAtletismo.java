package com.example.tap2023.vistas;

import com.example.tap2023.components.Hilo;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PistaAtletismo extends Stage {
    private ProgressBar[] pgbCorredores = new ProgressBar[6];
    private Hilo[] thrCorredores = new Hilo[6];
    private VBox vBox;
    private Button btnIniciar;
    private Scene escena;
    private String[] strCorredores = {"Martina","German","Yuno","Rodrigo","Rubensin","Vanessa"};
    public PistaAtletismo(){
        CrearUI();
        escena = new Scene(vBox);
        this.setTitle("Pista de Atletismo :)");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        vBox = new VBox();
        for (int i = 0; i < pgbCorredores.length; i++) {
            pgbCorredores[i] = new ProgressBar(0);
            thrCorredores[i] = new Hilo(strCorredores[i],pgbCorredores[i]);
            vBox.getChildren().add(pgbCorredores[i]);
        }
        btnIniciar = new Button("Iniciar Carrera :)");
        btnIniciar.setOnAction(event -> {
            for (int i = 0; i < pgbCorredores.length ; i++) {
                thrCorredores[i].start();
            }
        });
        vBox.getChildren().add(btnIniciar);
    }

}
