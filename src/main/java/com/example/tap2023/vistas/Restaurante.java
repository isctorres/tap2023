package com.example.tap2023.vistas;

import com.example.tap2023.components.ButtonCell;
import com.example.tap2023.modelos.CategoriasDAO;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.kordamp.bootstrapfx.BootstrapFX;
import org.kordamp.bootstrapfx.scene.layout.Panel;

public class Restaurante extends Stage {

    private VBox vBox;
    private TableView<CategoriasDAO> tbvCategorias;
    private Button btnAgregar;
    private CategoriasDAO categoriasDAO;
    public Restaurante(){
        CrearUI();
        Panel panel = new Panel("This is the title");
        panel.getStyleClass().add("panel-primary");                            //(2)
        BorderPane content = new BorderPane();
        content.setPadding(new Insets(20));
        content.setCenter(vBox);
        panel.setBody(content);

        Scene scene = new Scene(panel);
        scene.getStylesheets().add(BootstrapFX.bootstrapFXStylesheet());       //(3)

        this.setTitle("BootstrapFX");
        this.setScene(scene);
        this.sizeToScene();
        this.show();
    }

    private void CrearUI(){

        categoriasDAO = new CategoriasDAO();
        tbvCategorias = new TableView<CategoriasDAO>();
        CrearTable();
        btnAgregar = new Button("Agregar");
        btnAgregar.getStyleClass().setAll("btn","btn-success");                     //(2)
        btnAgregar.setOnAction(event -> new CategoriaForm(tbvCategorias, null));
        vBox = new VBox(tbvCategorias,btnAgregar);
    }

    private void CrearTable(){
        TableColumn<CategoriasDAO,Integer> tbcIdCat = new TableColumn<CategoriasDAO,Integer>("ID");
        tbcIdCat.setCellValueFactory(new PropertyValueFactory<>("idCategoria"));

        TableColumn<CategoriasDAO,String> tbcNomCat = new TableColumn<CategoriasDAO,String>("Categoria");
        tbcNomCat.setCellValueFactory(new PropertyValueFactory<>("nomCategoria"));

        TableColumn<CategoriasDAO,String> tbcEditar = new TableColumn<CategoriasDAO,String>("EDITAR");
        tbcEditar.setCellFactory(
                new Callback<TableColumn<CategoriasDAO, String>, TableCell<CategoriasDAO, String>>() {
                    @Override
                    public TableCell<CategoriasDAO, String> call(TableColumn<CategoriasDAO, String> param) {
                        return new ButtonCell(1);
                    }
                }
        );

        TableColumn<CategoriasDAO,String> tbcEliminar = new TableColumn<CategoriasDAO,String>("ELIMINAR");
        tbcEliminar.setCellFactory(
                new Callback<TableColumn<CategoriasDAO, String>, TableCell<CategoriasDAO, String>>() {
                    @Override
                    public TableCell<CategoriasDAO, String> call(TableColumn<CategoriasDAO, String> param) {
                        return new ButtonCell(2);
                    }
                }
        );

        tbvCategorias.getColumns().addAll(tbcIdCat,tbcNomCat,tbcEditar,tbcEliminar);
        tbvCategorias.setItems(categoriasDAO.LISTARCATEGORIAS());
    }
}
