package com.example.tap2023.vistas;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Calculadora extends Stage {

    private Scene escena;
    private VBox vBox;
    private GridPane grdTeclado;
    private TextField txtResultado;
    private Button[][] arTeclas = new Button[4][4];
    private char[] arDigitos = {'7','8','9','/','4','5','6','*','1','2','3','-','0','.','=','+'};
    public Calculadora(){
        CrearUI();
        escena = new Scene(vBox, 200, 200);
        this.setTitle("Calculadora");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI(){
        int pos = 0;
        grdTeclado = new GridPane();
        txtResultado = new TextField("0");
        txtResultado.setAlignment(Pos.BASELINE_RIGHT);
        txtResultado.setEditable(false);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                arTeclas[i][j] = new Button(arDigitos[pos]+"");
                arTeclas[i][j].setPrefSize(50,50);
                int finalPos = pos;
                arTeclas[i][j].setOnAction(
                        (event)->GenerarExpresion(arDigitos[finalPos]+""));
                grdTeclado.add(arTeclas[i][j],i,j);
                pos++;
            }
        }
        vBox = new VBox(txtResultado,grdTeclado);
    }

    private void GenerarExpresion(String simbolo){
        txtResultado.appendText(simbolo);
    }
}
