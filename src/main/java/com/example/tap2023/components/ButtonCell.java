package com.example.tap2023.components;

import com.example.tap2023.modelos.CategoriasDAO;
import com.example.tap2023.vistas.CategoriaForm;
import javafx.scene.control.*;

import java.util.Optional;

public class ButtonCell extends TableCell<CategoriasDAO,String> {
    private Button btnCelda;
    private int opc;
    private TableView<CategoriasDAO> tbvCategorias;
    private CategoriasDAO objCat;
    public ButtonCell(int opc){
        this.opc = opc;
        String txtBtn = this.opc == 1 ? "Editar" : "Eliminar";
        btnCelda = new Button(txtBtn);
        btnCelda.setOnAction(event -> accionBoton());
    }

    private void accionBoton() {
        tbvCategorias = ButtonCell.this.getTableView();
        objCat = tbvCategorias.getItems().get(ButtonCell.this.getIndex());

        if( this.opc == 1 ){
            new CategoriaForm(tbvCategorias, objCat);
        }
        else{
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Tópicos Avanzados de Programación");
            alert.setHeaderText("Confirmación del Sistema");
            alert.setContentText("¿Deseas eliminar la categoría?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                objCat.ELIMINAR();
                tbvCategorias.setItems(objCat.LISTARCATEGORIAS());
                tbvCategorias.refresh();
            }
        }
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if( !empty ){
            this.setGraphic(btnCelda);
        }
    }
}
