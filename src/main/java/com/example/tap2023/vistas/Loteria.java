package com.example.tap2023.vistas;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Loteria extends Stage {
    private Scene escena;
    private HBox hPrincipal, hBtnSeleccion;
    private VBox vTablilla, vMazo;
    private Image imgCarta;
    private Button[][] arBtnTablilla = new Button[4][4];
    private Button btnAnterior, btnSiguiente, btnIniciar;
    private GridPane grdTablilla;
    public Loteria(){
        CrearUI();
        escena = new Scene(hPrincipal, 800, 600);
        this.setTitle("Loteria");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        CrearTablilla();

        btnAnterior = new Button("<");
        btnAnterior.setPrefSize(200,100);
        btnSiguiente = new Button(">");
        btnSiguiente.setPrefSize(200,100);
        hBtnSeleccion = new HBox(btnAnterior,btnSiguiente);
        vTablilla = new VBox(grdTablilla,hBtnSeleccion);
        vTablilla.setSpacing(20);

        vMazo = new VBox();
        hPrincipal = new HBox(vTablilla,vMazo);
        hPrincipal.setPadding(new Insets(20));
    }

    private void CrearTablilla() {
        String[] arImagenes = {"barril.jpeg","","","","",""};
        grdTablilla = new GridPane();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ImageView imv;
                //Image imgCartaP = new Image(
                //        new File("src/main/java/com/example/tap2023/imagenes/barril.jpeg").toURI().toString());
                try {
                    InputStream stream = new FileInputStream("src/main/java/com/example/tap2023/imagenes/barril.jpeg");
                    Image imgCartaP = new Image(stream);
                    imv = new ImageView(imgCartaP);

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

                imv.setFitHeight(140);
                imv.setFitWidth(100);
                arBtnTablilla[i][j] = new Button();
                arBtnTablilla[i][j].setGraphic(imv);

                arBtnTablilla[i][j].setPrefSize(100,140);
                grdTablilla.add(arBtnTablilla[i][j],i,j);
            }
        }
    }
}
