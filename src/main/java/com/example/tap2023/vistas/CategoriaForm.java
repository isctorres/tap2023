package com.example.tap2023.vistas;

import com.example.tap2023.modelos.CategoriasDAO;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CategoriaForm extends Stage {
    private Scene escena;
    private HBox hBox;
    private TextField txtNameCat;
    private Button btnGuardar;
    private CategoriasDAO objCatDAO;
    TableView<CategoriasDAO> tbvCategorias;
    public CategoriaForm(TableView<CategoriasDAO> tbvCat){
        this.tbvCategorias = tbvCat;
        CrearUI();
        escena = new Scene(hBox);
        this.setTitle("Gestión de Categorias");
        this.setScene(escena);
        this.show();
    }

    private void CrearUI() {
        objCatDAO = new CategoriasDAO();
        txtNameCat = new TextField();
        txtNameCat.setPromptText("Nombre de la categoria");
        btnGuardar = new Button("Guardar");
        btnGuardar.setOnAction(event -> guardarCategoria());
        hBox = new HBox(txtNameCat,btnGuardar);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(10));
    }

    private void guardarCategoria(){
        objCatDAO.setNomCategoria(txtNameCat.getText());
        objCatDAO.INSERTAR();
        tbvCategorias.setItems(objCatDAO.LISTARCATEGORIAS());
        tbvCategorias.refresh();
        this.close();
    }
}
